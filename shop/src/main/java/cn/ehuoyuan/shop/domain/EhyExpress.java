package cn.ehuoyuan.shop.domain;

import java.util.Date;
/**
 * 快递公司的模型类
 */
public class EhyExpress {
	//快递公司的主键id
    private String expreessId;
    //名称
    private String name;
    //编码
    private String code;
    //网址
    private String url;
    //LOGO
    private String logo;
    //是否有效
    private Integer isva;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
    //排序
    private Integer sort;
    /**
     * 
     * @return 快递公司的主键id
     */
    public String getExpreessId() {
        return expreessId;
    }
    /**
     * 
     * @param 快递公司的主键id
     */
    public void setExpreessId(String expreessId) {
        this.expreessId = expreessId == null ? null : expreessId.trim();
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
     * @return 编码
     */ 
    public String getCode() {
        return code;
    }
    /**
     * 
     * @param 编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
    /**
     * 
     * @return 网址
     */
    public String getUrl() {
        return url;
    }
    /**
     * 
     * @param 网址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
    /**
     * 
     * @return LOGO
     */
    public String getLogo() {
        return logo;
    }
    /**
     * 
     * @param LOGO
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
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