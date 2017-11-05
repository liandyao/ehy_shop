package cn.ehuoyuan.shop.domain;

import java.util.Date;

/**
 * 地区表的模型类
 *
 */
public class EhyArea {
	//地区编号
    private String areaId;
    //地区表地区id自关联外键
    private String parentId;
    //地区名称
    private String areaName;
    //地区编号
    private String areaCode;
    //地区备注
    private String areaRemark;
    //是否有效
    private Integer isva;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
    
    /**
     * 
     * @return 地区编号
     */
    public String getAreaId() {
        return areaId;
    }
    /**
     * 
     * @param 地区编号
     */
    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }
    /**
     * 
     * @return 地区表地区id自关联外键
     */
    public String getParentId() {
        return parentId;
    }
    /**
     * 
     * @param 地区表地区id自关联外键
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }
    /**
     * 
     * @return 地区名称
     */
    public String getAreaName() {
        return areaName;
    }
    /**
     * 
     * @param 地区名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName == null ? null : areaName.trim();
    }
    /**
     * 地区编号
     * @return
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 
     * @param 地区编号
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }
    
    /**
     * 
     * @return 地区备注
     */
    public String getAreaRemark() {
        return areaRemark;
    }
    /**
     * 
     * @param 地区备注
     */
    public void setAreaRemark(String areaRemark) {
        this.areaRemark = areaRemark == null ? null : areaRemark.trim();
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