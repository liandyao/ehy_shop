/**
 * 
 */
package cn.ehuoyuan.shop.service.productSpecificationValue;

import java.util.List;

import cn.ehuoyuan.shop.domain.EhyProductSpecificationValue;

/**
 * 产品规格表Service接口
 * @author 欧阳丰
 * @data 2017年10月28日16:23:08
 */
public interface ProductSpecificationValueService {
	
	/**
     * 根据产品ID查找该产品的规格
     * @param proId 产品ID
     * @date 2017年10月31日15:52:33
	 * @version 1.1
     * @return 影响行数
     */
    public List<EhyProductSpecificationValue> findAllByProId(String proId);
	
	/**
     * 增加产品规格
     * @param record 产品规格实体类
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年10月28日16:37:09
	 * @version 1.1
     */
    public int insertSelective(EhyProductSpecificationValue record);
    
    /**
     * 根据产品ID修改该产品的所有规格为无效
     * @param proId 产品ID
     * @date 2017年10月28日17:12:05
	 * @version 1.1
     * @return 影响行数
     */
    public int updateIsvaByProId(String proId);
}
