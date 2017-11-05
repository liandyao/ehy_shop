/**
 * 
 */
package cn.ehuoyuan.shop.service.privilege;

import java.util.List;

import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.shop.domain.EhyManager;

/**
 *后台用户管理Service的接口
 * @author zengren
 * @date 2017年9月28日
 * version v1.0
 */
public interface ManagerService {
	
	/**
	 * 后台用户登录
	 * @param record
	 * @return
	 */
	public EhyManager isLogin(EhyManager record);
	
	/**
	 * 增加后台用户
	 * @param record
	 * @return
	 */
	public boolean addManager(EhyManager record);
	
	/**
	 * 删除后台用户
	 * @param manId
	 * @return
	 */
	public boolean deleteManager(String manId);
	
	/**
	 * 修改后台用户
	 * @param record
	 * @return
	 */
	public boolean updateManager(EhyManager record);
	
	/**
	 * 显示后台用户
	 * @param record 
	 * @return
	 */
	public List<EhyManager> findAllPage(EhyManager record, Pages pages);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	public EhyManager findById(String manId);
	
	/**
	 * 得到总行数
	 * @param record
	 * @return
	 */
	public int countRows(EhyManager record);
	
	/**
	 * 查询用户名是否已存在，存在返回true,不存在返回false
	 * @param manUser
	 * @return
	 */
	public boolean findByName(String manUser);
}
