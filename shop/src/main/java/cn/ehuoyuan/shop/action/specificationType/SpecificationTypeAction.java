/**
 * 
 */
package cn.ehuoyuan.shop.action.specificationType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ehuoyuan.common.CommomUtils;
import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhySpecificationType;
import cn.ehuoyuan.shop.service.specificationType.SpecificationTypeService;

/**
 * 规格类型action
 * @author HuXin
 * @date 2017年10月10日
 */
@Controller
@RequestMapping("SpecificationTypeAction")
public class SpecificationTypeAction {
	//规格service接口
	@Resource
	private SpecificationTypeService service;
	
	
	/**
	 * 得到规格类型集合
	 * @author 胡鑫
	 * @date 2017年10月10日16:32:40
	 * @return 返回json
	 */
	@ResponseBody
	@RequestMapping("/back/findSpecificationType")
	public List<EhySpecificationType> findSpecificationType(){
		Map<String,Object> map2 = new HashMap<String,Object>();
		map2.put("isva",CommomUtils.ISVA_YES );//设置参数 为有效
		//得到规格类型集合
		List<EhySpecificationType>list = service.findSpecificationTypeList(map2);
		return list;
	}
	
	/**
	 * 得到规格类型集合
	 * @author 胡鑫
	 * @date 2017年10月18日10:11:04
	 * @return 返回json
	 */
	@ResponseBody
	@RequestMapping("/back/findSpecificationTypeAll")
	public Map<String,Object> findSpecificationTypeAll(String page,String limit,String id){
		
		
		//创建map集合 用于分页、模糊查询
		Map<String,Object> map2 = new HashMap<String,Object>();
		Pages pages = new Pages();//创建分页对象
		pages.setCurPage(Integer.valueOf(page));//设置分页开始的页数
		pages.setMaxResult(Integer.valueOf(limit));//每页显示的行数
		map2.put("isva",CommomUtils.ISVA_YES );//设置 有效
		map2.put("pages", pages);//传入分页对象
		if(Tools.isEmpty(id)){
			map2.put("like", "");//设置模糊查询的值
		}else{
			map2.put("like", "%"+id+"%");//设置模糊查询的值
		}
		int count = service.selectCountSpecificationType(map2);//得到规格类型的总行数
		//得到规格类型集合
		List<EhySpecificationType>list = service.selectAll(map2);
		/**
		 * 需要返回到asp 页面的数据
		 */
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", 0);
		map.put("msg", "");
		map.put("data", list);//分页的数据
		map.put("count", count);//查询的总行数
		return map;
	}
	
	/**
	 * 根据规格类型id 查询该规格的所有信息
	 * @author 胡鑫
	 * @date 2017年10月19日09:30:30
	 * @return  返回规格类型
	 * @param 规格类型id
	 */
	@ResponseBody
	@RequestMapping("/back/showUpdate")
	public EhySpecificationType showUpdate(String sptId){
		
		return service.selectByPrimaryKey(sptId);
	}
	
	
	/**
	 * 增加或者修改的方法
	 * @author 胡鑫
	 * @date 2017年10月18日18:50:40
	 * @return 返回消息类
	 */
	@ResponseBody
	@RequestMapping("/back/addOrUpdate")
	public EhyMessage addOrUpdate(EhySpecificationType ehySpecificationType,String[] spValue ){
		EhyMessage mes = new EhyMessage();//定义一个消息类
		Map<String,Object>map = new HashMap<String,Object>();//定义map集合 用来存放规格类型数据 和 规格值数组
		map.put("ehySpecificationType", ehySpecificationType);//规格类型
		map.put("spValue", spValue);//规格值
		//判断规格类型id是否为空 为空返回true 则进行增加方法
		int rows = 0;
		if(Tools.isEmpty(ehySpecificationType.getSptId())){
			rows = service.insertSelective(map);
		}else{
			rows = service.updateByPrimaryKeySelective(map);
		}
		if(rows>0){
			mes.setMes("增加成功");
			mes.setState(1);
		}else{
			mes.setMes("增加失败");
			mes.setState(0);
		}
		return mes;
	}
	/**
	 * 根据规格类型id 进行规格删除(修改isva为0)
	 * @author 胡鑫
	 * @date 2017年10月20日00:22:22
	 * @param sptId 规格类型id
	 * @return 返回消息类
	 */
	@ResponseBody
	@RequestMapping("/back/delete")
	public EhyMessage delete(String sptId){
		EhyMessage mes = new EhyMessage();//定义一个消息类
		//得到查询到的行数
		int rows = service.deleteSelect(sptId);
		if(rows>0){
			mes.setMes("该规格类型不能删除!");
			mes.setState(0);
		}else{
			Map<String,Object>map = new HashMap<String,Object>();
			map.put("sptId", sptId);
			map.put("isva", CommomUtils.ISVA_NO);
			service.deleteByPrimaryKey(map);
			mes.setMes("删除成功");
			mes.setState(1);
		}
		return mes;
	}
}