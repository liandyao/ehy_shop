/**
 * 
 */
package cn.ehuoyuan.shop.service.base.news;


import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyNews;

/**
 * 公告service
 * @author dong
 * @da2017年10月12日
 * @version 1.0
 */
public interface NewsService {
	/**
	 * 增加方法
	 * @param record
	 * @return
	 */
	int insert(EhyNews record);
	
	/**
	 * 查询所有
	 * @param map
	 * @return
	 */
	List<EhyNews> findAll(Map<String, Object> map);
	
	/**
	 * 总行数
	 * @param map
	 * @return
	 */
	int findRowCount(Map<String, Object> map);
	
	/**
	 * 修改或删除方法
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(EhyNews record);
	
	/**
	 * 根据ID查询
	 * @param newsId
	 * @return
	 */
	 EhyNews selectByPrimaryKey(String newsId);
	 
	 /**
	  * 修改，取消置顶
	  * @param newsId
	  * @return
	  */
	 int updateByPrimaryKey(String newsId);
	 
	 /**
	  * 修改，置顶
	  * @param newsId
	  * @return
	  */
	  int update(String newsId);
	    
    /**
     * 根据站点查询是否该站点存在置顶 
     * @param station
     * @return
     */
	  String showstation(String station);
	  
	  /**
	   * 根据站点标识码查询公告
	   * @param station
	   * @return
	   */
	  List<EhyNews> shownews(String station);
	  
	  /**
	   * 根据站点标识码查询更多公告
	   * @param station
	   * @return
	   */
	  List<EhyNews> show(Map<String, Object> map);
	  
	  /**
	   * 更多公告总行数
	   * @param map
	   * @return
	   */
	  int showRowCount(String newsId);
}
