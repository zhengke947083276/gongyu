package org.com.service.Impl;

import org.com.dao.TblAdministratorMapper;
import org.com.entity.TblAdministrator;
import org.com.entity.TblAdministratorExample;
import org.com.service.TblAdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TblAdministratorServiceImpl implements TblAdministratorService {
//    TblAdministratorMapper tblAdministratorMapper = MyBatisUtil.getSqlSession().getMapper(TblAdministratorMapper.class);

    @Autowired
    TblAdministratorMapper tblAdministratorMapper;

    @Override
    public TblAdministrator administratorLogin(String admUser,String admPass) {
        //创建一个查询对象
        TblAdministratorExample tblAdministratorExample = new TblAdministratorExample();
        TblAdministratorExample.Criteria criteria = tblAdministratorExample.createCriteria();
        //添加账号
        criteria.andAdmUserEqualTo(admUser);
        //添加密码
        criteria.andAdmPassEqualTo(admPass);
        //调用底层dao
        List<TblAdministrator> tblAdministrators = tblAdministratorMapper.selectByExample(tblAdministratorExample);
        if (tblAdministrators.size()>0){//判断查询结果个数
            return tblAdministrators.get(0);
        }
        return null;
    }
    @Override
    public int administratorSet(TblAdministrator tblAdministrator) {
        return tblAdministratorMapper.updateByPrimaryKeySelective(tblAdministrator);
    }
}
