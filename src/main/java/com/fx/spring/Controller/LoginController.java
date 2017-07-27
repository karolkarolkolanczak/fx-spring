package com.fx.spring.Controller;

import com.fx.spring.Dao.PartnerDAO;
import com.fx.spring.Dao.PartnerDaoImpl;
import com.fx.spring.Dao.UserDAO;
import com.fx.spring.Entity.ClosedTradesTransaction;
import com.fx.spring.Entity.User;
import com.fx.spring.Utility.ClosedTradesTransactionCsvReader;
import com.fx.spring.Utility.StrategyChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//import java.util.ArrayList;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 17/07/2017.
 */
@Controller
//@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private PartnerDAO partnerDAO;
    PartnerDaoImpl partnerDaoImpl;
    User user;
    List<ClosedTradesTransaction> closedTradesTransactionslist;
//    ArrayList<User>listOfAllUsers;
//    ArrayList<Partner>listOfAllPartners;
    Boolean isLogged;


    public LoginController() {
//        listOfAllUsers=new ArrayList<>();
//        listOfAllPartners=new ArrayList<>();
        isLogged=false;
        closedTradesTransactionslist=new ArrayList<>();
        partnerDaoImpl=new PartnerDaoImpl();
init();
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String showLoginPage(Model model){
        User user = new User();
        user.setLogin("admin");
        user.setPassword("admin");
//        listOfAllUsers=userDAO.getListOfAllUsers();
//        listOfAllPartners=partnerDAO.getListOfAllPartners();
        model.addAttribute("user", user);
//        init();
        return "login";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    String register( @ModelAttribute("user") User user,  BindingResult result) {
        if(isLogged(user).equals(true)){
            System.out.println("User '"+user.getLogin()+"': logged");
//            for(Partner value:listOfAllPartners){
//                System.out.println("1 partner: "+value.getPartnerId()+" "+value.getLogin());
//            }
//            for(User value:listOfAllUsers){
//                System.out.println("1 user: "+value.getUserId()+" "+value.getLogin());
//            }

            return "redirect:admin";
        }
        else{
            System.out.println("WRONG login");
            return "redirect:login";
        }
    }


    public Boolean isLogged(User userFromForm){

        for(User value: userDAO.getListOfAllUsers()){
            if(value.getLogin().equals(userFromForm.getLogin()) && value.getPassword().equals(userFromForm.getPassword())){
                isLogged=true;
                return isLogged;
            }
            else{
                isLogged=false;
            }
        }
        return isLogged;
    }

    public void init(){
//        List<String> listOfClosedTradesStrategiesResources=new ArrayList<>();
        List<ClosedTradesTransaction> listOfClosedTradesStrategies=new ArrayList<>();

        StrategyChooser strategyChooser=new StrategyChooser();

//        listOfClosedTradesStrategiesResources=strategyChooser.getListOfClosedTradesStrategiesResources();
        listOfClosedTradesStrategies=strategyChooser.getListOfClosedTradesStrategies();


        for(int i=0;i<listOfClosedTradesStrategies.size();i++){
            if (partnerDaoImpl.getClosedTradesTransactionslist(listOfClosedTradesStrategies.get(i)).size()==0){
                try {
                    ClosedTradesTransactionCsvReader closedTradesTransactionCsvReader=new ClosedTradesTransactionCsvReader();
                    closedTradesTransactionslist=closedTradesTransactionCsvReader.getClosedTradesTransactionslist(listOfClosedTradesStrategies.get(i));

                    partnerDaoImpl.addclosedTradesTransactionslist(closedTradesTransactionslist);

                    for(ClosedTradesTransaction value: closedTradesTransactionslist){
                        System.out.println(value.getTransactionId()+" "+value.getSymbol()+" "+value.getProfit());
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else return;
        }
    }
}
