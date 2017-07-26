package com.fx.spring.Dao;

import com.fx.spring.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a on 25/07/2017.
 */
@Repository
public class UserDAOImpl implements UserDAO {


// old way
//    SessionFactory sessionFactory = new Configuration()
//            .configure("hibernate.cfg.xml")
//            .addAnnotatedClass(User.class)
//            .buildSessionFactory();


    @Autowired
    private SessionFactory sessionFactory;
    Session session;

    public UserDAOImpl() {
    }

    @Override
    @Transactional
    public List<User> getListOfAllUsers() {
        session = sessionFactory.getCurrentSession();

        List<User> listOfAllUsers=new ArrayList<>();

        listOfAllUsers=(ArrayList<User>) session.createQuery("from User",User.class).getResultList();

        return listOfAllUsers;
    }
}
