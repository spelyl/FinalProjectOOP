package group5.webapp.FinalProjectOOP.controllers;

import group5.webapp.FinalProjectOOP.models.*;
import group5.webapp.FinalProjectOOP.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class UserCustomerController {

    @Autowired
    UserService userService;

    @Autowired
    CustomerInfoService customerInfoService;

    @Autowired
    UploadFileService uploadFileService;

    @Autowired
    BillService billService;

    @Autowired
    BillDetailService billDetailService;

    @Autowired
    AddressService addressService;

    @Autowired
    CardService cardService;

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String LoginPage(@RequestParam(required = false, value = "username") String username,
                            @RequestParam(required = false, value = "password") String password,
                            RedirectAttributes redirectAttributes,
                            HttpServletRequest rq){
        User user = userService.getUserByUserNameAndPassWord(username,password);

        if(user == null){
            redirectAttributes.addFlashAttribute("message1","Sai thông đăng nhập!!!");
            return "redirect:/login";
        }else {
            redirectAttributes.addFlashAttribute("message1", "Đăng nhập thành công!!!");
            CustomerInfo customerInfo = customerInfoService.findByUser(user);
            if(customerInfo == null){
                CustomerInfo temp = new CustomerInfo();
                temp.setFullname(username);
                customerInfo = temp;
            }
            HttpSession session = rq.getSession();

            session.setAttribute("account", user);
            session.setAttribute("info", customerInfo);
            return "redirect:/home";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String RegisterPage( @RequestParam(required = false, value = "fullname") String fullname,
                                @RequestParam(required = false, value = "email") String email,
                               @RequestParam(required = false, value = "phone") String phone,
                               @RequestParam(required = false, value = "username") String username,
                               @RequestParam(required = false, value = "password") String password,
                               RedirectAttributes redirectAttributes,
                               HttpServletRequest rq){

        User user = userService.getUserByUserName(username);
        if(user != null){
            redirectAttributes.addFlashAttribute("message2", "Tài khoản đăng nhập đã tồn tại!!!");
            return "redirect:/login";
        }else {
            User userRegister = new User();
            userRegister.setUserName(username);
            userRegister.setPassWord(password);
            userRegister.setRole(1);
            userService.saveUser(userRegister);

            userRegister = userService.getUserByUserName(username);
            CustomerInfo customerInfo = new CustomerInfo();
            customerInfo.setFullname(fullname);
            customerInfo.setEmail(email);
            customerInfo.setPhone(phone);
            customerInfo.setUser(userRegister);
            customerInfoService.addCustomerInfo(customerInfo);

            redirectAttributes.addFlashAttribute("message2", "Đăng kí tài khoản thành công!!!");
            return "redirect:/login";
        }
    }

    @RequestMapping(value = {"/recover-password"} , method = RequestMethod.POST)
    public String RecoverPasswordPage(@RequestParam(required = false, value = "username") String username,
                                      @RequestParam(required = false, value = "email") String email,
                                      @RequestParam(required = false, value = "newpassword") String newpassword,
                                      @RequestParam(required = false, value = "confirmpassword") String confirmpassword,
                                      RedirectAttributes redirectAttributes,
                                      Model model){
        User user = userService.getUserByUserName(username);
        if(user != null){
            CustomerInfo customerInfo = customerInfoService.findByEmail(email);

            if(customerInfo.getUser().getId() == user.getId()){
                if(confirmpassword.equals(confirmpassword)){
                    user.setPassWord(newpassword);
                    userService.saveUser(user);
                    redirectAttributes.addFlashAttribute("message1", "Lấy lại mật khẩu thành công!!!");
                    return "redirect:/recover-password";
                }else{
                    redirectAttributes.addFlashAttribute("message1", "Mật khẩu không trùng khớp!!!");
                    return "redirect:/recover-password";
                }
            }else {
                redirectAttributes.addFlashAttribute("message1", "Email không đúng!!!");
                return "redirect:/recover-password";
            }
        }else {
            redirectAttributes.addFlashAttribute("message1", "Không tìm thấy tài khoản!!!");
            return "redirect:/recover-password";
        }
    }

    @RequestMapping(value = "/logout")
    public String LogoutPage(HttpServletRequest rq){
        HttpSession session = rq.getSession();
        session.removeAttribute("account");
        session.removeAttribute("info");
        return "web/login";
    }

    @RequestMapping(value = "/profile")
    public String ProfileUserPage(HttpServletRequest rq,
                                  Model model){
        HttpSession session = rq.getSession();

        User user = (User) session.getAttribute("account");
        if(user != null){
            return "web/profile";
        }
        return "redirect:/login";
    }

    @RequestMapping(value = "/edit-profile", method = RequestMethod.POST)
    public String EditProfile(@RequestParam(required = false, value = "fullname") String fullname,
                              @RequestParam(required = false, value = "phone") String phone,
                              @RequestParam(required = false, value = "email") String email,
                              @RequestParam(required = false, value = "username") String username,
                              @RequestParam(required = false, value = "birthday") Date birthday,
                              RedirectAttributes redirectAttributes,
                              HttpServletRequest rq){

        HttpSession session = rq.getSession();

        try {
            User user = (User) session.getAttribute("account");
            User usernameCheck = userService.getUserByUserName(username);
            if(username.isEmpty()){
                redirectAttributes.addFlashAttribute("message1", "Tên tài khoản không được để trống!!!");
                return "redirect:/profile";
            }else if(usernameCheck != null && user.getUserName().equals(username) == false){
                    redirectAttributes.addFlashAttribute("message1", "Tên tài khoản đã tồn tại!!!");
                    return "redirect:/profile";
            }
            user.setUserName(username);
            userService.saveUser(user);
            CustomerInfo customerInfo = (CustomerInfo) session.getAttribute("info");
            customerInfo.setUser(user);
            customerInfo.setFullname(fullname);
            customerInfo.setPhone(phone);
            customerInfo.setEmail(email);
            customerInfo.setBithday(birthday);
            customerInfoService.addCustomerInfo(customerInfo);

            User newUser = userService.getUserByUserName(username);
            CustomerInfo newCustomerInfo = customerInfoService.findByUser(newUser);

            session.removeAttribute("account");
            session.removeAttribute("info");
            session.setAttribute("account", newUser);
            session.setAttribute("info", customerInfo);

            redirectAttributes.addFlashAttribute("message1", "Cập nhập thông tin thành công!!!");
            return "redirect:/profile";
        }catch (Exception e){
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("message1", "Cập nhập thông tin thất bại!!!");
        return "redirect:/profile";
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
    public String ChangePassword(@RequestParam(required = false, value = "oldpassword") String oldpassword,
                                 @RequestParam(required = false, value = "newpassword") String newpassword,
                                 @RequestParam(required = false, value = "confirmpassword") String confirmpassword,
                                 RedirectAttributes redirectAttributes,
                                 HttpServletRequest rq
                                 ){
        HttpSession session = rq.getSession();

        try {
            User user = (User) session.getAttribute("account");
            if(oldpassword.equals(user.getPassWord())){
                if(newpassword.equals(confirmpassword)){
                    user.setPassWord(newpassword);
                    userService.saveUser(user);
                    session.removeAttribute("account");
                    session.setAttribute("account", userService.getUserByUserName(user.getUserName()));
                    redirectAttributes.addFlashAttribute("message2", "Đổi mật khẩu thành công!!!");
                    return "redirect:/profile";
                }else {
                    redirectAttributes.addFlashAttribute("message2", "Mật khẩu mới không trùng nhau!!!");
                    return "redirect:/profile";
                }
            }else {
                redirectAttributes.addFlashAttribute("message2", "Mật khẩu cũ không đúng!!!");
                return "redirect:/profile";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("message2", "Đổi mật khẩu thất bại!!!");
        return "redirect:/profile";

    }

    @RequestMapping(value = "/change-avt", method = RequestMethod.POST)
    public String ChangeAvatar( @RequestParam("avatar") MultipartFile avatar,
                                HttpServletRequest rq,
                                RedirectAttributes redirectAttributes){

        HttpSession session = rq.getSession();

        CustomerInfo customerInfo = (CustomerInfo) session.getAttribute("info");

        try{
            customerInfo.setLinkAVT(uploadFileService.storeFile(avatar));
            customerInfoService.addCustomerInfo(customerInfo);

            session.removeAttribute("info");
            session.setAttribute("info", customerInfoService.findByUser(customerInfo.getUser()));

            redirectAttributes.addFlashAttribute("message3", "Đổi avatar thành công!!!");
            return "redirect:/profile";
        }catch (Exception e){
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("message3", "Đổi avatar thất bại!!!");
        return "redirect:/profile";
    }

    @RequestMapping(value = "/transaction-history")
    public String TransactionHistoryPage(HttpServletRequest rq,
                                         Model model){
        HttpSession session = rq.getSession();

        User user = (User) session.getAttribute("account");
        if(user != null){

            List<Bill> billList = billService.findAllByUserAndStatus(user, 1);

            List<BillDetail> billDetailList = billDetailService.findAll();

            model.addAttribute("billList", billList);
            model.addAttribute("billDetailList", billDetailList);

            return "web/transaction-history";
        }
        return "redirect:/login";

    }

    @RequestMapping(value = "/address")
    public String AddressPage(HttpServletRequest rq,
                              RedirectAttributes attributes,
                              Model model){
        HttpSession session = rq.getSession();

        User user = (User) session.getAttribute("account");

        if(user == null)
            return "redirect:/login";

        return "web/address";
    }

    @RequestMapping(value = "/card")
    public String CardPage(HttpServletRequest rq,
                           RedirectAttributes attributes,
                           Model model){
            HttpSession session = rq.getSession();

            User user = (User) session.getAttribute("account");

            if(user == null)
                return "redirect:/login";

        return "web/card";
    }

    @RequestMapping(value = "/payment")
    public String PaymentPage(HttpServletRequest rq,
                            RedirectAttributes attributes,
                            Model model){
        HttpSession session = rq.getSession();

        User user = (User) session.getAttribute("account");

        if(user == null){
            return "redirect:/login";
        }else {
            Optional<Bill> billCheck = billService.findByUserAndStatus(user,-1);
            if(billCheck.isPresent()){
                Bill bill = billCheck.get();
                List<Address> addressList =  addressService.findAllByUser(user);
                List<Card> cardList =  cardService.findAllByUser(user);

                model.addAttribute("total", bill.getTotal());
                model.addAttribute("addressList", addressList);
                model.addAttribute("cardList", cardList);
            }
        }

        return "web/payment";
    }

    @RequestMapping(value = {"/payment-confirm"})
    public String PaymentConfirmPage(HttpServletRequest rq,
                            RedirectAttributes attributes,
                            Model model){
        HttpSession session = rq.getSession();

        User user = (User) session.getAttribute("account");

        if(user == null){
            return "redirect:/login";
        }else {
            Optional<Bill> billCheck = billService.findByUserAndStatus(user,-1);
            if(billCheck.isPresent()){
                Bill bill = billCheck.get();
                Date date = Date.valueOf(LocalDate.now());
                bill.setDate(date);
                bill.setStatus(1);
                List<BillDetail> listBillDetail = billDetailService.findAllByBillId(bill);
                for(BillDetail bd : listBillDetail){
                    Product product = bd.getProductId();
                    int newAmount = product.getAmount() + bd.getQuantity();
                    if(newAmount > product.getQuantity()){
                        attributes.addFlashAttribute("message", "Thanh toán thất bại !!!");
                        return "redirect:/cart";
                    }

                    product.setAmount(newAmount);
                    productService.saveProduct(product);
                }
                billService.saveBill(bill);
                attributes.addFlashAttribute("message", "Thanh toán thành công !!!");
                return "redirect:/cart";
            }

            attributes.addFlashAttribute("message", "Vui lòng đặt hàng trước khi thanh toán !!!");
            return "redirect:/cart";
        }
    }
}
