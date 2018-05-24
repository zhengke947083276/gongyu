package org.com.service;

import org.com.entity.TblCheck;

import java.util.List;

public interface TblCheckService {
    /**
     * 0.宿舍状态正常（1）+学生状态入学（1）
     * 之前
     * 添加入住信息
     * 步骤
     * 1.添加入住信息完后
     * 2.修改学生状态为入住（2）
     * 3.查询对应的宿舍号，入住状态（true）的入住信息==8
     * 4.修改对应的宿舍号状态，为已满（2）
     * @param tblCheck
     * @return
     */
    public int addTblCheck(TblCheck tblCheck);

    /**
     * 入住信息入住状态（true）修改为false
     * 0.先查
     * 步骤
     * 1.修改入住信息完了
     * 2.修改学生状态
     * IF(1){修改学生状态为入校(1)}
     *
     * IF(3){修改学生状态为毕业(3)
     *  判断宿舍状态是否为已满（2）==》改正常(1)
     * }
     *
     * @param checkId
     * @param stuState 1入校  3毕业
     * @return
     */
    public int updateTblCheck(int checkId,int stuState);

    /**
     *
     * 步骤
     * 1.先查询入住信息
     * IF(true){
     * 2.删除入住信息
     * 3.
     * }
     * IF(false){2.删除入住信息}
     *
     *
     *
     * @param checkId
     * @return
     */
    public int delete(int checkId);


    /**
     * 查询所有入住信息
     * @return
     */
    public List<TblCheck> selectAll();


    /**
     * 查询所有入住信息+学生+宿舍
     * @return
     */
    public List<TblCheck> selectCheAndStuAndDormAll();

    /**
     * 入住信息+学生+宿舍
     * @param cheId
     * @return
     */
    public TblCheck selectCheAndStuAndDormByCheId(Integer cheId);


    /**
     * 学生查询入住状态的入住信息及宿舍
     * @param stuId
     * @return
     */
    public TblCheck selectWithDormByCheckState1AndStuId(Integer stuId);


}
