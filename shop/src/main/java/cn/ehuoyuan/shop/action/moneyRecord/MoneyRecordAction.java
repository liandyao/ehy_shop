package cn.ehuoyuan.shop.action.moneyRecord;

import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhyManager;
import cn.ehuoyuan.shop.domain.EhyMoneyRecord;
import cn.ehuoyuan.shop.service.moneyRecord.MoneyRecordService;
import cn.ehuoyuan.shop.service.order.OrderItemService;
import cn.ehuoyuan.shop.service.order.OrderServiceImpl;

/**
 * 
 * 类的描述：资金记录的Action
 * @author zengren
 * @date 2017年10月25日
 * @version 1.0
 */
@Controller
@RequestMapping("moneyRecord")
public class MoneyRecordAction {
	
	@Resource
	private MoneyRecordService moneyRecordService;
	
	@RequestMapping("back/showList")
	@ResponseBody
	public Map<String, Object> showList(HttpSession session,@RequestParam Map<String, Object> map, int limit, int page){
		Pages pages = new Pages();
		pages.setCurPage(page);
		pages.setMaxResult(limit);
		map.put("stId", ((EhyManager)session.getAttribute("manager")).getStId());
		map.put("pages", pages);
		return moneyRecordService.showList(map);
	}
	
	@RequestMapping("back/findMaxTime")
	@ResponseBody
	public EhyMessage findMaxTime(){
		EhyMessage mes = new EhyMessage();
		String time = moneyRecordService.findMaxTime();
		if(time!=null){
			mes.setMes(time);
			mes.setState(EhyMessage.SUCCESS);
		}else{
			mes.setMes("资金还没有开始算，将从最早的订单开始结算");
			mes.setState(EhyMessage.SUCCESS);
		}
		return mes;
	}
	
	
	@RequestMapping("back/jeiSuan")
	@ResponseBody
	public EhyMessage jeiSuan(HttpSession session, EhyMoneyRecord ehyMoneyRecord, @RequestParam Map<String, Object> map){
		EhyMessage mes = new EhyMessage();
		String mrId = UUID.randomUUID().toString();
		ehyMoneyRecord.setMrId(mrId);
		ehyMoneyRecord.setOper(((EhyManager)session.getAttribute("manager")).getManUser());
		ehyMoneyRecord.setMrDatetime(Tools.getCurDateTime());
		
		int rows = moneyRecordService.addRecord(ehyMoneyRecord, map);
		if (rows==2){
			mes.setState(2);
			mes.setMes("改时间段的资金已经结算过了，请勿重复结算！");
		}else if(rows>0){
			mes.setState(EhyMessage.SUCCESS);
			mes.setMes(EhyMessage.SUCCESS_MES);
		}else{
			mes.setState(EhyMessage.ERROR);
			mes.setMes(EhyMessage.ERROR_MES);
		}
		return mes;
	}
	
}
