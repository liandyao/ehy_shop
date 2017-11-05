package cn.ehuoyuan.shop.dao;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyProductSpecificationValue;
/**
 * 产品规格dao
 * @author 欧阳丰
 * @date 2017年10月28日17:07:00
 */
public interface EhyProductSpecificationValueMapper {
    int deleteByPrimaryKey(String priId);

    int insert(EhyProductSpecificationValue record);
    
    /**
     * 根据产品ID查找该产品的规格
     * @param proId 产品ID
     * @date 2017年10月31日15:45:15
     * @author 欧阳丰
	 * @version 1.1
     * @return 影响行数
     */
    public List<EhyProductSpecificationValue> findAllByProId(String proId);
    
    /**
     * 根据产品ID修改该产品的所有规格为无效
     * @param proId 产品ID
     * @date 2017年10月28日17:01:30
     * @author 欧阳丰
	 * @version 1.1
     * @return 影响行数
     */
    public int updateIsvaByProId(String proId);
    
    /**
     * 增加产品规格
     * @param record 产品规格实体类
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年10月28日16:37:09
	 * @version 1.1
     */
    public int insertSelective(EhyProductSpecificationValue record);

    EhyProductSpecificationValue selectByPrimaryKey(String priId);

    int updateByPrimaryKeySelective(EhyProductSpecificationValue record);

    int updateByPrimaryKey(EhyProductSpecificationValue record);
    
    /**
     * 根据产品ID查询产品详情的规格参数 
     * @param proId 产品ID
     * @return 返回一个Map的List集合
     * @author 罗海兵
     * @dateTime 2017年10月27日 上午10:27:21
     * @versions 1.0
     */
    List<Map<String, Object>> findByProId(String proId);
}