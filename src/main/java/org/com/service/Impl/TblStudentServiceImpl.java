package org.com.service.Impl;

import org.com.dao.TblCheckMapper;
import org.com.dao.TblDormMapper;
import org.com.dao.TblSpecialtyMapper;
import org.com.dao.TblStudentMapper;
import org.com.entity.*;
import org.com.service.TblCheckService;
import org.com.service.TblSpecialtyService;
import org.com.service.TblStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TblStudentServiceImpl implements TblStudentService {
    @Autowired
    TblStudentMapper tblStudentMapper;
    @Autowired
    TblCheckMapper tblCheckMapper;
    @Autowired
    TblDormMapper tblDormMapper;
    @Autowired
    TblSpecialtyMapper tblSpecialtyMapper;
    @Autowired
    TblSpecialtyService tblSpecialtyService;
    @Autowired
    TblCheckService tblCheckService;

    @Override
    public int addTblStudent(TblStudent tblStudent) {
        return tblStudentMapper.insertSelective(tblStudent);
    }

    @Override
    public int updateTblStudent(TblStudent tblStudent) {
        return tblStudentMapper.updateByPrimaryKeySelective(tblStudent);
    }

    @Override
    public int addTblDormFor(List<TblStudent> tblStudents) {
        return tblStudentMapper.insertSelectFor(tblStudents);
    }

    @Override
    public int deleteStudent(Integer stuId) {
        return tblStudentMapper.deleteByPrimaryKey(stuId);
    }

    @Override
    public List<TblStudent> selectAll() {
        return tblStudentMapper.selectByExample(null);
    }

    @Override
    public List<TblStudent> selectStuAndSpeAndFacAll() {
        List<TblStudent> tblStudents = tblStudentMapper.selectByExample(null);
        for (TblStudent tblStudent:tblStudents){
            TblSpecialty tblSpecialty = tblSpecialtyService.selectSpeAndFacBySpeId(tblStudent.getSpeId());
            tblStudent.setTblSpecialty(tblSpecialty);
        }
        return tblStudents;
    }

    @Override
    public TblStudent selectStuAndSpeAndFacBy(Integer stuId) {
        TblStudent tblStudent = tblStudentMapper.selectByPrimaryKey(stuId);
        TblSpecialty tblSpecialty = tblSpecialtyService.selectSpeAndFacBySpeId(tblStudent.getSpeId());
        tblStudent.setTblSpecialty(tblSpecialty);
        return tblStudent;
    }

    @Override
    public List<TblStudent> selectTblStudentByStuState1() {
        TblStudentExample tblStudentExample = new TblStudentExample();
        TblStudentExample.Criteria criteria = tblStudentExample.createCriteria();
        criteria.andStuStateEqualTo(1);
        return tblStudentMapper.selectByExample(tblStudentExample);
    }

    @Override
    public List<TblStudent> selectTblStudentByStuState2AndSpeId(Integer speId) {
        TblStudentExample tblStudentExample = new TblStudentExample();
        TblStudentExample.Criteria criteria = tblStudentExample.createCriteria();
        criteria.andStuStateEqualTo(2);
        criteria.andSpeIdEqualTo(speId);
        return tblStudentMapper.selectByExample(tblStudentExample);
    }
    /**
     * 入住=》毕业
     * 入住表+宿舍表+学生表
     * 入校=》毕业
     * 学生表
     *
     * 入住=》入校
     * 入住表+学生表+宿舍表
     * 毕业=》入校
     * 学生表
     */
    @Override
    public int updateTblStudent(Integer stuId, Integer stuState,Integer state) {
        int i =0;


        if(stuState==1){//修改为入校状态
            if (state==2){//当前状态入住
                TblStudent tblStudent = new TblStudent();
                //添加学生id
                tblStudent.setStuId(stuId);
                //改为入校
                tblStudent.setStuState(stuState);
                i = tblStudentMapper.updateByPrimaryKeySelective(tblStudent);
                if (i>0){
                    TblCheckExample tblCheckExample = new TblCheckExample();
                    //先查询出来对应的入住信息
                    //学生+入住状态
                    tblCheckExample.createCriteria().andStuIdEqualTo(stuId).andCheckStateEqualTo(true);
                    List<TblCheck> tblChecks = tblCheckMapper.selectByExample(tblCheckExample);
                    TblCheck tblCheck = tblChecks.get(0);
                    i = tblCheckService.updateTblCheck(tblCheck.getCheckId(),stuState);
                }
            }
            if (state==3) {//当前状态毕业
                TblStudent tblStudent = new TblStudent();
                //添加学生id
                tblStudent.setStuId(stuId);
                //入住
                tblStudent.setStuState(stuState);
                i = tblStudentMapper.updateByPrimaryKeySelective(tblStudent);
            }
        }

        if (stuState==3){//修改为毕业状态
            if (state==1){//当前状态入校
                TblStudent tblStudent = new TblStudent();
                //添加学生id
                tblStudent.setStuId(stuId);
                //毕业
                tblStudent.setStuState(stuState);
                i = tblStudentMapper.updateByPrimaryKeySelective(tblStudent);
            }
            if (state==2) {//当前状态入住
                TblStudent tblStudent = new TblStudent();
                //添加学生id
                tblStudent.setStuId(stuId);
                //改为毕业
                tblStudent.setStuState(stuState);
                i = tblStudentMapper.updateByPrimaryKeySelective(tblStudent);
                if (i>0){
                    TblCheckExample tblCheckExample = new TblCheckExample();
                    //先查询出来对应的入住信息
                    //学生+入住状态
                    tblCheckExample.createCriteria().andStuIdEqualTo(stuId).andCheckStateEqualTo(true);
                    List<TblCheck> tblChecks = tblCheckMapper.selectByExample(tblCheckExample);
                    TblCheck tblCheck = tblChecks.get(0);
                    //修改入住状态
                    i = tblCheckService.updateTblCheck(tblCheck.getCheckId(),stuState);
                }


            }
        }
        return i;
    }


}
