/**
 * 
 */
package cn.ehuoyuan.shop.action.base.area;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhyArea;
import cn.ehuoyuan.shop.domain.EhyManager;
import cn.ehuoyuan.shop.service.base.area.EhyAreaService;
/**
 * 地区action
 * @author dong
 * @date 2017年9月29日 上午11:30:10
 * @version 1.0 
 */
@Controller
@RequestMapping("area")
public class EhyAreaAction {

	@Resource
	private EhyAreaService ehyAreaService;
	
	
	
	/**
	 * 查询所有方法
	 * @param page
	 * @param limit
	 * @param area
	 * @return
	 */
	@RequestMapping("/back/showList")
	@ResponseBody  //ajax注解
	public Map<String,Object> showList(int page ,int limit,EhyArea area){
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> pagmap = new HashMap<String, Object>();
		Pages ps=new Pages();
		ps.setCurPage(page);
		ps.setMaxResult(limit);
		pagmap.put("page", ps.getFirstRows());
		pagmap.put("limit", ps.getMaxResult());
		pagmap.put("area", area.getAreaName());//查询
		List<EhyArea> list =ehyAreaService.findAll(pagmap);
		
		//layui数据表格需要返回的参数
		map.put("count", ehyAreaService.findRowCount(pagmap));
		map.put("data", list);
		map.put("code",0);
		map.put("msg", "");
		return map;
	}
	
	
	/**
	 * 删除方法
	 * @param express
	 * @return
	 */
	@RequestMapping("/back/delete")
	@ResponseBody
	public EhyMessage delete(EhyArea area){
		area.setIsva(0);//定义0
		int rows = ehyAreaService.updateByPrimaryKeySelective(area);
		EhyMessage message = new EhyMessage();//消息类
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
	 * 下拉框查询
	 * @param session
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("/back/showajax")
	@ResponseBody  //ajax的注解
	public List<EhyArea> showAjax(){
		
		List<EhyArea> list = ehyAreaService.findshow();
		return list;
		
	}
	
	
	/**
	 * 增加和修改
	 * @param express
	 * @return
	 */
	@RequestMapping("/back/addOrUpdate")
	@ResponseBody
	public EhyMessage addOrUpdate(EhyArea area,HttpSession session){
		EhyMessage mes = new EhyMessage();//消息类
		EhyManager man = (EhyManager) session.getAttribute("manager");//取session中的用户名
		
		area.setAreaId(area.getAreaId());//地区编号
		area.setAreaName(area.getAreaName());//地区名称
		area.setParentId(area.getParentId());//地区表地区id自关联外键
		area.setOper(man.getManUser());//操作人
		area.setIsva(1);
		if(Tools.isEmpty(area.getAreaId())){//判断ID是否为空
			int rows=ehyAreaService.insert(area);//增加方法
			if(rows>0){
				mes.setMes(EhyMessage.SUCCESS_MES);
				mes.setState(EhyMessage.SUCCESS);
			}else{
				mes.setMes(EhyMessage.ERROR_MES);
				mes.setState(EhyMessage.ERROR);
			}
			
		}else{
			
			int rows=ehyAreaService.update(area);//修改方法
			if(rows>0){
				mes.setMes(EhyMessage.SUCCESS_MES);
				mes.setState(EhyMessage.SUCCESS);
			}else{
				mes.setMes(EhyMessage.ERROR_MES);
				mes.setState(EhyMessage.ERROR);
			}
			
			
			
			
		}

		return mes;
		
	}
	
	/**
	 * 根据ID查询
	 * @param express
	 * @return
	 */
	@RequestMapping("/back/findById")
	@ResponseBody
	public EhyArea findById(EhyArea area){
		EhyArea e=ehyAreaService.selectByPrimaryKey(area.getAreaId());
		return e;
		
	}
	
	
	/**
	 * 查询省区导出
	 * @param express
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/back/province")
	@ResponseBody
	public EhyMessage province(EhyArea area,HttpSession session,int judge) throws IOException{
		EhyMessage mes = new EhyMessage();//消息类
		
		
		String path = session.getServletContext().getRealPath("/res/area/json");//得到项目的地址
		
		
		ObjectMapper mapper = new ObjectMapper();
		//省区导出
		if(judge==1){
			List<Map<String, Object>> list=ehyAreaService.findProvince();
			
			
			if(list.size()>0){
				mes.setMes(EhyMessage.SUCCESS_MES);
				mes.setState(EhyMessage.SUCCESS);
			}else{
				mes.setMes(EhyMessage.ERROR_MES);
				mes.setState(EhyMessage.ERROR);
			}
			
			
			
			 
			BufferedWriter w = new BufferedWriter 
					(new OutputStreamWriter(new FileOutputStream (path+"\\provinces.json",false),"UTF-8"));//如果是false则覆盖，如果是true的追加
	
			
			
			
			String json= mapper.writeValueAsString(list);
			w.write(json);
			w.flush();
			w.close();
		}else if(judge==2){//查询城市导出
			List<Map<String, Object>> list=ehyAreaService.findProvince();//先查询出省
			
			
		
				Map<String, Object> newMap=new HashMap<String, Object>();//定义省区map
				
			for(int i=0;i<list.size();i++){//循环省份
				Map<String, Object> map=list.get(i);//传人map
				String provinceId=(String) map.get("provinceId");//取出省份ID
				
				List<Map<String, Object>> cityList2=ehyAreaService.findCity(provinceId);//根据省份ID查询市
				
				if(cityList2.size()>0){
					mes.setMes(EhyMessage.SUCCESS_MES);
					mes.setState(EhyMessage.SUCCESS);
				}else{
					mes.setMes(EhyMessage.ERROR_MES);
					mes.setState(EhyMessage.ERROR);
				}
				
				
				newMap.put(provinceId, cityList2);//传人json
				
				
			}
			
			BufferedWriter w = new BufferedWriter 
					(new OutputStreamWriter(new FileOutputStream (path+"\\cities.json",false),"UTF-8"));//如果是false则覆盖，如果是true的追加
			
			String json= mapper.writeValueAsString(newMap);
			
			w.write(json);
			w.flush();
			w.close();
		}else if(judge==3){// 查询城市导出
			List<Map<String, Object>> list=ehyAreaService.findProvince();//先查询出省
			
			
		
			Map<String, Object> newMap=new HashMap<String, Object>();//定义市区map
			
			for(int i=0;i<list.size();i++){//循环省份
				Map<String, Object> map=list.get(i);//传人map
				String provinceId=(String) map.get("provinceId");//取出省份ID
				
				List<Map<String, Object>> cityList2=ehyAreaService.findCity(provinceId);//根据省份ID查询市
				
				for(int j=0;j<cityList2.size();j++){//循环出市区
					Map<String, Object> map1=cityList2.get(j);//传人map
					
					String cityId=(String) map1.get("cityId");//取出市区ID
					
					List<Map<String, Object>> areaList2=ehyAreaService.findArea(cityId);//根据市区ID查询区县
					
					
					if(areaList2.size()>0){
						mes.setMes(EhyMessage.SUCCESS_MES);
						mes.setState(EhyMessage.SUCCESS);
					}else{
						mes.setMes(EhyMessage.ERROR_MES);
						mes.setState(EhyMessage.ERROR);
					}
					
					
				
					
					newMap.put(cityId, areaList2);//传人json
					
					
				}
				
			}
			BufferedWriter w = new BufferedWriter 
					(new OutputStreamWriter(new FileOutputStream (path+"\\areas.json",false),"UTF-8"));//如果是false则覆盖，如果是true的追加
			
			
			String json= mapper.writeValueAsString(newMap);
			
			w.write(json);
			w.flush();
			w.close();
		}
		
		
		
		return mes ;
		
	}
	
	
	/**
	 * 查询城市导出
	 * @param express
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/back/findArea")
	@ResponseBody
	public EhyMessage area(EhyArea area,HttpSession session) throws IOException{
		
		EhyMessage mes = new EhyMessage();//消息类
		
		
		
		
		return mes ;
		
	}
}
