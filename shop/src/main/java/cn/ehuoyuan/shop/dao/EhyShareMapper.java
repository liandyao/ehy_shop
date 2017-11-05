package cn.ehuoyuan.shop.dao;

import cn.ehuoyuan.shop.domain.EhyShare;

public interface EhyShareMapper {
    int deleteByPrimaryKey(String shaId);

    int insert(EhyShare record);

    int insertSelective(EhyShare record);

    EhyShare selectByPrimaryKey(String shaId);

    int updateByPrimaryKeySelective(EhyShare record);

    int updateByPrimaryKey(EhyShare record);
}