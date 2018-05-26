package org.com.service;

import org.com.entity.TblAdministrator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml","classpath:springmvc-config.xml"})
public class TblAdministratorServiceTest {
    @Autowired
    TblAdministratorService tblAdministratorService;
    @Test
    public void administratorLogin() {
        TblAdministrator tblAdministrator = tblAdministratorService.administratorLogin("zhengke", "0000");
        System.out.println(tblAdministrator);
    }
}