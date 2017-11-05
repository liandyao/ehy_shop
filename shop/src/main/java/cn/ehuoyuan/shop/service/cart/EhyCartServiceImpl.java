package cn.ehuoyuan.shop.service.cart;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.action.cart.CartVo;
import cn.ehuoyuan.shop.dao.EhyCartMapper;
import cn.ehuoyuan.shop.dao.EhyProductSpecificationValueMapper;
import cn.ehuoyuan.shop.domain.EhyCart;
import cn.ehuoyuan.shop.domain.EhyProductSpecificationValue;

/**
 * 类的描述：购物车的Service实现类
 * @author 罗海兵
 * @dateTime 2017年10月30日 上午9:15:21
 * @version 1.0
 */
@Service
public class EhyCartServiceImpl implements EhyCartService{
	
	@Resource
	EhyCartMapper ehyCartMapper;//购物车的DAO
	
	@Resource
	EhyProductSpecificationValueMapper ehyProductSpecificationValueMapper;//产品规格的DAO

	@Override
	public int delete(String cartId) {
		
		return ehyCartMapper.delete(cartId);
	}

	@Override
	public int add(EhyCart cart) {
		return ehyCartMapper.add(cart);
	}

	@Override
	public CartVo findById(String cartId) {
		
		return ehyCartMapper.findByCartId(cartId);
	}

	@Override
	public List<CartVo> findByMbId(String mbId) {
		List<CartVo> voList=ehyCartMapper.findByMbId(mbId);
		for(int i=0;i<voList.size();i++){
			CartVo cartVo=voList.get(i);
			String proId=cartVo.getProId();
			String[] strArr=cartVo.getSpNames().split(",");
			List<String> strList=new ArrayList<String>();
			List<EhyProductSpecificationValue> valueList = ehyProductSpecificationValueMapper.findAllByProId(proId);
			for(int j=0;j<valueList.size();j++){
				EhyProductSpecificationValue obj=valueList.get(j);
				String key = obj.getSptName();
				String value = obj.getSpName();
				for(int k=0;k<strArr.length;k++){
					String str=strArr[k];
					if(str.equals(value)){
						strList.add(key+"："+value);
					}
				}
				System.out.println("key : "+key+" , value : "+value);
			}
			cartVo.setSpValues(strList);
		}
		return voList;
	}

	@Override
	public int update(EhyCart cart) {
		return ehyCartMapper.updateByPrimaryKeySelective(cart);
	}

	@Override
	public int findCartNum(String mbId) {
		return ehyCartMapper.findCartNum(mbId);
	}
	
	
}
