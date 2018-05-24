package org.com.dao;

import org.com.entity.TblCheck;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class TblCheckMapperTest {
    @Autowired
    TblCheckMapper tblCheckMapper;
    @Test
    public void selectByExample() {
        List<TblCheck> tblChecks = tblCheckMapper.selectByExample(null);
        for (TblCheck tblCheck:tblChecks){
            System.out.println(tblCheck.getCheckId());
        }

    }

    @Test
    public void selectByPrimaryKey() {
    }
}