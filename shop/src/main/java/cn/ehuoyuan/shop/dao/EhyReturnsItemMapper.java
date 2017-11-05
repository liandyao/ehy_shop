package cn.ehuoyuan.shop.dao;

import cn.ehuoyuan.shop.domain.EhyReturnsItem;

public interface EhyReturnsItemMapper {
    int deleteByPrimaryKey(String reItemId);

    int insert(EhyReturnsItem record);

    int insertSelective(EhyReturnsItem record);

    EhyReturnsItem selectByPrimaryKey(String reItemId);

    int updateByPrimaryKeySelective(EhyReturnsItem record);

    int updateByPrimaryKey(EhyReturnsItem record);
}