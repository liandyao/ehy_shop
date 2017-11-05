package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 商品品牌表的模型
 */
public class EhyProductBand implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5532002015159903061L;
	//商品品牌id
    private String bandId;
    //名称
    private String name;
    //logo
    private String logo;
    //绑定分类
    private String type;
    //排序
    private Integer sort;
//    /操作人
    private String oper;
    //操作时间
    private Date optime;
    //是否有效
    private Integer isva;	
    /**
     * 
     * @return 商品品牌id
     */
    public String getBandId() {
        return bandId;
    }
    /**
     * 
     * @param 商品品牌id
     */
    public void setBandId(String bandId) {
        this.bandId = bandId == null ? null : bandId.trim();
    }
    /**
     * 
     * @return 名称
     */
    public String getName() {
        return name;
    }
    /**
     * 
     * @param 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    /**
     * 
     * @return logo
     */
    public String getLogo() {
        return logo;
    }
    /**
     * 
     * @param logo
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }
    /**
     * 
     * @return 绑定分类
     */
    public String getType() {
        return type;
    }
    /**
     * 
     * @param 绑定分类
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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
}