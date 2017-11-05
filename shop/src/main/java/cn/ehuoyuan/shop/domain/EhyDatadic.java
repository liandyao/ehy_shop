package cn.ehuoyuan.shop.domain;

import java.util.Date;
/**
 * 数据字典表的模型
 */
public class EhyDatadic {
	//字典id
    private String dicId;
    //字典名称
    private String dicName;
    //字典编码
    private String dicCode;
    //字典备注
    private String dicRemark;
    //是否有效
    private Integer isva;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
    /**
     * 
     * @return 字典id
     */
    public String getDicId() {
        return dicId;
    }
    /**
     * 
     * @param 字典id
     */
    public void setDicId(String dicId) {
        this.dicId = dicId == null ? null : dicId.trim();
    }
    /**
     * 
     * @return 字典名称
     */
    public String getDicName() {
        return dicName;
    }
    /**
     * 
     * @param 字典名称
     */
    public void setDicName(String dicName) {
        this.dicName = dicName == null ? null : dicName.trim();
    }
    /**
     * 
     * @return 字典编码
     */
    public String getDicCode() {
        return dicCode;
    }
    /**
     * 
     * @param 字典编码
     */
    public void setDicCode(String dicCode) {
        this.dicCode = dicCode == null ? null : dicCode.trim();
    }
    /**
     * 
     * @return 字典备注
     */ 
    public String getDicRemark() {
        return dicRemark;
    }
    /**
     * 
     * @param 字典备注
     */
    public void setDicRemark(String dicRemark) {
        this.dicRemark = dicRemark == null ? null : dicRemark.trim();
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