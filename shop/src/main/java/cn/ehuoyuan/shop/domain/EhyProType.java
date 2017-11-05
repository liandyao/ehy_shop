package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 产品类型表的模型
 */
public class EhyProType implements Serializable{
	private static final long serialVersionUID = -9018908990300514186L;
	//类型主键
    private String proTypeId;
    //父类型
    private String ptId;
    //类型编码
    private String proTypeCode;
    //类型名称
    private String proTypeName;
    //类型描述
    private String proTypeRemark;
    //是否有效
    private Integer isva;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
    //排序
    private Integer sort;
    
    
    /**
     * 扩展属性(数据库里没有,相当VO属性)
     * @author 胡鑫
     * @date 2017年10月16日09:52:20
     */
    private List<EhyProTypeSpecification>proTypeSpecification;//类型规格
    private String typeName;//上级分类名称
    private String typeId;//上级分类id
    
    
    
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	public List<EhyProTypeSpecification> getProTypeSpecification() {
		return proTypeSpecification;
	}
	public void setProTypeSpecification(List<EhyProTypeSpecification> proTypeSpecification) {
		this.proTypeSpecification = proTypeSpecification;
	}
	/**
     * 
     * @return 类型主键
     */
    public String getProTypeId() {
        return proTypeId;
    }
    /**
     * 
     * @param 类型主键
     */
    public void setProTypeId(String proTypeId) {
        this.proTypeId = proTypeId == null ? null : proTypeId.trim();
    }
    /**
     * 
     * @return 父类型
     */
    public String getPtId() {
        return ptId;
    }
    /**
     * 
     * @param 父类型
     */
    public void setPtId(String ptId) {
        this.ptId = ptId == null ? null : ptId.trim();
    }
    /**
     * 
     * @return 类型编码
     */
    public String getProTypeCode() {
        return proTypeCode;
    }
    /**
     * 
     * @param 类型编码
     */
    public void setProTypeCode(String proTypeCode) {
        this.proTypeCode = proTypeCode == null ? null : proTypeCode.trim();
    }
    /**
     * 
     * @return 类型名称
     */
    public String getProTypeName() {
        return proTypeName;
    }
    /**
     * 
     * @param 类型名称
     */
    public void setProTypeName(String proTypeName) {
        this.proTypeName = proTypeName == null ? null : proTypeName.trim();
    }
    /**
     * 
     * @return 类型描述
     */
    public String getProTypeRemark() {
        return proTypeRemark;
    }
    /**
     * 
     * @param 类型描述
     */
    public void setProTypeRemark(String proTypeRemark) {
        this.proTypeRemark = proTypeRemark == null ? null : proTypeRemark.trim();
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