package org.com.service.Impl;

import org.com.dao.TblCheckMapper;
import org.com.dao.TblDormMapper;
import org.com.dao.TblStudentMapper;
import org.com.entity.*;
import org.com.service.TblDormService;
import org.com.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TblDormServiceImpl implements TblDormService {
    @Autowired
    TblDormMapper tblDormMapper;
    @Autowired
    TblCheckMapper tblCheckMapper;
    @Autowired
    TblStudentMapper tblStudentMapper;

    @Override
    public int addTblDorm(TblDorm tblDorm) {
        return tblDormMapper.insertSelective(tblDorm);
    }

    @Override
    public int addTblDormFor(List<TblDorm> tblDorms) {
        return tblDormMapper.insertSelectFor(tblDorms);
    }

    @Override
    public List<TblDorm> selectTblDormByDormState1() {
        TblDormExample tblDormExample= new TblDormExample();
        TblDormExample.Criteria criteria = tblDormExample.createCriteria();
        criteria.andDormStateEqualTo(1);
        return tblDormMapper.selectByExample(tblDormExample);
    }

//    @Override
//    public int updateTblDorm(TblDorm tblDorm) {
//        return tblDormMapper.updateByPrimaryKeySelective(tblDorm);
//    }

//    @Override
//    public List<TblDorm> selectTblDormByDormState(Integer boo) {
//        //创建条件对象
//        TblDormExample tblDormExample = new TblDormExample();
//        TblDormExample.Criteria criteria = tblDormExample.createCriteria();
//        //设置状态属性
//        criteria.andDormStateEqualTo(boo);
//        return tblDormMapper.selectByExample(tblDormExample);
//    }

    @Override
    public List<TblDorm> selectAll() {
        return tblDormMapper.selectByExample(null);
    }

    @Override
    public int deleteById(Integer dormId) {
        return tblDormMapper.deleteByPrimaryKey(dormId);
    }

    @Override
    public int updateByDormState(Integer dormId,Integer dormState) {
        int i = 0;
        if (dormState==1){
            TblDorm tblDorm = new TblDorm();
            //对应的id
            tblDorm.setDormId(dormId);
            //正常
            tblDorm.setDormState(dormState);
            i = tblDormMapper.updateByPrimaryKeySelective(tblDorm);
        }
        if (dormState==2){
            TblDorm tblDorm = new TblDorm();
            //对应的id
            tblDorm.setDormId(dormId);
            //已满
            tblDorm.setDormState(dormState);
            i = tblDormMapper.updateByPrimaryKeySelective(tblDorm);
        }

        if (dormState==3){
            TblDorm tblDorm = new TblDorm();
            //对应的id//不正常
            tblDorm.setDormId(dormId);
            tblDorm.setDormState(dormState);

            try {
                i = tblDormMapper.updateByPrimaryKeySelective(tblDorm);
                //然后让已经住入的学生入住信息修改处住
                TblCheck tblCheck = new TblCheck();
                //要成修改什么样子
                //入住信息状态false
                //出住时间
                tblCheck.setCheckState(false);
                tblCheck.setCheckOutTime(new Date());
                TblCheckExample tblCheckExample = new TblCheckExample();
                //添加宿舍条件//添加入住信息状态true条件
                tblCheckExample.createCriteria().andDormIdEqualTo(dormId).andCheckStateEqualTo(true);
                int i1 = tblCheckMapper.updateByExampleSelective(tblCheck, tblCheckExample);

                //先查看是那些学生
                List<TblCheck> tblChecks = tblCheckMapper.selectByExample(tblCheckExample);
                //创建一个要修改状态的学生集合
                List<TblStudent> tblStudents = new ArrayList<TblStudent>();
                //遍历添加到学生集合中
                for (TblCheck tblCheck1:tblChecks){
                    tblStudents.add(tblCheck1.getTblStudent());
                }

                //这里应该改为批量修改学生（后续完善）
                //遍历修改
                for (TblStudent tblStudent:tblStudents){
                    //学生状态为1
                    tblStudent.setStuState(1);
                    //修改对应的学生状态
                    tblStudentMapper.updateByPrimaryKeySelective(tblStudent);
                }
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }
}
