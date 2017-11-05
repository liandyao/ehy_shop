package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 产品类型规格
 * @author 欧阳丰
 * @date 2017年10月10日 21:28:20
 * @version 1.1
 */
public class EhyProTypeSpecification implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1167988157088645776L;
	private String ptsId;	//主键ID
    private String typeId;	//产品类型ID
    private String speId;	//规格ID
    private Integer isva;	//是否有效 0无效 1有效
    private Date optime;	//操作时间
    private String oper;	//操作人
    private Integer sort;	//排序
    
    //扩展属性(数据库里没有,相当VO属性)
    private String sptName;	//规格类型名称
    private String spId;	//规格值ID
    private	String spValue;	//规格值
    
    /**
     * 主键ID
     * @return
     */
    public String getPtsId() {
        return ptsId;
    }
    /**
     * 主键ID
     * @param ptsId
     */
    public void setPtsId(String ptsId) {
        this.ptsId = ptsId == null ? null : ptsId.trim();
    }
    /**
     * 产品类型ID
     * @return
     */
    public String getTypeId() {
        return typeId;
    }
    /**
     * 产品类型ID
     * @param typeId
     */
    public void setTypeId(String typeId) {
        this.typeId = typeId == null ? null : typeId.trim();
    }
    /**
     * 规格ID
     * @return
     */
    public String getSpeId() {
        return speId;
    }
    /**
     * 规格ID
     * @param speId
     */
    public void setSpeId(String speId) {
        this.speId = speId == null ? null : speId.trim();
    }
    /**
     * 是否有效 0无效 1有效
     * @return
     */
    public Integer getIsva() {
        return isva;
    }
    /**
     * 是否有效 0无效 1有效
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
	
    
    
    //扩展属性(数据库里没有)
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
	 * 规格值ID
	 * @return
	 */
	public String getSpId() {
		return spId;
	}
	/**
	 * 规格值ID
	 * @param spId
	 */
	public void setSpId(String spId) {
		this.spId = spId;
	}
	/**
	 * 规格值
	 * @return
	 */
	public String getSpValue() {
		return spValue;
	}
	/**
	 * 规格值
	 * @param spValue
	 */
	public void setSpValue(String spValue) {
		this.spValue = spValue;
	}
}