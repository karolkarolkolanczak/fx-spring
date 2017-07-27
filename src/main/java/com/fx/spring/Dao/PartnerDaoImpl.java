package com.fx.spring.Dao;

import com.fx.spring.Entity.ClosedTradesTransaction;
import com.fx.spring.Entity.Partner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by a on 25/07/2017.
 */
@Repository
public class PartnerDaoImpl implements PartnerDAO {

    @Autowired
    private SessionFactory sessionFactory;
    Session session;

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fxdatabase-persistence-unit");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public PartnerDaoImpl() {
    }

    @Override
    @Transactional
    public List<Partner> getListOfAllPartners() {
        session=sessionFactory.getCurrentSession();
        List<Partner> listOfAllPartners=new ArrayList<>();
        listOfAllPartners= (ArrayList<Partner>) session.createQuery("from Partner",Partner.class).getResultList();
        return listOfAllPartners;
    }

    @Override
    @Transactional
    public void addPartner(Partner partner) {
        session=sessionFactory.getCurrentSession();
        session.save(partner);
    }

    @Override
    @Transactional
    public Partner getPartnerById(int partnerId) {
        session=sessionFactory.getCurrentSession();
        Partner partner=session.get(Partner.class,partnerId);
        return partner;
    }

    @Override
    @Transactional
    public void deletePartnerById(int partnerId) {
        session=sessionFactory.getCurrentSession();
        Partner partner=session.get(Partner.class,partnerId);
        session.delete(partner);
    }

    @Override
    @Transactional
    public void updatePartner(Partner updatedPartner) {
        session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(updatedPartner);
    }

    @Override
    public List<ClosedTradesTransaction> getClosedTradesTransactionslist(ClosedTradesTransaction closedTradesTransaction){
        List<ClosedTradesTransaction>closedTradesTransactionslist=new ArrayList<>();
        entityManager.getTransaction().begin();
        String queryString="SELECT e FROM "+closedTradesTransaction.getClass().getSimpleName()+" e";
        javax.persistence.Query query = entityManager.createQuery(queryString, ClosedTradesTransaction.class);
        closedTradesTransactionslist=query.getResultList();
        entityManager.flush();
        entityManager.clear();
        entityManager.getTransaction().commit();
        return closedTradesTransactionslist;
    }

    @Override
    public void addclosedTradesTransactionslist(List<ClosedTradesTransaction> closedTradesTransactionslist) {
        for(int i=0;i< closedTradesTransactionslist.size();i++){
            entityManager.getTransaction().begin();
            // must be "entityManager.merge" instead "entityManager.persist " if not will be "detached entity passed to persist"
            entityManager.persist (closedTradesTransactionslist.get(i));
            entityManager.flush();
            entityManager.clear();
            entityManager.getTransaction().commit();
        }
    }
    @Override
    public List<ClosedTradesTransaction> getClosedTradesTransactionslistFiltered(ClosedTradesTransaction closedTradesTransaction, String closedTradesFrom, String closedTradesTo){
        List<ClosedTradesTransaction>closedTradesTransactionslist=new ArrayList<>();
        entityManager.getTransaction().begin();
        String queryString="SELECT * FROM "+closedTradesTransaction.getClass().getSimpleName()+" WHERE closeDate between '"+closedTradesFrom+"' and '"+closedTradesTo+"'";
//        "SELECT * FROM ClosedTradesTransaction WHERE closeDate between '2017-01-01' and '2017-02-01'"
        javax.persistence.Query query = entityManager.createNativeQuery(queryString, closedTradesTransaction.getClass());
        closedTradesTransactionslist=query.getResultList();
        entityManager.flush();
        entityManager.clear();
        entityManager.getTransaction().commit();
        return closedTradesTransactionslist;
    }

}
