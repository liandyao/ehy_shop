package cn.ehuoyuan.shop.dao;

import cn.ehuoyuan.shop.domain.EhyRefunds;

public interface EhyRefundsMapper {
    int deleteByPrimaryKey(String refId);

    int insert(EhyRefunds record);

    int insertSelective(EhyRefunds record);

    EhyRefunds selectByPrimaryKey(String refId);

    int updateByPrimaryKeySelective(EhyRefunds record);

    int updateByPrimaryKey(EhyRefunds record);
}