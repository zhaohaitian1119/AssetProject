package com.zht.asset.controller;

import com.zht.asset.pojo.Asstes;
import com.zht.asset.service.AssteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-07 17:15
 */
@Controller
public class AssteController {

    @Resource
    AssteService assteService;

    @RequestMapping("/")
    public String toindex(Model model, HttpServletRequest request){
        String assetid = request.getParameter("assetid");
        if(assetid != null && !assetid.equals("")){
            List<Asstes> asstes = assteService.selByAssteId(assetid);
            model.addAttribute("assteslist",asstes);
        }else{
            List<Asstes> asstes = assteService.selByAssteId(null);
            model.addAttribute("assteslist",asstes);
        }

        return "index";
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request){
        String assetid = request.getParameter("assetid");
        String assetname = request.getParameter("assetname");
        String assettype = request.getParameter("assettype");
        String intodate = request.getParameter("intodate");
        SimpleDateFormat simdate1=new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        try {
            date1 = simdate1.parse(intodate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Asstes asstes = new Asstes();
        asstes.setAssetid(assetid);
        asstes.setAssetname(assetname);
        asstes.setAssettype(assettype);
        asstes.setIntodate(date1);
        int insert = assteService.insert(asstes);
        return "redirect:/";
    }
}
