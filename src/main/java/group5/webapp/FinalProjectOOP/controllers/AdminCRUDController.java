package group5.webapp.FinalProjectOOP.controllers;

import group5.webapp.FinalProjectOOP.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/admin")
public class AdminCRUDController {

    @RequestMapping(value = "/list-user")
    public String ListUserPage(HttpServletRequest rq, RedirectAttributes redirectAttributes){

        HttpSession session = rq.getSession();
        User user = (User) session.getAttribute("account");
        if(user == null) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập!!!");
            return "redirect:/admin/login";
        }
        else {
            if(user.getRole() != 3) {
                redirectAttributes.addFlashAttribute("message", "Tài khoản không có quyền admin!!!");
                return "redirect:/admin/login";
            }else {
                //do some thing

                return "admin/list-user";
            }
        }
    }

    @RequestMapping(value = "/list-customerinfo")
    public String ListCustomerInfoPage(HttpServletRequest rq, RedirectAttributes redirectAttributes){

        HttpSession session = rq.getSession();
        User user = (User) session.getAttribute("account");
        if(user == null) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập!!!");
            return "redirect:/admin/login";
        }
        else {
            if(user.getRole() != 3) {
                redirectAttributes.addFlashAttribute("message", "Tài khoản không có quyền admin!!!");
                return "redirect:/admin/login";
            }else {
                //do some thing

                return "admin/list-customerinfo";
            }
        }
    }

    @RequestMapping(value = "/list-card")
    public String ListCardPage(HttpServletRequest rq, RedirectAttributes redirectAttributes){

        HttpSession session = rq.getSession();
        User user = (User) session.getAttribute("account");
        if(user == null) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập!!!");
            return "redirect:/admin/login";
        }
        else {
            if(user.getRole() != 3) {
                redirectAttributes.addFlashAttribute("message", "Tài khoản không có quyền admin!!!");
                return "redirect:/admin/login";
            }else {
                //do some thing

                return "admin/list-card";
            }
        }
    }

    @RequestMapping(value = "/list-address")
    public String ListAddressPage(HttpServletRequest rq, RedirectAttributes redirectAttributes){

        HttpSession session = rq.getSession();
        User user = (User) session.getAttribute("account");
        if(user == null) {
            redirectAttributes.addFlashAttribute("message", "Vui lòng đăng nhập!!!");
            return "redirect:/admin/login";
        }
        else {
            if(user.getRole() != 3) {
                redirectAttributes.addFlashAttribute("message", "Tài khoản không có quyền admin!!!");
                return "redirect:/admin/login";
            }else {
                //do some thing

                return "admin/list-address";
            }
        }
    }
}
