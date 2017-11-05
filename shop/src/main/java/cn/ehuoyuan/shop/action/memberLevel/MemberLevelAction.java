/**
 * 
 */
package cn.ehuoyuan.shop.action.memberLevel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhyDatadic;
import cn.ehuoyuan.shop.domain.EhyMemberLevel;
import cn.ehuoyuan.shop.service.base.datadic.DatadicService;
import cn.ehuoyuan.shop.service.memberLevel.MemberLevelService;

/**
 * 会员等级的控制层
 * @author Weimianwu
 * @date 2017年10月9日 下午4:06:17
 * @version 1.0
 */
@Controller
@RequestMapping("memberLevel")
public class MemberLevelAction {
	/**
	 * 注入会员等级的Service
	 */
	@Resource
	private MemberLevelService memberLevelService ;
	/**
	 * 注入字典的Service
	 */
	@Resource
	private DatadicService datadicService;
	/**
	 * new一个消息类
	 */
	EhyMessage mes = new EhyMessage();
	/**
	 * 查询所有
	 * @author Weimianwu
	 * @param page 开始的页数
	 * @param limit 结束的页数
	 * @param memberLevel 查询的参数
	 * @param dicRemark 字典表的字段
	 * @return map 返回值
	 */
	@RequestMapping("/back/findAll")
	@ResponseBody  
	public Map<String,Object> findAll(int page,int limit,EhyMemberLevel memberLevel,String dicRemark){
		//适应Layui的模式 而 new 的map
		Map<String,Object> map = new HashMap<String, Object>();
		/*Tools.isEmpty(memberLevel.getLevelName());*/
		//使用工具类判断是否为空
		if(Tools.isEmpty(memberLevel.getLevelName())==true)memberLevel.setLevelName(null);
		if(Tools.isEmpty(dicRemark)==true)dicRemark=null;
		//new一个分页的工具类
		Pages pages=new Pages();
		//页面的当前页数
		pages.setCurPage(page);
		//页面的显示多少行
		pages.setMaxResult(limit);
		//方便传入dao的参数new 一个 map
		Map<String,Object> mapParam = new HashMap<String, Object>();
		//传入参数
		mapParam.put("firstRows", pages.getFirstRows());
		mapParam.put("maxResult", pages.getMaxResult());
		mapParam.put("levelName", memberLevel.getLevelName());
		mapParam.put("scale", memberLevel.getScale());
		mapParam.put("dicRemark", dicRemark);
		//模糊查询
		List<Map> list  = memberLevelService.findAll(mapParam);
		//得到总行数
		int totalRows = memberLevelService.getTatolRows(mapParam);

		//为了适应Layui而这样取参数并且 传入前台
		map.put("count", totalRows);
		map.put("data", list);
		map.put("code",0);
		map.put("msg", "");
		//返回值
		return map;

	}
	/**
	 * 增加会员等级
	 * @author Weimianwu
	 * @param memberLevel 参数
	 * @param dicRemark 字典参数
	 * @param dicId 字典id
	 * @return mes
	 */
	@RequestMapping("/back/addOrUpdate")
	@ResponseBody  
	public EhyMessage addOrUpdate(EhyMemberLevel memberLevel ,String dicRemark,String dicId){
		//设定字典表为空
		EhyDatadic ehyDatadic =null;
		//使用工具类判断是否为空
		if(Tools.isEmpty(memberLevel.getLevelId())==true){
			memberLevel.setLevelId(null);
		}
		//如果id是空的 就是增加
		if(memberLevel.getLevelId()==null){
			int maxSort = memberLevelService.maxSort();
			memberLevel.setSort(maxSort+1);
			//调用增加的方法
			int rows= memberLevelService.insertSelective(memberLevel);
			//当增加了等级表返回的值大于0时
			if(rows>0){
				//new一个字典对象
				ehyDatadic = new EhyDatadic();
				//会员等级id
				ehyDatadic.setDicName("isShare");
				//赋值一个是否能加入货架
				ehyDatadic.setDicCode(memberLevel.getLevelId());
				//给字典备注赋值一个值
				ehyDatadic.setDicRemark(dicRemark);
				//调用增加的方法
			 	int count = datadicService.insertSelective(ehyDatadic);
			 	//当增加字典表大于0时
			 	if(count>0){
			 		//返回去页面的消息类赋值
			 		mes.setMes(EhyMessage.SUCCESS_MES);
					mes.setState(EhyMessage.SUCCESS);
			 	}else{
			 		//返回去页面的消息类赋值
			 		mes.setMes(EhyMessage.ERROR_MES);
					mes.setState(EhyMessage.ERROR);
			 	}
				
			}else{
				//返回去页面的消息类赋值
				mes.setMes(EhyMessage.ERROR_MES);
				mes.setState(EhyMessage.ERROR);
			}
			
		}else{
			//修改会员等级
			int rows= memberLevelService.updateByPrimaryKeySelective(memberLevel);
			//当修改返回的值大于0是
			if(rows>0){
				//new一个字典对象
				ehyDatadic = new EhyDatadic();
				//取到字典id
				ehyDatadic.setDicId(dicId);
				//字典备注的值
				ehyDatadic.setDicRemark(dicRemark);
				//修改字典表
			 	int count = datadicService.updateByPrimaryKeySelective(ehyDatadic);
			 	//当返回的值大于0 时
			 	if(count>0){
			 		//返回去页面的消息类赋值
			 		mes.setMes(EhyMessage.SUCCESS_MES);
					mes.setState(EhyMessage.SUCCESS);
			 	}else{
			 		//返回去页面的消息类赋值
			 		mes.setMes(EhyMessage.ERROR_MES);
					mes.setState(EhyMessage.ERROR);
			 	}
			}else{
				//返回去页面的消息类赋值
				mes.setMes(EhyMessage.ERROR_MES);
				mes.setState(EhyMessage.ERROR);
			}
		}
		return mes;
	}

