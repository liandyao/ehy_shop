package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 产品属性表模型
 * @author 欧阳丰
 * @date 2017年11月2日10:08:39
 */
public class EhyProductAttribute implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2318268235999713283L;
	
	private String attrId;		//属性ID
    private String attrName;	//属性名称
    private String attrValue;	//属性值
    private String proId;		//产品ID
    private String proName;		//产品名称
    private String typeId;		//类型ID
    private String flag;		//标记
    private Integer sort;		//排序
    private String oper;		//操作人
    private Date optime;		//操作时间
    private Integer isva;		//是否有效
    
    /**
     * 属性ID
     * @return
     */
    public String getAttrId() {
        return attrId;
    }
    /**
     * 属性ID
     * @param attrId
     */
    public void setAttrId(String attrId) {
        this.attrId = attrId == null ? null : attrId.trim();
    }
    /**
     * 属性名称
     * @return
     */
    public String getAttrName() {
        return attrName;
    }
    /**
     * 属性名称
     * @param attrName
     */
    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }
    /**
     * 属性值
     * @return
     */
    public String getAttrValue() {
        return attrValue;
    }
    /**
     * 属性值
     * @param attrValue
     */
    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue == null ? null : attrValue.trim();
    }
    /**
     * 产品ID
     * @return
     */
    public String getProId() {
        return proId;
    }
    /**
     * 产品ID
     * @param proId
     */
    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }
    /**
     * 产品名称
     * @return
     */
    public String getProName() {
        return proName;
    }
    /**
     * 产品名称
     * @param proName
     */
    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }
    /**
     * 类型ID
     * @return
     */
    public String getTypeId() {
        return typeId;
    }
    /**
     * 类型ID
     * @param typeId
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }
    /**
     * 标记
     * @return
     */
    public String getFlag() {
        return flag;
    }
    /**
     * 标记
     * @param flag
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }
    /**
     * 排序
     * @return
     */
    public Integer getSort() {
        return sort;
    }
    /**
     * 排序
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    /**
     * 操作人
     * @return
     */
    public String getOper() {
        return oper;
    }
    /**
     * 操作人
     * @param oper
     */
    public void setOper(String oper) {
        this.oper = oper == null ? null : oper.trim();
    }
    /**
     * 操作时间
     * @return
     */
    public Date getOptime() {
        return optime;
    }
    /**
     * 操作时间
     * @param optime
     */
    public void setOptime(Date optime) {
        this.optime = optime;
    }
    /**
     * 是否有效
     * @return
     */
    public Integer getIsva() {
        return isva;
    }
    /**
     * 是否有效
     * @param isva
     */
    public void setIsva(Integer isva) {
        this.isva = isva;
    }
}