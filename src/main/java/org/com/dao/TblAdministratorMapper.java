package org.com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.com.entity.TblAdministrator;
import org.com.entity.TblAdministratorExample;
import org.springframework.stereotype.Repository;


@Repository
public interface TblAdministratorMapper {
    long countByExample(TblAdministratorExample example);

    int deleteByExample(TblAdministratorExample example);

    int deleteByPrimaryKey(Integer admId);

    int insert(TblAdministrator record);

    int insertSelective(TblAdministrator record);

    List<TblAdministrator> selectByExample(TblAdministratorExample example);

    TblAdministrator selectByPrimaryKey(Integer admId);

    int updateByExampleSelective(@Param("record") TblAdministrator record, @Param("example") TblAdministratorExample example);

    int updateByExample(@Param("record") TblAdministrator record, @Param("example") TblAdministratorExample example);

    int updateByPrimaryKeySelective(TblAdministrator record);

    int updateByPrimaryKey(TblAdministrator record);
}