package org.com.service;

import org.com.entity.TblFaculty;

import java.util.List;

public interface TblFacultyService {
    /**
     * 查询所有学院以及对于的专业
     * @return
     */
    public List<TblFaculty> selectFacultyWithSpecialty();

    /**
     * 查询所有学院
     * @return
     */
    public List<TblFaculty> selectAll();
}
