/**
 * 
 */
package cn.ehuoyuan.shop.service.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.shop.dao.EhyProductMapper;
import cn.ehuoyuan.shop.domain.EhyProduct;

/**
 * 产品service实现接口
 * @author 欧阳丰
 * @data 2017年10月12日
 */
@Service
public class ProductServiceImpl implements ProductService{
	@Resource
	EhyProductMapper dao;
	
	@Override
	public int insertSelective(EhyProduct record) {
		return dao.insertSelective(record);
	}

	@Override
	public int updateByProId(EhyProduct prodyct) {
		return dao.updateByPrimaryKeySelective(prodyct);
	}

	@Override
	public List<EhyProduct> findAll(Map<String,Object> map) {
		List<EhyProduct> list =dao.findAll(map);
		List<EhyProduct> listVo = new ArrayList<EhyProduct>();
		BigDecimal num = new BigDecimal("100");
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			EhyProduct ehyProduct = (EhyProduct) iterator.next();
			if(ehyProduct.getProFactoryPrice()!=null && !"".equals(ehyProduct.getProFactoryPrice())){
				ehyProduct.setProFactoryPrice(new BigDecimal(ehyProduct.getProFactoryPrice().toString()).divide(num,2));
			}
			if(ehyProduct.getProPrice()!=null && !"".equals(ehyProduct.getProPrice())){
				ehyProduct.setProPrice(new BigDecimal(ehyProduct.getProPrice().toString()).divide(num,2));
			}
			if(ehyProduct.getProPrice0()!=null && !"".equals(ehyProduct.getProPrice0())){
				ehyProduct.setProPrice0(new BigDecimal(ehyProduct.getProPrice0().toString()).divide(num,2));
			}
			if(ehyProduct.getProPrice1()!=null && !"".equals(ehyProduct.getProPrice1())){
				ehyProduct.setProPrice1(new BigDecimal(ehyProduct.getProPrice1().toString()).divide(num,2));
			}
			listVo.add(ehyProduct);
		}
		return listVo;
	}

	@Override
	public int findAllSize(Map<String,Object> map) {
		return dao.findAllSize(map);
	}

	@Override
	public int updateByPrimaryKeySelective(EhyProduct product) {
		return dao.updateByPrimaryKeySelective(product);
	}

	@Override
	public Map<String, Object> findProductAndBandByProId(String proId) {
		Map<String, Object> map =dao.findProductAndBandByProId(proId);
		//把出厂价从分转换成元
		if(map.get("PRO_FACTORY_PRICE")!=null){
			map.put("PRO_FACTORY_PRICE",new BigDecimal(map.get("PRO_FACTORY_PRICE").toString()).divide(new BigDecimal("100"),2));
		}
		return map;
	}
	/**
	 * 根据产品id得到产品信息
	 * @author 胡鑫
	 * @date 2017年10月23日11:20:49
	 * @param 产品id
	 * @return 返回产品类
	 */
	@Override
	public EhyProduct findByIdProduct(String proId) {
		EhyProduct product = dao.findByIdProduct(proId);//定义产品实体类
		BigDecimal num = new BigDecimal("100");
		product.setProPrice0(new BigDecimal(product.getProPrice0().toString()).divide(num,2));
		product.setProFactoryPrice(new BigDecimal(product.getProFactoryPrice().toString()).divide(num,2));
		return product;
	}
	
}
