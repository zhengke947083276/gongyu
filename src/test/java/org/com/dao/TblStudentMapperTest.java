package org.com.dao;

import org.com.entity.TblStudent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class TblStudentMapperTest {
    @Autowired
    TblStudentMapper tblStudentMapper;
    @Test
    public void insertSelectFor() {
        List<TblStudent> tblStudents = new ArrayList<TblStudent>();
        for (int i = 0; i < 20; i++) {
            TblStudent tblStudent = new TblStudent();
            tblStudent.setStuNo("20159610"+i);
            tblStudent.setStuPeriod("2015");
            tblStudent.setStuName("张"+i);
            tblStudent.setSpeId(1);
            tblStudent.setStuBirthday(new Date());
            tblStudent.setStuSex(true);
            tblStudent.setStuPhone("110");
            tblStudent.setStuPicture("");
            tblStudent.setStuAddress("***");
            tblStudents.add(tblStudent);
        }
        int i = tblStudentMapper.insertSelectFor(tblStudents);
        System.out.println(i);
    }
}