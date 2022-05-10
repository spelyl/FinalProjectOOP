package group5.webapp.FinalProjectOOP.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CartController {

    @RequestMapping(value = "/add-to-cart", method = RequestMethod.POST)
    public String AddToCart(@RequestParam(required = false, value = "product") Integer product,
                            @RequestParam(required = false, value = "quantity") int quantity,
                            HttpServletRequest rq){
        
        return "web/cart";
    }
}
