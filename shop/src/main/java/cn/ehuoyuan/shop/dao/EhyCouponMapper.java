package cn.ehuoyuan.shop.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.ehuoyuan.shop.domain.EhyCoupon;

/**
 * 后台优惠券的Dao接口类
 * @author denglijie
 * @2017年10月10日
 * @version v1.0
 */
public interface EhyCouponMapper {
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
	
    int deleteByPrimaryKey(String couponId);

    /**
     * 增加
     * @param record
     * @return
     */
    int insertSelective(EhyCoupon record);

    /**
     * 根据id查找
     * @param couponId
     * @return
     */
    EhyCoupon selectByPrimaryKey(String couponId);

    /**
     * 根据优惠券编码查找
     * @param couponCode
     * @return
     */
    int selectByCode(String couponCode);
    
    /**
     * 修改或删除
     * @param record
     * @return
     */
    int updateSelective(EhyCoupon record);

    /**
     * 排序
     * @param startNum
     * @param endNum
     * @param couponId
     * @return
     */
    int sortCoupon(@Param("startNum")Integer startNum, @Param("endNum")Integer endNum, @Param("couponId")String couponId);
}