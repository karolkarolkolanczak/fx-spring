package com.fx.spring.Controller;

import com.fx.spring.Dao.PartnerDAO;
import com.fx.spring.Dao.UserDAO;
import com.fx.spring.Entity.Partner;
import com.fx.spring.Entity.User;
import com.fx.spring.Utility.FxQuotesParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

/**
 * Created by a on 24/07/2017.
 */
@Controller
public class AdminController {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PartnerDAO partnerDAO;
    FxQuotesParser fxQuotesParser;
//    ArrayList<User> listOfAllUsers;
//    ArrayList<Partner>listOfAllPartners;

    public AdminController() {
        fxQuotesParser=new FxQuotesParser();
//        listOfAllUsers=new ArrayList<>();
//        listOfAllPartners=new ArrayList<>();
    }

    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public String admin(Model model){
//        model.addAttribute("listOfAllUsers",userDAO.getListOfAllUsers());
        Partner partner=new Partner();
        partner.setFirstName("adam");
        partner.setLastName("kowalski");
        partner.setLogin("adam");
        partner.setPassword("123");
        partner.setEmail("123@wp.pl");
        partner.setClosedTradesTransactionStrategyNumber(1);
        model.addAttribute("listOfAllPartners",partnerDAO.getListOfAllPartners());
        model.addAttribute("partner",partner);
        try {
            model.addAttribute("listOfQuotes",fxQuotesParser.getListOfQuotes());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        for(Partner value:listOfAllPartners){
//            System.out.println("2 partner: "+value.getPartnerId()+" "+value.getLogin());
//        }
//        for(User value:listOfAllUsers){
//            System.out.println("2 user: "+value.getUserId()+" "+value.getLogin());
//        }
//        User user = new User();
//        user.setLogin("admin");
//        user.setPassword("admin");
//        listOfAllUsers=userDAO.getListOfAllUsers();
//        listOfAllPartners=partnerDAO.getListOfAllPartners();
//        model.addAttribute("user", user);
//        model.addAttribute("listOfAllUsers",listOfAllUsers);
//
//        model.addAttribute("listOfAllPartners",listOfAllPartners);
        return "admin";
    }

    @RequestMapping(value="/GoToAdmin", method = RequestMethod.GET)
    public String GoToAdmin(){
        return "redirect:admin";
    }
    @RequestMapping(value="/LogOut", method = RequestMethod.GET)
    public String LogOut(){
        return "redirect:login";
    }


}
