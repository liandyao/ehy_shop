package cn.ehuoyuan.shop.dao;

import cn.ehuoyuan.shop.domain.EhyShelves;

public interface EhyShelvesMapper {
    int deleteByPrimaryKey(String sheId);

    int insert(EhyShelves record);

    int insertSelective(EhyShelves record);

    EhyShelves selectByPrimaryKey(String sheId);

    int updateByPrimaryKeySelective(EhyShelves record);

    int updateByPrimaryKey(EhyShelves record);
}