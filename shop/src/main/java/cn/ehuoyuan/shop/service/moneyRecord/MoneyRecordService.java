/**
 * 
 */
package cn.ehuoyuan.shop.service.moneyRecord;

import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyMoneyRecord;

/**
 * 类的描述：
 * @author zengren
 * @date 2017年10月25日
 * @version 1.0
 */
public interface MoneyRecordService {
	
	public Map<String, Object> showList(Map<String, Object> map);
	
	public int addRecord(EhyMoneyRecord ehyMoneyRecord, Map<String, Object> map);
	
	public String findMaxTime();
	
}
