/**
 * 
 */
package cn.ehuoyuan.shop.action.base.news;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;

import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhyArea;
import cn.ehuoyuan.shop.domain.EhyManager;
import cn.ehuoyuan.shop.domain.EhyNews;
import cn.ehuoyuan.shop.domain.EhyStation;
import cn.ehuoyuan.shop.service.base.news.NewsService;
import cn.ehuoyuan.shop.service.station.StationService;

/**
 * 公告action
 * @author dong
 * @da2017年10月11日
 * @version 1.0
 */
@Controller
@RequestMapping("news")
public class EhyNewsAction {
		
	//站点
	@Resource
	private StationService stationService;
	
	@Resource
	private NewsService newsService;
	
	/**
	 * 站点查询
	 * @param session
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("/back/showListAjax")
	@ResponseBody  //ajax的注解
	public List<EhyStation> showListAjax(){
		
		List<EhyStation> list = stationService.findStation();//查询所有站点
		return list;
	}
	
	/**
	 * 发布公告
	 * @param news
	 * @return
	 */
	@RequestMapping("/back/add")
	@ResponseBody
	public EhyMessage add(EhyNews news,HttpSession session){
		EhyMessage mes = new EhyMessage();//消息类
	
		String str=news.getStation();//定义站点标识码
		
		if(str.length()==0 || Tools.isEmpty(news.getNewsContent())){//判断站点标识码或者文本内容是否问空
			mes.setState(EhyMessage.ERROR);
			mes.setMes("请认真输入");
		}else{
			String[] sourceStrArray = news.getStation().split("_");//把站点用_分割
			for (int i = 0; i < sourceStrArray.length; i++) {//循环站点
			    news.setNewsTitle(news.getNewsTitle());//公告标题
			    news.setNewsContent(news.getNewsContent());//公告正文
			    news.setNewsType(news.getNewsType());//公告类型
			    news.setStation(sourceStrArray[i]);//站点
			    news.setIsva(1);//是否有效 
			    EhyManager man = (EhyManager) session.getAttribute("manager");//取session中的用户名
			    news.setOper(man.getManUser());//操作人
			    
			    news.setSort(999);//排序
			    newsService.insert(news);//增加方法
			    mes.setState(EhyMessage.SUCCESS);
				mes.setMes("发布成功");
			}
		}
		return mes;
	}
	
	/**
	 * 显示所有
	 * @param page
	 * @param limit
	 * @param news
	 * @return
	 */
	@RequestMapping("/back/showList")
	@ResponseBody  //ajax注解
	public Map<String,Object> showList(int page ,int limit,EhyNews news,String stName){
		Map<String,Object> map = new HashMap<String, Object>();//定义map集合
		Map<String,Object> pagmap = new HashMap<String, Object>();//定义map集合
		Pages ps=new Pages();
		ps.setCurPage(page);//复职当前页数
		ps.setMaxResult(limit);//复职当前行数
		pagmap.put("page", ps.getFirstRows());//复职到map
		pagmap.put("limit", ps.getMaxResult());//复职到map
		pagmap.put("stName", stName);//查询站点
		pagmap.put("newsTitle", news.getNewsTitle());//查询公告标题
		pagmap.put("newsType", news.getNewsType());//查询公告类型
		List<EhyNews> list =newsService.findAll(pagmap);
		
		//layui数据表格需要返回的参数
		map.put("count", newsService.findRowCount(pagmap));
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
	public EhyMessage delete(EhyNews news){
		news.setIsva(0);
		int rows = newsService.updateByPrimaryKeySelective(news);
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
	 * 根据ID查询
	 * @param express
	 * @return
	 */
	@RequestMapping("/back/findById")
	@ResponseBody
	public EhyNews findById(EhyNews news){
		EhyNews e=newsService.selectByPrimaryKey(news.getNewsId());
		return e;
		
	}
	
	/**
	 * 修改
	 * @param express
	 * @return
	 */
	@RequestMapping("/back/Update")
	@ResponseBody
	public EhyMessage Update(EhyNews news,HttpSession session){
		EhyManager man = (EhyManager) session.getAttribute("manager");//取session中的用户名
		
		news.setNewsId(news.getNewsId());//公告ID
		news.setNewsTitle(news.getNewsTitle());//公告标题
		news.setNewsType(news.getNewsType());//公告类型
		news.setStation(news.getStation());//站点标识码
		news.setNewsContent(news.getNewsContent());//公告正文
		news.setOper(man.getManUser());//操作人
		
		int rows = newsService.updateByPrimaryKeySelective(news);//修改方法
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
	 * 修改，取消置顶
	 * @param express
	 * @return
	 */
	@RequestMapping("/back/Updateid")
	@ResponseBody
	public EhyMessage Updateid(EhyNews news){
		int rows = newsService.updateByPrimaryKey(news.getNewsId());//取消置顶方法
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
	 * 修改，置顶
	 * @param express
	 * @return
	 */
	@RequestMapping("/back/UpdateStick")
	@ResponseBody
	public EhyMessage UpdateStick(EhyNews news){
		EhyMessage message = new EhyMessage();
		String zd = newsService.showstation(news.getStation());//查询站点是否存在有置顶的公告
		
		if(zd!=null && !"".equals(zd)){
			message.setState(EhyMessage.ERROR);
		}else{
			newsService.update(news.getNewsId());//置顶方法
			message.setState(EhyMessage.SUCCESS);
		}
		
		return message;
	}
	
	/**
	 * 根据站点标识码查询公告
	 * @param express
	 * @return
	 */
	@RequestMapping("/back/shownews")
	@ResponseBody
	public List<EhyNews> showmews(EhyNews news){
		List<EhyNews> e=newsService.shownews(news.getStation());
		return e;
		
	}
	
	/**
	 * 根据站点标识码查询更多公告
	 * @param express
	 * @return
	 */
	@RequestMapping("/back/show")
	@ResponseBody
	public Map<String,Object> show(EhyNews news,String curPage){
		Pages pages=new Pages();//分页
		Map<String,Object> map=new HashMap<>();//定义map传值到dao
		
		Map<String,Object> map1=new HashMap<>();//定义map传值到dao
		
		System.out.println(curPage+"=----===-=-=-=-=-=-=-=-=-");
		
		int totalrows=newsService.showRowCount(news.getStation());//根据查询站点标识码更多公告总行数
		
		pages.setTotalRows(totalrows);//总行数
		pages.setMaxResult(5);//复职当前行数
		if(curPage==null){
			pages.setCurPage(1);//复职当前页数
		}else{
			pages.setCurPage(Integer.valueOf(curPage));//复职当前页数
		}
		
		
		map.put("station", news.getStation());//站点标识码
		map.put("page", pages.getFirstRows());//复职到map
		map.put("limit", pages.getMaxResult());//复职到map
		
		
		List<EhyNews> e=newsService.show(map);//根据站点标识码查询更多公告
		
		map1.put("list", e);//内容
		map1.put("pages", pages);//分页
		
		
		return map1;
		
	}
}
