package group5.webapp.FinalProjectOOP.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {
    @RequestMapping(value = {"/", "/home", "/index"})
    public String HomePage(){
        return "admin/home";
    }

    @RequestMapping(value = {"/login"})
    public String LoginPage(){
        return "admin/login";
    }

    @RequestMapping(value = {"/register"})
    public String Register(){
        return "admin/register";
    }

    @RequestMapping(value = {"/profile"})
    public String Profile(){
        return "admin/profile";
    }

    @RequestMapping(value = {"/revenue-statistics"})
    public String RevenueStatisticsPage(){
        return "admin/revenue-statistics";
    }
}
