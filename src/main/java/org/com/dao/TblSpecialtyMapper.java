package org.com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.com.entity.TblSpecialty;
import org.com.entity.TblSpecialtyExample;
import org.springframework.stereotype.Repository;

@Repository
public interface TblSpecialtyMapper {
    long countByExample(TblSpecialtyExample example);

    int deleteByExample(TblSpecialtyExample example);

    int deleteByPrimaryKey(Integer speId);

    int insert(TblSpecialty record);

    int insertSelective(TblSpecialty record);

    List<TblSpecialty> selectByExample(TblSpecialtyExample example);

    TblSpecialty selectByPrimaryKey(Integer speId);

    int updateByExampleSelective(@Param("record") TblSpecialty record, @Param("example") TblSpecialtyExample example);

    int updateByExample(@Param("record") TblSpecialty record, @Param("example") TblSpecialtyExample example);

    int updateByPrimaryKeySelective(TblSpecialty record);

    int updateByPrimaryKey(TblSpecialty record);
}