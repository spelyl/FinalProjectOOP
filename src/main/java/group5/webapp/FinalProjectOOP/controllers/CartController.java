package group5.webapp.FinalProjectOOP.controllers;

import group5.webapp.FinalProjectOOP.models.Bill;
import group5.webapp.FinalProjectOOP.models.BillDetail;
import group5.webapp.FinalProjectOOP.models.Product;
import group5.webapp.FinalProjectOOP.models.User;
import group5.webapp.FinalProjectOOP.repositories.BillRepository;
import group5.webapp.FinalProjectOOP.services.BillDetailService;
import group5.webapp.FinalProjectOOP.services.BillService;
import group5.webapp.FinalProjectOOP.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class CartController {

    @Autowired
    ProductService productService;

    @Autowired
    BillService billService;

    @Autowired
    BillDetailService billDetailService;

    @RequestMapping(value = "/add-to-cart/{product}/{quantity}")
    public String AddToCart(@PathVariable Integer product,
                            @PathVariable Integer quantity,
                            HttpServletRequest rq) {
        HttpSession session = rq.getSession();
        Product productModel = productService.getProductById(product);
        User user = (User) session.getAttribute("account");
        System.out.println("Product: " + product + " - Quantity : "+ quantity);

        if (user == null) {
            return "Vui lòng đăng nhập!!!";
        } else {
            Optional<Bill> billCheck = billService.findByUserAndStatus(user,-1);
            if(billCheck.isPresent()){ // Đã có giỏ hàng
                Bill bill = billCheck.get();
                BillDetail billDetail = null;
                Optional<BillDetail> billDetailCheck = billDetailService.findByProductAndBill(productModel.getId(),bill.getId());
                if(billDetailCheck.isPresent()){
                    billDetail = billDetailCheck.get();
                    Integer newQuantity = billDetail.getQuantity() + quantity;
                    billDetail.setQuantity(newQuantity);
                }else{
                    billDetail = new BillDetail();
                    billDetail.setBill(bill);
                    billDetail.setProduct(productModel);
                    billDetail.setQuantity(quantity);
                }
                List<BillDetail> billDetailList = billDetailService.findAllByBill(bill);
                double total = 0;
                for(BillDetail b: billDetailList){
                    total += b.getQuantity() * b.getProduct().getPrice();
                }
                bill.setTotal(total);
                billService.saveBill(bill);
                billDetailService.saveBillDetail(billDetail);

                return "Thêm thành công";
            } else { // Nếu chưa có giỏ hàng mới
                Bill bill = new Bill();
                bill.setStatus(-1);
                Date date = Date.valueOf(LocalDate.now());
                bill.setDate(date);
                bill.setUser(user);

                billService.saveBill(bill);
                BillDetail billDetail = new BillDetail();


                billDetail.setBill(bill);
                billDetail.setProduct(productModel);
                billDetail.setQuantity(quantity);
                List<BillDetail> billDetailList = billDetailService.findAllByBill(bill);
                double total = 0;
                for(BillDetail b: billDetailList){
                    total += b.getQuantity() * b.getProduct().getPrice();
                }
                bill.setTotal(total);

                billService.saveBill(bill);
                billDetailService.saveBillDetail(billDetail);
                return "Thêm thành công";
            }
        }

    }

}
