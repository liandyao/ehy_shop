/**
 * 
 */
package cn.ehuoyuan.shop.service.proshow;


import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.action.proshow.ProshowVo;
import cn.ehuoyuan.shop.domain.EhyProShow;

/**
 * 产品展示service
 * @author dong
 * @da2017年10月18日
 * @version 1.0
 */
public interface ProshowService {
	
	
	/**
	 * 增加方法
	 * @param record
	 * @return
	 */
	 int insertSelective(EhyProShow record);
	 
	 /**
	  * 查询所有
	  * @param map
	  * @return
	  */
	 List<EhyProShow> findAllshow(Map<String, Object> map);

	 
 /**
	* 排序
	* @return
	*/
	int sortModule(int start, int end, String showId);
	 
	 /**
	  * 总行数
	  * @param map
	  * @return
	  */
	 int findRowCount(Map<String, Object> map);
	 
	 
	 /**
	  * 根据ID查询
	  * @param showId
	  * @return
	  */
	EhyProShow selectByPrimaryKey(String showId);
	
	/**
	 * 修改或删除方法
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(EhyProShow record);
	 /**
	  * @title 查询全部
	  * @description 查询全部的商品展示列表数据 
	  * @return 返回一个商品展示列表的模型的集合
	  * @author 罗海兵
	  * @dateTime 2017年10月19日 上午9:34:15
	  * @versions 1.0
	  */
	 public List<EhyProShow> findAll(EhyProShow proShow);
	 
	 /**
	  * @title 查询总行数
	  * @description  根据查询条件查询总行数
	  * @param proShow 封装了查询条件的商品展示列表的模型对象
	  * @return 返回总行数
	  * @author 罗海兵
	  * @dateTime 2017年10月19日 上午10:02:55
	  * @versions 1.0
	  */
	 public int findTotalRows(EhyProShow proShow);
	 
	 /**
	  * @title 查询全部
	  * @description 查询全部的商品展示列表数据 
	  * @return 返回一个商品展示列表的模型的集合
	  * @author 罗海兵
	  * @dateTime 2017年10月19日 上午9:34:15
	  * @versions 1.0
	  */
	 public List<ProshowVo> showAll(String stId);
	 
	 /**
	  * @title 产品ID查询
	  * @description 根据产品ID查询产品基本信息、规格类型、规格值、规格价格、产品图片等信息  
	  * @param proId 产品ID
	  * @return 返回一个产品展示的视图层模型
	  * @author 罗海兵
	  * @dateTime 2017年10月20日 下午1:27:47
	  * @versions 1.0
	  */
	 public ProshowVo findById(String proId);
	 
	 /**
     * @title 根据产品ID和图片类型查询产品图片
     * @param map 封装了产品ID和图片类型的Map对象
     * @return 返回一个图片地址的Map的List集合
     * @author 罗海兵
     * @dateTime 2017年10月26日 下午2:57:03
     * @versions 1.0
     */
    List<Map<String, Object>> findImgByProId(Map<String, Object> map);
    
    /**
     * 根据产品ID查询产品详情的规格参数 
     * @param proId 产品ID
     * @return 返回一个Map的List集合
     * @author 罗海兵
     * @dateTime 2017年10月27日 上午10:27:21
     * @versions 1.0
     */
    List<Map<String, Object>> findByProId(String proId);
}
