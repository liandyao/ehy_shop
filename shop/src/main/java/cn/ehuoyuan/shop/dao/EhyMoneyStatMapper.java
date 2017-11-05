package cn.ehuoyuan.shop.dao;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyMoneyStat;

public interface EhyMoneyStatMapper {
    int deleteByPrimaryKey(String msId);

    int insert(EhyMoneyStat record);

    int insertSelective(EhyMoneyStat record);

    EhyMoneyStat selectByPrimaryKey(String msId);

    int updateByPrimaryKeySelective(EhyMoneyStat record);

    int updateByPrimaryKey(EhyMoneyStat record);
    
    List<EhyMoneyStat> showList(Map<String, Object> map);
    
    int countRows(Map<String, Object> map);
}