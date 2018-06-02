package org.com.controller;

import org.com.entity.TblSpecialty;
import org.com.service.TblSpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/spe")
public class Spe {
    @Autowired
    TblSpecialtyService tblSpecialtyService;

    @RequestMapping("/selectByFacId")
    @ResponseBody
    public List<TblSpecialty> selectByFacId(Integer facId){
        return tblSpecialtyService.selectByFacId(facId);
    }

    @RequestMapping("/selectSpeAndFacBySpeId")
    @ResponseBody
    public TblSpecialty selectSpeAndFacBySpeId(Integer speId){
        TblSpecialty tblSpecialty = tblSpecialtyService.selectSpeAndFacBySpeId(speId);
        return tblSpecialty;
    }
}
