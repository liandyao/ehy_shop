package cn.ehuoyuan.shop.dao;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyExpress;

public interface EhyExpressMapper {
    int deleteByPrimaryKey(String expreessId);

    //增加
    int insert(EhyExpress record);

    int insertSelective(EhyExpress record);
    //根据ID查询
    EhyExpress selectByPrimaryKey(String expreessId);
    //删除方法
    int updateByPrimaryKeySelective(EhyExpress record);
    //修改方法
    int update(EhyExpress record);

    //查询所有
   	List<EhyExpress> findAll(Map<String, Object> map);
    
   	//总行数
  	int findRowCount(Map<String, Object> map);
  	
    int updateByPrimaryKey(EhyExpress record);
   
    /**
     * 查询所有的快递
     * @author 邓丽杰
     * @date 2017年10月18日13:58:10
	 * @version 1.1
     */
	List<EhyExpress> findExpress();
    
}