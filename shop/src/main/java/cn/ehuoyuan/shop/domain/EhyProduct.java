package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 产品表的模型
 */
public class EhyProduct implements Serializable{
	/**
	 * 序列化随机编号
	 */
	private static final long serialVersionUID = -721527824235391201L;
	//产品ID
    private String proId;
    //产品类型
    private String proTypeId;
    //站点ID
    private String stId;
    //品牌
    private String bandId;
    //产品编号
    private String proCode;
    //产品名称
    private String proName;
    //产品规格
    private String proGuige;
    //产品重量
    private Double proWeight;
    //产品材质
    private String proCailiao;
    //出厂价格
    private BigDecimal proFactoryPrice;
    //产品显示价格(元)
    private BigDecimal proPrice;
    //普通会员价格
    private BigDecimal proPrice0;
    //银牌会员价格
    private BigDecimal proPrice1;
    //金牌会员价格
    private BigDecimal proPrice2;
    //产品附件
    private String proFujian;
    //产品保修政策
    private String proLaw;
    //产品描述
    private String proRemark;
    //属性01(运费模板)
    private String proAttr01;
    //属性02
    private String proAttr02;
    //属性03
    private String proAttr03;
    //属性04
    private String proAttr04;
    //属性05
    private String proAttr05;
    //属性06
    private String proAttr06;
    //属性07
    private String proAttr07;
    //属性08
    private String proAttr08;
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
     * @return 产品ID
     */
    public String getProId() {
        return proId;
    }
    /**
     * 
     * @param 产品ID
     */
    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }
    /**
     * 
     * @return 产品类型
     */
    public String getProTypeId() {
        return proTypeId;
    }
    /**
     * 
     * @param 产品类型
     */
    public void setProTypeId(String proTypeId) {
        this.proTypeId = proTypeId == null ? null : proTypeId.trim();
    }
    /**
     * 
     * @return 站点ID
     */
    public String getStId() {
        return stId;
    }
    /**
     * 
     * @param 站点ID
     */
    public void setStId(String stId) {
        this.stId = stId == null ? null : stId.trim();
    }
    /**
     * 
     * @return 品牌
     */ 
    public String getBandId() {
        return bandId;
    }
    /**
     * 
     * @param 品牌
     */
    public void setBandId(String bandId) {
        this.bandId = bandId == null ? null : bandId.trim();
    }	
    /**
     * 
     * @return 产品编号
     */
    public String getProCode() {
        return proCode;
    }
    /**
     * 
     * @param 产品编号
     */
    public void setProCode(String proCode) {
        this.proCode = proCode == null ? null : proCode.trim();
    }
    /**
     * 
     * @return 产品名称
     */
    public String getProName() {
        return proName;
    }
    /**
     * 
     * @param 产品名称
     */
    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }
    /***
     * 
     * @return 产品规格
     */
    public String getProGuige() {
        return proGuige;
    }
    /**
     * 
     * @param 产品规格
     */
    public void setProGuige(String proGuige) {
        this.proGuige = proGuige == null ? null : proGuige.trim();
    }
    /**
     * 
     * @return 产品重量
     */
    public Double getProWeight() {
        return proWeight;
    }
    /**
     * 
     * @param 产品重量
     */
    public void setProWeight(Double proWeight) {
        this.proWeight = proWeight;
    }
    /**
     * 
     * @return 产品材质
     */
    public String getProCailiao() {
        return proCailiao;
    }
    /**
     * 
     * @param 产品材质
     */
    public void setProCailiao(String proCailiao) {
        this.proCailiao = proCailiao == null ? null : proCailiao.trim();
    }
    /**
     * 
     * @return 出厂价格
     */
    public BigDecimal getProFactoryPrice() {
        return proFactoryPrice;
    }
    /**
     * 
     * @param 出厂价格
     */
    public void setProFactoryPrice(BigDecimal proFactoryPrice) {
        this.proFactoryPrice = proFactoryPrice;
    }
    /**
     * 
     * @return 产品显示价格(元)
     */  
    public BigDecimal getProPrice() {
        return proPrice;
    }
    /**
     * 
     * @param 产品显示价格(元)
     */
    public void setProPrice(BigDecimal proPrice) {
        this.proPrice = proPrice;
    }
    /**
     * 
     * @return 普通会员价格
     */
    public BigDecimal getProPrice0() {
        return proPrice0;
    }
    /**
     * 
     * @param 普通会员价格
     */
    public void setProPrice0(BigDecimal proPrice0) {
        this.proPrice0 = proPrice0;
    }
    /**
     * 
     * @return 银牌会员价格
     */
    public BigDecimal getProPrice1() {
        return proPrice1;
    }
    /**
     * 
     * @param 银牌会员价格
     */
    public void setProPrice1(BigDecimal proPrice1) {
        this.proPrice1 = proPrice1;
    }
    /**
     * 
     * @return 金牌会员价格
     */
    public BigDecimal getProPrice2() {
        return proPrice2;
    }
    /**
     * 
     * @param 金牌会员价格
     */
    public void setProPrice2(BigDecimal proPrice2) {
        this.proPrice2 = proPrice2;
    }
    /**
     * 
     * @return 产品附件
     */
    public String getProFujian() {
        return proFujian;
    }
    /**
     * 
     * @param 产品附件
     */
    public void setProFujian(String proFujian) {
        this.proFujian = proFujian == null ? null : proFujian.trim();
    }
    /**
     * 
     * @return 产品保修政策
     */
    public String getProLaw() {
        return proLaw;
    }
    /**
     * 
     * @param 产品保修政策
     */
    public void setProLaw(String proLaw) {
        this.proLaw = proLaw == null ? null : proLaw.trim();
    }
    /**
     * 
     * @return 产品描述
     */
    public String getProRemark() {
        return proRemark;
    }
    /**
     * 
     * @param 产品描述
     */
    public void setProRemark(String proRemark) {
        this.proRemark = proRemark == null ? null : proRemark.trim();
    }
    /**
     * 
     * @return 属性01(运费模板)
     */
    public String getProAttr01() {
        return proAttr01;
    }
    /**
     * 
     * @param 属性01(运费模板)
     */
    public void setProAttr01(String proAttr01) {
        this.proAttr01 = proAttr01 == null ? null : proAttr01.trim();
    }
    /**
     * 
     * @return 属性02
     */
    public String getProAttr02() {
        return proAttr02;
    }
    /**
     * 
     * @param 属性02
     */
    public void setProAttr02(String proAttr02) {
        this.proAttr02 = proAttr02 == null ? null : proAttr02.trim();
    }
    /**
     * 
     * @return 属性03
     */
    public String getProAttr03() {
        return proAttr03;
    }
    /**
     * 
     * @param 属性03
     */
    public void setProAttr03(String proAttr03) {
        this.proAttr03 = proAttr03 == null ? null : proAttr03.trim();
    }
    /**
     * 
     * @return 属性04
     */
    public String getProAttr04() {
        return proAttr04;
    }
    /***
     * 
     * @param 属性04
     */
    public void setProAttr04(String proAttr04) {
        this.proAttr04 = proAttr04 == null ? null : proAttr04.trim();
    }
    /**
     * 
     * @return 属性05
     */
    public String getProAttr05() {
        return proAttr05;
    }
    /**
     * 
     * @param 属性05
     */
    public void setProAttr05(String proAttr05) {
        this.proAttr05 = proAttr05 == null ? null : proAttr05.trim();
    }
    /**
     * 
     * @return 属性06
     */
    public String getProAttr06() {
        return proAttr06;
    }
    /**
     * 
     * @param 属性06
     */
    public void setProAttr06(String proAttr06) {
        this.proAttr06 = proAttr06 == null ? null : proAttr06.trim();
    }
    /**
     * 
     * @return 属性07
     */
    public String getProAttr07() {
        return proAttr07;
    }
    /**
     * 
     * @param 属性07
     */
    public void setProAttr07(String proAttr07) {
        this.proAttr07 = proAttr07 == null ? null : proAttr07.trim();
    }
    /**
     * 
     * @return 属性08
     */
    public String getProAttr08() {
        return proAttr08;
    }
    /**
     * 
     * @param 属性08
     */
    public void setProAttr08(String proAttr08) {
        this.proAttr08 = proAttr08 == null ? null : proAttr08.trim();
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