package org.com.service.Impl;

import org.com.dao.TblFacultyMapper;
import org.com.dao.TblSpecialtyMapper;
import org.com.entity.TblFaculty;
import org.com.entity.TblSpecialty;
import org.com.entity.TblSpecialtyExample;
import org.com.service.TblFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TblFacultyServiceImpl implements TblFacultyService {
    @Autowired
    TblFacultyMapper tblFacultyMapper;
    @Autowired
    TblSpecialtyMapper tblSpecialtyMapper;

    @Override
    public List<TblFaculty> selectFacultyWithSpecialty() {
        //查询所有学院
        List<TblFaculty> tblFaculties = tblFacultyMapper.selectByExample(null);
        for (TblFaculty tblFaculty:tblFaculties){
            TblSpecialtyExample tblSpecialtyExample = new TblSpecialtyExample();
            TblSpecialtyExample.Criteria criteria = tblSpecialtyExample.createCriteria();
            criteria.andFacIdEqualTo(tblFaculty.getFacId());
            //查询每个学院对象的专业
            List<TblSpecialty> tblSpecialties = tblSpecialtyMapper.selectByExample(tblSpecialtyExample);
            //将专业添加到学院中
            tblFaculty.setTblSpecialties(tblSpecialties);
        }
        //返回学院且包含所有对应的专业
        return tblFaculties;
    }

    @Override
    public List<TblFaculty> selectAll() {
        return tblFacultyMapper.selectByExample(null);
    }
}
