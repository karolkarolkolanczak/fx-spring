package com.fx.spring.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TestConnectionServlet")
public class TestConnectionServlet extends HttpServlet {

//@Resource(lookup = "java:/fxdatabase")
//@Resource(lookup = "java:/comp/env/jdbc/fxdatabase")
//@Resource(name="jdbc/fxdatabase")
//private DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String sqlAllPartners = "select * from partner";
//
//        ObjectPersist objectPersist =new ObjectPersist();
//
//        objectPersist.getListOfPartners();

    }
}
