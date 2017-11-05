/**
 * 
 */
package cn.ehuoyuan.shop.action.moneyRecord;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ehuoyuan.shop.service.moneyRecord.MoneyStatService;

/**
 * 类的描述：类的描述：资金结算时间汇总Action类
 * @author zengren
 * @date 2017年10月26日
 * @version 1.0
 */
@Controller
@RequestMapping("moneyStat")
public class MoneyStatAction {
	
	@Resource
	private MoneyStatService moneyStatService;
	
	@RequestMapping("back/showList")
	@ResponseBody
	public Map<String, Object> showList(@RequestParam Map<String, Object> map){
		System.out.println("1234567890--------------------");
		return moneyStatService.showList(map);
	}
	
}
