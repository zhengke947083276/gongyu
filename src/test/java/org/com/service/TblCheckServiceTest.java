package org.com.service;

import org.com.entity.TblCheck;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml","classpath:springmvc-config.xml"})

public class TblCheckServiceTest {
    @Autowired
    TblCheckService tblCheckService;

    @Test
    public void selectWithDormByCheckState1AndStuId() {
        TblCheck tblCheck = tblCheckService.selectWithDormByCheckState1AndStuId(3);
        System.out.println(tblCheck.getTblDorm().getDormName());
    }

    @Test
    public void updateTblCheck() {
        int checkId = 12;
        int i = tblCheckService.updateTblCheck(checkId, 3);
    }
}