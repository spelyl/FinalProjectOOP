package group5.webapp.FinalProjectOOP.controllers;

import group5.webapp.FinalProjectOOP.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/seller")
public class SellerCRUDController {

    @RequestMapping(value = "/list-product")
    public String ListProductPage(HttpServletRequest rq, RedirectAttributes redirectAttributes){

        HttpSession session = rq.getSession();
        User user = (User) session.getAttribute("account");
        if(user == null) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập!!!");
            return "redirect:/seller/login";
        }
        else {
            if(user.getRole() != 2) {
                redirectAttributes.addFlashAttribute("message", "Tài khoản không có quyền seller!!!");
                return "redirect:/seller/login";
            }else {
                //do some thing

                return "seller/list-product";
            }
        }
    }

    @RequestMapping(value = "/list-productimage")
    public String ListProductImagePage(HttpServletRequest rq, RedirectAttributes redirectAttributes){

        HttpSession session = rq.getSession();
        User user = (User) session.getAttribute("account");
        if(user == null) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập!!!");
            return "redirect:/seller/login";
        }
        else {
            if(user.getRole() != 2) {
                redirectAttributes.addFlashAttribute("message", "Tài khoản không có quyền seller!!!");
                return "redirect:/seller/login";
            }else {
                //do some thing

                return "seller/list-productimage";
            }
        }
    }

    @RequestMapping(value = "/list-productdetail")
    public String ListProductDetailPage(HttpServletRequest rq, RedirectAttributes redirectAttributes){

        HttpSession session = rq.getSession();
        User user = (User) session.getAttribute("account");
        if(user == null) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập!!!");
            return "redirect:/seller/login";
        }
        else {
            if(user.getRole() != 2) {
                redirectAttributes.addFlashAttribute("message", "Tài khoản không có quyền seller!!!");
                return "redirect:/seller/login";
            }else {
                //do some thing

                return "seller/list-productdetail";
            }
        }
    }

    @RequestMapping(value = "/list-category")
    public String ListCategoryPage(HttpServletRequest rq, RedirectAttributes redirectAttributes){

        HttpSession session = rq.getSession();
        User user = (User) session.getAttribute("account");
        if(user == null) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập!!!");
            return "redirect:/seller/login";
        }
        else {
            if(user.getRole() != 2) {
                redirectAttributes.addFlashAttribute("message", "Tài khoản không có quyền seller!!!");
                return "redirect:/seller/login";
            }else {
                //do some thing

                return "seller/list-category";
            }
        }
    }

    @RequestMapping(value = "/list-bill")
    public String ListBillPage(HttpServletRequest rq, RedirectAttributes redirectAttributes){

        HttpSession session = rq.getSession();
        User user = (User) session.getAttribute("account");
        if(user == null) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập!!!");
            return "redirect:/seller/login";
        }
        else {
            if(user.getRole() != 2) {
                redirectAttributes.addFlashAttribute("message", "Tài khoản không có quyền seller!!!");
                return "redirect:/seller/login";
            }else {
                //do some thing

                return "seller/list-bill";
            }
        }
    }

    @RequestMapping(value = "/list-billdetail")
    public String ListBillDetailPage(HttpServletRequest rq, RedirectAttributes redirectAttributes){

        HttpSession session = rq.getSession();
        User user = (User) session.getAttribute("account");
        if(user == null) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập!!!");
            return "redirect:/seller/login";
        }
        else {
            if(user.getRole() != 2) {
                redirectAttributes.addFlashAttribute("message", "Tài khoản không có quyền seller!!!");
                return "redirect:/seller/login";
            }else {
                //do some thing

                return "seller/list-billdetail";
            }
        }
    }
}
