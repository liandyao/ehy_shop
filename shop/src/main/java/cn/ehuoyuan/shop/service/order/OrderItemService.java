/**
 * 
 */
package cn.ehuoyuan.shop.service.order;

import java.util.Map;

import cn.ehuoyuan.common.Pages;

/**
 * 类的描述：
 * @author zengren
 * @date 2017年10月27日
 * @version 1.0
 */
public interface OrderItemService {
	
	Map<String, Object> showList(Map<String, Object> map, int state);
	
	int jsMoney(Map<String, Object> map);
	
	int deliverGoods(Map<String, Object> map,String[] arr);
	
	String findMoney(Map<String, Object> map);
	
}
