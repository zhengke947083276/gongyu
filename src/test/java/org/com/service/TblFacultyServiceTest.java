package org.com.service;

import org.com.entity.TblFaculty;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml","classpath:springmvc-config.xml"})
public class TblFacultyServiceTest {
    @Autowired
    TblFacultyService tblFacultyService;
    @Test
    public void selectFacultyWithSpecialty() {
        List<TblFaculty> tblFaculties = tblFacultyService.selectFacultyWithSpecialty();
        for (TblFaculty tblFaculty:tblFaculties){
            System.out.println(tblFaculty.getTblSpecialties());
        }
    }
}