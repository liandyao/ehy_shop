package cn.ehuoyuan.shop.domain;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 退款单表的模型
 */
public class EhyRefunds {
	//退款单ID
    private String refId;
    //退货单ID
    private String reId;
    //退款单编码
    private String refCode;
    //退款账号
    private String refSendAccount;
    //退款银行
    private String refSendBank;
    //退款金额
    private BigDecimal refSendMoney;
    //备注
    private String refRemark;
    //操作员
    private String refOper;
    //收款人
    private String refReceiver;
    //收款方式微信或者支付宝,银行卡等
    private String refReceiveType;
    //收款账号
    private String refReceiveAccount;
    //收款金额
    private BigDecimal refReceiveMoney;
    //收款银行
    private String refReceiveBank;
    //是否有效
    private Integer isva;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
    /**
     * 
     * @return 退款单ID
     */
    public String getRefId() {
        return refId;
    }
    /**
     * 
     * @param 退款单ID
     */
    public void setRefId(String refId) {
        this.refId = refId == null ? null : refId.trim();
    }
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
     * @return 退款单编码
     */
    public String getRefCode() {
        return refCode;
    }
    /**
     * 
     * @param 退款单编码
     */
    public void setRefCode(String refCode) {
        this.refCode = refCode == null ? null : refCode.trim();
    }
    /**
     * 
     * @return 退款账号
     */
    public String getRefSendAccount() {
        return refSendAccount;
    }
    /**
     * 
     * @param 退款账号
     */
    public void setRefSendAccount(String refSendAccount) {
        this.refSendAccount = refSendAccount == null ? null : refSendAccount.trim();
    }
    /**
     * 
     * @return 退款银行
     */
    public String getRefSendBank() {
        return refSendBank;
    }
    /**
     * 
     * @param 退款银行
     */
    public void setRefSendBank(String refSendBank) {
        this.refSendBank = refSendBank == null ? null : refSendBank.trim();
    }
    /**
     * 
     * @return 退款金额
     */
    public BigDecimal getRefSendMoney() {
        return refSendMoney;
    }
    /**
     * 
     * @param 退款金额
     */
    public void setRefSendMoney(BigDecimal refSendMoney) {
        this.refSendMoney = refSendMoney;
    }
    /**
     * 
     * @return 备注
     */
    public String getRefRemark() {
        return refRemark;
    }
    /**
     * 
     * @param 备注
     */
    public void setRefRemark(String refRemark) {
        this.refRemark = refRemark == null ? null : refRemark.trim();
    }
    /**
     * 
     * @return 操作员
     */
    public String getRefOper() {
        return refOper;
    }
    /**
     * 
     * @param 操作员
     */
    public void setRefOper(String refOper) {
        this.refOper = refOper == null ? null : refOper.trim();
    }
    /**
     * 
     * @return 收款人
     */
    public String getRefReceiver() {
        return refReceiver;
    }
    /**
     * 
     * @param 收款人
     */
    public void setRefReceiver(String refReceiver) {
        this.refReceiver = refReceiver == null ? null : refReceiver.trim();
    }
    /**
     * 
     * @return 收款方式微信或者支付宝,银行卡等
     */
    public String getRefReceiveType() {
        return refReceiveType;
    }
    /**
     * 
     * @param 收款方式微信或者支付宝,银行卡等
     */
    public void setRefReceiveType(String refReceiveType) {
        this.refReceiveType = refReceiveType == null ? null : refReceiveType.trim();
    }
    /**
     * 
     * @return 收款账号
     */
    public String getRefReceiveAccount() {
        return refReceiveAccount;
    }
    /**
     * 
     * @param 收款账号
     */
    public void setRefReceiveAccount(String refReceiveAccount) {
        this.refReceiveAccount = refReceiveAccount == null ? null : refReceiveAccount.trim();
    }
    /**
     * 
     * @return 收款金额
     */
    public BigDecimal getRefReceiveMoney() {
        return refReceiveMoney;
    }
    /**
     * 
     * @param 收款金额
     */
    public void setRefReceiveMoney(BigDecimal refReceiveMoney) {
        this.refReceiveMoney = refReceiveMoney;
    }
    /**
     *  
     * @return 收款银行
     */
    public String getRefReceiveBank() {
        return refReceiveBank;
    }
    /**
     * 
     * @param 收款银行
     */
    public void setRefReceiveBank(String refReceiveBank) {
        this.refReceiveBank = refReceiveBank == null ? null : refReceiveBank.trim();
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