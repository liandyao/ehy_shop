package cn.ehuoyuan.shop.dao;

import java.util.List;

import cn.ehuoyuan.shop.domain.EhyProductAttribute;

public interface EhyProductAttributeMapper {
    int deleteByPrimaryKey(String attrId);

    int insert(EhyProductAttribute record);
    
    /**
	  * 增加产品属性
	  * @return 影响行数
	  * @author 欧阳丰
	  * @dateTime 2017年11月2日10:34:10
	  * @versions 1.1
	  */
    public int insertSelective(EhyProductAttribute record);
    
    /**
	  * 查询某产品的所有属性
	  * @return 属性集合
	  * @author 欧阳丰
	  * @dateTime 2017年11月2日10:35:59
	  * @versions 1.1
	  */
    public List<EhyProductAttribute> findAllByProId(String proId);
    
    /**
	  * 修改某产品的所有属性为无效
	  * @return 影响行数
	  * @author 欧阳丰
	  * @dateTime 2017年11月2日19:13:41
	  * @versions 1.1
	  */
    public int updateIsvaByProId(String proId);

    EhyProductAttribute selectByPrimaryKey(String attrId);

    int updateByPrimaryKeySelective(EhyProductAttribute record);

    int updateByPrimaryKey(EhyProductAttribute record);
}