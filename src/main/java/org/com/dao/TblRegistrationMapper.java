package org.com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.com.entity.TblRegistration;
import org.com.entity.TblRegistrationExample;
import org.springframework.stereotype.Repository;

@Repository
public interface TblRegistrationMapper {
    long countByExample(TblRegistrationExample example);

    int deleteByExample(TblRegistrationExample example);

    int deleteByPrimaryKey(Integer regId);

    int insert(TblRegistration record);

    int insertSelective(TblRegistration record);

    List<TblRegistration> selectByExample(TblRegistrationExample example);

    TblRegistration selectByPrimaryKey(Integer regId);

    int updateByExampleSelective(@Param("record") TblRegistration record, @Param("example") TblRegistrationExample example);

    int updateByExample(@Param("record") TblRegistration record, @Param("example") TblRegistrationExample example);

    int updateByPrimaryKeySelective(TblRegistration record);

    int updateByPrimaryKey(TblRegistration record);
}