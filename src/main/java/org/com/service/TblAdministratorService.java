package org.com.service;

import org.com.entity.TblAdministrator;

public interface TblAdministratorService {

    /**
     * 管理员登录账号和密码
     * @param admUser
     * @param admPass
     * @return
     */
    public TblAdministrator administratorLogin(String admUser,String admPass);

    /**
     * 管理员修改密码
     * @param tblAdministrator 修改那个字段
     * @return
     */
    public int administratorSet(TblAdministrator tblAdministrator);
}
