package org.com.dao;

import org.com.entity.TblDorm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class TblDormMapperTest {

    @Autowired
    TblDormMapper tblDormMapper;
    @Test
    public void selectByExample() {
        List<TblDorm> tblDorms = tblDormMapper.selectByExample(null);
        for (TblDorm tblDorm:tblDorms){
            System.out.println(tblDorm);
        }
    }
    @Test
    public void selectByPrimaryKey() {
        TblDorm tblDorm = tblDormMapper.selectByPrimaryKey(4);
        System.out.println(tblDorm);
    }



}