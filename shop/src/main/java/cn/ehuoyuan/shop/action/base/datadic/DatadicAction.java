/**
 * 
 */
package cn.ehuoyuan.shop.action.base.datadic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhyArea;
import cn.ehuoyuan.shop.domain.EhyDatadic;
import cn.ehuoyuan.shop.domain.EhyManager;
import cn.ehuoyuan.shop.service.base.datadic.DatadicService;

/**
 * 数据字典action
 * @author dong
 * @da2017年10月16日
 * @version 1.0
 */
@Controller
@RequestMapping("datadic")
public class DatadicAction {
	
	@Resource
	private DatadicService datadicService;
	/**
	 * 查询所有方法
	 * @param page
	 * @param limit
	 * @param area
	 * @return
	 */
	@RequestMapping("/back/showList")
	@ResponseBody  //ajax注解
	public Map<String,Object> showList(int page ,int limit,EhyDatadic datadic){
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> pagmap = new HashMap<String, Object>();
		Pages ps=new Pages();
		ps.setCurPage(page);
		ps.setMaxResult(limit);
		pagmap.put("page", ps.getFirstRows());//把页数传到map
		pagmap.put("limit", ps.getMaxResult());//把页数传到map
		pagmap.put("dicName",datadic.getDicName());//查询字典名称
		pagmap.put("dicCode",datadic.getDicCode());//查询字典编码
		pagmap.put("dicRemark",datadic.getDicRemark());//查询字典备注
		List<EhyDatadic> list =datadicService.findAll(pagmap);
		
		//layui数据表格需要返回的参数
		map.put("count",datadicService.findRowCount(pagmap));//总行数
		map.put("data", list);
		map.put("code",0);
		map.put("msg", "");
		return map;
	}
	
	/**
	 * 删除方法
	 * @param express
	 * @return
	 */
	@RequestMapping("/back/delete")
	@ResponseBody
	public EhyMessage delete(EhyDatadic datadic){
		datadic.setIsva(0);//定义0
		int rows = datadicService.updateByPrimaryKeySelective(datadic);//删除方法
		EhyMessage message = new EhyMessage();//消息类
		if(rows>0){
			message.setState(EhyMessage.SUCCESS);
			message.setMes(EhyMessage.SUCCESS_MES);
		}else{
			message.setState(EhyMessage.ERROR);
			message.setMes(EhyMessage.ERROR_MES);
		}
		return message;
	}
	
	/**
	 * 增加和修改
	 * @param express
	 * @return
	 */
	@RequestMapping("/back/addOrUpdate")
	@ResponseBody
	public EhyMessage addOrUpdate(EhyDatadic datadic,HttpSession session){
		EhyMessage mes = new EhyMessage();
		
		EhyManager man = (EhyManager) session.getAttribute("manager");//取session中的用户名
		
		
		datadic.setDicName(datadic.getDicName());//字典名称
		datadic.setDicCode(datadic.getDicCode());//字典编码
		datadic.setDicRemark(datadic.getDicRemark());//字典备注
		datadic.setIsva(1);//是否有效
		datadic.setOper(man.getManUser());
		
		
		if(Tools.isEmpty(datadic.getDicId())){//判断ID是否为空
			int rows=datadicService.insert(datadic);//增加方法
			if(rows>0){
				mes.setMes(EhyMessage.SUCCESS_MES);
				mes.setState(EhyMessage.SUCCESS);
			}else{
				mes.setMes(EhyMessage.ERROR_MES);
				mes.setState(EhyMessage.ERROR);
			}
			
		}else{
			int rows=datadicService.updateByPrimaryKeySelective(datadic);//修改方法
			if(rows>0){
				mes.setMes(EhyMessage.SUCCESS_MES);
				mes.setState(EhyMessage.SUCCESS);
			}else{
				mes.setMes(EhyMessage.ERROR_MES);
				mes.setState(EhyMessage.ERROR);
			}
		}
		return mes;
		
	}
	/**
	 * 根据ID查询
	 * @param express
	 * @return
	 */
	@RequestMapping("/back/findById")
	@ResponseBody
	public EhyDatadic findById(EhyDatadic datadic){
		EhyDatadic e=datadicService.selectByPrimaryKey(datadic.getDicId());
		return e;
		
	}
}
