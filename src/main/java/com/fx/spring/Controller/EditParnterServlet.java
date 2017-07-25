package com.fx.spring.Controller;

import com.fx.spring.Entity.Partner;
import com.fx.spring.Utility.ObjectPersist;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by a on 20/06/2017.
 */
@WebServlet("/EditParnterServlet")
public class EditParnterServlet extends HttpServlet{


    ObjectPersist objectPersist;
    Partner partner;

    public EditParnterServlet() {
        objectPersist=new ObjectPersist();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        partner = new Partner();
        String className=partner.getClass().getSimpleName().toLowerCase();
        int partnerId= Integer.parseInt(request.getParameter("parameterPartnerId"));

        partner=(Partner)objectPersist.findObjectById(partnerId);
        request.setAttribute("partnerDetails",partner);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/editPartner.jsp");
        dispatcher.forward(request, response);
    }
}
