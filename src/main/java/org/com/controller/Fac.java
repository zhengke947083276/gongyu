package org.com.controller;

import org.com.entity.TblFaculty;
import org.com.service.TblFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/fac")
public class Fac {
    @Autowired
    TblFacultyService tblFacultyService;

    @RequestMapping("/selectFacultyWithSpecialty")
    @ResponseBody
    public List<TblFaculty> selectFacultyWithSpecialty(){
        return tblFacultyService.selectFacultyWithSpecialty();
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<TblFaculty> selectAll(){
        return tblFacultyService.selectAll();
    }

}
