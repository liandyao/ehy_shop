/**
 * 
 */
package cn.ehuoyuan.shop.action.coupon;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ehuoyuan.common.CommomUtils;
import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhyCoupon;
import cn.ehuoyuan.shop.domain.EhyStation;
import cn.ehuoyuan.shop.service.coupon.CouponService;
import cn.ehuoyuan.shop.service.station.StationService;

/**
 * 类的描述 后台优惠券管理action
 * @author denglijie
 * @date 2017年10月10日
 * @version v1.0
 */
@Controller
@RequestMapping("coupon")
public class CouponAction {
	
	/**
	 * 注入优惠券的service
	 */
	@Resource
	private CouponService couponService;
	
	/**
	 * 注入站点的service
	 */
	@Resource
	private StationService stationService;
	
	/**
	 * 显示列表
	 * @param page 
	 * @param limit
	 * @return map
	 */
	@RequestMapping("/back/showList")
	@ResponseBody
	public Map<String, Object> showList(int page,int limit,EhyCoupon coupon,String stName ){
		
		Map<String , Object> map = new HashMap<>();
		
		Pages p = new Pages();
		p.setCurPage(page);
		p.setMaxResult(limit);
		Map<String,Object> mapParam = new HashMap<String,Object>();
		
		mapParam.put("stName", stName);
		
		mapParam.put("couponCode", coupon.getCouponCode());
		
		mapParam.put("startTime", coupon.getStartTime());
		
		mapParam.put("endTime", coupon.getEndTime());
		
		
		mapParam.put("firstRows", p.getFirstRows());
		mapParam.put("maxResult", p.getMaxResult());
		
		List<Map> list = couponService.findAll(mapParam);
		for (Map m : list) {
			m.put("couponMinMoney", Tools.moneyFenToYuan2(m.get("couponMinMoney").toString()));
			m.put("couponMoney", Tools.moneyFenToYuan2(m.get("couponMoney").toString())); 
		}
		
		int count = couponService.findRowCount(mapParam);
		map.put("data", list);
		map.put("count", count);
	
		map.put("code",0);
		map.put("msg", "");
		return map;
	}
	
	/**
	 * 显示所有站点
	 * @return
	 */
	@RequestMapping("/back/findStation")
	@ResponseBody
	public Map<String, Object> findStation(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<EhyStation> list = stationService.findStation();
		System.out.println(list.size());
		map.put("list",list);
		return map;
	}
	
	
	
	/**
	 * 增加或修改
	 * @param ehyStation
	 * @return
	 */
	@RequestMapping("/back/addOrUpdate")
	@ResponseBody
	public EhyMessage addOrUpdate(EhyCoupon coupon){

		EhyMessage message = new EhyMessage();
		if(Tools.isEmpty(coupon.getCouponId())){
			//如果页面传过来的字母是小写则自动转换为大写字母
			coupon.setCouponCode(coupon.getCouponCode().toUpperCase());
			
			String couponCode = coupon.getCouponCode()+"_"+Tools.getRandomString(8);
			while(true){
				int row = couponService.selectByCode(couponCode);
				if(row>0){
					couponCode = coupon.getCouponCode()+Tools.getRandomString(8);
				}else{
					coupon.setCouponCode(couponCode);
					break;
				}
			}
			int rows = couponService.insertSelective(coupon);
			if(rows>0){
				message.setState(EhyMessage.SUCCESS);
				message.setMes(EhyMessage.SUCCESS_MES);
			}else{
				message.setState(EhyMessage.ERROR);
				message.setMes(EhyMessage.ERROR_MES);
			}
		}else{
			int rows = couponService.updateSelective(coupon);
			if(rows>0){
				message.setState(EhyMessage.SUCCESS);
				message.setMes(EhyMessage.SUCCESS_MES);
			}else{
				message.setState(EhyMessage.ERROR);
				message.setMes(EhyMessage.ERROR_MES);
			}
		}
		return message;
	}
	
	/**
	 * 显示修改信息
	 * @param stId
	 * @return
	 */
	@RequestMapping("/back/showUpdate")
	@ResponseBody
	public EhyCoupon showUpdate(String couponId){
		EhyCoupon coupon =  couponService.selectByPrimaryKey(couponId);
		coupon.setCouponMoney(new BigDecimal(Tools.moneyFenToYuan2(coupon.getCouponMoney().toString())));
		coupon.setCouponMinMoney(new BigDecimal(Tools.moneyFenToYuan2(coupon.getCouponMinMoney().toString())));
		return coupon;
		
	}
	
	/**
	 * 删除
	 * @param coupon
	 * @return
	 */
	@RequestMapping("/back/delete")
	@ResponseBody
	public EhyMessage delete(EhyCoupon coupon){
		coupon.setIsva(CommomUtils.ISVA_NO);
		int rows = couponService.updateSelective(coupon);
		EhyMessage message = new EhyMessage();
		if(rows>0){
			message.setState(EhyMessage.SUCCESS);
			message.setMes(EhyMessage.SUCCESS_MES);
		}else{
			message.setState(EhyMessage.ERROR);
			message.setMes(EhyMessage.ERROR_MES);
		}
		return message;
	}
	
	/**
	 * 排序
	 * @param start
	 * @param end
	 * @param couponId
	 * @return
	 */ 
	@RequestMapping("/back/sortCoupon")
	@ResponseBody
	public EhyMessage sortStation(int start, int end, String couponId) {
		System.out.println(couponId+"-------------------------");
		EhyMessage mes = new EhyMessage();
		int rows = couponService.sortCoupon(start, end, couponId);
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
