/**
 * 
 */
package cn.ehuoyuan.shop.service.coupon;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyCoupon;

/**
 * 后台优惠券的service接口类
 * @author denglijie
 * @2017年10月10日
 * @version v1.0
 */
public interface CouponService {
	
	/**
	 * 查询数据
	 * @param map
	 * @return
	 */
	List<Map> findAll(Map<String, Object> map);
	
	/**
	 * 查询总行数
	 * @param map
	 * @return
	 */
	int findRowCount(Map<String, Object> map);
	
	/**
     * 根据优惠券编码查找
     * @param couponCode
     * @return
     */
    int selectByCode(String couponCode);
	
	/**
	 * 增加
	 * @param coupon
	 * @return
	 */
	int insertSelective(EhyCoupon coupon);
	
	/**
     * 根据id查找
     * @param couponId
     * @return
     */
    EhyCoupon selectByPrimaryKey(String couponId);
	
	/**
	 * 删除或修改
	 * @param record
	 * @return
	 */
	int updateSelective(EhyCoupon coupon);
	
	 /**
     * 排序
     * @param startNum
     * @param endNum
     * @param couponId
     * @return
     */
    int sortCoupon(Integer startNum, Integer endNum, String couponId);
}
