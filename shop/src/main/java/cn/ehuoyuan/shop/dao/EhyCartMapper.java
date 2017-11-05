package cn.ehuoyuan.shop.dao;

import java.util.List;

import cn.ehuoyuan.shop.action.cart.CartVo;
import cn.ehuoyuan.shop.domain.EhyCart;

/**
 * 类的描述：购物车的DAO
 * @author 罗海兵
 * @dateTime 2017年11月1日 下午9:52:34
 * @version 1.0
 */
public interface EhyCartMapper {
	/**
	 * 根据ID删除购物车
	 * @param cartId 购物车ID
	 * @return 成功返回1,失败返回0
	 * @author 罗海兵
	 * @dateTime 2017年10月30日 上午8:32:32
	 * @versions 1.0
	 */
    int delete(String cartId);
    
    /**
     * 加入购物车(全选)
     * @param record 购物车对象
     * @return 成功返回1,失败返回0
     * @author 罗海兵
     * @dateTime 2017年10月30日 上午8:33:14
     * @versions 1.0
     */
    int add(EhyCart record);
    
    /**
     * 加入购物车(可选部分)
     * @param record 购物车对象
     * @return 成功返回1,失败返回0
     * @author 罗海兵
     * @dateTime 2017年10月30日 上午8:33:14
     * @versions 1.0
     */
    int insertSelective(EhyCart record);
    
    /**
     * 根据购车ID查询购物车
     * @param cartId 购车ID
     * @return 找到一个返回购物车对象,找不到返回null
     * @author 罗海兵
     * @dateTime 2017年10月30日 上午8:34:49
     * @versions 1.0
     */
    CartVo findByCartId(String cartId);
    
    /**
     * 根据会员ID查询购物车
     * @param mbId 会员ID
     * @return 找到一个返回购物车对象,找不到返回null
     * @author 罗海兵
     * @dateTime 2017年10月30日 上午8:34:49
     * @versions 1.0
     */
    List<CartVo> findByMbId(String mbId);
    
    /**
     * 根据购物车ID修改购物车(可选部分)
     * @param record 购物车对象
     * @return 成功返回1,失败返回0
     * @author 罗海兵
     * @dateTime 2017年10月30日 上午8:36:46
     * @versions 1.0
     */
    int updateByPrimaryKeySelective(EhyCart record);
    
    /**
     * 根据购物车ID修改购物车(全选)
     * @param record 购物车对象
     * @return 成功返回1,失败返回0
     * @author 罗海兵
     * @dateTime 2017年10月30日 上午8:36:46
     * @versions 1.0
     */
    int updateByPrimaryKey(EhyCart record);
    
    /**
     * 根据会员ID查询
     * @param mbId 会员ID
     * @return 返回购物车数量
     * @author 罗海兵
     * @dateTime 2017年10月31日 下午4:03:08
     * @versions 1.0
     */
    int findCartNum(String mbId);
}