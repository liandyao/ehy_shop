/**
 * 
 */
package cn.ehuoyuan.shop.action.privilege;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhyModule;
import cn.ehuoyuan.shop.service.privilege.ModuleService;

/**
 * 后台模块管理action
 * @author zengren
 * @date 2017年9月28日
 * @version v1.0
 */
@Controller
@RequestMapping("module")
public class ModuleAction {
	
	@Resource
	private ModuleService moduleService;
	
	/**
	 * 增加或修改
	 * @param module
	 * @return
	 */
	@RequestMapping("back/addOrUpdate")
	@ResponseBody
	public EhyMessage addOrUpdate(EhyModule module){
		EhyMessage mes = new EhyMessage();
		int rows = 0;
		if(Tools.isEmpty(module.getModId())){
			module.setModId(UUID.randomUUID().toString());
			rows = moduleService.addEhyModule(module);
		}else{
			rows = moduleService.updateEhyModule(module);
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
	 * @param modId
	 * @return
	 */
	@RequestMapping("back/delete")
	@ResponseBody
	public EhyMessage delete(String modId){
		EhyMessage mes = new EhyMessage();
		int rows = moduleService.deleteEhyModule(modId);
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
	 * 根据id查询
	 * @param modId
	 * @return
	 */
	@RequestMapping("back/findById")
	@ResponseBody
	public EhyModule findById(String modId){
		return moduleService.findById(modId);
	}
	
	/**
	 * 显示全部数据
	 * @param module
	 * @param pages
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("back/showList")
	@ResponseBody
	public Map<String, Object> findAllPage(EhyModule module, Pages pages, int page, int limit){
		Map<String, Object> map = new HashMap<String, Object>();
		pages.setCurPage(page);
		pages.setMaxResult(limit);
		List<EhyModule> list = moduleService.findAllPage(module, pages);
		int count = moduleService.conutRows(module);
		map.put("code", "");
		map.put("msg", "");
		map.put("count", count);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 
	 * @param start
	 * @param end
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("back/sortModule")
	@ResponseBody
	public EhyMessage sortModule(int start, int end, String modId) {
		EhyMessage mes = new EhyMessage();
		int rows = moduleService.sortModule(start, end, modId);
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
	 * 查询一级分类
	 * @return
	 */
	@RequestMapping("back/findFirstLevel")
	@ResponseBody
	public List<EhyModule> findFirstLevel(){
		return moduleService.findFirstLevel();
	}
	
}
