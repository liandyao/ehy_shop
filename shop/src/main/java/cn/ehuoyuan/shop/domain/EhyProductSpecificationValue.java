package cn.ehuoyuan.shop.domain;

import java.util.Date;
/**
 * 产品规格价格
 * @author 欧阳丰
 * @date 2017年10月23日08:44:38
 * @update 欧阳丰
 * @updateTime 2017年10月28日16:04:36
 * @updateContent 更改了数据库表，增加了新的属性
 */
public class EhyProductSpecificationValue {
    private String priId;	//主键ID
    private String proId;	//产品ID
    private String sptId;	//规格类型ID
    private String sptName;	//规格类型名称
    private String spName;	//规格值名称
    private String remark;	//规格值备注
    private Integer isva;	//是否有效
    private Date optime;	//操作时间
    private String oper;	//操作人
    
    
    /**
     * 规格类型名称
     * @return
     */
    public String getSptName() {
		return sptName;
	}
    /**
     * 规格类型名称
     * @param sptName
     */
	public void setSptName(String sptName) {
		this.sptName = sptName;
	}
	/**
	 * 规格值备注
	 * @return
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 规格值备注
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
     * 主键ID
     * @return
     */
    public String getPriId() {
        return priId;
    }
    /**
     * 主键ID
     * @param priId
     */
    public void setPriId(String priId) {
        this.priId = priId == null ? null : priId.trim();
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
     * 规格类型ID
     * @return
     */
    public String getSptId() {
        return sptId;
    }
    /**
     * 规格类型ID
     * @param spId
     */
    public void setSptId(String sptId) {
        this.sptId = sptId == null ? null : sptId.trim();
    }
    /**
     * 规格值名称
     * @return
     */
    public String getSpName() {
        return spName;
    }
    /**
     * 规格值名称
     * @param spName
     */
    public void setSpName(String spName) {
        this.spName = spName == null ? null : spName.trim();
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
}