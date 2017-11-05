/**
 * 
 */
package cn.ehuoyuan.shop.action.privilege;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhyManager;
import cn.ehuoyuan.shop.domain.EhyMember;
import cn.ehuoyuan.shop.domain.EhyStation;
import cn.ehuoyuan.shop.service.privilege.ManagerService;
import cn.ehuoyuan.shop.service.station.StationService;

/**
 * 后台用户管理action
 * @author zengren
 * @date 2017年9月28日
 * @version 1.0
 */
@Controller
@RequestMapping("manager")
public class ManagerAction {
	
	@Resource
	private ManagerService managerService;
	
	@Resource
	private StationService stationService;
	
	/**
	 * 验证会员是否登陆
	 * @param session HttpSession会话对象
	 * @return 已登陆返回true,未登陆返回false
	 * @author 罗海兵
	 * @dateTime 2017年10月30日 上午9:41:11
	 * @versions 1.0
	 */
	@RequestMapping("back/isLogin")
	@ResponseBody
	public boolean isLogin(HttpSession session){
		EhyManager manager=(EhyManager) session.getAttribute("manager");
		return manager!=null;
	}
	
	/**
	 * 后台登录
	 * @param record
	 * @param session
	 * @return
	 */
	@RequestMapping("back/login")
	@ResponseBody
	public String isLogin(EhyManager record, HttpSession session){
		record.setManPwd(Tools.password(record.getManPwd()));
		EhyManager manager = managerService.isLogin(record);
		if(manager!=null){
			session.setAttribute("manager", manager);
			return "1";
		}else{
			return "0";
		}
	}
	
	/**
	 * 增加或者修改
	 * @param record
	 * @return
	 */
	@RequestMapping("back/addOrUpdate")
	@ResponseBody
	public EhyMessage addOrUpdate(EhyManager record, HttpSession session){
		EhyMessage mes = new EhyMessage();
		boolean flag = false;
		EhyManager man = (EhyManager) session.getAttribute("manager");
		record.setManPwd(Tools.password(record.getManPwd()));
		if(Tools.isEmpty(record.getManId())){
			record.setManId(UUID.randomUUID().toString());
			record.setOper(man.getManUser());
			flag = managerService.addManager(record);
		}else{
			flag = managerService.updateManager(record);
		}
		if(flag){
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
	 * @param manId
	 * @return
	 */
	@RequestMapping("back/delete")
	@ResponseBody
	public EhyMessage delete(String manId){
		EhyMessage mes = new EhyMessage();
		boolean flag = managerService.deleteManager(manId);
		if(flag){
			mes.setMes(EhyMessage.SUCCESS_MES);
			mes.setState(EhyMessage.SUCCESS);
		}else{
			mes.setMes(EhyMessage.ERROR_MES);
			mes.setState(EhyMessage.ERROR);
		}
		return mes;
	}
	
	/**
	 * 根据id查询
	 * @param manId
	 * @return
	 */
	@RequestMapping("back/findById")
	@ResponseBody
	public EhyManager findById(String manId){
		EhyManager man = managerService.findById(manId);
		return man;
	}
	
	/**
	 * 显示全部，并分页
	 * @param record
	 * @param pages
	 * @return
	 */
	@RequestMapping("back/showList")
	@ResponseBody
	public Map<String, Object> showList(EhyManager record, Pages pages, int limit, int page){
		Map<String, Object> map = new HashMap<String, Object>();
		pages.setCurPage(page);
		pages.setMaxResult(limit);
		if(Tools.isEmpty(record.getStId())){
			record.setStId(null);
		}
		List<EhyManager> list = managerService.findAllPage(record, pages);
		int count = managerService.countRows(record);
		map.put("code", "");
		map.put("msg", "");
		map.put("count", count);
		map.put("data", list);
		return map;
	}
	
	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping("back/logout")
	@ResponseBody
	public ModelAndView logout(HttpSession session){
		ModelAndView mav = new ModelAndView("redirect:/pages/back/login.jsp");
		session.removeAttribute("manager");
		return mav;
	}
	
	/**
	 * 显示全部分站
	 * @return
	 */
	@RequestMapping("back/showAllStation")
	@ResponseBody
	public List<EhyStation> showAllStation(){
		return stationService.findStation();
	}
	
	/**
	 * 判断用户名是否已存在
	 * @return
	 */
	@RequestMapping("back/isManUser")
	@ResponseBody
	public EhyMessage isManUser(String manUser){
		EhyMessage mes = new EhyMessage();
		boolean flag = managerService.findByName(manUser);
		if(!flag){
			mes.setMes(EhyMessage.SUCCESS_MES);
			mes.setState(EhyMessage.SUCCESS);
		}else{
			mes.setMes(EhyMessage.ERROR_MES);
			mes.setState(EhyMessage.ERROR);
		}
		return mes;
	}
	
}
