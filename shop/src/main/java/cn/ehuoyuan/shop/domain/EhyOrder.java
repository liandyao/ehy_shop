package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 订单表的模型类
 */
public class EhyOrder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3282206922694691316L;
	//订单ID
    private String ordId;
    //订单编号
    private String ordCode;
    //支付编号
    private String payCode;
    //支付时间
    private String payTime;
    //支付方式
    private String payType;
    //支付金额
    private BigDecimal payMoney;
    //确认订单时间
    private String ordTime;
    //订单总金额
    private BigDecimal ordSumMoney;
    //订单总数量
    private Long ordSum;
    //是否使用优惠券
    private Integer ordIscoupon;
    //优惠券号码
    private String ordCoupon;
    //收货人
    private String ordMember;
    //收货地址
    private String ordAddress;
    //收货电话
    private String ordPhone;
    //订单支付截止时间
    private String ordEndtime;
    //运费 没用
    private BigDecimal ordFreight;
    //订单状态 没用
    private Integer ordState;
    //快递公司没用
    private String ordExpress;
    //快递单号没用
    private String ordExpressCode;
    //是否有效
    private Integer isva;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
    /**
     * 
     * @return 订单ID
     */
    public String getOrdId() {
        return ordId;
    }
    /**
     * 
     * @param 订单ID
     */
    public void setOrdId(String ordId) {
        this.ordId = ordId == null ? null : ordId.trim();
    }
    /**
     * 
     * @return 订单编号
     */
    public String getOrdCode() {
        return ordCode;
    }
    /**
     * 
     * @param 订单编号
     */
    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode == null ? null : ordCode.trim();
    }
    /**
     * 
     * @return 支付编号
     */
    public String getPayCode() {
        return payCode;
    }
    /**
     * 
     * @param 支付编号
     */
    public void setPayCode(String payCode) {
        this.payCode = payCode == null ? null : payCode.trim();
    }
    /**
     * 
     * @return 支付时间
     */
    public String getPayTime() {
        return payTime;
    }
    /**
     * 
     * @param 支付方式
     */
    public void setPayTime(String payTime) {
        this.payTime = payTime == null ? null : payTime.trim();
    }
    /**
     * 
     * @return 支付方式
     */
    public String getPayType() {
        return payType;
    }
    /**
     * 
     * @param 支付方式
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }
    /**
     * 
     * @return 支付金额
     */
    public BigDecimal getPayMoney() {
        return payMoney;
    }
    /**
     * 
     * @param 支付金额
     */
    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }
    /**
     * 
     * @return 确认订单时间
     */
    public String getOrdTime() {
        return ordTime;
    }
    /**
     * 
     * @param 确认订单时间
     */
    public void setOrdTime(String ordTime) {
        this.ordTime = ordTime == null ? null : ordTime.trim();
    }
    /**
     * 
     * @return 订单总金额
     */
    public BigDecimal getOrdSumMoney() {
        return ordSumMoney;
    }
    /**
     * 
     * @param 订单总金额
     */
    public void setOrdSumMoney(BigDecimal ordSumMoney) {
        this.ordSumMoney = ordSumMoney;
    }
    /**
     *  
     * @return 订单总数量
     */
    public Long getOrdSum() {
        return ordSum;
    }
    /**
     * 
     * @param 订单总数量
     */
    public void setOrdSum(Long ordSum) {
        this.ordSum = ordSum;
    }
    /**
     * 
     * @return 是否使用优惠券
     */
    public Integer getOrdIscoupon() {
        return ordIscoupon;
    }
    /**
     * 
     * @param 是否使用优惠券
     */
    public void setOrdIscoupon(Integer ordIscoupon) {
        this.ordIscoupon = ordIscoupon;
    }
    /**
     * 
     * @return 优惠券号码
     */
    public String getOrdCoupon() {
        return ordCoupon;
    }
    /**
     * 
     * @param 优惠券号码
     */
    public void setOrdCoupon(String ordCoupon) {
        this.ordCoupon = ordCoupon == null ? null : ordCoupon.trim();
    }
    /**
     * 
     * @return 收货人
     */
    public String getOrdMember() {
        return ordMember;
    }
    /**
     * 
     * @param 收货人
     */
    public void setOrdMember(String ordMember) {
        this.ordMember = ordMember == null ? null : ordMember.trim();
    }
    /**
     * 
     * @return 收货地址
     */
    public String getOrdAddress() {
        return ordAddress;
    }
    /**
     * 
     * @param 收货地址
     */
    public void setOrdAddress(String ordAddress) {
        this.ordAddress = ordAddress == null ? null : ordAddress.trim();
    }
    /**
     * 
     * @return 收货电话
     */
    public String getOrdPhone() {
        return ordPhone;
    }
    /**
     * 
     * @param 收货电话
     */
    public void setOrdPhone(String ordPhone) {
        this.ordPhone = ordPhone == null ? null : ordPhone.trim();
    }
    /**
     * 
     * @return 订单支付截止时间
     */
    public String getOrdEndtime() {
        return ordEndtime;
    }
    /**
     * 
     * @param 订单支付截止时间
     */
    public void setOrdEndtime(String ordEndtime) {
        this.ordEndtime = ordEndtime == null ? null : ordEndtime.trim();
    }
    /**
     * 
     * @return 运费 没用
     */
    public BigDecimal getOrdFreight() {
        return ordFreight;
    }
    /**
     * 
     * @param 运费 没用
     */
    public void setOrdFreight(BigDecimal ordFreight) {
        this.ordFreight = ordFreight;
    }
    /**
     * 
     * @return 订单状态 没用
     */
    public Integer getOrdState() {
        return ordState;
    }
    /**
     * 
     * @param 订单状态 没用
     */
    public void setOrdState(Integer ordState) {
        this.ordState = ordState;
    }
    /**
     * 
     * @return 快递公司没用
     */
    public String getOrdExpress() {
        return ordExpress;
    }
    /**
     * 
     * @param 快递公司没用
     */
    public void setOrdExpress(String ordExpress) {
        this.ordExpress = ordExpress == null ? null : ordExpress.trim();
    }
    /**
     * 
     * @return 快递单号没用
     */
    public String getOrdExpressCode() {
        return ordExpressCode;
    }
    /**
     * 
     * @param 快递单号没用
     */
    public void setOrdExpressCode(String ordExpressCode) {
        this.ordExpressCode = ordExpressCode == null ? null : ordExpressCode.trim();
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
}