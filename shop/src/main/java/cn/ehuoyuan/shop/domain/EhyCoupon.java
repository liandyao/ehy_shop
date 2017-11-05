package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import cn.ehuoyuan.common.Tools;
/**
 * 优惠券的模型类
 */
public class EhyCoupon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 565928909783428108L;
	//优惠券ID
    private String couponId;
    //站点ID
    private String stId;
    //优惠券编码
    private String couponCode;
    //金额
    private BigDecimal couponMoney;
    //使用说明备注
    private String remark;
    //抵扣金额
    private BigDecimal couponMinMoney;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;
    //计算规则
    private String calc;
    //是否有效
    private Integer isva;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
    //排序
    private Integer sort;
    
    
    /**
     * 
     * @return 优惠券ID
     */
    public String getCouponId() {
        return couponId;
    }
    /**
     * 
     * @param 优惠券ID
     */
    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }
    /**
     * 
     * @return 站点ID
     */
    public String getStId() {
        return stId;
    }
    /**
     * 
     * @param 站点ID
     */
    public void setStId(String stId) {
        this.stId = stId == null ? null : stId.trim();
    }
    /**
     * 
     * @return 优惠券编码
     */
    public String getCouponCode() {
        return couponCode;
    }
    /**
     * 
     * @param 优惠券编码
     */
    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode == null ? null : couponCode.trim();
    }
    /**
     * 
     * @return 金额
     */
    public BigDecimal getCouponMoney() {
        return couponMoney;
    }
    /**
     * 
     * @param 金额
     */
    public void setCouponMoney(BigDecimal couponMoney) {
        this.couponMoney = couponMoney;
    }
    /**
     * 
     * @return 使用说明备注
     */
    public String getRemark() {
        return remark;
    }
    /**
     * 
     * @param 使用说明备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
    /**
     * 
     * @return 抵扣金额
     */
    public BigDecimal getCouponMinMoney() {
        return couponMinMoney;
    }
    /**
     * 
     * @param 抵扣金额
     */
    public void setCouponMinMoney(BigDecimal couponMinMoney) {
        this.couponMinMoney = couponMinMoney;
    }
    /**
     * 
     * @return 开始时间
     */
    public String getStartTime() {
        return startTime;
    }
    /**
     * 
     * @param 开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }
    /**
     * 
     * @return 结束时间
     */
    public String getEndTime() {
        return endTime;
    }
    /**
     * 
     * @param 结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }
    /**
     * 
     * @return 计算规则
     */
    public String getCalc() {
        return calc;
    }
    /**
     * 
     * @param 计算规则
     */
    public void setCalc(String calc) {
        this.calc = calc == null ? null : calc.trim();
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