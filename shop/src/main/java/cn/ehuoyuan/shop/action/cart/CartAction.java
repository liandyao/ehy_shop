/**
 * 
 */
package cn.ehuoyuan.shop.action.cart;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ehuoyuan.shop.domain.EhyCart;
import cn.ehuoyuan.shop.domain.EhyMember;
import cn.ehuoyuan.shop.service.cart.EhyCartService;

/**
 * 类的描述：购物车的控制器
 * @author 罗海兵
 * @dateTime 2017年10月30日 上午8:24:34
 * @version 1.0
 */
@Controller
@RequestMapping("/cart")
public class CartAction {
	
	@Resource
	EhyCartService ehyCartService;//购物车的Service
	
	/**
	 * 加入购物车
	 * @param cart 购物车的对象
	 * @param session HttpSession会话对象
	 * @return 成功返回1,失败返回0
	 * @author 罗海兵
	 * @dateTime 2017年10月30日 上午8:29:22
	 * @versions 1.0
	 */
	@RequestMapping("front/add")
	@ResponseBody
	public int add(EhyCart cart, HttpSession session){
		EhyMember mem=(EhyMember) session.getAttribute("login");
		cart.setMbId(mem.getMbId());
		cart.setCartType(0);
		cart.setCartDatetime(new Date());
		int rows=ehyCartService.add(cart);
		return rows;
	}
	
	/**
     * 根据会员ID查询
     * @param session HttpSession会话对象
     * @return 返回购物车数量
     * @author 罗海兵
     * @dateTime 2017年10月31日 下午4:03:08
     * @versions 1.0
     */
	@RequestMapping("front/findCartNum")
	@ResponseBody
	public int findCartNum(HttpSession session){
		EhyMember mem=(EhyMember) session.getAttribute("login");
		int rows=ehyCartService.findCartNum(mem.getMbId());
		return rows;
	}
	
	/**
	 * 根据会员ID查询购物车集合
	 * @param session HttpSession会话对象
	 * @return 返回一个购物车的集合
	 * @author 罗海兵
	 * @dateTime 2017年10月31日 下午4:43:10
	 * @versions 1.0
	 */
	@RequestMapping("front/findByMbId")
	@ResponseBody
	public List<CartVo> findByMbId(HttpSession session){
		EhyMember mem=(EhyMember) session.getAttribute("login");
		List<CartVo> cartList=ehyCartService.findByMbId(mem.getMbId());
		return cartList;
	}
	
	/**
	 * 根据购物车ID删除一条记录
	 * @param cartId 购物车ID
	 * @return 成功返回1,失败返回0
	 * @author 罗海兵
	 * @dateTime 2017年11月2日 下午3:15:14
	 * @versions 1.0
	 */
	@RequestMapping("front/delete")
	@ResponseBody
	public int delete(String cartId){
		int rows=ehyCartService.delete(cartId);
		return rows;
	}
	
	/**
	 * 增加或者减少购物车的产品数量
	 * @param cart 购物车对象
	 * @return 成功返回1,失败返回0
	 * @author 罗海兵
	 * @dateTime 2017年11月2日 下午4:26:50
	 * @versions 1.0
	 */
	@RequestMapping("front/addOrCut")
	@ResponseBody
	public int addOrCut(EhyCart cart){
		int rows=ehyCartService.update(cart);
		return rows;
	}
}
