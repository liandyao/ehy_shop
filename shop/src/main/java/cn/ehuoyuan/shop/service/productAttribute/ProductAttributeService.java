package cn.ehuoyuan.shop.service.productAttribute;

import java.util.List;

import cn.ehuoyuan.shop.domain.EhyProductAttribute;

/**
 * 产品属性service接口
 * @author 欧阳丰
 * @data 2017年11月2日10:40:52
 */
public interface ProductAttributeService {
	/**
	  * 增加产品属性
	  * @return 影响行数
	  * @author 欧阳丰
	  * @dateTime 2017年11月2日10:34:10
	  * @versions 1.1
	  */
   public int addList(List<EhyProductAttribute> list,String proId);
   
   /**
	  * 查询某产品的所有属性
	  * @return 属性集合
	  * @author 欧阳丰
	  * @dateTime 2017年11月2日10:35:59
	  * @versions 1.1
	  */
   public List<EhyProductAttribute> findAllByProId(String proId);

}
