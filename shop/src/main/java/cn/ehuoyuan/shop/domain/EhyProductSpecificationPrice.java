package cn.ehuoyuan.shop.domain;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 产品规格价格
 * @author 欧阳丰
 * @date 2017年10月23日08:35:18
 * @update 欧阳丰
 * @updateTime 2017年10月28日16:12:02
 * @updateContent 更改了数据库表，删除了部分属性
 */
public class EhyProductSpecificationPrice {
    private String pspId;			//主键ID
    private String proId;			//产品ID
    private String proName;			//产品名称
    private String pspName;			//组合名称
    private String pspGroupName;	//规格值组合名称 可使用@_@隔开
    private BigDecimal pspPrice;	//规格值组合价格
    private BigDecimal pspFactoryPrice;//规格值组合出厂价
    private Integer isva;			//是否有效
    private Date optime;			//操作时间
    private String oper;			//操作人
    private Integer sort;			//排序
    
    /**
     * 规格值组合出厂价
     * @return
     */
    public BigDecimal getPspFactoryPrice() {
		return pspFactoryPrice;
	}
    /**
     * 规格值组合出厂价
     * @param pspFactoryPrice
     */
	public void setPspFactoryPrice(BigDecimal pspFactoryPrice) {
		this.pspFactoryPrice = pspFactoryPrice;
	}
	/**
     * 主键ID
     * @return
     */
    public String getPspId() {
        return pspId;
    }
    /**
     * 主键ID
     * @param pspId
     */
    public void setPspId(String pspId) {
        this.pspId = pspId == null ? null : pspId.trim();
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
     * 组合名称
     * @return
     */
    public String getPspName() {
        return pspName;
    }
    /**
     * 组合名称
     * @param pspName
     */
    public void setPspName(String pspName) {
        this.pspName = pspName == null ? null : pspName.trim();
    }
    
    /**
     * 规格值组合名称 可使用@_@隔开
     * @return
     */
    public String getPspGroupName() {
        return pspGroupName;
    }
    /**
     * 规格值组合名称 可使用@_@隔开
     * @param pspGroupName
     */
    public void setPspGroupName(String pspGroupName) {
        this.pspGroupName = pspGroupName == null ? null : pspGroupName.trim();
    }
    /**
     * 规格值组合价格
     * @return
     */
    public BigDecimal getPspPrice() {
        return pspPrice;
    }
    /**
     * 规格值组合价格
     * @param pspPrice
     */
    public void setPspPrice(BigDecimal pspPrice) {
        this.pspPrice = pspPrice;
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
}