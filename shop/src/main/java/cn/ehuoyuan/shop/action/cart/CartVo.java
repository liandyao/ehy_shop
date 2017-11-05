package cn.ehuoyuan.shop.action.cart;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.ehuoyuan.common.Tools;
/**
 * 购物车的模型类
 */
public class CartVo {
	//购物车ID
    private String cartId;
    //产品ID
    private String proId;
    //加入时间
    private Date cartDatetime;
    //加入数量
    private Integer cartNum;
    //加入价格
    private String cartPrice;
    //购物车类型(会员等级不同)
    private Integer cartType;
    //站点名称
    private String stName;
    //产品名称(冗余)
    private String proName;
    
    //产品规格的集合
    private List<String> spValues;
    
    //产品规格描述
    private String spNames;
    
    //产品图片
    private String proImg;
    
    
    
    /**  
	 * @return  产品规格描述
	 */
	public String getSpNames() {
		return spNames;
	}
	/**
	 * @param spNames 产品规格描述
	 */
	public void setSpNames(String spNames) {
		this.spNames = spNames;
	}
	/**  
	 * @return  产品图片
	 */
	public String getProImg() {
		return proImg;
	}
	/**
	 * @param proImg 产品图片
	 */
	public void setProImg(String proImg) {
		this.proImg = proImg;
	}
	/**  
	 * @return  产品规格的集合
	 */
	public List<String> getSpValues() {
		return spValues;
	}
	/**
	 * @param spValues 产品规格的集合
	 */
	public void setSpValues(List<String> spValues) {
		this.spValues = spValues;
	}
	/**  
	 * @return 产品名称(冗余)
	 */
	public String getProName() {
		return proName;
	}
	/**
	 * @param proName 产品名称(冗余)
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}
	/**
     * 
     * @return 购物车ID
     */
    public String getCartId() {
        return cartId;
    }
    /**
     * 
     * @param 购物车ID
     */
    public void setCartId(String cartId) {
        this.cartId = cartId == null ? null : cartId.trim();
    }
    /**
     * 
     * @return 产品ID
     */
    public String getProId() {
        return proId;
    }
    /**
     * 
     * @param 产品ID
     */
    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }
    /**
     * 
     * @return 加入时间
     */
    @JsonFormat(pattern="yyyy-mm-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-mm-dd HH:mm:ss")
    public Date getCartDatetime() {
        return cartDatetime;
    }
    /**
     * 
     * @param 加入时间
     */
    public void setCartDatetime(Date cartDatetime) {
        this.cartDatetime = cartDatetime;
    }
    /**
     * 
     * @return 加入数量
     */
    public Integer getCartNum() {
        return cartNum;
    }
    /**
     * 
     * @param 加入数量
     */
    public void setCartNum(Integer cartNum) {
        this.cartNum = cartNum;
    }
    /**
     * 
     * @return 加入价格
     */
    public String getCartPrice() {
        return Tools.moneyFenToYuan2(cartPrice);
    }
    /**
     * 
     * @param 加入价格
     */
    public void setCartPrice(String cartPrice) {
        this.cartPrice = cartPrice;
    }
    /**
     * 
     * @return 购物车类型(会员等级不同)
     */
    public Integer getCartType() {
        return cartType;
    }
    /***
     * 
     * @param 购物车类型(会员等级不同)
     */
    public void setCartType(Integer cartType) {
        this.cartType = cartType;
    }
    /**
     * 
     * @return 站点名称
     */
    public String getStName() {
        return stName;
    }
    /**
     * 
     * @param 站点名称
     */
    public void setStName(String stName) {
        this.stName = stName == null ? null : stName.trim();
    }
}