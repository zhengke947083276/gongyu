package org.com.controller;

import org.apache.poi.hssf.usermodel.*;
import org.com.entity.TblDorm;
import org.com.entity.User;
import org.com.service.TblDormService;
import org.com.view.ViewExcel;
import org.com.view.ViewPDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class XDorm {
    @Autowired
    TblDormService tblDormService;
    @RequestMapping(value = "/excel")
    public ModelAndView viewExcel() {
        Map<String, Object> model = new HashMap<>();
        List<TblDorm> tblDorms = tblDormService.selectAll();
        model.put("tblDormList", tblDorms);
        return new ModelAndView(new ViewExcel(), model);
    }



//    @RequestMapping("/pdf")
//    public ModelAndView viewPDF(){
//        Map<String, Object> model = new HashMap<>();
//        model.put("userList", getStudents());
//        return new ModelAndView(new ViewPDF(), model);
//    }

    @RequestMapping("/pdf")
    public ModelAndView viewPDF(){
        ModelAndView mv = new ModelAndView();
        ViewPDF viewPDF = new ViewPDF();
        mv.setView(viewPDF);
        return mv;
    }

    private List<User> getStudents() {
        List<User> userList = new ArrayList<>();
        User user = new User(1,"zhengke1", "0000",12,"男");
        User user1 = new User(2,"zhengke1", "0000",13,"男");
        userList.add(user);
        userList.add(user1);
        return userList;
    }
}
