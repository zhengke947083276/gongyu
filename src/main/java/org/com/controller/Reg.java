package org.com.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.com.dao.TblStudentMapper;
import org.com.entity.TblRegistration;
import org.com.entity.TblStudent;
import org.com.service.TblRegistrationService;
import org.com.service.TblStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/reg")
public class Reg {
    @Autowired
    TblRegistrationService tblRegistrationService;
    @Autowired
    TblStudentService tblStudentService;

    @RequestMapping("/jinChu")
    public String jinChu(){
        return "reg/jinChu";
    }
    @RequestMapping("/add")
    public String add(TblRegistration tblRegistration, TblStudent tblStudent){
        int stuId = tblRegistrationService.addTblReg(tblRegistration, tblStudent);
        System.out.println(stuId);
        return "forward:/reg/selectSutId?stuId="+stuId;
    }
    @RequestMapping("/select")
    public String select(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
        //引入pagehelper插件
        //查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,10);
        //startPage后就是一个分页查询
        List<TblRegistration> tblRegistrations = tblRegistrationService.selectAll();
        //使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了
        //封装了详细的分页信息，包括有我们查询出来的数据,c传入连续显示的页数
        PageInfo pageInfo = new PageInfo(tblRegistrations,5);
        model.addAttribute("pageInfo",pageInfo);
        return "reg/select";
    }
    @RequestMapping("/selectSutId")
    public String selectSutId(Model model,Integer stuId,@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        //引入pagehelper插件
        //查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn,10);
        //startPage后就是一个分页查询
        List<TblRegistration> tblRegistrations = tblRegistrationService.selectAllByStuId(stuId);
        //使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了
        //封装了详细的分页信息，包括有我们查询出来的数据,c传入连续显示的页数
        PageInfo pageInfo = new PageInfo(tblRegistrations,5);
        model.addAttribute("pageInfo",pageInfo);
        return "reg/select";
    }


    @RequestMapping("/delete")
    public String delete(Integer regID){
        int n = tblRegistrationService.delete(regID);
        System.out.println(n);
        return "redirect:/reg/select";
    }
}
