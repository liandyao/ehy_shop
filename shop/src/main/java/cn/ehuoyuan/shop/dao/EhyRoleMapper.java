package cn.ehuoyuan.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.shop.domain.EhyRole;

public interface EhyRoleMapper {
    int deleteByPrimaryKey(String roleId);

    int insert(EhyRole record);

    int insertSelective(EhyRole record);

    EhyRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(EhyRole record);

    int updateByPrimaryKey(EhyRole record);
    
    List<EhyRole> findAllPage(@Param("role")EhyRole record, @Param("pages")Pages pages);
    
    int countRows(@Param("role")EhyRole record);
    
    int deleteRole(String roleId);
    
    List<EhyRole> findAll();
    
}