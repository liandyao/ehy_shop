/**
 * 
 */
package cn.ehuoyuan.shop.service.order;

import java.util.Map;

import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;

/**
 * 类的描述：订单的Service接口
 * @author xym
 * @date 2017年10月19日
 * @version 1.0
 */
public interface OrderService {
	/**
	 * 前端登录显示
	 * @param 会员编号
	 * @param 分页对象
	 * @return 会员订单集合与状态
	 */
	public Map<String, Object> frontShowAll(Map<String, Object> map);
	
	/**
	 * 后台订单显示
	 * @param map
	 * @param pages
	 * @param state 状态，1：待发货订单，2：已发货订单，3：已收货订单。
	 * @return
	 */
	public Map<String, Object> backShowAll(Map<String, Object> map, Pages pages, int state);
	
	/**
	 * 显示全部已发货订单
	 * @param map
	 * @param pages
	 * @return
	 */
	public Map<String, Object> deliveredShowAll(Map<String, Object> map, Pages pages);
	
	/**
	 * 显示全部待发货订单
	 * @param map
	 * @param pages
	 * @return
	 */
	public Map<String, Object> overhangShowAll(Map<String, Object> map, Pages pages);
	
	/**
	 * 显示全部已收货订单
	 * @param map
	 * @param pages
	 * @return
	 */
	public Map<String, Object> receivedShowAll(Map<String, Object> map, Pages pages);
	
	public EhyMessage receipt(Map<String, Object> map);
	
}
