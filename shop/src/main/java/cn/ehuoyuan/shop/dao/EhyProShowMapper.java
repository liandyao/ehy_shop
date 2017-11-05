package cn.ehuoyuan.shop.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import cn.ehuoyuan.shop.action.proshow.ProshowVo;

import cn.ehuoyuan.shop.domain.EhyProShow;

public interface EhyProShowMapper {
    int deleteByPrimaryKey(String showId);

    
    int insert(EhyProShow record);

    
    //增加
    int insertSelective(EhyProShow record);

    //查询所有
    List<EhyProShow> findAllshow(Map<String, Object> map);
    
  //总行数
  	int findRowCount(Map<String, Object> map);
  	
  	//根据ID查询
  	EhyProShow selectByPrimaryKey(String showId);
  	
  	//修改或删除
  	 int updateByPrimaryKeySelective(EhyProShow record);
  	
  	 //排序
  	int sortModule(@Param("startNum")Integer startNum, @Param("endNum")Integer endNum, @Param("showId")String showId);
  	
  	int updateByPrimaryKey(EhyProShow record);
  	
 
    

   

   
    
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
	  * @title 查询总行数
	  * @description  根据查询条件查询总行数
	  * @param proShow 封装了查询条件的商品展示列表的模型对象
	  * @return 返回总行数
	  * @author 罗海兵
	  * @dateTime 2017年10月19日 上午10:02:55
	  * @versions 1.0
	  */
	 public List<ProshowVo> showAll(String stId);
	 
	 /**
	  * @title 产品ID查询
	  * @description 根据产品ID查询产品基本信息、规格类型、规格值、规格价格、产品图片等信息  
	  * @param proId 产品ID
	  * @return 返回一个产品展示的视图层模型
	  * @author 罗海兵
	  * @dateTime 2017年10月20日 下午1:32:26
	  * @versions 1.0
	  */
	 public ProshowVo findById(String proId);
	 
}