package org.com.service.Impl;

import org.com.dao.TblCheckMapper;
import org.com.dao.TblDormMapper;
import org.com.dao.TblStudentMapper;
import org.com.entity.*;
import org.com.service.TblCheckService;
import org.com.service.TblStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TblCheckServiceImpl implements TblCheckService {
    @Autowired
    TblCheckMapper tblCheckMapper;
    @Autowired
    TblDormMapper tblDormMapper;
    @Autowired
    TblStudentMapper tblStudentMapper;
    @Autowired
    TblStudentService tblStudentService;
    /**
     * 入住信息入住状态（true）修改为false
     * 步骤
     * 1.修改入住信息完了
     * 2.修改学生状态
     * IF(1){修改学生状态为入校(1)}
     *
     * IF(3){修改学生状态为毕业(3)
     *  判断宿舍状态是否为已满（2）==》改正常(1)
     * }
     *
     * @param checkId
     * @param stuState 1入校  3毕业
     * @return
     */
    @Override
    public int updateTblCheck(int checkId,int stuState) {
        int i;
        TblCheck tblCheck = tblCheckMapper.selectByPrimaryKey(checkId);
        //修改入住信息(添加出宿舍时间+宿舍状态)
        tblCheck.setCheckOutTime(new Date());
        tblCheck.setCheckState(false);
        i = tblCheckMapper.updateByPrimaryKeySelective(tblCheck);
        if (stuState==3){
            //修改学生状态为毕业(3)
            TblStudent tblStudent = new TblStudent();
            tblStudent.setStuId(tblCheck.getStuId());
            tblStudent.setStuState(stuState);
            i = tblStudentMapper.updateByPrimaryKeySelective(tblStudent);
            //判断宿舍状态是否为已满（2）==》改正常(1)
            TblDorm tblDorm = tblDormMapper.selectByPrimaryKey(tblCheck.getDormId());
            if (tblDorm.getDormState()==2){
                TblDorm tblDorm1 = new TblDorm();
                tblDorm1.setDormId(tblDorm.getDormId());
                tblDorm1.setDormState(1);
                i = tblDormMapper.updateByPrimaryKeySelective(tblDorm1);
            }
        }
        if (stuState==1){
            //修改学生状态为入校(1)
            TblStudent tblStudent = new TblStudent();
            tblStudent.setStuId(tblCheck.getStuId());
            tblStudent.setStuState(stuState);
            i = tblStudentMapper.updateByPrimaryKeySelective(tblStudent);
            //判断宿舍状态是否为已满（2）==》改正常(1)
            TblDorm tblDorm = tblDormMapper.selectByPrimaryKey(tblCheck.getDormId());
            if (tblDorm.getDormState()==2){
                TblDorm tblDorm1 = new TblDorm();
                tblDorm1.setDormId(tblDorm.getDormId());
                tblDorm1.setDormState(1);
                i = tblDormMapper.updateByPrimaryKeySelective(tblDorm1);
            }
        }
        return i;
    }

    @Override
    public int delete(int checkId) {
        return tblCheckMapper.deleteByPrimaryKey(checkId);
    }


    /**
     * 宿舍状态正常（1）+学生状态入学（1）
     * 之前
     * 添加入住信息
     * 步骤
     * 1.添加入住信息完后
     * 2.修改学生状态为入住（2）
     * 3.查询对应的宿舍号，入住状态（true）的入住信息==8
     * 4.修改对应的宿舍号状态，为已满（2）
     * @param tblCheck
     * @return
     */
    @Override
    public int addTblCheck(TblCheck tblCheck) {
        int i;
        tblCheck.setCheckInTime(new Date());
        //添加入住信息完后
        i = tblCheckMapper.insertSelective(tblCheck);
        //修改学生状态为入住（2）
        TblStudent tblStudent = new TblStudent();
        tblStudent.setStuId(tblCheck.getStuId());
        tblStudent.setStuState(2);
        i = tblStudentMapper.updateByPrimaryKeySelective(tblStudent);
        //查询对应的宿舍号，入住状态（true）的入住信息==8
        TblCheckExample tblCheckExample = new TblCheckExample();
        //对应的宿舍号+入住状态(true)
        TblCheckExample.Criteria criteria = tblCheckExample.createCriteria();
        criteria.andDormIdEqualTo(tblCheck.getDormId());
        criteria.andCheckStateEqualTo(true);
        List<TblCheck> tblChecks = tblCheckMapper.selectByExample(tblCheckExample);
        if (tblChecks.size()==8){
            //修改宿舍状态为已满（2）
            TblDorm tblDorm = new TblDorm();
            tblDorm.setDormId(tblCheck.getDormId());
            tblDorm.setDormState(2);
            i = tblDormMapper.updateByPrimaryKeySelective(tblDorm);
        }
        return i;
    }





    @Override
    public List<TblCheck> selectAll() {
        return tblCheckMapper.selectByExample(null);
    }

    @Override
    public List<TblCheck> selectCheAndStuAndDormAll() {
        List<TblCheck> tblChecks = tblCheckMapper.selectByExample(null);
        for (TblCheck tblCheck:tblChecks){
            TblDorm tblDorm = tblDormMapper.selectByPrimaryKey(tblCheck.getDormId());
            tblCheck.setTblDorm(tblDorm);
            TblStudent tblStudent = tblStudentService.selectStuAndSpeAndFacBy(tblCheck.getStuId());
            tblCheck.setTblStudent(tblStudent);
        }
        return tblChecks;
    }

    @Override
    public TblCheck selectCheAndStuAndDormByCheId(Integer cheId) {
        TblCheck tblCheck = tblCheckMapper.selectByPrimaryKey(cheId);
        TblStudent tblStudent = tblStudentService.selectStuAndSpeAndFacBy(tblCheck.getStuId());
        tblCheck.setTblStudent(tblStudent);
        return tblCheck;
    }

    /**
     * 学生查询入住状态的入住信息及宿舍
     * @param stuId
     * @return
     */
    @Override
    public TblCheck selectWithDormByCheckState1AndStuId(Integer stuId) {
        TblCheckExample tblCheckExample = new TblCheckExample();
        TblCheckExample.Criteria criteria = tblCheckExample.createCriteria();
        //入住状态
        criteria.andCheckStateEqualTo(true);
        //学生
        criteria.andStuIdEqualTo(stuId);
        List<TblCheck> tblChecks = tblCheckMapper.selectByExample(tblCheckExample);
        TblDormExample tblDormExample = new TblDormExample();
        TblCheckExample.Criteria criteria1 = tblCheckExample.createCriteria();
        criteria1.andDormIdEqualTo(tblChecks.get(0).getDormId());
        List<TblDorm> tblDorms = tblDormMapper.selectByExample(tblDormExample);
        tblChecks.get(0).setTblDorm(tblDorms.get(0));
        return tblChecks.get(0);
    }
}
