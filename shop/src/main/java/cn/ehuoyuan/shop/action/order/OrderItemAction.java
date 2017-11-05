/**
 * 
 */
package cn.ehuoyuan.shop.action.order;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.shop.service.moneyRecord.MoneyRecordService;
import cn.ehuoyuan.shop.service.order.OrderItemService;

/**
 * 类的描述：
 * @author zengren
 * @date 2017年10月27日
 * @version 1.0
 */
@Controller
@RequestMapping("orderItem")
public class OrderItemAction {
	
	@Resource
	private OrderItemService orderItemService;
	@Resource
	private MoneyRecordService moneyRecordService;
	
	/**
	 * 显示后台订单
	 * @param map
	 * @param page
	 * @param limit
	 * @param state 状态，1：待发货订单，2：已发货订单，3：已收货订单。
	 * @return
	 */
	@RequestMapping("back/showList")
	@ResponseBody
	public Map<String, Object> showList(@RequestParam Map<String, Object> map, int page, int limit, int state){
		Pages pages = new Pages();
		pages.setCurPage(page);
		pages.setMaxResult(limit);
		map.put("pages", pages);
		return orderItemService.showList(map, state);
	}
	
	@RequestMapping("back/deliverGoods")
	@ResponseBody
	public EhyMessage deliverGoods(@RequestParam Map<String, Object> map, String arr[]){
		EhyMessage mes = new EhyMessage();
		int rows = orderItemService.deliverGoods(map, arr);
		if(rows>0){
			mes.setState(EhyMessage.SUCCESS);
			mes.setMes(EhyMessage.SUCCESS_MES);
		}else{
			mes.setState(EhyMessage.ERROR);
			mes.setMes(EhyMessage.ERROR_MES);
		}
		return mes;
	}
	
}
