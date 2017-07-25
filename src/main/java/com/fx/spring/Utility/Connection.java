package com.fx.spring.Utility;

import com.fx.spring.Entity.User;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by a on 24/07/2017.
 */
@Repository
public class Connection {
//     create session factory (OTHER WAY WITH "hibernate.cfg.xml")
    SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(User.class)
            .buildSessionFactory();


//    @Autowired
//    private SessionFactory sessionFactory;
//
//

//@Transactional   (at the begining of method it autmatically you dont need following commands:)
//session.beginTransaction();
//session.getTransaction().commit();

Session session;

    public void addUser() {
        User user=new User("firstName",  "lastName",  "zz",  "password", "email");

        session = sessionFactory.getCurrentSession();
        // start a transaction
        session.beginTransaction();
        // save object to database
        session.save(user);
        // commit transaction
        session.getTransaction().commit();


        System.out.println("saved user id: "+user.getUserId());


        System.out.println("------");
        }
//        public User getUser(){
//
//        return
//        }

    public User getUserById(int userId){
            session = sessionFactory.getCurrentSession();
            // start a transaction
            session.beginTransaction();

            User user=session.get(User.class,userId);

            session.getTransaction().commit();
            System.out.println("user from database: "+user.getUserId()+" "+user.getLogin());
            session.close();
        return user;
    }
    public List<User> getListOfAllUsers(){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<User> listOfAllUsers=new ArrayList<>();
        listOfAllUsers=session.createQuery("from User").getResultList();

        session.getTransaction().commit();
        session.close();
        return listOfAllUsers;
    }
    public User updateUserById(int userId,User updatedUser){


        session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        User userFromDatabase=session.get(User.class,userId);

        userFromDatabase.setLogin(updatedUser.getLogin());
        session.update(userFromDatabase);

        session.getTransaction().commit();
        session.close();
        return userFromDatabase;
    }

    public void deleteUserById(int userId) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();

//        User user=session.get(User.class,userId);
//        session.delete(user);
String queryString="delete from User where userId="+userId;
        session.createQuery(queryString).executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}
