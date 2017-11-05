/**
 * 
 */
package cn.ehuoyuan.shop.service.privilege;

import java.util.Map;

import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.shop.domain.EhyRole;

/**
 * 角色Service接口
 * @author zengren
 * @date 2017年10月10日
 * version v1.0
 */
public interface RoleService {
	
	/**
	 * 增加
	 * @param role
	 * @return
	 */
	int addRole(EhyRole role);
	
	/**
	 * 删除
	 * @param roleId
	 * @return
	 */
	int deleteRole(String roleId);
	
	/**
	 * 修改
	 * @param role
	 * @return
	 */
	int updateRole(EhyRole role);
	
	/**
	 * 查询全部并分页
	 * @param role
	 * @param pages
	 * @return
	 */
	Map<String, Object> findAllPage(EhyRole role, Pages pages);
	
	/**
	 * 得到总行数
	 * @param role
	 * @return
	 */
	int countRows(EhyRole role);
	
	/**
	 * 根据id查询
	 * @param roleId
	 * @return
	 */
	EhyRole findById(String roleId);
	
}
