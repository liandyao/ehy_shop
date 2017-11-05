package cn.ehuoyuan.shop.domain;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 退货单表的模型
 */
public class EhyReturns {
	//退货单ID
    private String reId;
    //退货单编号
    private String reCode;	
    //订单ID
    private String ordId;
    //退货时间
    private String reTime;
    //退货状态
    private Integer reState;
    //收货人
    private String reMember;
    //收货地址
    private String reAddress;
    //收货电话
    private String rePhone;
    //运单号
    private String reExpressCode;
    //快递公司
    private String reExpress;
    //物流费用
    private BigDecimal reXepressMoney;
    //备注
    private String reDesc;
    //是否有效
    private Integer isva;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
    /**
     * 
     * @return 退货单ID
     */
    public String getReId() {
        return reId;
    }
    /**
     * 
     * @param 退货单ID
     */
    public void setReId(String reId) {
        this.reId = reId == null ? null : reId.trim();
    }
    /**
     * 
     * @return 退货单编号
     */
    public String getReCode() {
        return reCode;
    }
    /**
     * 
     * @param 退货单编号
     */
    public void setReCode(String reCode) {
        this.reCode = reCode == null ? null : reCode.trim();
    }
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
     * @return 退货时间
     */
    public String getReTime() {
        return reTime;
    }
    /***
     * 
     * @param 退货时间
     */
    public void setReTime(String reTime) {
        this.reTime = reTime == null ? null : reTime.trim();
    }
    /**
     * 
     * @return 退货状态
     */
    public Integer getReState() {
        return reState;
    }
    /**
     * 
     * @param 退货状态
     */
    public void setReState(Integer reState) {
        this.reState = reState;
    }
    /**
     * 
     * @return 收货人
     */
    public String getReMember() {
        return reMember;
    }
    /**
     * 
     * @param 收货人
     */
    public void setReMember(String reMember) {
        this.reMember = reMember == null ? null : reMember.trim();
    }
    /**
     * 
     * @return 收货地址
     */
    public String getReAddress() {
        return reAddress;
    }
    /**
     * 
     * @param 收货地址
     */
    public void setReAddress(String reAddress) {
        this.reAddress = reAddress == null ? null : reAddress.trim();
    }
    /**
     * 
     * @return 收货电话
     */ 
    public String getRePhone() {
        return rePhone;
    }
    /**
     * 
     * @param 收货电话
     */
    public void setRePhone(String rePhone) {
        this.rePhone = rePhone == null ? null : rePhone.trim();
    }
    /**
     * 
     * @return 运单号
     */
    public String getReExpressCode() {
        return reExpressCode;
    }
    /**
     * 
     * @param 运单号
     */
    public void setReExpressCode(String reExpressCode) {
        this.reExpressCode = reExpressCode == null ? null : reExpressCode.trim();
    }
    /**
     * 
     * @return 快递公司
     */
    public String getReExpress() {
        return reExpress;
    }
    /**
     * 
     * @param 快递公司
     */
    public void setReExpress(String reExpress) {
        this.reExpress = reExpress == null ? null : reExpress.trim();
    }
    /**
     * 
     * @return 物流费用
     */
    public BigDecimal getReXepressMoney() {
        return reXepressMoney;
    }
    /**
     * 
     * @param 物流费用
     */
    public void setReXepressMoney(BigDecimal reXepressMoney) {
        this.reXepressMoney = reXepressMoney;
    }
    /**
     * 
     * @return 备注
     */
    public String getReDesc() {
        return reDesc;
    }
    /**
     * 
     * @param 备注
     */
    public void setReDesc(String reDesc) {
        this.reDesc = reDesc == null ? null : reDesc.trim();
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