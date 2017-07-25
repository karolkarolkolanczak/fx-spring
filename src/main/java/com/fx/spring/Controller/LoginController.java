package com.fx.spring.Controller;

import com.fx.spring.Dao.UserDAO;
import com.fx.spring.Dao.UserDAOImpl;
import com.fx.spring.Entity.User;
import com.fx.spring.Utility.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 17/07/2017.
 */
@Controller
//@RequestMapping("/login")
public class LoginController {

    User user;
    @Autowired
    private UserDAO userDAO;
    List<User>listOfAllUsers;
    Boolean isLogged;

    public LoginController() {
        listOfAllUsers=new ArrayList<>();
        isLogged=false;
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(Model model){
        User user = new User();
        user.setLogin("admin");
        user.setPassword("admin");
        model.addAttribute("user", user);
        listOfAllUsers=userDAO.getAllUsers();
        model.addAttribute("listOfAllUsers",listOfAllUsers);
        return "login";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    String register( @ModelAttribute("user") User user, BindingResult result) {
        if(isLogged(user).equals(true)){
            System.out.println("SUCCESSS");
            return "admin";
        }
        else{
            System.out.println("WRONG login");
            return "login";
        }
    }

    public Boolean isLogged(User userFromForm){

        for(User value: listOfAllUsers){
            if(value.getLogin().equals(userFromForm.getLogin()) && value.getPassword().equals(userFromForm.getPassword())){

                isLogged=true;
                System.out.println("--> Logged succesfully");
                return isLogged;
            }
            else{
                isLogged=false;
                System.out.println("---> wrong password or login");
            }
        }
        return isLogged;
    }
}
