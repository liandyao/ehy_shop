package cn.ehuoyuan.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.shop.domain.EhyManager;

public interface EhyManagerMapper {
	
	/**
	 * 根据id删除，自动生成的
	 * @param manId
	 * @return
	 */
    int deleteByPrimaryKey(String manId);
    
    /**
     * 增加
     * @param record
     * @return
     */
    int insert(EhyManager record);
    
    /**
     * 选择属性增加
     * @param record
     * @return
     */
    int insertSelective(EhyManager record);
    
    /**
     * 根据id查询
     * @param manId
     * @return
     */
    EhyManager selectByPrimaryKey(String manId);
    
    /**
     * 根据id选择属性修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(EhyManager record);
    
    /**
     * 根据id修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(EhyManager record);
    
    /**
     * 用户登录
     * @param record
     * @return
     */
    EhyManager isLogin(EhyManager record);
    
    /**
     * 删除，实际是把状态改为0
     * @param manId
     * @return
     */
    int delete(String manId);
    
    /**
     * 显示全部，并分页
     * @param record
     * @param pages
     * @return
     */
    List<EhyManager> findAllPage(@Param("manager")EhyManager record, @Param("pages")Pages pages);
    
    /**
     * 得到总行数
     * @param record
     * @return
     */
    int countRows(@Param("manager")EhyManager record);
    
    int findByName(String manUser);
    
}