/**
 * 
 */
package cn.ehuoyuan.shop.service.privilege;

import java.util.List;

import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.shop.domain.EhyModule;

/**
 * 后台角色管理service
 * @author zengren
 * @date 2017年9月28日
 * version v1.0
 */
public interface ModuleService {
	
	/**
	 * 增加
	 * @param module
	 * @return
	 */
	int addEhyModule(EhyModule module);
	
	/**
	 * 删除
	 * @param modId
	 * @return
	 */
	int deleteEhyModule(String modId);
	
	/**
	 * 修改
	 * @param module
	 * @return
	 */
	int updateEhyModule(EhyModule module);
	
	/**
	 * 显示全部加分页
	 * @param module
	 * @param pages
	 * @return
	 */
	List<EhyModule> findAllPage(EhyModule module, Pages pages);
	
	/**
	 * 根据id查询
	 * @param modId
	 * @return
	 */
	EhyModule findById(String modId);
	
	/**
	 * 得到总行数
	 * @param module
	 * @return
	 */
	int conutRows(EhyModule module );
	
	/**
	 * 查询一级模块
	 * @return
	 */
	List<EhyModule> findFirstLevel();
	
	/**
	 * 查询全部模块
	 * @return
	 */
	List<EhyModule> findAll();
	
	/**
	 * 得到最大排序
	 * @return
	 */
	int maxSort();
	
	/**
	 * 排序
	 * @return
	 */
	int sortModule(int start, int end, String modId);
}
