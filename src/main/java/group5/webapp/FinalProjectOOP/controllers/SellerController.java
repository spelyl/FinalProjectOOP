package group5.webapp.FinalProjectOOP.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/seller")
public class SellerController {

    @RequestMapping(value = {"/", "/home", "/index"})
    public String HomePage(){
        return "seller/home";
    }

    @RequestMapping(value = {"/login"})
    public String LoginPage(){
        return "seller/login";
    }

    @RequestMapping(value = {"/register"})
    public String Register(){
        return "seller/register";
    }

    @RequestMapping(value = {"/profile"})
    public String Profile(){
        return "seller/profile";
    }

}
