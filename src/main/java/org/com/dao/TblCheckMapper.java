package org.com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.com.entity.TblCheck;
import org.com.entity.TblCheckExample;
import org.springframework.stereotype.Repository;

@Repository
public interface TblCheckMapper {
    long countByExample(TblCheckExample example);

    int deleteByExample(TblCheckExample example);

    int deleteByPrimaryKey(Integer checkId);

    int insert(TblCheck record);

    int insertSelective(TblCheck record);

    List<TblCheck> selectByExample(TblCheckExample example);

    TblCheck selectByPrimaryKey(Integer checkId);

    int updateByExampleSelective(@Param("record") TblCheck record, @Param("example") TblCheckExample example);

    int updateByExample(@Param("record") TblCheck record, @Param("example") TblCheckExample example);

    int updateByPrimaryKeySelective(TblCheck record);

    int updateByPrimaryKey(TblCheck record);
}