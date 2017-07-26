package com.fx.spring.Controller;

import com.fx.spring.Dao.PartnerDAO;
import com.fx.spring.Entity.Partner;
import com.fx.spring.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by a on 26/07/2017.
 */
@Controller
public class PartnerController {
    @Autowired
    private PartnerDAO partnerDAO;

    @RequestMapping(value = "/addPartner", method = RequestMethod.POST)
    String addPartnerForm(@ModelAttribute("partner")Partner partner) {
        partnerDAO.addPartner(partner);
        return "redirect:admin";
    }

    @RequestMapping(value="/editPartner", method = RequestMethod.GET)
    public String editPartner(@RequestParam("parameterPartnerId")int parameterPartnerId, Model model){
        Partner partner=new Partner();
        partner=partnerDAO.getPartnerById(parameterPartnerId);
        model.addAttribute("partner",partner);
        return "editPartner";
    }

    @RequestMapping(value="/editPartner", method = RequestMethod.POST)
    public String editPartner(@ModelAttribute("partner")Partner partner){
        partnerDAO.updatePartner(partner);
        return "editPartner";
    }

    @RequestMapping(value="/deletePartner", method = RequestMethod.GET)
    String deletePartner(@RequestParam("parameterPartnerId")int parameterPartnerId){
        partnerDAO.deletePartnerById(parameterPartnerId);
        return "redirect:admin";
    }
//    @ModelAttribute("partner")Partner partner
}
