package com.fx.spring.Dao;

import com.fx.spring.Entity.Partner;
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
public class PartnerDaoImpl implements PartnerDAO {

    @Autowired
    private SessionFactory sessionFactory;
    Session session;

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
    public void deletePartnerById(int PartnerId) {
        session=sessionFactory.getCurrentSession();

    }

    @Override
    @Transactional
    public void updatePartner(Partner updatedPartner) {
        session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(updatedPartner);
    }
}
