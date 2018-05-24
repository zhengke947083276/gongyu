package org.com.service.Impl;

import org.com.dao.TblRegistrationMapper;
import org.com.dao.TblStudentMapper;
import org.com.entity.TblRegistration;
import org.com.entity.TblRegistrationExample;
import org.com.entity.TblStudent;
import org.com.entity.TblStudentExample;
import org.com.service.TblRegistrationService;
import org.com.service.TblStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TblRegistrationServiceImpl implements TblRegistrationService {
    @Autowired
    TblRegistrationMapper tblRegistrationMapper;
    @Autowired
    TblStudentMapper tblStudentMapper;
    @Autowired
    TblStudentService tblStudentService;
    @Override
    public int addTblReg(TblRegistration tblRegistration,TblStudent tblStudent) {
        TblStudentExample tblStudentExample = new TblStudentExample();
        TblStudentExample.Criteria criteria = tblStudentExample.createCriteria();
        //学生学号
        criteria.andStuNoEqualTo(tblStudent.getStuNo());
        //学生入住状态
        criteria.andStuStateEqualTo(2);
        List<TblStudent> tblStudents = tblStudentMapper.selectByExample(tblStudentExample);
        if (tblStudents!=null && tblStudents.size()!=0){//判断查询结果是否存在
            tblRegistration.setStuId(tblStudents.get(0).getStuId());
            tblRegistration.setRegTime(new Date());
            int i = tblRegistrationMapper.insertSelective(tblRegistration);
            if (i>0){
                return tblStudents.get(0).getStuId();//进出学生id
            }else {
                return 0;
            }
        }
        return 0;
    }

    @Override
    public List<TblRegistration> selectAll() {
        List<TblRegistration> tblRegistrations = tblRegistrationMapper.selectByExample(null);
        for (TblRegistration tblRegistration:tblRegistrations){
            TblStudent tblStudent = tblStudentService.selectStuAndSpeAndFacBy(tblRegistration.getStuId());
            tblRegistration.setTblStudent(tblStudent);
        }


        return tblRegistrations;
    }

    @Override
    public List<TblRegistration> selectAllByStuId(Integer stuId) {
        TblRegistrationExample tblRegistrationExample = new TblRegistrationExample();
        TblRegistrationExample.Criteria criteria = tblRegistrationExample.createCriteria();
        //某学生
        criteria.andStuIdEqualTo(stuId);
        return tblRegistrationMapper.selectByExample(tblRegistrationExample);
    }
    @Override
    public int delete(Integer regId) {
        return tblRegistrationMapper.deleteByPrimaryKey(regId);
    }
}
