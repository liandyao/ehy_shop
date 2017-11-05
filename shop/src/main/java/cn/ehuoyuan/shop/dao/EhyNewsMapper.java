package cn.ehuoyuan.shop.dao;


import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyNews;

public interface EhyNewsMapper {
    int deleteByPrimaryKey(String newsId);
    
    //增加
    int insert(EhyNews record);

    //查询所有
    List<EhyNews> findAll(Map<String, Object> map);
    
    //总行数
    int findRowCount(Map<String, Object> map);
    
    //删除或修改方法
    int updateByPrimaryKeySelective(EhyNews record);
    
    //根据ID查询
    EhyNews selectByPrimaryKey(String newsId);
    
    //修改，取消置顶
    int updateByPrimaryKey(String newsId);
    
    //修改，置顶
    int update(String newsId);
    
    //根据站点查询是否该站点存在置顶 
    String showstation(String station);
    
    //根据站点标识码查询公告
    List<EhyNews> shownews(String station);
    
    //根据站点标识码查询更多公告
    List<EhyNews> show(Map<String, Object> map);
    
    //更多公告总行数
    int showRowCount(String newsId);
    
    
    int insertSelective(EhyNews record);

   

  

    
}