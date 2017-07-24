package com.fx.spring.Controller;

//import Model.ClosedTradesTransaction;
//import Model.Partner;
//
//import Model.User;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Created by a on 2017-05-03.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
//    User user;
//    List<Partner> listOfAllPartners;
//    List<User> listOfAllUsers;
//    Session sessionClass;
//    HttpSession session;
//    UserDataUtil userDataUtil;
//    Boolean isLogged;
//    ObjectPersist objectPersist;
//    List<ClosedTradesTransaction> closedTradesTransactionslist;
//
//    public LoginServlet() {
//        user = new User();
//        sessionClass = new Session();
//        userDataUtil=new UserDataUtil();
//        isLogged=false;
//        listOfAllPartners=new ArrayList<>();
//        listOfAllUsers=new ArrayList<>();
//        objectPersist =new ObjectPersist();
//        closedTradesTransactionslist=new ArrayList<>();
//        init();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        listOfAllUsers= objectPersist.getListOfAllUsers();
//        listOfAllPartners= objectPersist.getListOfAllPartners();
//        session=sessionClass.getSession(request);
//        session.setAttribute("isLogged",isLogged(request));
//        session.setAttribute("listOfUsers", listOfAllUsers);
//        request.setAttribute("listOfAllPartners", listOfAllPartners);
//
//        if(session.getAttribute("isLogged").equals(true)){
//
//            System.out.println("FROM SESSION - LOGIN: "+((User)session.getAttribute("userSessionData")).getLogin());
//            RequestDispatcher dispatcher=request.getRequestDispatcher("/admin.jsp");
//            dispatcher.forward(request,response);
//        }
//        else{
//            RequestDispatcher dispatcher=request.getRequestDispatcher("/login.jsp");
//            dispatcher.forward(request,response);
//        }
//    }
//
//    Boolean isLogged(HttpServletRequest request){
//
//        for(User value: listOfAllUsers){
//            if(value.getLogin().equals(request.getParameter("login")) && value.getPassword().equals(request.getParameter("password"))){
//                user.setLogin(request.getParameter("login"));
//                user.setPassword(request.getParameter("password"));
//                session.setAttribute("userSessionData",user);
//                isLogged=true;
//                System.out.println("--> Logged succesfully");
//                return isLogged;
//            }
//            else{
//                isLogged=false;
//                System.out.println("---> wrong password or login");
//            }
//        }
//        return isLogged;
//    }
//
//    public void init(){
//        List<String> listOfClosedTradesStrategiesResources=new ArrayList<>();
//        List<ClosedTradesTransaction> listOfClosedTradesStrategies=new ArrayList<>();
//
//        StrategyChooser strategyChooser=new StrategyChooser();
//
//        listOfClosedTradesStrategiesResources=strategyChooser.getListOfClosedTradesStrategiesResources();
//        listOfClosedTradesStrategies=strategyChooser.getListOfClosedTradesStrategies();
//
//
//    for(int i=0;i<listOfClosedTradesStrategies.size();i++){
//        if (objectPersist.getClosedTradesTransactionslist(listOfClosedTradesStrategies.get(i)).size()==0){
//            try {
//                ClosedTradesTransactionCsvReader closedTradesTransactionCsvReader=new ClosedTradesTransactionCsvReader();
//                closedTradesTransactionslist=closedTradesTransactionCsvReader.getClosedTradesTransactionslist(listOfClosedTradesStrategies.get(i));
//
//                objectPersist.addclosedTradesTransactionslist(closedTradesTransactionslist);
//
//                for(ClosedTradesTransaction value: closedTradesTransactionslist){
//                    System.out.println(value.getTransactionId()+" "+value.getSymbol()+" "+value.getProfit());
//                }
//
//            } catch (ParseException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        else return;
//}
//
//    }
}

