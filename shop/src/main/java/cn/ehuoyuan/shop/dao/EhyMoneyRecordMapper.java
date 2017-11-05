package cn.ehuoyuan.shop.dao;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyMoneyRecord;

public interface EhyMoneyRecordMapper {
    int deleteByPrimaryKey(String mrId);

    int insert(EhyMoneyRecord record);

    int insertSelective(EhyMoneyRecord record);

    EhyMoneyRecord selectByPrimaryKey(String mrId);

    int updateByPrimaryKeySelective(EhyMoneyRecord record);

    int updateByPrimaryKey(EhyMoneyRecord record);
    
    List<EhyMoneyRecord> showList(Map<String, Object> map);
    
    int countRows(Map<String, Object> map);
    
    String findMaxTime();
    
}