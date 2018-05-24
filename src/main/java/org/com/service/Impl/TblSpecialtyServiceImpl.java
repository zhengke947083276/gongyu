package org.com.service.Impl;

import org.com.dao.TblFacultyMapper;
import org.com.dao.TblSpecialtyMapper;
import org.com.entity.TblFaculty;
import org.com.entity.TblSpecialty;
import org.com.entity.TblSpecialtyExample;
import org.com.service.TblSpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TblSpecialtyServiceImpl implements TblSpecialtyService {
    @Autowired
    TblSpecialtyMapper tblSpecialtyMapper;
    @Autowired
    TblFacultyMapper tblFacultyMapper;
    @Override
    public List<TblSpecialty> selectByFacId(Integer facId) {
        TblSpecialtyExample tblSpecialtyExample = new TblSpecialtyExample();
        TblSpecialtyExample.Criteria criteria = tblSpecialtyExample.createCriteria();
        criteria.andFacIdEqualTo(facId);
        return tblSpecialtyMapper.selectByExample(tblSpecialtyExample);
    }

    @Override
    public TblSpecialty selectSpeAndFacBySpeId(Integer speId) {
        TblSpecialty tblSpecialty = tblSpecialtyMapper.selectByPrimaryKey(speId);
        TblFaculty tblFaculty = tblFacultyMapper.selectByPrimaryKey(tblSpecialty.getFacId());
        tblSpecialty.setTblFaculty(tblFaculty);
        return tblSpecialty;
    }
}
