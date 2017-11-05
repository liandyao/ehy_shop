/**
 * 
 */
package cn.ehuoyuan.shop.action.logs;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ehuoyuan.shop.action.logs.vo.EhyLogsVo;
import cn.ehuoyuan.shop.service.logs.LogsService;

/**
 * 类的描述：日志记录的Action
 * @author 罗海兵
 * @date 2017年10月1日
 * @version 1.1
 */
@Controller
@RequestMapping("logs")
public class LogsAction {
	
	@Resource
	private LogsService logsService;//日志的service接口
	
	/**
	 * @title 删除
	 * @description 根据ID删除一条记录
	 * @param logsId 日志ID
	 * @return 返回删除行数
	 * @author 罗海兵
	 * @dateTime 2017年10月23日 下午4:39:17
	 * @versions 1.0
	 */
	@RequestMapping("back/deleteByPrimaryKey")
	@ResponseBody
	public int deleteByPrimaryKey(String logsId){
		System.out.println("logsId :  "+logsId);
		int rows=logsService.deleteByPrimaryKey(logsId);//根据id删除对象
		return rows;//返回删除行数
	}
	
	/**
	 * 增加或者修改
	 * <p>只填充/修改某些列</p>
	 * @param record 封装查询条件的EhyLogsVo的对象
	 * @return 返回修改行数
	 * @author 罗海兵
	 * @date 2017年10月17日
	 * @version 1.1
	 */
	@RequestMapping("back/addOrUpdate")
	@ResponseBody
	public int addOrUpdate(EhyLogsVo record){
		String logsId=record.getLogsId();//取出日志id
		int rows=0;//定义一个初始化返回行数
		if(logsId==null || "".equals(logsId)){//如果id等于空
			rows=logsService.insertSelective(record);//增加
		}else{
			rows=logsService.updateByPrimaryKeySelective(record);//修改
		}
		return rows;//返回影响行数
	}
	
	/**
	 * @title 查询ID
	 * @description 根据id查询一条记录
	 * @param logsId
	 * @return 返回一个EhyLogsVo对象
	 * @author 罗海兵
	 * @dateTime 2017年10月23日 下午4:44:09
	 * @versions 1.0
	 */
	public EhyLogsVo findById(String logsId){
		EhyLogsVo vo=logsService.selectByPrimaryKey(logsId);//根据日志id查询EhyLogsVo对象
		return vo;//返回查询到的EhyLogsVo对象
	}
    
	/**
	 * 查询多条记录
	 * <p>根据某些列查询</p>
	 * @param record 封装查询条件的EhyLogsVo的对象
	 * @return 返回一个EhyLogsVo对象的集合
	 * @author 罗海兵
	 * @date 2017年10月17日
	 * @version 1.1
	 */
	@RequestMapping("back/select")
	@ResponseBody
	public List<EhyLogsVo> select(EhyLogsVo record){
		List<EhyLogsVo> listVo=logsService.select(record);//根据条件查询EhyLogsVo对象的集合
		return listVo;//返回查询到的EhyLogsVo对象集合
	}
    
	/**
	 * 查询所有记录
	 * <p>无条件查询</p>
	 * @return 返回一个EhyLogsVo对象的集合
	 * @author 罗海兵
	 * @date 2017年10月17日
	 * @version 1.1
	 */
	@RequestMapping("back/selectAll")
	@ResponseBody
	public List<EhyLogsVo> selectAll(){
		System.out.println("\n\n进入了LogsAction的selectAll方法");
		List<EhyLogsVo> listVo=logsService.selectAll();//无条件查询EhyLogsVo对象的集合
		System.out.println("查询到的集合长度是："+listVo.size());
		return listVo;//返回查询到的EhyLogsVo对象集合
	}
}
