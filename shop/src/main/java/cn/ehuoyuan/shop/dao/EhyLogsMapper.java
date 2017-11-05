package cn.ehuoyuan.shop.dao;

import java.util.List;

import cn.ehuoyuan.shop.domain.EhyLogs;

public interface EhyLogsMapper {
    int deleteByPrimaryKey(String logsId);

    int insert(EhyLogs record);

    int insertSelective(EhyLogs record);

    EhyLogs selectByPrimaryKey(String logsId);
    
    List<EhyLogs> select(EhyLogs record);
    
    List<EhyLogs> selectAll();

    int updateByPrimaryKeySelective(EhyLogs record);

    int updateByPrimaryKey(EhyLogs record);
}