package org.com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.com.entity.TblCheck;
import org.com.entity.TblStudent;
import org.com.service.TblCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/che")
public class Che {
    @Autowired
    TblCheckService tblCheckService;

    @RequestMapping("/add")
    public String add(){
        return "che/add";
    }
    @RequestMapping("insert")
    public String insert(TblCheck tblCheck){
        int i = tblCheckService.addTblCheck(tblCheck);
        System.out.println(i);
        return "redirect:/che/selectAll";
    }
    @RequestMapping("/delete")
    public String delete(TblCheck tblCheck){
        tblCheckService.delete(tblCheck.getCheckId());
        return "redirect:/che/selectAll";
    }
    @RequestMapping("/update")
    public String update(int checkId,int stuState){
        System.out.println(checkId+"  "+stuState);
        tblCheckService.updateTblCheck(checkId, stuState);
        return "redirect:/che/selectAll";
    }

    @RequestMapping("/selectAll")
    public String selectAll(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model){
        //        //引入pagehelper插件
        //查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,5);
        //startPage后就是一个分页查询
        List<TblCheck> tblChecks = tblCheckService.selectCheAndStuAndDormAll();
        PageInfo pageInfo = new PageInfo(tblChecks,5);
        model.addAttribute("pageInfo",pageInfo);
        return "che/select";
    }

    @RequestMapping("/selectWithDormByCheckState1AndStuId")
    @ResponseBody
    public TblCheck selectWithDormByCheckState1AndStuId(Integer stuId){
        return tblCheckService.selectWithDormByCheckState1AndStuId(stuId);
    }
}
