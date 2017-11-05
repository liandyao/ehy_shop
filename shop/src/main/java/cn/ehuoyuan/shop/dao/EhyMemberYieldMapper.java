package cn.ehuoyuan.shop.dao;

import cn.ehuoyuan.shop.domain.EhyMemberYield;

public interface EhyMemberYieldMapper {
    int deleteByPrimaryKey(String myId);

    int insert(EhyMemberYield record);

    int insertSelective(EhyMemberYield record);

    EhyMemberYield selectByPrimaryKey(String myId);

    int updateByPrimaryKeySelective(EhyMemberYield record);

    int updateByPrimaryKey(EhyMemberYield record);
}