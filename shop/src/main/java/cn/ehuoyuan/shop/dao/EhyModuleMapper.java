package cn.ehuoyuan.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.shop.domain.EhyModule;

public interface EhyModuleMapper {
	
    int deleteByPrimaryKey(String modId);
    
    int insert(EhyModule record);

    int insertSelective(EhyModule record);

    EhyModule selectByPrimaryKey(String modId);

    int updateByPrimaryKeySelective(EhyModule record);

    int updateByPrimaryKey(EhyModule record);
    
    List<EhyModule> showMenuTree(String manId);
    
    List<EhyModule> findAllPage(@Param("module")EhyModule record, @Param("pages")Pages pages);
    
    int deleteEhyModule(String modId);
    
    int countRows(@Param("module")EhyModule record);
    
    List<EhyModule> findFirstLevel();
    
    List<EhyModule> findInferior(String modId);
    
    List<EhyModule> findAll();
    
    int maxSort();
    
    int sortModule(@Param("startNum")Integer startNum, @Param("endNum")Integer endNum, @Param("modId")String modId);
    
}