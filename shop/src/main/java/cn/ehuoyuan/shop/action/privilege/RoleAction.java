/**
 * 
 */
package cn.ehuoyuan.shop.action.privilege;

import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhyRole;
import cn.ehuoyuan.shop.service.privilege.RoleService;

/**
 *
 * @author zengren
 * @date 2017年10月10日
 * version v1.0
 */
@Controller
@RequestMapping("role")
public class RoleAction {
	
	@Resource
	private RoleService roleService;
	
	/**
	 * 增加或修改
	 * @param role
	 * @return
	 */
	@RequestMapping("back/addOrUpdate")
	@ResponseBody
	public EhyMessage addOrupdate(EhyRole role){
		EhyMessage mes = new EhyMessage();
		int rows = 0;
		if(Tools.isEmpty(role.getRoleId())){
			role.setRoleId(UUID.randomUUID().toString());
			rows = roleService.addRole(role);
		}else{
			rows = roleService.updateRole(role);
		}
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
	 * 删除
	 * @param roleId
	 * @return
	 */
	@RequestMapping("back/delete")
	@ResponseBody
	public EhyMessage delete(String roleId){
		EhyMessage mes = new EhyMessage();
		int rows = roleService.deleteRole(roleId);
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
	 * 显示全部并分页
	 * @param role
	 * @param limit
	 * @param page
	 * @return
	 */
	@RequestMapping("back/showList")
	@ResponseBody
	public Map<String, Object>findAllPage(EhyRole role, int limit, int page){
		Pages pages = new Pages();
		pages.setCurPage(page);
		pages.setMaxResult(limit);
		return roleService.findAllPage(role, pages);
	}
	
	/**
	 * 根据id查询
	 * @param roleId
	 * @return
	 */
	@RequestMapping("back/findById")
	@ResponseBody
	public EhyRole findById(String roleId){
		return roleService.findById(roleId);
	}
	
}
