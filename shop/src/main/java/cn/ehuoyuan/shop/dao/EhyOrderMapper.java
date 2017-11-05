package cn.ehuoyuan.shop.dao;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyOrder;
import cn.ehuoyuan.shop.domain.EhyOrderItem;

public interface EhyOrderMapper {
    int deleteByPrimaryKey(String ordId);

    int insert(EhyOrder record);

    int insertSelective(EhyOrder record);

    EhyOrder selectByPrimaryKey(String ordId);

    int updateByPrimaryKeySelective(EhyOrder record);

    int updateByPrimaryKey(EhyOrder record);
    
    List<EhyOrderItem> findAllOrderItem(Map<String, Object> map);
    
    int countRows(Map<String, Object> map);
    
    int jsMoney(Map<String, Object> map);
    
    int deliverGoods(Map<String, Object> map);
    
    String findMoney(Map<String, Object> map);
}