/**
 * 
 */
package cn.ehuoyuan.shop.action.proType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.common.TreeNode;
import cn.ehuoyuan.shop.domain.EhyProType;
import cn.ehuoyuan.shop.service.proType.ProTypeService;

/**
 * 产品类型action
 * @author HuXin
 * @date 2017年9月29日
 */
@Controller
@RequestMapping("ProductTypeAction")
public class ProTypeAction {
	@Resource
	private ProTypeService proTypeService ;//定义一个产品类型service
	
	/**
	 * 分页 模糊查询
	 * 显示产品类型集合
	 * @param id 模糊查询 参数
	 * @param page 分页参数 (page开始的行数)
	 * @param limit 最大显示的行数
	 * @return 返回Map集合
	 */
	@ResponseBody
	@RequestMapping("/back/findProductTypeList")
	public Map<String,Object>findProductTypeList(String id,String page,String limit){
		Map<String,Object> map = new HashMap<String, Object>();//创建一个map集合
		Pages pages = new Pages();//设置分页对象
		pages.setCurPage(Integer.valueOf(page));//开始的页数
		pages.setMaxResult(Integer.valueOf(limit));//最大显示的行数
		Map<String,Object>map2 = new HashMap<String,Object>();
		map2.put("pages",pages);
		if(Tools.isEmpty(id)){//判断值是否为空
			map2.put("like", "");//空 则赋值为空
		}else{
			map2.put("like", "%"+id+"%");//不为空则赋值
		}
		List<EhyProType>proTypeList = proTypeService.selectAllProType(map2);
		List<EhyProType>proTypeList2 = new ArrayList<EhyProType>();//创建一个list集合
		for (Iterator iterator = proTypeList.iterator(); iterator.hasNext();) {
			EhyProType ehyProType = (EhyProType) iterator.next();
			EhyProType proType = proTypeService.selectByPtId(ehyProType.getPtId());//得到上级信息
			String station = proTypeService.selectEhyStationList(ehyProType.getProTypeRemark());
			if(Tools.isEmpty(ehyProType.getPtId())|| ehyProType.getPtId().equals("0")){//判断该值是否为空 或者是否为0
				ehyProType.setPtId("产品");
			}else{
				ehyProType.setPtId(proType.getProTypeName());//将上级名称赋值
			}
			if(Tools.isEmpty(station)){
				ehyProType.setProTypeRemark("该类型暂无无站点");
			}else{
				ehyProType.setProTypeRemark(station);//将站点名称赋值
			}
			proTypeList2.add(ehyProType);
		}
		
		int count = proTypeService.selectCountProType();//得到总行数
		map.put("code","0");
		map.put("msg","");
		map.put("count", count);
		map.put("data", proTypeList2);
		
		
		
		return map;//返回map
	}
	
	/**
     * 产品分类的树形菜单
     * @author 欧阳丰
	 * @date 2017年10月1日 17:54:26
	 * @version 1.1
     */
	@ResponseBody
	@RequestMapping("/back/proTypeTree")
	public List<TreeNode> proTypeTree(){
		TreeNode node = new TreeNode();
		node.setId("0");
		node.setName("产品");
		proTypeService.getTreeNode(node);
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(node);
		
		
		
		return list;
	}
	
