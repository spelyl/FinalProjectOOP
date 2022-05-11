package group5.webapp.FinalProjectOOP.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/admin")
public class AdminHomeController {
    @RequestMapping(value = {"/login"},method = RequestMethod.GET)
    public String LoginPage(){

        return "admin/login";
    }
}
