package org.com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.com.entity.TblStudent;
import org.com.entity.TblStudentExample;
import org.springframework.stereotype.Repository;

@Repository
public interface TblStudentMapper {
    long countByExample(TblStudentExample example);

    int deleteByExample(TblStudentExample example);

    int deleteByPrimaryKey(Integer stuId);

    int insert(TblStudent record);

    int insertSelective(TblStudent record);

    int insertSelectFor(@Param("tblStudents") List<TblStudent> tblStudents);

    List<TblStudent> selectByExample(TblStudentExample example);

    TblStudent selectByPrimaryKey(Integer stuId);

    int updateByExampleSelective(@Param("record") TblStudent record, @Param("example") TblStudentExample example);

    int updateByExample(@Param("record") TblStudent record, @Param("example") TblStudentExample example);

    int updateByPrimaryKeySelective(TblStudent record);

    int updateByPrimaryKey(TblStudent record);
}