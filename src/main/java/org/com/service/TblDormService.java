package org.com.service;

import org.com.entity.TblDorm;
import org.com.util.Page;

import java.util.List;

public interface TblDormService {
    /**
     * 添加宿舍信息
     * @param tblDorm
     * @return
     */
    public int addTblDorm(TblDorm tblDorm);

    /**
     * 批量添加宿舍信息
     * @param tblDorms
     * @return
     */
    public int addTblDormFor(List<TblDorm> tblDorms);


//
//    /**
//     * 修改宿舍信息
//     * @param tblDorm
//     * @return
//     */
//    public int updateTblDorm(TblDorm tblDorm);

    /**
     *根据宿舍状态查询所有可住人的宿舍
     * @return
     */
    public List<TblDorm> selectTblDormByDormState1();

    /**
     * 查询所有宿舍
     * @return
     */
    public List<TblDorm> selectAll();

    /**
     * id单一删除宿舍
     * @param dormId
     * @return
     */

    public int deleteById(Integer dormId);


    /**
     * 1修改为正常
     * 2修改为已满
     * 3修改为不正常
     * @param dormId
     * @param dormState
     * @return
     */
    public int updateByDormState(Integer dormId,Integer dormState);


}
