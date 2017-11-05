package cn.ehuoyuan.shop.dao;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.shop.action.order.vo.OrderVo;
import cn.ehuoyuan.shop.domain.EhyOrderItem;

public interface EhyOrderItemMapper {
    int deleteByPrimaryKey(String mxId);

    int insert(EhyOrderItem record);

    int insertSelective(EhyOrderItem record);

    EhyOrderItem selectByPrimaryKey(String mxId);

    int updateByPrimaryKeySelective(EhyOrderItem record);

    int updateByPrimaryKey(EhyOrderItem record);
    /**
     * 查询所有的方法，前台
     * @param 会员的id
     * @return 订单的集合
     */
    List<OrderVo> frontShowAll(Map<String, Object> map);
    /**
     * 确认收货的方法
     * @param 参数 ：会员编号。订单编号
     * @return 修改行数
     */
    int receipt(Map<String, Object> map);
    
    /**
     * 查询所有方法，后台
     * @param map
     * @return
     */
    List<EhyOrderItem> backShowAll(Map<String, Object> map);
    
    /**
	 * 显示全部已发货订单
	 * @param map
	 * @return
	 */
	public List<EhyOrderItem> deliveredShowAll(Map<String, Object> map);
	
	/**
	 * 显示全部待发货订单
	 * @param map
	 * @return
	 */
	public List<EhyOrderItem> overhangShowAll(Map<String, Object> map);
	
	/**
	 * 显示全部已收货订单
	 * @param map
	 * @return
	 */
	public List<EhyOrderItem> receivedShowAll(Map<String, Object> map);
	
	public int ordersCount(Map<String,Object> map);
    
    
}