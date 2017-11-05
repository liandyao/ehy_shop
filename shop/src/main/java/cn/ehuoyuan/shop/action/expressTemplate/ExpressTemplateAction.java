/**
 * 
 */
package cn.ehuoyuan.shop.action.expressTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ehuoyuan.common.CommomUtils;
import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhyCoupon;
import cn.ehuoyuan.shop.domain.EhyExpress;
import cn.ehuoyuan.shop.domain.EhyExpressTemplate;
import cn.ehuoyuan.shop.domain.EhyManager;
import cn.ehuoyuan.shop.domain.EhyStation;
import cn.ehuoyuan.shop.service.base.expres.ExpressService;
import cn.ehuoyuan.shop.service.expressTemplate.ExpressTemplateService;
import cn.ehuoyuan.shop.service.station.StationService;

/**
 * 运费模版管理的action类
 * @author denglijie
 * @date 2017年10月17日 下午 15:29:09
 * @version 1.0
 */
@Controller
@RequestMapping("expressTemplate")
public class ExpressTemplateAction {

	/**
	 * 注入运费模版的service
	 */
	@Resource
	private ExpressTemplateService expressTemplateService;
	
	/**
	 * 注入物流的service
	 */
	@Resource
	private ExpressService expressService;
	
	/**
	 * 注入站点的service
	 */
	@Resource
	private StationService stationService;
	
	/**
     * 根据站点ID查询所有运费模板
     * @param stId 站点ID
     * @return 运费模板集合
     * @author 欧阳丰
	 * @date 2017年10月19日18:20:09
	 * @version 1.1
     */
	@RequestMapping("/back/findByStId")
	@ResponseBody
	public List<EhyExpressTemplate> findByStId(String stId){
		return expressTemplateService.findByStId(stId);
	}
	
	/**
	 * 显示列表
	 * @param page 
	 * @param limit
	 * @return map
	 */
	@RequestMapping("/back/showList")
	@ResponseBody
	public Map<String, Object> showList(int page,int limit,String tempName,String name,String stName){
		//定义一个map集合
		Map<String , Object> map = new HashMap<>();
		//new出一个分页工具类对象
		Pages p = new Pages();
		p.setCurPage(page);
		p.setMaxResult(limit);
		Map<String,Object> mapParam = new HashMap<String,Object>();
		
		mapParam.put("tempName",tempName);
		mapParam.put("name",name);
		mapParam.put("stName",stName);
		
		mapParam.put("firstRows", p.getFirstRows());
		mapParam.put("maxResult", p.getMaxResult());
		
		//查询显示列表的方法
		List<Map> list = expressTemplateService.findAll(mapParam);
		
		for (Map m : list) {
			//利用工具类将运费由分转化为元
			m.put("money", Tools.moneyFenToYuan2(m.get("money").toString()));
		}
		//查询总行数的方法
		int count = expressTemplateService.findRowCount(mapParam);
		map.put("data", list);
		map.put("count", count);
	
		map.put("code",0);
		map.put("msg", "");
		return map;
	}
	
	/**
	 * 显示所有快递
	 * @return
	 */
	@RequestMapping("/back/findExpress")
	@ResponseBody
	public Map<String, Object> findExpress(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<EhyExpress> list = expressService.findExpress();
		map.put("list",list);
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
		map.put("list",list);
		return map;
	}
	
	/**
	 * 显示修改信息
	 * @param ehyStation
	 * @return
	 */
	@RequestMapping("/back/showUpdate")
	@ResponseBody
	public EhyExpressTemplate showUpdate(String tempId){
		EhyExpressTemplate expressTemplate = expressTemplateService.findById(tempId);
		expressTemplate.setMoney(new BigDecimal(Tools.moneyFenToYuan2(expressTemplate.getMoney().toString())));
		return expressTemplate;
	}
	
	/**
	 * 增加或修改
	 * @param ehyStation
	 * @param session
	 * @return
	 */
	@RequestMapping("/back/addOrUpdate")
	@ResponseBody
	public EhyMessage addOrUpdate(EhyExpressTemplate expressTemplate,HttpSession session){
		//获取session里面的用户对象
		EhyManager man = (EhyManager) session.getAttribute("manager");
		//取用户对象里的用户账号赋值给运费模版的操作人
		expressTemplate.setOper(man.getManUser());
		
		EhyMessage message = new EhyMessage();
		if(Tools.isEmpty(expressTemplate.getTempId())){
			int rows = expressTemplateService.insertSelective(expressTemplate);
			if(rows>0){
				message.setState(EhyMessage.SUCCESS);
				message.setMes(EhyMessage.SUCCESS_MES);
			}else{
				message.setState(EhyMessage.ERROR);
				message.setMes(EhyMessage.ERROR_MES);
			}
		}else{
			int rows = expressTemplateService.updateSelective(expressTemplate);
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
	 * 删除
	 * @param coupon
	 * @return
	 */
	@RequestMapping("/back/delete")
	@ResponseBody
	public EhyMessage delete(EhyExpressTemplate expressTemplate){
		expressTemplate.setIsva(CommomUtils.ISVA_NO);
		int rows = expressTemplateService.updateSelective(expressTemplate);
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
	 * @param tempId
	 * @return
	 */
	@RequestMapping("/back/sortTemplate")
	@ResponseBody
	public EhyMessage sortTemplate(int start, int end, String tempId) {
		EhyMessage mes = new EhyMessage();
		int rows = expressTemplateService.sortTemplate(start, end, tempId);
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
