package cn.ehuoyuan.shop.domain;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 会员收益表的模型
 */
public class EhyMemberYield {
	//收益ID
    private String myId;
    //会员主键
    private String mbId;
    //收益金额
    private BigDecimal myMoney;
    //产生收益时间
    private String myDatatime;
    //是否结算
    private Integer myIsjs;
    //是否有效
    private Integer isva;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
    //受益来源
    private String yieldSource;
    /**
     * 
     * @return 收益ID
     */
    public String getMyId() {
        return myId;
    }
    /**
     * 
     * @param 收益ID
     */
    public void setMyId(String myId) {
        this.myId = myId == null ? null : myId.trim();
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
     * @return 收益金额
     */
    public BigDecimal getMyMoney() {
        return myMoney;
    }
    /**
     * 
     * @param 收益金额
     */
    public void setMyMoney(BigDecimal myMoney) {
        this.myMoney = myMoney;
    }
    /**
     * 
     * @return 产生收益时间
     */
    public String getMyDatatime() {
        return myDatatime;
    }
    /**
     * 
     * @param 产生收益时间
     */
    public void setMyDatatime(String myDatatime) {
        this.myDatatime = myDatatime == null ? null : myDatatime.trim();
    }
    /**
     * 
     * @return 是否结算
     */
    public Integer getMyIsjs() {
        return myIsjs;
    }
    /**
     * 
     * @param 是否结算
     */
    public void setMyIsjs(Integer myIsjs) {
        this.myIsjs = myIsjs;
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
     * @return 受益来源
     */
    public String getYieldSource() {
        return yieldSource;
    }
    /**
     * 
     * @param 受益来源
     */
    public void setYieldSource(String yieldSource) {
        this.yieldSource = yieldSource == null ? null : yieldSource.trim();
    }
}