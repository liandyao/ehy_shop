package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 规格类型的模型
 */
public class EhySpecificationType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6993746173242068042L;
	//规格类型ID
    private String sptId;
    //规格类型名称
    private String sptName;
    //规格说明
    private String sptDes;
    //是否有效
    private Integer isva;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
    //排序
    private Integer sort;
    
    /**
     * 规格值集合 Vo
     *  
     */
    private List<EhySpecification>ehySpecifications;
    
    
    /**
     * 规格值集合 相当于Vo
     * @author 胡鑫
     * @date 2017年10月18日09:43:00
     * @return 返回规格值集合
     */
    public List<EhySpecification> getEhySpecifications() {
		return ehySpecifications;
	}
    /**
     * 规格值
     * @param ehySpecifications 规格值集合
     */
	public void setEhySpecifications(List<EhySpecification> ehySpecifications) {
		this.ehySpecifications = ehySpecifications;
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
     * @return 规格类型名称
     */
    public String getSptName() {
        return sptName;
    }
    /**
     * 
     * @param 规格类型名称
     */
    public void setSptName(String sptName) {
        this.sptName = sptName == null ? null : sptName.trim();
    }
    /**
     * 
     * @return 规格说明
     */
    public String getSptDes() {
        return sptDes;
    }
    /**
     * 
     * @param 规格说明
     */
    public void setSptDes(String sptDes) {
        this.sptDes = sptDes == null ? null : sptDes.trim();
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