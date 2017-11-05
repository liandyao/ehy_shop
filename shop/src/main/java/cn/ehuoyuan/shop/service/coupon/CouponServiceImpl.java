/**
 * 
 */
package cn.ehuoyuan.shop.service.coupon;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.shop.dao.EhyCouponMapper;
import cn.ehuoyuan.shop.domain.EhyCoupon;

/**
 * 后台优惠券的service实现类
 * @author denglijie
 * @2017年10月10日
 * @version v1.0
 */
@Service
public class CouponServiceImpl implements CouponService{

	@Resource
	private EhyCouponMapper ehyCouponMapper;
	
	/**
	 * 查询数据
	 */
	public List<Map> findAll(Map<String, Object> map) {
		return ehyCouponMapper.findAll(map);
	}

	/**
	 * 查询总行数
	 */
	public int findRowCount(Map<String, Object> map) {
		return ehyCouponMapper.findRowCount(map);
	}

	/**
	 * 删除或修改
	 */
	public int updateSelective(EhyCoupon record) {
		
		return ehyCouponMapper.updateSelective(record);
	}

	/**
	 * 增加
	 */
	public int insertSelective(EhyCoupon coupon) {
		
		return ehyCouponMapper.insertSelective(coupon);
	}

	/**
	 * 根据优惠券编码查找
	 */
	public int selectByCode(String couponCode) {
		
		return ehyCouponMapper.selectByCode(couponCode);
	}

	/**
	 * 根据id查找
	 */
	public EhyCoupon selectByPrimaryKey(String couponId) {
		
		return ehyCouponMapper.selectByPrimaryKey(couponId);
	}

	/**
	 * 排序
	 */
	public int sortCoupon(Integer startNum, Integer endNum, String couponId) {
		return ehyCouponMapper.sortCoupon(startNum, endNum, couponId);
	}

}
