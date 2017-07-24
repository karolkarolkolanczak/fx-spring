package com.fx.spring.Utility;

import com.fx.spring.ModelFx.Partner;

import java.util.ArrayList;
import java.util.List;

public class PartnerDataUtil {
    List<Partner> listOfPartners =new ArrayList<>();
    ObjectPersist objectPersist =new ObjectPersist();

    public List<Partner> getListOfAllPartners(){

//        listOfPartners.add(new Partner("ala","nowak","234@wp.pl"));
//        listOfPartners.add(new Partner("zenek","wiaderek","345@wp.pl"));
//        listOfPartners.add(new Partner("wojtek","ccc","456@wp.pl"));

        listOfPartners= objectPersist.getListOfAllPartners();

        return listOfPartners;
    }

//    public void addToListOfPartners(Partner partner){
//        objectPersist.addToListOfPartners(partner);
//    }

}
