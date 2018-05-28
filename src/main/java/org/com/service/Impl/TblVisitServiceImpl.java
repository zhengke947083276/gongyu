package org.com.service.Impl;

import org.com.dao.TblVisitMapper;
import org.com.entity.TblCheck;
import org.com.entity.TblStudent;
import org.com.entity.TblVisit;
import org.com.service.TblCheckService;
import org.com.service.TblStudentService;
import org.com.service.TblVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class TblVisitServiceImpl implements TblVisitService {
    @Autowired
    TblVisitMapper tblVisitMapper;
    @Autowired
    TblCheckService tblCheckService;
    @Autowired
    TblStudentService tblStudentService;
    @Override
    public int addTblVisit(TblVisit tblVisit) {
        tblVisit.setVisTime(new Date());
        return tblVisitMapper.insertSelective(tblVisit);
    }

    @Override
    public List<TblVisit> selectAll() {
        List<TblVisit> tblVisits = tblVisitMapper.selectByExample(null);
        if (tblVisits!=null && tblVisits.size()!=0){
            for (TblVisit tblVisit:tblVisits){
                TblCheck tblCheck = tblCheckService.selectWithDormByCheckState1AndStuId(tblVisit.getStuId());
                TblStudent tblStudent = tblStudentService.selectStuAndSpeAndFacBy(tblVisit.getStuId());
                tblCheck.setTblStudent(tblStudent);
                tblVisit.setTblCheck(tblCheck);
            }
        }

        return tblVisits;
    }

    @Override
    public int delete(Integer visId) {
        return tblVisitMapper.deleteByPrimaryKey(visId);
    }
}
