/**
 * 
 */
package cn.ehuoyuan.shop.action.base.exoress;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhyArea;
import cn.ehuoyuan.shop.domain.EhyExpress;
import cn.ehuoyuan.shop.domain.EhyManager;
import cn.ehuoyuan.shop.service.base.expres.ExpressService;

/**
 * 物流action
 * @author dong
 * @da2017年10月7日
 * @version 1.0
 */
@Controller
@RequestMapping("express")
public class ExpressAction {

	@Resource
	private ExpressService expressService;
	
	
	/**
	 * 查询所有方法
	 * @param page
	 * @param limit
	 * @param area
	 * @return
	 */
	@RequestMapping("/back/showList")
	@ResponseBody  //ajax注解
	public Map<String,Object> showList(int page ,int limit,EhyExpress express){
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> pagmap = new HashMap<String, Object>();
		Pages ps=new Pages();//new一个分页的工具类
		ps.setCurPage(page);//页面的当前页数
		ps.setMaxResult(limit);//页面的显示多少行
		pagmap.put("page", ps.getFirstRows());
		pagmap.put("limit", ps.getMaxResult());
		pagmap.put("mingcheng", express.getName());
		pagmap.put("code", express.getCode());
		pagmap.put("url", express.getUrl());
	
		
		List<EhyExpress> list =expressService.findAll(pagmap);
		
		//layui数据表格需要返回的参数
		map.put("count", expressService.findRowCount(pagmap));
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
	public EhyMessage delete(EhyExpress express){
		express.setIsva(0);//是否有效 0删除
		int rows = expressService.updateByPrimaryKeySelective(express);//删除方法
		EhyMessage message = new EhyMessage();
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
	 * 增加或修改
	 * @param express
	 * @return
	 */
	@RequestMapping("/back/addOrUpdate")
	@ResponseBody
	public EhyMessage addOrUpdate(EhyExpress express,HttpSession session){
		
		
		EhyMessage mes=new EhyMessage();//消息类
		EhyManager man = (EhyManager) session.getAttribute("manager");//取session中的用户名
		
		
		express.setExpreessId(express.getExpreessId());//快递公司的主键id
		express.setName(express.getName());//名称
		express.setCode(express.getCode());//编码
		express.setLogo(express.getLogo());//logo
		express.setUrl(express.getUrl());//网址
		express.setIsva(1);//是否有效
		express.setOper(man.getManUser());//操作人
		
		//增加
		if(Tools.isEmpty(express.getExpreessId())){//判断是否问空
			
			int rows=expressService.insert(express);//增加方法
			if(rows>0){
				mes.setState(EhyMessage.SUCCESS);
				mes.setMes(EhyMessage.SUCCESS_MES);
			}else{
				mes.setState(EhyMessage.ERROR);
				mes.setMes(EhyMessage.ERROR_MES);
			}
			
		}else{
			int rows=expressService.update(express);//修改方法
			if(rows>0){
				mes.setState(EhyMessage.SUCCESS);
				mes.setMes(EhyMessage.SUCCESS_MES);
			}else{
				mes.setState(EhyMessage.ERROR);
				mes.setMes(EhyMessage.ERROR_MES);
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
	public EhyExpress findById(EhyExpress express){
		EhyExpress e=expressService.selectByPrimaryKey(express.getExpreessId());//根据ID查询
		return e;
		
	}
	
}
