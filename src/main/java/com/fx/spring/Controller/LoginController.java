package com.fx.spring.Controller;

import com.fx.spring.ModelFx.ClosedTradesTransaction;
import com.fx.spring.ModelFx.Partner;
import com.fx.spring.ModelFx.User;
import com.fx.spring.Utility.ObjectPersist;
import com.fx.spring.Utility.UserDataUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 17/07/2017.
 */
@Controller
//@RequestMapping("/login")
public class LoginController {

User user;

    public LoginController() {
//        user=new User();
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(Model model){
        System.out.println("Login Controller");
        User user = new User();
        user.setLogin("john");
        user.setPassword("balboa");
        model.addAttribute("user", user);
        System.out.println("--part 1--");
        return "login";
    }


    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    String register( @ModelAttribute("user") User user, BindingResult result) {
        System.out.println("2");
        System.out.println("Login: "+ user.getLogin()+" Pass: "+user.getPassword());
        return "login";
    }







}
