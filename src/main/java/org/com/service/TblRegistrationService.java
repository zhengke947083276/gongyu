package org.com.service;

import org.com.entity.TblRegistration;
import org.com.entity.TblStudent;

import java.util.List;

public interface TblRegistrationService {
    /**
     * 添加出入记录信息
     * 1.用学生学号、入住学生状态，查询学生
     * 2.添加
     * @param tblRegistration
     * @return
     */
    public int addTblReg(TblRegistration tblRegistration, TblStudent tblStudent);

    /**
     * 查询所有学生出入记录
     * @return
     */
    public List<TblRegistration> selectAll();

    /**
     * 查询某学生的所有出入记录
     * @param stuId
     * @return
     */
    public List<TblRegistration> selectAllByStuId(Integer stuId);

    /**
     * 删除出入记录
     * @param regId
     * @return
     */
    public int delete(Integer regId);
}
