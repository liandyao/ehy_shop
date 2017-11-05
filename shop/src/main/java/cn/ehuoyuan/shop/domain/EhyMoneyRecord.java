package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 资金结算记录表的模型
 */
public class EhyMoneyRecord implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5798006578983245227L;
	//资金结算主键
    private String mrId;
    //明细主键
    private String mxId;
    //汇总ID
    private String msId;
    //结算时间
    private String mrDatetime;
    //结算金额
    private BigDecimal mrMoney;
    ///结算说明
    private String mrRemark;
    //是否有效
    private Integer isva;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
    /**
     * 
     * @return 资金结算主键
     */
    public String getMrId() {
        return mrId;
    }
    /**
     * 
     * @param 资金结算主键
     */
    public void setMrId(String mrId) {
        this.mrId = mrId == null ? null : mrId.trim();
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
     * @return 汇总ID
     */
    public String getMsId() {
        return msId;
    }
    /**
     * 
     * @param 汇总ID
     */
    public void setMsId(String msId) {
        this.msId = msId == null ? null : msId.trim();
    }
    /**
     * 
     * @return 结算时间
     */
    public String getMrDatetime() {
        return mrDatetime;
    }
    /**
     * 
     * @param 结算时间
     */
    public void setMrDatetime(String mrDatetime) {
        this.mrDatetime = mrDatetime == null ? null : mrDatetime.trim();
    }
    /**
     * 
     * @return 结算金额
     */
    public BigDecimal getMrMoney() {
        return mrMoney;
    }
    /**
     * 
     * @param 结算金额
     */
    public void setMrMoney(BigDecimal mrMoney) {
        this.mrMoney = mrMoney;
    }
    /**
     * 
     * @return 结算说明
     */
    public String getMrRemark() {
        return mrRemark;
    }
    /**
     * 
     * @param 结算说明
     */
    public void setMrRemark(String mrRemark) {
        this.mrRemark = mrRemark == null ? null : mrRemark.trim();
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