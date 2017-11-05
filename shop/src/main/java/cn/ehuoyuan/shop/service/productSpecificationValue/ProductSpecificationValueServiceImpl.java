package cn.ehuoyuan.shop.service.productSpecificationValue;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.shop.dao.EhyProductSpecificationValueMapper;
import cn.ehuoyuan.shop.domain.EhyProductSpecificationValue;

/**
 * 产品规格表Service实现接口
 * @author 欧阳丰
 * @data 2017年10月28日16:23:08
 */
@Service
public class ProductSpecificationValueServiceImpl implements ProductSpecificationValueService{
	
	@Resource
	EhyProductSpecificationValueMapper dao;
	
	@Override
	public int insertSelective(EhyProductSpecificationValue record) {
		return dao.insertSelective(record);
	}

	@Override
	public int updateIsvaByProId(String proId) {
		return dao.updateIsvaByProId(proId);
	}

	@Override
	public List<EhyProductSpecificationValue> findAllByProId(String proId) {
		return dao.findAllByProId(proId);
	}

}
