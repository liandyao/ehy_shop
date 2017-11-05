/**
 * 
 */
package cn.ehuoyuan.shop.interceptor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.action.logs.vo.EhyLogsVo;
import cn.ehuoyuan.shop.domain.EhyDatadic;
import cn.ehuoyuan.shop.domain.EhyManager;
import cn.ehuoyuan.shop.domain.EhyMember;
import cn.ehuoyuan.shop.service.base.datadic.DatadicService;
import cn.ehuoyuan.shop.service.logs.LogsService;
/**
 * 类的描述：日志记录拦截器
 * @author 罗海兵
 * @date 2017年10月1日
 * @version 1.1
 */
public class EhyLogsInterceptor extends HandlerInterceptorAdapter{
	private static Map<String, String> moduleMap=new HashMap<String, String>();//模块集合
	private static Map<String, String> methodMap=new HashMap<String, String>();//方法集合
	
	@Resource
	private LogsService logsService;//日志记录的Service
	
	@Resource
	private DatadicService datadicService;//数据字典的Service
	
	/**
	 * 
	 * @title 
	 * @description   
	 * @author 罗海兵
	 * @dateTime 2017年10月23日 下午6:18:32
	 * @versions 1.0
	 */
	private void init() {
		if(moduleMap.isEmpty()){
			List<EhyDatadic> moduleList=datadicService.findByDicName("module");
			for(int i=0;i<moduleList.size();i++){
				EhyDatadic datadic=moduleList.get(i);
				moduleMap.put(datadic.getDicCode(), datadic.getDicRemark());
			}
		}
		if(methodMap.isEmpty()){
			List<EhyDatadic> methodList=datadicService.findByDicName("method");
			for(int i=0;i<methodList.size();i++){
				EhyDatadic datadic=methodList.get(i);
				methodMap.put(datadic.getDicCode(), datadic.getDicRemark());
			}
		}
		
	}
	
	/**
	 * 返回视图之前执行的方法
	 * @param request 请求对象
	 * @param response 响应对象
	 * @param handler action处理对象
	 * @param ex 异常监控对象
	 * @author 罗海兵
	 * @date 2017年10月17日
	 * @version 1.1
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		init();
		String uri=request.getRequestURI();
		System.out.println("日志拦截器,请求的URI地址是: "+uri);
		EhyLogsVo record=getLogsVo(request);
		int rows=logsService.insert(record);
		if(rows>0){
			System.out.println("日志记录成功\n\n\n\n");
			System.out.println(record.getLogsRemark());
		}else{
			System.out.println("日志记录失败\n\n\n\n");
		}
		
		super.afterCompletion(request, response, handler, ex);
	}
	
	/**
	 * 生产日志对象的方法
	 * @param request 请求对象
	 * @return 传入一个request请求对象，返回一个EhyLogsVo日志对象
	 * @author 罗海兵
	 * @date 2017年10月17日
	 * @version 1.1
	 */
	private EhyLogsVo getLogsVo(HttpServletRequest request){
		String logsOper,logsModule = "",logsCode,logsRemark,type;
		Date logsDatetime=new Date();
		HttpSession session=request.getSession();
		
		
		
		String url = request.getRequestURI();
		String[] strArr=url.substring(1).split("/");
		logsCode=url;
		logsModule=moduleMap.get(strArr[1]);
		if("front".equals(strArr[2])){
			type="前台";
			EhyMember mem=(EhyMember) session.getAttribute("man");
			if(mem!=null){
				logsOper=mem.getMbName();
			}else{
				logsOper=(String) request.getAttribute("mbLogin");
			}
		}else{
			type="后台";
			EhyManager man=(EhyManager) session.getAttribute("man");
			if(man!=null){
				logsOper=man.getManUser();
			}else{
				logsOper=(String) request.getAttribute("manUser");
			}
		}
		System.out.println("\n\n模块是："+type+"   "+logsModule);
		String action="";
		Set<String> setKey=methodMap.keySet();
		for(String key:setKey){
			if(url.contains(key)){
				action=type+methodMap.get(key);
				System.out.println("本次请求的操作是："+action);
				break;
			}
		}
		String ip =Tools.getIpAddr(request);  
		logsRemark=logsModule+" : "+action+",   操作人 :  "+logsOper+",  ip地址 :  "+ip+",  操作时间"+Tools.getDateStr(logsDatetime);
		EhyLogsVo record=new EhyLogsVo(logsModule, logsRemark, logsDatetime, logsOper, logsCode);
		return record;
	}
	
}
