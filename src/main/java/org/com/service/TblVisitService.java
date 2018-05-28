package org.com.service;

import org.com.entity.TblVisit;

import java.util.List;

public interface TblVisitService {
    /**
     * 添加来访
     * @param tblVisit
     * @return
     */
    public int addTblVisit(TblVisit tblVisit);

    /**
     * 查询所有来访
     * @return
     */
    public List<TblVisit> selectAll();

    /**
     * 删除来访信息
     * @param visId
     * @return
     */
    public int delete(Integer visId);
}
