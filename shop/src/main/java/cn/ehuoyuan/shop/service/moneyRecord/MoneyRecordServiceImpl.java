/**
 * 
 */
package cn.ehuoyuan.shop.service.moneyRecord;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.dao.EhyMoneyRecordMapper;
import cn.ehuoyuan.shop.dao.EhyOrderMapper;
import cn.ehuoyuan.shop.domain.EhyMoneyRecord;

/**
 * 类的描述：资金结算记录Service实现类
 * @author zengren
 * @date 2017年10月25日
 * @version 1.0
 */
@Service
public class MoneyRecordServiceImpl implements MoneyRecordService{
	
	@Resource
	private EhyMoneyRecordMapper ehyMoneyRecordMapper;
	@Resource
	private EhyOrderMapper ehyOrderMapper;

	@Override
	public Map<String, Object> showList(Map<String, Object> map) {
		Map<String, Object> reutrnMap = new HashMap<String, Object>();
		reutrnMap.put("data", ehyMoneyRecordMapper.showList(map));
		reutrnMap.put("code", 0);
		reutrnMap.put("count", ehyMoneyRecordMapper.countRows(map));
		reutrnMap.put("msg", "");
		return reutrnMap;
	}

	@Override
	public int addRecord(EhyMoneyRecord ehyMoneyRecord, Map<String, Object> map) {
		String mrId = ehyMoneyRecord.getMrId();
		String mrMoney = ehyOrderMapper.findMoney(map);
		if(mrMoney==null){
			return 2;
		}
		if(Tools.isEmpty(ehyMoneyRecord.getMrRemark())){
			ehyMoneyRecord.setMrRemark("这个人很懒，提交的时候什么都不写！");
		}
		ehyMoneyRecord.setMrMoney(new BigDecimal(mrMoney));
		int rows = ehyMoneyRecordMapper.insertSelective(ehyMoneyRecord);
		map.put("mrId", mrId);
		rows = ehyOrderMapper.jsMoney(map);
		return rows;
	}

	@Override
	public String findMaxTime() {
		// TODO Auto-generated method stub
		return ehyMoneyRecordMapper.findMaxTime();
	}
	
}