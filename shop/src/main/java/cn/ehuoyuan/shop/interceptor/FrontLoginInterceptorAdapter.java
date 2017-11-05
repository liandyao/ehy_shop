/**
 * 
 */
package cn.ehuoyuan.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhyMember;

/**
 * 类的描述：前台登陆拦截器
 * @author 罗海兵
 * @dateTime 2017年10月21日 上午9:17:41
 * @version 1.0
 */
public class FrontLoginInterceptorAdapter extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取请求的URL  
        String url = request.getRequestURI();  
        
        System.out.println("前台登陆拦截器,请求地址："+url+"\n\n\n");
        //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制  
        
        if(url.contains("login") || url.contains("logout")){  
            return true;  
        }  
        String intercept=request.getParameter("intercept");
        if("true".equalsIgnoreCase(intercept)){
        	return true;
        }
        HttpSession session=request.getSession();
        EhyMember login=(EhyMember) session.getAttribute("login");
    	if(login==null){
    		if(Tools.isAjaxRequest(request)){
    			System.out.println("未登陆,这是一个Ajax请求,返回0");
    			response.getWriter().write("0");
    		}else{
    			System.out.println("未登陆,这不是一个Ajax请求,重定向到登陆页面");
    			response.sendRedirect("pages/front/login.jsp");
    		}
    		return false;
		}
		return true;
	}
}
