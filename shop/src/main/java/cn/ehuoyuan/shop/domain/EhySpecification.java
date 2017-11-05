package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 规格值的模型类
 */
public class EhySpecification implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8640815591208698159L;
	//规格值ID
    private String spId;
    //规格类型ID
    private String sptId;
    //规格名称
    private String spName;
    //规格值
    private String spValue;
    //是否有效
    private Integer isva;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
    //排序
    private Integer sort;
    
    /**
     * 规格类型
     * 查询需要的属性
     */
    private EhySpecificationType ehySpecificationType;
    
    /**
     * 规格类型
     * @author 胡鑫
     * @date 2017年10月18日09:44:29
     * @return 返回规格类型
     */
    public EhySpecificationType getEhySpecificationType() {
		return ehySpecificationType;
	}
    /**
     * 规格类型
     * @param ehySpecificationType 规格类型
     */
	public void setEhySpecificationType(EhySpecificationType ehySpecificationType) {
		this.ehySpecificationType = ehySpecificationType;
	}
	/**
     * 
     * @return 规格值ID
     */
    public String getSpId() {
        return spId;
    }
    /**
     * 
     * @param 规格值ID
     */
    public void setSpId(String spId) {
        this.spId = spId == null ? null : spId.trim();
    }
    /**
     * 
     * @return 规格类型ID
     */
    public String getSptId() {
        return sptId;
    }
    /**
     * 
     * @param 规格类型ID
     */
    public void setSptId(String sptId) {
        this.sptId = sptId == null ? null : sptId.trim();
    }
    /**
     * 
     * @return 规格名称
     */
    public String getSpName() {
        return spName;
    }
    /**
     * 
     * @param 规格名称
     */
    public void setSpName(String spName) {
        this.spName = spName == null ? null : spName.trim();
    }
    /**
     * 
     * @return 规格值
     */
    public String getSpValue() {
        return spValue;
    }
    /**
     * 
     * @param 规格值
     */
    public void setSpValue(String spValue) {
        this.spValue = spValue == null ? null : spValue.trim();
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