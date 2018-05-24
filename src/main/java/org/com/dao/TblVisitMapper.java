package org.com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.com.entity.TblVisit;
import org.com.entity.TblVisitExample;
import org.springframework.stereotype.Repository;

@Repository
public interface TblVisitMapper {
    long countByExample(TblVisitExample example);

    int deleteByExample(TblVisitExample example);

    int deleteByPrimaryKey(Integer visId);

    int insert(TblVisit record);

    int insertSelective(TblVisit record);

    List<TblVisit> selectByExample(TblVisitExample example);

    TblVisit selectByPrimaryKey(Integer visId);

    int updateByExampleSelective(@Param("record") TblVisit record, @Param("example") TblVisitExample example);

    int updateByExample(@Param("record") TblVisit record, @Param("example") TblVisitExample example);

    int updateByPrimaryKeySelective(TblVisit record);

    int updateByPrimaryKey(TblVisit record);
}