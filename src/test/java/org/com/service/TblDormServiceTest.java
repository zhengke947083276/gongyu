package org.com.service;

import org.com.entity.TblDorm;
import org.com.service.Impl.TblDormServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml","classpath:springmvc-config.xml"})
public class TblDormServiceTest {
    @Autowired
    TblDormServiceImpl tblDormServiceImpl;
    @Test
    public void selectAll() {
        System.out.println(tblDormServiceImpl);
        List<TblDorm> tblDorms = tblDormServiceImpl.selectAll();
        for (TblDorm tblDorm : tblDorms){
            System.out.println(tblDorm);
        }
    }
}