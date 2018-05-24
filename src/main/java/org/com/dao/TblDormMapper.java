package org.com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.com.entity.TblDorm;
import org.com.entity.TblDormExample;
import org.com.util.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface TblDormMapper {
    long countByExample(TblDormExample example);

    int deleteByExample(TblDormExample example);

    int deleteByPrimaryKey(Integer dormId);

    int insert(TblDorm record);

    int insertSelective(TblDorm record);

    int insertSelectFor(@Param("tblDorms") List<TblDorm> tblDorms);

    List<TblDorm> selectByExample(TblDormExample example);

//    List<TblDorm> selectByPage(@Param(value = "startPos") Integer startPos,@Param(value = "pageSize") Integer pageSize);

    TblDorm selectByPrimaryKey(Integer dormId);

    int updateByExampleSelective(@Param("record") TblDorm record, @Param("example") TblDormExample example);

    int updateByExample(@Param("record") TblDorm record, @Param("example") TblDormExample example);

    int updateByPrimaryKeySelective(TblDorm record);

    int updateByPrimaryKey(TblDorm record);
}