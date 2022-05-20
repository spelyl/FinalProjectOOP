package group5.webapp.FinalProjectOOP.controllers;

import group5.webapp.FinalProjectOOP.models.Address;
import group5.webapp.FinalProjectOOP.models.Card;
import group5.webapp.FinalProjectOOP.models.CustomerInfo;
import group5.webapp.FinalProjectOOP.models.User;
import group5.webapp.FinalProjectOOP.services.AddressService;
import group5.webapp.FinalProjectOOP.services.CardService;
import group5.webapp.FinalProjectOOP.services.CustomerInfoService;
import group5.webapp.FinalProjectOOP.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminCRUDController {

    @Autowired
    UserService userService;

    @Autowired
    CustomerInfoService customerInfoService;
    @Autowired
    AddressService addressService;
    @Autowired
    CardService cardService;
    @RequestMapping(value = "/list-user")
    public String ListUserPage(HttpServletRequest rq, RedirectAttributes redirectAttributes, Model model){

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
                List<User> userList=userService.findAll();
                model.addAttribute("userList",userList);
                return "admin/list-user";
            }
        }
    }

    @RequestMapping(value = "/list-customerinfo")
    public String ListCustomerInfoPage(HttpServletRequest rq, RedirectAttributes redirectAttributes,Model model){

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
                List<CustomerInfo> customerInfoList=customerInfoService.findAll();
                model.addAttribute("customerInfoList",customerInfoList);
                return "admin/list-customerinfo";
            }
        }
    }

    @RequestMapping(value = "/list-card")
    public String ListCardPage(HttpServletRequest rq, RedirectAttributes redirectAttributes,Model model){

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
                List<Card> cardList=cardService.findAll();
                model.addAttribute("cardList",cardList);
                return "admin/list-card";
            }
        }
    }

    @RequestMapping(value = "/list-address")
    public String ListAddressPage(HttpServletRequest rq, RedirectAttributes redirectAttributes,Model model){

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
                List<Address> addressList=addressService.findAll();
                model.addAttribute("addressList",addressList);
                return "admin/list-address";
            }
        }
    }

    @RequestMapping(value ="/save_user/{id}/{username}/{password}/{role}/{status}")
    public String saveUser(@PathVariable Integer id,
                           @PathVariable String username,
                           @PathVariable String password,
                           @PathVariable int role,
                           @PathVariable Integer status){
        User user = userService.getUserById(id);
        user.setUserName(username);
        user.setStatus(status);
        user.setRole(role);
        user.setPassWord(password);
        userService.saveUser(user);
        return "redirect:/admin/list-user";
    }
    @RequestMapping(value ="/delete_user/{id}")
    public String deleteUser(@PathVariable Integer id){
        userService.deleteUserById(id);
        return "redirect:/admin/list-user";
    }
    @RequestMapping(value ="/admin/delete_customerinfo/{id}")
    public String deleteCustomerInfo(@PathVariable Integer id){
        customerInfoService.deletInfoById(id);
        return "redirect:/admin/list-customerinfo";
    }

    @RequestMapping(value ="/insert_user/{username}/{password}/{status}")
    public String insertUser(@PathVariable String username,
                             @PathVariable String password,
                             @PathVariable Integer status){
        User user = new User();
        user.setUserName(username);
        user.setPassWord(password);
        user.setStatus(status);
        userService.saveUser(user);

        return "redirect:/admin/list-user";
    }

}
