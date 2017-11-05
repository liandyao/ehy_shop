/**
 * 
 */
package cn.ehuoyuan.shop.service.privilege;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyModule;

/**
 * 权限管理的Service接口
 * @author zengren
 * @date 2017年9月29日
 * version v1.0
 */
public interface PrivilegeService {
	
	/**
	 * 根据用户id查询权限
	 * @param manId
	 * @return
	 */
	public List<EhyModule> showMenuTree(String manId);
	
	/**
	 * 查询全部模块
	 * @return
	 */
	public List<Map<String, Object>> moduleTree();
	
	/**
	 * 显示全部角色
	 * @return
	 */
	public List<Map<String, Object>> showRole();
	
	/**
	 * 修改角色模块
	 * @param modIdArr
	 * @param roleId
	 * @return
	 */
	public int updateModRole(String[] modIdArr, String roleId);
	
	/**
	 * 修改用户角色
	 * @param roleIdArr
	 * @param manId
	 * @return
	 */
	public int updateManMod(String[] roleIdArr, String manId);
	
	/**
	 * 删除角色模块
	 * @param roleId
	 * @return
	 */
	public int deleteModRole(String roleId);
	
	/**
	 * 删除用户角色
	 * @param manId
	 * @return
	 */
	public int deleteManMod(String manId); 
	
	/**
	 * 根据角色id查模块
	 * @param roleId
	 * @return
	 */
	public List<String> findByRoleId(String roleId);
	
	/**
	 * 根据用户查角色
	 * @param roleId
	 * @return
	 */
	public List<String> findByManId(String manId);
}
