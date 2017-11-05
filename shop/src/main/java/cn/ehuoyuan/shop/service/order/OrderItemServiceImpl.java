/**
 * 
 */
package cn.ehuoyuan.shop.service.order;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.shop.dao.EhyOrderMapper;

/**
 * 类的描述：
 * @author zengren
 * @date 2017年10月27日
 * @version 1.0
 */
@Service
public class OrderItemServiceImpl implements OrderItemService{
	
	@Resource
	private EhyOrderMapper ehyOrderMapper;
	
	@Override
	public Map<String, Object> showList(Map<String, Object> map, int state) {
		map.put("state", state);
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("data", ehyOrderMapper.findAllOrderItem(map));
		hashMap.put("count", ehyOrderMapper.countRows(map));
		hashMap.put("msg", "");
		hashMap.put("code", 0);
		return hashMap;
	}
	
	
	@Override
	public int jsMoney(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ehyOrderMapper.jsMoney(map);
	}

	@Override
	public int deliverGoods(Map<String, Object> map, String[] arr) {
		int rows = 0;
		if(arr!=null){
			for(int i=0; i<arr.length; i++){
				map.put("mxId", arr[i]);
				rows += ehyOrderMapper.deliverGoods(map);
			}
		}
		return rows;
	}


	@Override
	public String findMoney(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ehyOrderMapper.findMoney(map);
	}
	
}
