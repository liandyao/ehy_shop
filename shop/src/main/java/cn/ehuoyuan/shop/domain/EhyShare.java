package cn.ehuoyuan.shop.domain;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 会员分享产品表的模型
 */
public class EhyShare {
	//分享ID
    private String shaId;
    //明细主键
    private String mxId;
    //评价分享时间
    private String shaDatetime;
    //分享价格
    private BigDecimal shaPrice;
    //出厂价
    private BigDecimal shaFactoryPrice;
    //预计收益
    private BigDecimal shaYield;
    //评价内容
    private String shaRemark;
    //属性评价
    private String shaEval;
    //是否有效
    private Integer isva;
    ///操作时间
    private Date optime;
    //操作人
    private String oper;
    //商品ID
    private String productId;
    //商品名称
    private String productName;
    //排序
    private Integer sort;
    //会员ID
    private String mbId;
    //会员名称
    private String mbName;
    /**
     * 
     * @return 分享ID
     */
    public String getShaId() {
        return shaId;
    }
    /**
     * 
     * @param 分享ID
     */
    public void setShaId(String shaId) {
        this.shaId = shaId == null ? null : shaId.trim();
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
     * @return 评价分享时间
     */
    public String getShaDatetime() {
        return shaDatetime;
    }
    /**
     * 
     * @param 评价分享时间
     */
    public void setShaDatetime(String shaDatetime) {
        this.shaDatetime = shaDatetime == null ? null : shaDatetime.trim();
    }
    /**
     * 
     * @return 分享价格
     */
    public BigDecimal getShaPrice() {
        return shaPrice;
    }
    /**
     * 
     * @param 分享价格
     */
    public void setShaPrice(BigDecimal shaPrice) {
        this.shaPrice = shaPrice;
    }
    /**
     * 
     * @return 出厂价
     */
    public BigDecimal getShaFactoryPrice() {
        return shaFactoryPrice;
    }
    /**
     * 
     * @param 出厂价
     */
    public void setShaFactoryPrice(BigDecimal shaFactoryPrice) {
        this.shaFactoryPrice = shaFactoryPrice;
    }
    /**
     * 
     * @return 预计收益
     */
    public BigDecimal getShaYield() {
        return shaYield;
    }
    /**
     * 
     * @param 预计收益
     */
    public void setShaYield(BigDecimal shaYield) {
        this.shaYield = shaYield;
    }
    /**
     * 
     * @return 评价内容
     */
    public String getShaRemark() {
        return shaRemark;
    }
    /**
     * 
     * @param 评价内容
     */
    public void setShaRemark(String shaRemark) {
        this.shaRemark = shaRemark == null ? null : shaRemark.trim();
    }
    /**
     * 
     * @return 属性评价
     */
    public String getShaEval() {
        return shaEval;
    }
    /**
     * 
     * @param 属性评价
     */
    public void setShaEval(String shaEval) {
        this.shaEval = shaEval == null ? null : shaEval.trim();
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
     * @return 商品ID
     */
    public String getProductId() {
        return productId;
    }
    /**
     * 
     * @param 商品ID
     */
    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }
    /**
     * 
     * @return 商品名称
     */
    public String getProductName() {
        return productName;
    }
    /**
     * 
     * @param 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
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
    /**
     * 
     * @return 会员ID
     */
    public String getMbId() {
        return mbId;
    }
    /**
     * 
     * @param 会员ID
     */
    public void setMbId(String mbId) {
        this.mbId = mbId == null ? null : mbId.trim();
    }
    /**
     * 
     * @return 会员名称
     */
    public String getMbName() {
        return mbName;
    }
    /**
     * 
     * @param 会员名称
     */
    public void setMbName(String mbName) {
        this.mbName = mbName == null ? null : mbName.trim();
    }
}