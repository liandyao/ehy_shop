package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 购物车的模型类
 */
public class EhyCart implements Serializable{
	/**
	 * IO流序列化随机数
	 */
	private static final long serialVersionUID = -3356378989116992607L;
	
	//购物车ID
    private String cartId;
    //会员主键
    private String mbId;
    //产品ID
    private String proId;
    //加入时间
    private Date cartDatetime;
    //加入数量
    private Integer cartNum;
    //加入价格
    private BigDecimal cartPrice;
    //购物车类型(会员等级不同)
    private Integer cartType;
    //站点名称
    private String stName;
    //是否有效
    private Integer isva;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
    //排序
    private Integer sort;
    //产品规格描述
    private String spNames;
    //产品名称(冗余)
    private String proName;
    
    /**  
	 * @return 产品规格描述
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
     * @return 会员主键
     */
    public String getMbId() {
        return mbId;
    }
    /**
     * 
     * @param 会员主键
     */
    public void setMbId(String mbId) {
        this.mbId = mbId == null ? null : mbId.trim();
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
    public BigDecimal getCartPrice() {
        return cartPrice;
    }
    /**
     * 
     * @param 加入价格
     */
    public void setCartPrice(BigDecimal cartPrice) {
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
    /**
     * 
     * @return 是否有效
     */
    public Integer getIsva() {
        return isva;
    }
    /**
     * 
     * @param 是否有效
     */
    public void setIsva(Integer isva) {
        this.isva = isva;
    }
    /**
     * 
     * @return 操作时间
     */
    public Date getOptime() {
        return optime;
    }
    /**
     * 
     * @param 操作时间
     */
    public void setOptime(Date optime) {
        this.optime = optime;
    }
    /**
     * 
     * @return 操作人
     */
    public String getOper() {
        return oper;
    }
    /**
     * 
     * @param 操作人
     */
    public void setOper(String oper) {
        this.oper = oper == null ? null : oper.trim();
    }
    /**
     * 
     * @return 排序
     */
    public Integer getSort() {
        return sort;
    }
    /**
     * 
     * @param 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}