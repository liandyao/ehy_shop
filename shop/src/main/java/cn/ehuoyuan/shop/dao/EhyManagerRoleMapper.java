package cn.ehuoyuan.shop.dao;

import java.util.List;

import cn.ehuoyuan.shop.domain.EhyManagerRole;

public interface EhyManagerRoleMapper {
    int deleteByPrimaryKey(String mrId);

    int insert(EhyManagerRole record);

    int insertSelective(EhyManagerRole record);

    EhyManagerRole selectByPrimaryKey(String mrId);

    int updateByPrimaryKeySelective(EhyManagerRole record);

    int updateByPrimaryKey(EhyManagerRole record);
    
    int deleteRoleMan(String manId);
    
    List<EhyManagerRole> findByManId(String manId);
    
}