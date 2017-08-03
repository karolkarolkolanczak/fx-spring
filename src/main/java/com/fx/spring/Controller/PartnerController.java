package com.fx.spring.Controller;

import com.fx.spring.Dao.PartnerDAO;
import com.fx.spring.Dao.PartnerDaoImpl;
import com.fx.spring.Entity.ClosedTradesTransaction;
import com.fx.spring.Entity.Partner;
import com.fx.spring.Entity.User;
import com.fx.spring.Utility.ClosedTradesTransactionCsvReader;
import com.fx.spring.Utility.PartnerDataUtil;
import com.fx.spring.Utility.StrategyChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by a on 26/07/2017.
 */
@Controller
public class PartnerController {
    @Autowired
    private PartnerDAO partnerDAO;

    StrategyChooser strategyChooser;
    float totalLotsTurnoverForPeriod;

    public PartnerController() {
        strategyChooser=new StrategyChooser();
    }

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

    @RequestMapping(value="/detailsPartner",method=RequestMethod.GET)
    String detailsPartner(@RequestParam("parameterPartnerId")int parameterPartnerId, Model model) {
        Partner partner=new Partner();
        PartnerDataUtil partnerDataUtil=new PartnerDataUtil();
        List<ClosedTradesTransaction> closedTradesTransactionslist=new ArrayList<>();
        String className=partner.getClass().getSimpleName().toLowerCase();
        partner=partnerDAO.getPartnerById(parameterPartnerId);
        partnerDataUtil.setClosedTradesFrom("2017-01-01");
        partnerDataUtil.setClosedTradesTo("2017-06-30");
        closedTradesTransactionslist=  partnerDAO.getClosedTradesTransactionslistFiltered(strategyChooser.getClosedTradesStrategyNewObjectByChosenStrategyNumber(partner.getClosedTradesTransactionStrategyNumber()),partnerDataUtil.getClosedTradesFrom(),partnerDataUtil.getClosedTradesTo());
        totalLotsTurnoverForPeriod=0;
        float totalLotsTurnoverForPeriod=sum(closedTradesTransactionslist);
        float totalBonusForPeriod=16 *totalLotsTurnoverForPeriod;
        model.addAttribute("closedTradesTransactionslist", closedTradesTransactionslist);
        model.addAttribute("totalLotsTurnoverForPeriod",totalLotsTurnoverForPeriod);
        model.addAttribute("totalBonusForPeriod",totalBonusForPeriod);
        model.addAttribute("partner",partner);
        model.addAttribute("partnerDataUtil", partnerDataUtil);
        return "partnerDetails";
    }

    @RequestMapping(value="/detailsPartnerFilter", method = RequestMethod.POST)
    String detailsPartnerFilter(@ModelAttribute("partnerDataUtil")PartnerDataUtil partnerDataUtil,Model model) {
        List<ClosedTradesTransaction> closedTradesTransactionslist=new ArrayList<>();
        Partner partner=new Partner();
        partner=partnerDAO.getPartnerById(partnerDataUtil.getPartnerId());
        closedTradesTransactionslist=  partnerDAO.getClosedTradesTransactionslistFiltered(strategyChooser.getClosedTradesStrategyNewObjectByChosenStrategyNumber(partner.getClosedTradesTransactionStrategyNumber()),partnerDataUtil.getClosedTradesFrom(),partnerDataUtil.getClosedTradesTo());
        //        W przypadku pary walutowej EURUSD stawka bonusowa dla Partnera wynosi 16 USD za 1 Lota. Zatem za dany okres Partner otrzyma: USD 16 * 3,84 Lota = USD 61.44 .
        totalLotsTurnoverForPeriod=0;
        float totalLotsTurnoverForPeriod=sum(closedTradesTransactionslist);
        float totalBonusForPeriod=16 *totalLotsTurnoverForPeriod;
        model.addAttribute("closedTradesTransactionslist", closedTradesTransactionslist);
        model.addAttribute("totalLotsTurnoverForPeriod",totalLotsTurnoverForPeriod);
        model.addAttribute("totalBonusForPeriod",totalBonusForPeriod);
        model.addAttribute("partner",partner);
        model.addAttribute("partnerDataUtil", partnerDataUtil);
        return "partnerDetails";
    }

    float sum(List<ClosedTradesTransaction> closedTradesTransactionslist){
        for(int i=0;i<closedTradesTransactionslist.size();i++){
            totalLotsTurnoverForPeriod= (float) (totalLotsTurnoverForPeriod+closedTradesTransactionslist.get(i).getLots());
        }
        return totalLotsTurnoverForPeriod;
    }
}
