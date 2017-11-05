package cn.ehuoyuan.shop.dao;

import cn.ehuoyuan.shop.domain.EhyReturns;

public interface EhyReturnsMapper {
    int deleteByPrimaryKey(String reId);

    int insert(EhyReturns record);

    int insertSelective(EhyReturns record);

    EhyReturns selectByPrimaryKey(String reId);

    int updateByPrimaryKeySelective(EhyReturns record);

    int updateByPrimaryKey(EhyReturns record);
}