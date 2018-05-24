package org.com.service;

import org.com.entity.TblStudent;
import org.com.entity.TblStudentExample;

import java.util.List;

public interface TblStudentService {
    /**
     * 添加学生信息
     * @param tblStudent
     * @return
     */
    public int addTblStudent(TblStudent tblStudent);

    /**
     * 学生id删除
     * @param stuId
     * @return
     */
    public int deleteStudent(Integer stuId);


    /**
     * 查询所有学生
     * @return
     */
    public List<TblStudent> selectAll();

    /**
     * 查询所有学生+学院+专业
     * @return
     */
    public List<TblStudent> selectStuAndSpeAndFacAll();

    /**
     * 查询学生+学院+专业
     * @param stuId
     * @return
     */
    public TblStudent selectStuAndSpeAndFacBy(Integer stuId);


    /**
     * 查询所有入校状态的学生
     * @return
     */
    public List<TblStudent> selectTblStudentByStuState1();

    /**
     * 查询专业对应的以入住的学生
     * @param speId
     * @return
     */
    public List<TblStudent> selectTblStudentByStuState2AndSpeId(Integer speId);



    /**
     * 修改学生
     * 1修改为入校
     * 3修改为毕业
     * @param stuId
     * @param stuState 要修改的状态
     * @param state 当前状态
     * @return
     */
    public int updateTblStudent(Integer stuId,Integer stuState,Integer state);
}
