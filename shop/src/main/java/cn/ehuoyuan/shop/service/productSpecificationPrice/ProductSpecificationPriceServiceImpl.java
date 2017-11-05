/**
 * 
 */
package cn.ehuoyuan.shop.service.productSpecificationPrice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.shop.dao.EhyProductSpecificationPriceMapper;
import cn.ehuoyuan.shop.domain.EhyProductSpecificationPrice;

/**
 * 产品规格价格表Service实现接口
 * @author 欧阳丰
 * @data 2017年10月28日16:23:08
 */
@Service
public class ProductSpecificationPriceServiceImpl implements ProductSpecificationPriceService{
	
	@Resource
	EhyProductSpecificationPriceMapper dao;
	
	@Override
	public int insertSelective(EhyProductSpecificationPrice record) {
		return dao.insertSelective(record);
	}

	@Override
	public int updateIsvaByProId(String proId) {
		return dao.updateIsvaByProId(proId);
	}

	@Override
	public List<EhyProductSpecificationPrice> findAllByProId(String proId) {
		List<EhyProductSpecificationPrice> listVo = new ArrayList<EhyProductSpecificationPrice>();
		List<EhyProductSpecificationPrice> list = dao.findAllByProId(proId);
		BigDecimal num = new BigDecimal("100");
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			EhyProductSpecificationPrice ehyProductSpecificationPrice = (EhyProductSpecificationPrice) iterator.next();
			if(ehyProductSpecificationPrice.getPspFactoryPrice()!=null && !"".equals(ehyProductSpecificationPrice.getPspFactoryPrice())){
				ehyProductSpecificationPrice.setPspFactoryPrice(new BigDecimal(ehyProductSpecificationPrice.getPspFactoryPrice().toString()).divide(num,2));
			}
			if(ehyProductSpecificationPrice.getPspPrice()!=null && !"".equals(ehyProductSpecificationPrice.getPspPrice())){
				ehyProductSpecificationPrice.setPspPrice(new BigDecimal(ehyProductSpecificationPrice.getPspPrice().toString()).divide(num,2));
			}
			listVo.add(ehyProductSpecificationPrice);
		}
		return listVo;
	}

}
