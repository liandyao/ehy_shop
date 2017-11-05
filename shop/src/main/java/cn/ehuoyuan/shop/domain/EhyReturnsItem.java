package cn.ehuoyuan.shop.domain;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 退货项表的模型类
 */
public class EhyReturnsItem {
	//退货项ID
    private String reItemId;
    //退货单ID
    private String reId;
    //明细主键
    private String mxId;
    //退货商品名称(冗余)
    private String productName;
    //退货数量
    private Long reItemNum;	
    //退货单价
    private BigDecimal reItemPrice;
    //退货总额
    private BigDecimal reItemSumMoney;
    //是否有效
    private Integer isva;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
    /**
     * 
     * @return 退货项ID
     */
    public String getReItemId() {
        return reItemId;
    }
    /**
     * 
     * @param 退货项ID
     */
    public void setReItemId(String reItemId) {
        this.reItemId = reItemId == null ? null : reItemId.trim();
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
     * @return 明细主键
     */
    public String getMxId() {
        return mxId;
    }
    /**
     * 
     * @param 明细主键
     */
    public void setMxId(String mxId) {
        this.mxId = mxId == null ? null : mxId.trim();
    }
    /**
     * 
     * @return 退货商品名称(冗余)
     */
    public String getProductName() {
        return productName;
    }
    /**
     * 
     * @param 退货商品名称(冗余)
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }	
    /**
     * 
     * @return 退货数量
     */
    public Long getReItemNum() {
        return reItemNum;
    }
    /**
     * 
     * @param 退货数量
     */
    public void setReItemNum(Long reItemNum) {
        this.reItemNum = reItemNum;
    }
    /**
     * 
     * @return 退货单价
     */
    public BigDecimal getReItemPrice() {
        return reItemPrice;
    }
    /**
     * 
     * @param 退货单价
     */
    public void setReItemPrice(BigDecimal reItemPrice) {
        this.reItemPrice = reItemPrice;
    }
    /**
     * 
     * @return 退货总额
     */
    public BigDecimal getReItemSumMoney() {
        return reItemSumMoney;
    }
    /***
     * 
     * @param 退货总额
     */
    public void setReItemSumMoney(BigDecimal reItemSumMoney) {
        this.reItemSumMoney = reItemSumMoney;
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