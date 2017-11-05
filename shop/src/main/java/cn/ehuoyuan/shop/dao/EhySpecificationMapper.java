package cn.ehuoyuan.shop.dao;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhySpecification;

public interface EhySpecificationMapper {
	/**
	 * 根据规格类型id进行规格值删除
	 * @author 胡鑫
	 * @date 2017年10月19日10:05:51
	 * @param sptId 规格类型id
	 * @return 返回执行的行数
	 */
    public int deleteByPrimaryKey(Map<String,Object>map);

    int insert(EhySpecification record);

    int insertSelective(EhySpecification record);

    EhySpecification selectByPrimaryKey(String spId);

    int updateByPrimaryKeySelective(EhySpecification record);

    int updateByPrimaryKey(EhySpecification record);
    
    /**
     * @title 根据规格类型ID查询规格值
     * @param sptId 规格类型ID
     * @return 返回一个Map的List集合
     * @author 罗海兵
     * @dateTime 2017年10月26日 上午8:56:16
     * @versions 1.0
     */
    List<Map<String, String>> findBySptId(String sptId);
}