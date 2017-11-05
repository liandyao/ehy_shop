/**
 * 
 */
package cn.ehuoyuan.shop.service.productAttribute;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.shop.dao.EhyProductAttributeMapper;
import cn.ehuoyuan.shop.domain.EhyManager;
import cn.ehuoyuan.shop.domain.EhyProductAttribute;

/**
 * 产品属性service时间接口
 * @author 欧阳丰
 * @data 2017年11月2日10:40:47
 */
@Service
public class ProductAttributeServiceImpl implements ProductAttributeService{
	@Resource
	EhyProductAttributeMapper dao;//产品属性DAO
	
	@Override
	public int addList(List<EhyProductAttribute> list,String proId) {
		//把之前的属性全部设为无效
		dao.updateIsvaByProId(proId);
		//增加属性
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			EhyProductAttribute ehyProductAttribute = (EhyProductAttribute) iterator.next();
			dao.insertSelective(ehyProductAttribute);
		}
		return 1;
	}

	@Override
	public List<EhyProductAttribute> findAllByProId(String proId) {
		return dao.findAllByProId(proId);
	}

}