	/**
	 * 根据 id查询 
	 * @param levelId 等级id参数
	 * @param dicId 字典id
	 * @return map
	 */
	@RequestMapping("/back/findById")
	@ResponseBody  
	public Map<String ,Object> findById(String levelId,String dicId){
		//传入已个Map查询字典表和会员等级表
		Map<String ,Object> map= memberLevelService.selectByPrimaryKey(levelId);
		//给予一个判断
		if(map!=null){
			return map;
			
		}else{
			return null;
		}

	}
	
	
	/**
	 * 根据id删除
	 * @param levelId 会员等级 id
	 * @return
	 */
	@RequestMapping("/back/deleteRec")
	@ResponseBody  
	public EhyMessage deleteRec(String levelId){
		//删除会员等级
		int rows= memberLevelService.deleteByPrimaryKey(levelId);
		//当返回的值 大于零时
		if(rows>0){
			int count =datadicService.deleteLevelId(levelId);
			if(count>0){
				//返回去页面的消息类赋值
				mes.setMes(EhyMessage.SUCCESS_MES);
				mes.setState(EhyMessage.SUCCESS);	
			}else{
				//返回去页面的消息类赋值
				mes.setMes(EhyMessage.ERROR_MES);
				mes.setState(EhyMessage.ERROR);
			}
			
		}else{
			//返回去页面的消息类赋值
			mes.setMes(EhyMessage.ERROR_MES);
			mes.setState(EhyMessage.ERROR);
		}
		//返回值
		return mes;

	}
	
	/**
	 * 下拉框查询会员等级
	 * @return list
	 */
	@RequestMapping("/back/selectEhyMemberLevel")
	@ResponseBody  
	public List<EhyMemberLevel> selectEhyMemberLevel(){
		//下拉框查询
		List<EhyMemberLevel> list = memberLevelService.ehyMemberLevelFindAll();
		//返回的值
		return list;
		
		
		

	}
	/**
	 * 排序
	 * @param start
	 * @param end
	 * @param levelId
	 * @return
	 */
	@RequestMapping("back/sortMemberLevel")
	@ResponseBody 
	public EhyMessage sortMemberLevel(int start, int end, String levelId){
		//修改数据库的排序字段
		int rows = memberLevelService.sortMemberLevel(start, end, levelId);
		//当返回的值大于0时
		if(rows>0){
			//返回去页面的消息类赋值
			mes.setState(EhyMessage.SUCCESS);
			mes.setMes(EhyMessage.SUCCESS_MES);
		}else{
			//返回去页面的消息类赋值
			mes.setState(EhyMessage.ERROR);
			mes.setMes(EhyMessage.ERROR_MES);
		}
		//返回的值
		return mes;
		
	}
	/**
	 * 查询会员等级是否存在
	 * @return
	 */
	@RequestMapping("back/islevelName")
	@ResponseBody 
	public EhyMessage islevelName(String levelName){
		//增加会员等级查询 名字是否存在
		int rows = memberLevelService.isLevelName(levelName);
		//当返回的值大于0
		if(rows>0){
			//返回去页面的消息类赋值
			mes.setState(EhyMessage.SUCCESS);
		}else{
			//返回去页面的消息类赋值
			mes.setState(EhyMessage.ERROR);
		}
		//返回的值
		return mes;
		
	}
	
}
