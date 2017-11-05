/**
 * 
 */
package cn.ehuoyuan.shop.action.proshow;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhyManager;
import cn.ehuoyuan.shop.domain.EhyProShow;
import cn.ehuoyuan.shop.service.product.ProductService;
import cn.ehuoyuan.shop.service.proshow.ProshowService;
import cn.ehuoyuan.shop.service.specificationType.SpecificationTypeService;

/**
 * 产品展示action
 * @author dong
 * @da2017年10月18日
 * @version 1.0
 */
@Controller
@RequestMapping("proshow")
public class ProshowAction {
	
	@Resource	
	private ProshowService proshowService;//产品展示service
	
	@Resource
	private ProductService productService;//产品service
	
	@Resource
	private SpecificationTypeService specificationTypeService;//规格类型service
	
	/**
	 * 排序
	 * @param start
	 * @param end
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/back/sortModule")
	@ResponseBody
	public EhyMessage sortModule(int start, int end, String showId) {
		EhyMessage mes = new EhyMessage();//消息类
		int rows = proshowService.sortModule(start, end, showId);//排序方法
		if(rows>0){
			mes.setState(EhyMessage.SUCCESS);
			mes.setMes(EhyMessage.SUCCESS_MES);
		}else{
			mes.setState(EhyMessage.ERROR);
			mes.setMes(EhyMessage.ERROR_MES);
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
	public EhyProShow findById(EhyProShow show){
		EhyProShow e=proshowService.selectByPrimaryKey(show.getShowId());
		return e;
		
	}
	
	/**
	 * 删除方法
	 * @param express
	 * @return
	 */
	@RequestMapping("/back/delete")
	@ResponseBody
	public EhyMessage delete(EhyProShow show){
		show.setIsva(0);//复职0
		int rows = proshowService.updateByPrimaryKeySelective(show);//删除方法
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
	 * 查询所有方法
	 * @param page
	 * @param limit
	 * @param area
	 * @return
	 */
	@RequestMapping("/back/showList")
	@ResponseBody  //ajax注解
	public Map<String,Object> showList(int page ,int limit,EhyProShow show,String stName,String proName){
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> pagmap = new HashMap<String, Object>();
		Pages ps=new Pages();//分页工具类
		ps.setCurPage(page);
		ps.setMaxResult(limit);
		pagmap.put("page", ps.getFirstRows());
		pagmap.put("limit", ps.getMaxResult());
		pagmap.put("showType", show.getShowType());//展示类型
		pagmap.put("showIsva", show.getShowIsva());//是否展示
		pagmap.put("stName", stName);//站点
		pagmap.put("proName", proName);//商品名称
		List<EhyProShow> list =proshowService.findAllshow(pagmap);//查询所有
		
		//layui数据表格需要返回的参数
		map.put("count", proshowService.findRowCount(pagmap));
		map.put("data", list);
		map.put("code",0);
		map.put("msg", "");
		return map;
	}
	
	
	/**
	 * 增加和修改
	 * @param express
	 * @return
	 */
	@RequestMapping("/back/addOrUpdate")
	@ResponseBody
	public EhyMessage addOrUpdate(EhyProShow proshow,HttpSession session){
		EhyMessage mes = new EhyMessage();//消息类
		
		EhyManager man = (EhyManager) session.getAttribute("manager");//取session中的用户名
		
		proshow.setOper(man.getManUser());//操作人
		proshow.setShowId(proshow.getShowId());//展示ID
		proshow.setProId(proshow.getProId());//产品ID
		proshow.setStId(proshow.getStId());//站点ID
		proshow.setShowType(proshow.getShowType());//展示类型
		proshow.setShowIsva(proshow.getShowIsva());//是否展示 
		if(Tools.isEmpty(proshow.getShowStartTime())){//如果不选开始时间就取当前时间
			proshow.setShowStartTime(Tools.getCurDateTime());//开始时间取当前时间
		}else{
			proshow.setShowStartTime(proshow.getShowStartTime());
		}
		
		proshow.setShowEndTime(proshow.getShowEndTime());//结束时间
		proshow.setIsva(1);//默认有效
		
		
		
		if(Tools.isEmpty(proshow.getShowId())){
			int rows=proshowService.insertSelective(proshow);//增加方法
			
			if(rows>0){
				mes.setMes(EhyMessage.SUCCESS_MES);
				mes.setState(EhyMessage.SUCCESS);
			}else{
				mes.setMes(EhyMessage.ERROR_MES);
				mes.setState(EhyMessage.ERROR);
			}
		}else{
			int rows=proshowService.updateByPrimaryKeySelective(proshow);//修改方法
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
	 * @title 查询全部
	 * @description 默认查询全部商品展示列表的模型，可分页，可附件条件查询
	 * @param pages 分页工具类对象
	 * @param proShow 封装了查询条件的商品展示列表的模型
	 * @return 返回一个封装好的Map对象
	 * @author 罗海兵
	 * @dateTime 2017年10月19日 上午10:05:33
	 * @versions 1.0
	 */
	@RequestMapping("/front/findAll")
	@ResponseBody
	public Map<String, Object> findAll(Pages pages, EhyProShow proShow){
		Map<String, Object> map=new HashMap<String, Object>();
		List<ProshowVo> proShowList=proshowService.showAll(proShow.getStId());
		map.put("proShowList", proShowList);
		
		return map;
	}
	
	/**
	 * 
	 * @title 根据站点ID查询产品的规格参数
	 * @description 传入一个站点ID,返回一个Map的List集合
	 * @param stId 站点ID
	 * @return 返回一个Map的List集合
	 * @author 罗海兵
	 * @dateTime 2017年10月25日 下午7:12:51
	 * @versions 1.0
	 */
	@RequestMapping("/front/findSpecification")
	@ResponseBody
	public List<Map<String, Object>> findSpecification(String stId){
		List<Map<String, Object>> specificationList=specificationTypeService.findByStId(stId);
		return specificationList;
	}
	
	/**
	 * @title 根据产品ID查询宝贝详情
	 * @description 查询产品图片、产品基本信息、规格类型、规格值、规格价格
	 * @param proId 产品ID
	 * @return 返回一个Map对象
	 * @author 罗海兵
	 * @dateTime 2017年10月26日 上午9:05:23
	 * @versions 1.0
	 */
	@RequestMapping("front/findById")
	@ResponseBody
	public Map<String, Object> findById(String proId){
		ProshowVo proVo=proshowService.findById(proId);
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("proVo", proVo);
		return map;
	}
	
	/**
     * 根据产品ID和图片类型查询产品图片
     * @param map 封装了产品ID和图片类型的Map对象
     * @return 返回一个图片地址的Map的List集合
     * @author 罗海兵
     * @dateTime 2017年10月26日 下午2:57:03
     * @versions 1.0
     */
	@RequestMapping("front/findImgByProId")
	@ResponseBody
    public List<Map<String, Object>> findImgByProId(String proId, int imgType){
		Map<String, Object> map=new HashMap<String, Object>();
    	map.put("proId", proId);
    	map.put("imgType", imgType);
    	List<Map<String, Object>> imgList=proshowService.findImgByProId(map);
    	return imgList;
    }
	
	 /**
     * 根据产品ID查询产品详情的规格参数 
     * @param proId 产品ID
     * @return 返回一个Map的List集合
     * @author 罗海兵
     * @dateTime 2017年10月27日 上午10:27:21
     * @versions 1.0
     */
	@RequestMapping("front/findByProId")
	@ResponseBody
	public List<Map<String, Object>> findByProId(String proId){
    	return proshowService.findByProId(proId);
    }
}
