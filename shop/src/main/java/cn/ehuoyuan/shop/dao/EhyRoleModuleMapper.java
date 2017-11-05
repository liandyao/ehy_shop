package cn.ehuoyuan.shop.dao;

import java.util.List;

import cn.ehuoyuan.shop.domain.EhyRoleModule;

public interface EhyRoleModuleMapper {
    int deleteByPrimaryKey(String rmId);

    int insert(EhyRoleModule record);

    int insertSelective(EhyRoleModule record);

    EhyRoleModule selectByPrimaryKey(String rmId);

    int updateByPrimaryKeySelective(EhyRoleModule record);

    int updateByPrimaryKey(EhyRoleModule record);
    
    int deleteModRole(String roleId);
    
    List<EhyRoleModule> findByRoleId(String roleId);
    
}