package org.com.service;

import org.com.entity.TblVisit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml","classpath:springmvc-config.xml"})
public class TblVisitServiceTest {
    @Autowired
    TblVisitService tblVisitService;
    @Test
    public void selectAll() {
        List<TblVisit> tblVisits = tblVisitService.selectAll();
        for (TblVisit tblVisit :tblVisits) {
//            System.out.println(tblVisit.getTblCheck().getTblDorm());
//            System.out.println(tblVisit.getTblCheck().getTblStudent());
            System.out.println(tblVisit);
        }
    }


}