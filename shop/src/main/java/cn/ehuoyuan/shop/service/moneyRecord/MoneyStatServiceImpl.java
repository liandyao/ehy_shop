/**
 * 
 */
package cn.ehuoyuan.shop.service.moneyRecord;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.shop.dao.EhyMoneyStatMapper;

/**
 * 类的描述：资金结算时间汇总Service实现类
 * @author zengren
 * @date 2017年10月26日
 * @version 1.0
 */
@Service
public class MoneyStatServiceImpl implements MoneyStatService{
	
	@Resource
	private EhyMoneyStatMapper ehyMoneyStatMapper;

	@Override
	public Map<String, Object> showList(Map<String, Object> map) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("data", ehyMoneyStatMapper.showList(map));
		hashMap.put("code", 0);
		hashMap.put("count", ehyMoneyStatMapper.countRows(map));
		hashMap.put("msg", "");
		return hashMap;
	}
	
}
