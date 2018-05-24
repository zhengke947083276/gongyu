package org.com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.com.entity.TblVisit;
import org.com.service.TblVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/vis")
public class Vis {
    @Autowired
    TblVisitService tblVisitService;

    @RequestMapping("/add")
    public String add(){
        return "vis/add";
    }
    @RequestMapping("/insert")
    public String insert(TblVisit tblVisit){
        int i = tblVisitService.addTblVisit(tblVisit);
        System.out.println(i);
        return "redirect:/vis/select";

    }

    @RequestMapping("/select")
    public String select(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        PageHelper.startPage(pn,10);
        List<TblVisit> tblVisits = tblVisitService.selectAll();
        PageInfo pageInfo = new PageInfo(tblVisits,5);
        model.addAttribute("pageInfo",pageInfo);
        return "vis/select";
    }
}