	/**
	 * 产品类型的增加和修改
	 * @author 胡鑫
	 * @date 2017年10月12日22:16:51
	 * @param proType 产品类型
	 * @param bandId 上级id
	 * @param sptId 规格id
	 * @param proTypeRemarks 站点id
	 * @return 返回消息对象
	 */
	@ResponseBody
	@RequestMapping("/back/addOrUpdate")
	public EhyMessage addOrUpdate(EhyProType proType,String typeId,String[]sptId,String[]proTypeRemarks){
		EhyMessage mes = new EhyMessage(); //创建消息类
		int rows =0;//定义一个int型用来判断
		proType.setPtId(typeId);//将子类型设置父类id
		
		if(Tools.isEmpty(proType.getProTypeId())){//判断类型id是否为空 
			rows = proTypeService.insertSelective(proType,sptId,proTypeRemarks);
			
		}else{
			rows = proTypeService.updateByPrimaryKeySelective(proType,sptId,proTypeRemarks);
		}
		if(rows==-1){
			mes.setMes("该站点已有类别!");
			mes.setState(0);
		}else if(rows>0){
			mes.setMes("提交成功!");
			mes.setState(1);
		}else{
			mes.setMes("数据异常!");
			mes.setState(0);
		}
		return mes;
	}
	/**
	 * 显示修改信息
	 * @author 胡鑫
	 * @date 2017年10月13日16:17:24
	 * @param proTypeId 产品类型id
	 * @return 返回Map集合
	 */
	@ResponseBody
	@RequestMapping("/back/showUpdate")
	public Map<String,Object> showUpdate(String proTypeId){
		
		Map<String,Object> map = new HashMap<String, Object>();//创建一个map集合
		//根据类型id得到类型详细信息
		EhyProType proType= proTypeService.selectByPrimaryKey(proTypeId);
		map.put("proType", proType);//map设值
		return map;
	}
	
	/**
	 * 
	 * -----此功能暂无完成!--
	 * 
	 * 判断该类型有无子节点
	 * @param bandId 类型id
	 * @return 返回消息类
	 */
	@ResponseBody
	@RequestMapping("/back/isSubClassExist")
	public EhyMessage isSubClassExist(String bandId){
		EhyMessage mes = new EhyMessage(); //创建消息类
		
		
		if(proTypeService.isSubClassExist(bandId)>0){
			mes.setState(1);
		}else{
			mes.setState(0);
		}
		
		return mes;
	}
	
	/**
	 * 得到类型集合的id和名字赋值下拉框
	 * @author 胡鑫
	 * @date 2017年10月16日09:07:34
	 * @return 返回产品类型集合
	 */
	@ResponseBody
	@RequestMapping("/back/selectIdOrName")
	public List<EhyProType> selectIdOrName(){
		return proTypeService.selectIdOrName();
	}
	
	
	/**
	 * 根据类型id进行类型删除
	 * @author 胡鑫
	 * @date 2017年10月16日16:49:55
	 * @param typeId 类型id
	 * @return 返回消息对象
	 */
	@ResponseBody
	@RequestMapping("/back/byTypeIdDelete")
	public EhyMessage byTypeIdDelete (String typeId){
		EhyMessage mes = new EhyMessage();//定义一个消息类
		Map<String,Object>map = new HashMap<String,Object>();
		map.put("typeId", typeId);//类型id
		if(typeId.equals("0")){
			mes.setMes("该类型不能删除!");
			mes.setState(0);
			return mes;
		}
		//执行删除(修改)
		int rows = proTypeService.deleteByKey(map);
		if(rows>0){
			mes.setMes("删除成功!");
			mes.setState(1);
		}else{
			mes.setMes("该类型不能删除!");
			mes.setState(0);
		}
		return mes;
	}
	
	/**
     * @title 查询首页需要显示的产品类型
     * @description 根据站点ID查询该站点的产品类型  
     * @param stId 站点ID
     * @return 返回一个Map的List集合
     * @author 罗海兵
     * @dateTime 2017年10月24日 下午4:55:41
     * @versions 1.0
     */
	@RequestMapping("front/findIndexShow")
	@ResponseBody
    public Map<String, Object> findIndexShow(String stId){
    	List<Map<String, Object>> superiorList=proTypeService.findByStId(stId);
    	if(superiorList.size()==0){
    		return null;
    	}
		Map<String, Object> map=superiorList.get(0);
		String typeId=(String) map.get("typeId");
		List<Map<String, Object>> subordinate=proTypeService.findSubordinate(typeId);
		map.put("list", subordinate);
    	return map;
    }
}
