package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 资金结算时间汇总
 */
public class EhyMoneyStat implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3585843706670496505L;
	//汇总ID
    private String msId;
    //站点ID
    private String stId;
    //开始时间
    private String msStartTime;
    //结束时间
    private String msEndTime;
    //年份
    private Integer msYear;
    //统计人
    private String msEmp;
    //统计时间
    private String msDatetime;
    //总金额
    private BigDecimal msMoney;
    //是否结算
    private Integer msIsjs;
    //收款人
    private String msGet;
    //收款方式
    private String msGettype;
    //收款时间
    private String msGettime;
    //是否有效
    private Integer isva;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
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
     * @return 开始时间
     */
    public String getMsStartTime() {
        return msStartTime;
    }	
    /**
     * 
     * @param 开始时间
     */
    public void setMsStartTime(String msStartTime) {
        this.msStartTime = msStartTime == null ? null : msStartTime.trim();
    }
    /**
     * 
     * @return 结束时间
     */
    public String getMsEndTime() {
        return msEndTime;
    }
    /**
     * 
     * @param 结束时间
     */
    public void setMsEndTime(String msEndTime) {
        this.msEndTime = msEndTime == null ? null : msEndTime.trim();
    }
    /**
     * 
     * @return 年份
     */
    public Integer getMsYear() {
        return msYear;
    }
    /**
     * 
     * @param 年份
     */
    public void setMsYear(Integer msYear) {
        this.msYear = msYear;
    }
    /**
     * 
     * @return 统计人
     */
    public String getMsEmp() {
        return msEmp;
    }
    /**
     * 
     * @param 统计人
     */
    public void setMsEmp(String msEmp) {
        this.msEmp = msEmp == null ? null : msEmp.trim();
    }
    /**
     * 
     * @return 统计时间
     */
    public String getMsDatetime() {
        return msDatetime;
    }
    /**
     * 
     * @param 统计时间
     */
    public void setMsDatetime(String msDatetime) {
        this.msDatetime = msDatetime == null ? null : msDatetime.trim();
    }
    /**
     * 
     * @return 总金额
     */
    public BigDecimal getMsMoney() {
        return msMoney;
    }
    /**
     * 
     * @param 总金额
     */
    public void setMsMoney(BigDecimal msMoney) {
        this.msMoney = msMoney;
    }
    /**
     * 
     * @return 是否结算
     */
    public Integer getMsIsjs() {
        return msIsjs;
    }
    /**
     * 
     * @param 是否结算
     */
    public void setMsIsjs(Integer msIsjs) {
        this.msIsjs = msIsjs;
    }
    /**
     * 
     * @return 收款人
     */
    public String getMsGet() {
        return msGet;
    }
    /**
     * 
     * @param 收款人
     */
    public void setMsGet(String msGet) {
        this.msGet = msGet == null ? null : msGet.trim();
    }
    /**
     * 
     * @return 收款方式
     */
    public String getMsGettype() {
        return msGettype;
    }
    /**
     * 
     * @param 收款方式
     */
    public void setMsGettype(String msGettype) {
        this.msGettype = msGettype == null ? null : msGettype.trim();
    }
    /**
     * 
     * @return 收款时间
     */
    public String getMsGettime() {
        return msGettime;
    }
    /**
     * 
     * @param 收款时间
     */
    public void setMsGettime(String msGettime) {
        this.msGettime = msGettime == null ? null : msGettime.trim();
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