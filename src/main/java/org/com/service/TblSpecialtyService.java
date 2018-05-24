package org.com.service;

import org.com.entity.TblSpecialty;

import java.util.List;

public interface TblSpecialtyService {
    /**
     * facId查询对应的所有专业
     * @param facId
     * @return
     */
    public List<TblSpecialty> selectByFacId(Integer facId);

    /**
     * 查询专业及学院
     * @param speId
     * @return
     */
    public TblSpecialty selectSpeAndFacBySpeId(Integer speId);
}
