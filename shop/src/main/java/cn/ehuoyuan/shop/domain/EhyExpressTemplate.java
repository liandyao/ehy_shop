package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 运费模版表的模型
 */
public class EhyExpressTemplate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -43746727538555854L;
	//模版主键
    private String tempId;
    //模版名称
    private String tempName;
    //快递公司
    private String expressId;
    //运费
    private BigDecimal money;
    //备注
    private String remark;
    //站点ID
    private String stId;
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
     * @return 模版主键
     */
    public String getTempId() {
        return tempId;
    }
    /**
     * 
     * @param 模版主键
     */
    public void setTempId(String tempId) {
        this.tempId = tempId == null ? null : tempId.trim();
    }
    /**
     * 
     * @return 模版名称
     */
    public String getTempName() {
        return tempName;
    }
    /**
     * 
     * @param 模版名称
     */
    public void setTempName(String tempName) {
        this.tempName = tempName == null ? null : tempName.trim();
    }
    /**
     * 
     * @return 快递公司
     */
    public String getExpressId() {
        return expressId;
    }
    /**
     * 
     * @param 快递公司
     */
    public void setExpressId(String expressId) {
        this.expressId = expressId == null ? null : expressId.trim();
    }
    /**
     * 
     * @return 运费
     */
    public BigDecimal getMoney() {
        return money;
    }
    /**
     * 
     * @param 运费
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }
    /**
     * 
     * @return 备注
     */
    public String getRemark() {
        return remark;
    }
    /**
     * 
     * @param 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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