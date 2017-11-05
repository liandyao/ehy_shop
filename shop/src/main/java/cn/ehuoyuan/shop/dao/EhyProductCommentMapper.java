package cn.ehuoyuan.shop.dao;

import cn.ehuoyuan.shop.domain.EhyProductComment;

public interface EhyProductCommentMapper {
    int deleteByPrimaryKey(String commId);

    int insert(EhyProductComment record);

    int insertSelective(EhyProductComment record);

    EhyProductComment selectByPrimaryKey(String commId);

    int updateByPrimaryKeySelective(EhyProductComment record);

    int updateByPrimaryKey(EhyProductComment record);
}