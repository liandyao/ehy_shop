package cn.ehuoyuan.shop.dao;

import java.util.List;

import cn.ehuoyuan.shop.domain.EhyProductSpecificationPrice;
/**
 * 产品规格价格dao
 * @author 欧阳丰
 * @date 2017年10月28日17:07:00
 */
public interface EhyProductSpecificationPriceMapper {
    int deleteByPrimaryKey(String pspId);

    int insert(EhyProductSpecificationPrice record);
    
    /**
     * 根据产品ID查找该产品的规格价格
     * @param proId 产品ID
     * @date 2017年10月31日15:45:15
	 * @version 1.1
     * @return 影响行数
     */
    public List<EhyProductSpecificationPrice> findAllByProId(String proId);
    
    /**
     * 根据产品ID修改该产品的所有规格价格为无效
     * @param proId 产品ID
     * @date 2017年10月28日17:01:30
	 * @version 1.1
     * @return 影响行数
     */
    public int updateIsvaByProId(String proId);
    
    /**
     * 增加产品规格价格
     * @param record 产品规格价格实体类
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年10月28日16:37:09
	 * @version 1.1
     */
    public int insertSelective(EhyProductSpecificationPrice record);

    EhyProductSpecificationPrice selectByPrimaryKey(String pspId);

    int updateByPrimaryKeySelective(EhyProductSpecificationPrice record);

    int updateByPrimaryKey(EhyProductSpecificationPrice record);
}