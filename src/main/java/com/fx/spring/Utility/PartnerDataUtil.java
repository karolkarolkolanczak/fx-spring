package com.fx.spring.Utility;

import com.fx.spring.Entity.Partner;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

public class PartnerDataUtil {


    private int partnerId;

    private String closedTradesFrom;

    private String closedTradesTo;

    public PartnerDataUtil() {
    }

    List<Partner> listOfPartners =new ArrayList<>();
    ObjectPersist objectPersist =new ObjectPersist();

    public List<Partner> getListOfAllPartners(){

//        listOfPartners.add(new Partner("ala","nowak","234@wp.pl"));
//        listOfPartners.add(new Partner("zenek","wiaderek","345@wp.pl"));
//        listOfPartners.add(new Partner("wojtek","ccc","456@wp.pl"));

        listOfPartners= objectPersist.getListOfAllPartners();

        return listOfPartners;
    }

    public int getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(int partnerId) {
        this.partnerId = partnerId;
    }

    public String getClosedTradesFrom() {
        return closedTradesFrom;
    }

    public void setClosedTradesFrom(String closedTradesFrom) {
        this.closedTradesFrom = closedTradesFrom;
    }

    public String getClosedTradesTo() {
        return closedTradesTo;
    }

    public void setClosedTradesTo(String closedTradesTo) {
        this.closedTradesTo = closedTradesTo;
    }

    @Override
    public String toString() {
        return "PartnerDataUtil{" +
                "partnerId=" + partnerId +
                ", closedTradesFrom='" + closedTradesFrom + '\'' +
                ", closedTradesTo='" + closedTradesTo + '\'' +
                '}';
    }
}
