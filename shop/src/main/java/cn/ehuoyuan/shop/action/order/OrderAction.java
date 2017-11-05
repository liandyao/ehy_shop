/**
 * 
 */
package cn.ehuoyuan.shop.action.order;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.shop.domain.EhyMember;
import cn.ehuoyuan.shop.service.order.OrderService;

/**
 * 类的描述：订单的action
 * @author xym
 * @date 2017年10月19日
 * @version 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderAction {
	@Resource
	private OrderService orderService;
	
	/**
	 * 前端显示全部订单的方法
	 * @param session
	 * @param 当前的页数
	 * @return 订单和消息状态
	 */
	@RequestMapping("front/showList")
	@ResponseBody
	public Map<String, Object> frontShowList(HttpSession session,@RequestParam Map<String, Object> map,Pages page){
		EhyMember mb=(EhyMember) session.getAttribute("login");//得到session中的会员对象
		if(null!=mb){
			map.put("mbId", mb.getMbId());//将会员的id传入map中
		}
		
		map.put("page", page);
		return orderService.frontShowAll(map);
	}
	/**
	 * 确认收货的方法
	 * @param session
	 * @param map
	 * @param ordId
	 * @return 消息结果
	 */
	@RequestMapping("front/receipt")
	@ResponseBody
	public EhyMessage receipt(HttpSession session,Map<String, Object> map,String ordId){
		EhyMember mb=(EhyMember) session.getAttribute("login");//得到session中的会员对象
		map.put("mbId", mb.getMbId());//将会员id传入map
		map.put("ordId", ordId);//将订单号传入map
		return orderService.receipt(map);
	}
	
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
	public Map<String, Object> backShowList(Map<String, Object> map, int page, int limit, int state){
		Pages pages = new Pages();
		pages.setCurPage(page);
		pages.setMaxResult(limit);
		return orderService.backShowAll(map, pages, state);
	}
}
