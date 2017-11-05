/**
 * 
 */
package cn.ehuoyuan.shop.action.station;

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
import cn.ehuoyuan.shop.domain.EhyManager;
import cn.ehuoyuan.shop.domain.EhyStation;
import cn.ehuoyuan.shop.service.station.StationService;

/**
 * 类的描述  站点管理的Action
 * @author denglijie
 * @date 2017年9月30日
 * @version v1.0
 */
@Controller
@RequestMapping("station")
public class StationAction {
	
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
	public Map<String, Object> showList(int page,int limit,EhyStation ehyStation){
		//定义一个map集合
		Map<String , Object> map = new HashMap<>();
		//new出一个分页工具类对象
		Pages p = new Pages(); 
		p.setCurPage(page);//将页面传过来的当前页数给分页对象中的当前页数重新赋值
		p.setMaxResult(limit);//将页面传过来的每页显示行数给分页对象中的每页最大显示条数重新赋值
		
		//定义一个map集合
		Map<String,Object> mapParam = new HashMap<String,Object>();
		
		mapParam.put("stName", ehyStation.getStName());//把站点名称加入到集合 
		mapParam.put("stCode", ehyStation.getStCode());//把站点编码加入到集合
		mapParam.put("stType", ehyStation.getStType()); //把站点类型加入到集合
		mapParam.put("stFlag", ehyStation.getStFlag()); //把站点邀请码标识加入到集合
		
		mapParam.put("firstRows", p.getFirstRows());//把开始的行数加入到集合
		mapParam.put("maxResult", p.getMaxResult());//把每页最大显示条数加入到集合
		
		//查询显示列表的方法
		List<EhyStation> list = stationService.findAll(mapParam);
		//查询列表总行数的方法
		int count = stationService.findRowCount(mapParam);
		
		map.put("data", list);//把集合加入到集合
		map.put("count", count); //把总行数加入到集合
		map.put("code",0);//把状态码加入到集合
		map.put("msg", "");//把错误提示加入到集合
		return map;
	}
	
	
	 
    /**
     * 根据站点ID查询站点名称
     * @author 欧阳丰
	 * @date 2017年10月9日 16:42:26
	 * @version 1.1
     */
	@RequestMapping("/back/selectByPrimaryKey")
	@ResponseBody
	public EhyStation selectByPrimaryKey(HttpSession session){
		EhyManager manager = (EhyManager) session.getAttribute("manager");
		EhyStation station = stationService.selectByPrimaryKey(manager.getStId());
		return station;
	}
	
	/**
     * 查询所有分站站点
     * @author 欧阳丰
     * <p>使用:罗海兵</p>
	 * @date 2017年10月14日 10:06:26
	 * @version 1.1
     */
	@RequestMapping("/back/findStation")
	@ResponseBody
	public List<EhyStation> findStation(){
		List<EhyStation> list = stationService.findStation();
		return list;
	}
	
	/**
	 * 显示修改信息
	 * @param stId
	 * @return
	 */
	@RequestMapping("/back/showUpdate")
	@ResponseBody
	public EhyStation showUpdate(String stId){
		//根据ID查找数据
		EhyStation ehyStation =  stationService.findById(stId);
		return ehyStation;
	}
	
	/**
	 * 增加或修改
	 * @param ehyStation
	 * @param session
	 * @return
	 */
	@RequestMapping("/back/addOrUpdate")
	@ResponseBody
	public EhyMessage addOrUpdate(EhyStation ehyStation,HttpSession session){
		//获取session里面的用户对象
		EhyManager man = (EhyManager) session.getAttribute("manager");
		//取用户对象里的用户账号赋值给站点的操作人
		ehyStation.setOper(man.getManUser());
		
		//如果有小写字母将会自动转化为大写字母
		ehyStation.setStCode(ehyStation.getStCode().toUpperCase());
		ehyStation.setStFlag(ehyStation.getStFlag().toUpperCase());
		
		//new出一个消息类对象
		EhyMessage message = new EhyMessage();
		if(Tools.isEmpty(ehyStation.getStId())){//利用工具类判断站点ID是否为空
			//根据站点名称判断站点名称是否存在的方法
			int row = stationService.isStation(ehyStation.getStName());
			if(row>0){
				message.setState(EhyMessage.ERROR);
				message.setMes("该站点已存在！");
			}else{
				//增加站点的方法
				int rows = stationService.insertSelective(ehyStation);
				if(rows>0){
					message.setState(EhyMessage.SUCCESS);
					message.setMes(EhyMessage.SUCCESS_MES);
				}else{
					message.setState(EhyMessage.ERROR);
					message.setMes(EhyMessage.ERROR_MES);
				}
			}
		}else{ 	
			//修改站点的方法
			int rows = stationService.update(ehyStation);
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
	 * @param ehyStation
	 * @return
	 */
	@RequestMapping("/back/delete")
	@ResponseBody
	public EhyMessage delete(EhyStation ehyStation){
		//利用定义常量类工具给站点的状态从新赋值为无效状态
		ehyStation.setIsva(CommomUtils.ISVA_NO);
		//修改站点的方法
		int rows = stationService.update(ehyStation);
		//new出一个消息类对象
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
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/back/sortStation")
	@ResponseBody
	public EhyMessage sortStation(int start, int end, String stId) {
		//new出一个消息类对象
		EhyMessage mes = new EhyMessage();
		//站点排序的方法
		int rows = stationService.sortStation(start, end, stId);
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
