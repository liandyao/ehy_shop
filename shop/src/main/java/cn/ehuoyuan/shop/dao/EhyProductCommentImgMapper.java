package cn.ehuoyuan.shop.dao;

import cn.ehuoyuan.shop.domain.EhyProductCommentImg;

public interface EhyProductCommentImgMapper {
    int deleteByPrimaryKey(String id);

    int insert(EhyProductCommentImg record);

    int insertSelective(EhyProductCommentImg record);

    EhyProductCommentImg selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(EhyProductCommentImg record);

    int updateByPrimaryKey(EhyProductCommentImg record);
}