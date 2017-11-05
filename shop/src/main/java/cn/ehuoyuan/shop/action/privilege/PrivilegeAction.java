/**
 * 
 */
package cn.ehuoyuan.shop.action.privilege;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.shop.domain.EhyModule;
import cn.ehuoyuan.shop.service.privilege.PrivilegeService;

/**
 * 权限管理的Action
 * @author zengren
 * @date 2017年9月29日
 * version v1.0
 */
@Controller
@RequestMapping("privilege")
public class PrivilegeAction {
	
	@Resource
	private PrivilegeService privilegeService;
	
	/**
	 * 根据用户id显示权限
	 * @param manId
	 * @return
	 */
	@RequestMapping("back/showMenuTree")
	@ResponseBody
	public List<EhyModule> showMenuTree(String manId){
		return privilegeService.showMenuTree(manId);
	}
	
	/**
	 * 显示分配权限的二级树
	 * @return
	 */
	@RequestMapping("back/moduleTree")
	@ResponseBody
	public List<Map<String, Object>> moduleTree(){
		return privilegeService.moduleTree();
	}
	
	/**
	 * 给角色分配模块
	 * @param modIdArr
	 * @param roleId
	 * @return
	 */
	@RequestMapping("back/updateModRole")
	@ResponseBody
	public EhyMessage updateModRole(String[] modIdArr,String roleId){
		EhyMessage mes = new EhyMessage();
		int rows = privilegeService.updateModRole(modIdArr, roleId);
		if(rows>0){
			mes.setState(EhyMessage.SUCCESS);
			mes.setMes(EhyMessage.SUCCESS_MES);
		}else{
			mes.setState(EhyMessage.ERROR);
			mes.setMes(EhyMessage.ERROR_MES);
		}
		return mes;
	}
	
	/**
	 * 根据角色id查模块
	 * @param roleId
	 * @return
	 */
	@RequestMapping("back/findByRoleId")
	@ResponseBody
	public List<String> findByRoleId(String roleId){
		return privilegeService.findByRoleId(roleId);
	}
	
	/**
	 * 显示全部角色
	 * @return
	 */
	@RequestMapping("back/showRole")
	@ResponseBody
	public List<Map<String, Object>> showRole(){
		
		return privilegeService.showRole();
	}
	
	/**
	 * 给用户分配角色
	 * @param modIdArr
	 * @param roleId
	 * @return
	 */
	@RequestMapping("back/updateManMod")
	@ResponseBody
	public EhyMessage updateManMod(String[] roleIdArr, String manId){
		EhyMessage mes = new EhyMessage();
		int rows = privilegeService.updateManMod(roleIdArr, manId);
		if(rows>0){
			mes.setState(EhyMessage.SUCCESS);
			mes.setMes(EhyMessage.SUCCESS_MES);
		}else{
			mes.setState(EhyMessage.ERROR);
			mes.setMes(EhyMessage.ERROR_MES);
		}
		return mes;
	}
	
	/**
	 * 根据用户查角色
	 * @param manId
	 * @return
	 */
	@RequestMapping("back/findByManId")
	@ResponseBody
	public List<String> findByManId(String manId){
		
		return privilegeService.findByManId(manId);
	}
	
}
