package org.com.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.com.entity.TblFaculty;
import org.com.entity.TblFacultyExample;
import org.springframework.stereotype.Repository;

@Repository
public interface TblFacultyMapper {
    long countByExample(TblFacultyExample example);

    int deleteByExample(TblFacultyExample example);

    int deleteByPrimaryKey(Integer facId);

    int insert(TblFaculty record);

    int insertSelective(TblFaculty record);

    List<TblFaculty> selectByExample(TblFacultyExample example);

    TblFaculty selectByPrimaryKey(Integer facId);

    int updateByExampleSelective(@Param("record") TblFaculty record, @Param("example") TblFacultyExample example);

    int updateByExample(@Param("record") TblFaculty record, @Param("example") TblFacultyExample example);

    int updateByPrimaryKeySelective(TblFaculty record);

    int updateByPrimaryKey(TblFaculty record);
}