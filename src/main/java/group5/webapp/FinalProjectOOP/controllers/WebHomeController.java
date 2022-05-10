package group5.webapp.FinalProjectOOP.controllers;

import group5.webapp.FinalProjectOOP.models.Category;
import group5.webapp.FinalProjectOOP.models.Product;
import group5.webapp.FinalProjectOOP.models.ProductDetail;
import group5.webapp.FinalProjectOOP.models.ProductImage;
import group5.webapp.FinalProjectOOP.repositories.ProductDetailRepository;
import group5.webapp.FinalProjectOOP.repositories.ProductRepository;
import group5.webapp.FinalProjectOOP.services.CategoryService;
import group5.webapp.FinalProjectOOP.services.ProductImageService;
import group5.webapp.FinalProjectOOP.services.ProductService;
import group5.webapp.FinalProjectOOP.services.implement.ProductImageServiceImplement;
import group5.webapp.FinalProjectOOP.services.implement.ProductServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebHomeController {

    @Autowired
    ProductService productService;

    @Autowired
    ProductImageService productImageService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductDetailRepository productDetailRepository;

    public static final int PAGE_SITE = 12;

    @RequestMapping(value = {"/", "/home", "/index"})
    public String HomePage(Model model){

        List<Product> listTop8Product = productService.getTop8Product();
        List<Product> listLast4Product = productService.getLast4Product();

        model.addAttribute("listtop8product", listTop8Product);
        model.addAttribute("listlast4product", listLast4Product);
        return "web/home";
    }

    @RequestMapping(value =  "/products/{category}/page/{pagenumber}")
    public String AllProductPage(@PathVariable("category") Integer category,
                                 @PathVariable("pagenumber") Integer pagenumber,
                                 Model model){

        List<Category> listAllCategory = categoryService.findAll();
        int amount = productService.findAll().size();
        int endPage = amount / PAGE_SITE;

        if(amount % 4 != 0){
            endPage += 1;
        }

        if(pagenumber == null){
            pagenumber = 1;
        }
        List<Product> productList =  productService.PagingAllProduct(pagenumber-1, PAGE_SITE).getContent();
        if(category !=0){
            Category categoryModel = categoryService.findCategoryById(category);
            productList = productService.PagingProductByCategory(pagenumber-1, PAGE_SITE, categoryModel).getContent();
        }

        model.addAttribute("listAllProduct", productList);
        model.addAttribute("listAllCategory", listAllCategory);
        model.addAttribute("tag", pagenumber);
        model.addAttribute("endPage", endPage);
        model.addAttribute("targetactive", category);

        return "web/product";
    }

    @RequestMapping(value = {"/product-detail/{product}/{category}"})
    public String ProductDetailPage(@PathVariable("product") Integer product,
                                    @PathVariable("category") Integer category,
                                    Model model){

        Product productDetail = productService.getProductById(product);
        System.out.println(categoryService.findCategoryById(category).getName());
        System.out.println(productService.getProductById(product).getName());
        //List<Product> listProductSame = productService.getProductSameCategory(categoryService.findCategoryById(category), product);

        List<ProductImage> listImageOfProduct = productImageService.getAllImageOfProduct(productDetail);

        ProductDetail detailOfProduct = productDetailRepository.findByProduct(productDetail);

        if(detailOfProduct == null){
            ProductDetail temp = new ProductDetail();
            temp.setBrand("Không");
            temp.setColor("Không");
            temp.setDescription("Không");
            temp.setMaterial("Không");
            detailOfProduct = temp;
        }

        model.addAttribute("product", productDetail);
        model.addAttribute("detail", detailOfProduct);
        //model.addAttribute("listProductSame", listProductSame);
        model.addAttribute("listImageOfProduct", listImageOfProduct);

        return "web/product-detail";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String SearchProductPage(@RequestParam("text") String text,
                                    @RequestParam("pagenumber") Integer pagenumber
                                    , Model model){

        List<Product> listAllProduct = productService.findProductByName(text, pagenumber-1, 8);
        List<Category> listAllCategory = categoryService.findAll();
        System.out.println(text);
        int amount = 0;
//        List<Product> list = productService.findAllProductByName(text);
//        System.out.println(list.size());
//        if(list.size() > 0) {
//            amount = list.size();
//        }else {
//            System.out.println("NUlllll");
//        }
        int endPage = amount / PAGE_SITE;

        if(amount % 4 != 0){
            endPage += 1;
        }

        if(pagenumber == null){
            pagenumber = 1;
        }

        model.addAttribute("listAllProduct", listAllProduct);
        model.addAttribute("listAllCategory", listAllCategory);
        model.addAttribute("tag", pagenumber);
        model.addAttribute("endPage", endPage);
        model.addAttribute("targetactive", 0);

        return "web/product";
    }

    @RequestMapping(value = {"/login"} , method = RequestMethod.GET)
    public String LoginPage(){
        return "web/login";
    }

    @RequestMapping(value = {"/recover-password"} , method = RequestMethod.GET)
    public String RecoverPasswordPage(){
        return "web/forgot-password";
    }

    @RequestMapping(value = {"/cart"})
    public String CartPage(){
        return "web/cart";
    }

    @RequestMapping(value = {"/order"})
    public String OrderPage(){
        return "web/payment";
    }

}
