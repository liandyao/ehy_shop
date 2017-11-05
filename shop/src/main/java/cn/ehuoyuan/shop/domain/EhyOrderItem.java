package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 订单明细表的模型
 */
public class EhyOrderItem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4436059101659460956L;
	//明细主键
    private String mxId;
    //订单号冗余
    private String ordCode;
    //批量结算单号
    private String mxBatchNo;
    //下单时间
    private String mxDatetime;
    //数量
    private Integer mxNum;
    //价格
    private BigDecimal mxPrice;
    //总金额
    private BigDecimal mxMoney;
    //实际付款金额
    private BigDecimal mxMoneyFact;
    //折扣
    private BigDecimal mxLi;
    //备注
    private String mxRemark;
    //会员id
    private String mbId;
    //会员名称
    private String mbName;
    //订单ID
    private String ordId;
    //产品ID
    private String proId;
    //是否结算
    private Integer mxIsjs;
    //结算时间
    private Date mxJstime;
    //结算人
    private String mxEmp;
    //是否有效
    private Integer isva;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
    //是否汇总
    private Integer isStat;
    //分享ID
    private String shareId;
    //快递公司
    private String ordExpress;
    //快递单号
    private String ordExpressCode;
    //订单状态
    private Integer ordState;
    //运费
    private String ordFreight;
    //站点ID
    private String stId;
    //站点名称
    private String stName;
    //商品名称
    private String proName;
    //资金结算ID
    private String mrId;
    /**
     * 
     * @return 资金结算ID
     */
    public String getMrId() {
		return mrId;
	}
    /**
     * 
     * @param mrId 资金结算ID
     */
	public void setMrId(String mrId) {
		this.mrId = mrId;
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
     * @return 销售单号,每个商品对应一个订单号
     */
    public String getOrdCode() {
        return ordCode;
    }
    /**
     * 
     * @param 销售单号,每个商品对应一个订单号
     */
    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode == null ? null : ordCode.trim();
    }
    /**
     * 
     * @return 批量结算单号,买家加入购物车批量结算时,此处生成一个结算单号
     */
    public String getMxBatchNo() {
        return mxBatchNo;
    }
    /**
     * 
     * @param 批量结算单号,买家加入购物车批量结算时,此处生成一个结算单号
     */
    public void setMxBatchNo(String mxBatchNo) {
        this.mxBatchNo = mxBatchNo == null ? null : mxBatchNo.trim();
    }
    /**
     * 
     * @return 下单时间
     */
    public String getMxDatetime() {
        return mxDatetime;
    }
    /**
     * 
     * @param 下单时间
     */
    public void setMxDatetime(String mxDatetime) {
        this.mxDatetime = mxDatetime == null ? null : mxDatetime.trim();
    }
    /**
     * 
     * @return 数量
     */
    public Integer getMxNum() {
        return mxNum;
    }
    /**
     * 
     * @param 数量
     */
    public void setMxNum(Integer mxNum) {
        this.mxNum = mxNum;
    }
    /**
     * 
     * @return 购买价格
     */
    public BigDecimal getMxPrice() {
        return mxPrice;
    }
    /**
     * 
     * @param 购买价格
     */
    public void setMxPrice(BigDecimal mxPrice) {
        this.mxPrice = mxPrice;
    }
    /**
     * 
     * @return 总金额
     */
    public BigDecimal getMxMoney() {
        return mxMoney;
    }
    /**
     * 
     * @param 总金额
     */
    public void setMxMoney(BigDecimal mxMoney) {
        this.mxMoney = mxMoney;
    }
    /**
     * 
     * @return 实际付款金额
     */
    public BigDecimal getMxMoneyFact() {
        return mxMoneyFact;
    }
    /**
     * 
     * @param 实际付款金额
     */
    public void setMxMoneyFact(BigDecimal mxMoneyFact) {
        this.mxMoneyFact = mxMoneyFact;
    }
    /**
     * 
     * @return 折扣
     */
    public BigDecimal getMxLi() {
        return mxLi;
    }
    /**
     * 
     * @param 折扣
     */
    public void setMxLi(BigDecimal mxLi) {
        this.mxLi = mxLi;
    }
    /**
     * 
     * @return 备注
     */
    public String getMxRemark() {
        return mxRemark;
    }
    /**
     * 
     * @param 备注
     */
    public void setMxRemark(String mxRemark) {
        this.mxRemark = mxRemark == null ? null : mxRemark.trim();
    }
    /**
     * 
     * @return 会员id
     */
    public String getMbId() {
        return mbId;
    }
    /**
     * 
     * @param 会员id
     */
    public void setMbId(String mbId) {
        this.mbId = mbId == null ? null : mbId.trim();
    }
    /**
     * 
     * @return 会员名称,冗余
     */
    public String getMbName() {
        return mbName;
    }
    /**
     * 
     * @param 会员名称,冗余
     */
    public void setMbName(String mbName) {
        this.mbName = mbName == null ? null : mbName.trim();
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
     * @return 是否结算0 否 1 是
     */
    public Integer getMxIsjs() {
        return mxIsjs;
    }
    /**
     * 
     * @param 是否结算0 否 1 是
     */
    public void setMxIsjs(Integer mxIsjs) {
        this.mxIsjs = mxIsjs;
    }
    /**
     * 
     * @return 结算时间
     */
    public Date getMxJstime() {
        return mxJstime;
    }
    /**
     * 
     * @param 结算时间
     */
    public void setMxJstime(Date mxJstime) {
        this.mxJstime = mxJstime;
    }
    /**
     * 
     * @return 结算人
     */
    public String getMxEmp() {
        return mxEmp;
    }
    /**
     * 
     * @param 结算人
     */
    public void setMxEmp(String mxEmp) {
        this.mxEmp = mxEmp == null ? null : mxEmp.trim();
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
     * @return 是否汇总0 未汇总 1 已汇总
     */
    public Integer getIsStat() {
        return isStat;
    }
    /**
     * 
     * @param 是否汇总0 未汇总 1 已汇总
     */
    public void setIsStat(Integer isStat) {
        this.isStat = isStat;
    }
    /**
     * 
     * @return 如果有值,则说明是其他会员分享,无值则说明是自己购买
     */
    public String getShareId() {
        return shareId;
    }
    /**
     * 
     * @param 如果有值,则说明是其他会员分享,无值则说明是自己购买
     */
    public void setShareId(String shareId) {
        this.shareId = shareId == null ? null : shareId.trim();
    }
    /**
     * 
     * @return 快递公司取快递表
     */
    public String getOrdExpress() {
        return ordExpress;
    }
    /**
     * 
     * @param 快递公司取快递表
     */
    public void setOrdExpress(String ordExpress) {
        this.ordExpress = ordExpress == null ? null : ordExpress.trim();
    }
    /**
     * 
     * @return 快递单号
     */
    public String getOrdExpressCode() {
        return ordExpressCode;
    }
    /**
     * 
     * @param 快递单号
     */
    public void setOrdExpressCode(String ordExpressCode) {
        this.ordExpressCode = ordExpressCode == null ? null : ordExpressCode.trim();
    }
    /**
     * 
     * @return 0   已删除 1  申请退货 2  已退货 10 已确认待支付 20 已支付,待发货 30 已发货 40 已签收
     */
    public Integer getOrdState() {
        return ordState;
    }
    /***
     * 
     * @param 0   已删除 1  申请退货 2  已退货 10 已确认待支付 20 已支付,待发货 30 已发货 40 已签收
     */
    public void setOrdState(Integer ordState) {
        this.ordState = ordState;
    }
    /**
     * 
     * @return 运费
     */
    public String getOrdFreight() {
        return ordFreight;
    }
    /**
     * 
     * @param 运费
     */
    public void setOrdFreight(String ordFreight) {
        this.ordFreight = ordFreight == null ? null : ordFreight.trim();
    }
    /***
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
     * @return 商品名称
     */
    public String getProName() {
        return proName;
    }
    /**
     * 
     * @param 商品名称
     */
    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }
}