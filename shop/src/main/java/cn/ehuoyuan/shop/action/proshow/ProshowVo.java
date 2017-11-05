package cn.ehuoyuan.shop.action.proshow;

import java.util.Set;

import cn.ehuoyuan.common.Tools;

/**
 * 类的描述：产品展示模型
 * @author 罗海兵
 * @dateTime 2017年10月19日 下午2:34:59
 * @version 1.0
 */
public class ProshowVo {
	//产品ID
    private String proId;
	//产品名称
    private String proName;
	//出厂价格
    private String proFactoryPrice;
    //产品显示价格(元)
    private String proPrice;
    
    //图片集合
    private String imgPath;
    
    //图片类型
    private Integer imgType;
    
    //展示ID
    private String showId;
    
    //规格类型ID
    private String sptId;
    //规格类型名称
    private String sptName;
    
    //规格值ID
    private Set<String> spIds;
    //规格值
    private Set<String> spValues;
	
    
	/**  
	 * @return  
	 */
	public Integer getImgType() {
		return imgType;
	}
	/**
	 * @param imgType 
	 */
	public void setImgType(Integer imgType) {
		this.imgType = imgType;
	}
	/**  
	 * @return  
	 */
	public Set<String> getSpIds() {
		return spIds;
	}
	/**
	 * @param spIds 
	 */
	public void setSpIds(Set<String> spIds) {
		this.spIds = spIds;
	}
	/**  
	 * @return  
	 */
	public Set<String> getSpValues() {
		return spValues;
	}
	/**
	 * @param spValues 
	 */
	public void setSpValues(Set<String> spValues) {
		this.spValues = spValues;
	}
	/**  
	 * @return  
	 */
	public String getSptId() {
		return sptId;
	}
	/**
	 * @param sptId 
	 */
	public void setSptId(String sptId) {
		this.sptId = sptId;
	}
	/**  
	 * @return  
	 */
	public String getSptName() {
		return sptName;
	}
	/**
	 * @param sptName 
	 */
	public void setSptName(String sptName) {
		this.sptName = sptName;
	}
	/**  
	 * @return  
	 */
	public String getShowId() {
		return showId;
	}
	/**
	 * @param showId 
	 */
	public void setShowId(String showId) {
		this.showId = showId;
	}
	/**  
	 * @return  
	 */
	public String getImgPath() {
		return imgPath;
	}
	/**
	 * @param imgPath 
	 */
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	/**  
	 * @return  
	 */
	public String getProId() {
		return proId;
	}
	/**
	 * @param proId 
	 */
	public void setProId(String proId) {
		this.proId = proId;
	}
	/**  
	 * @return  
	 */
	public String getProName() {
		return proName;
	}
	/**
	 * @param proName 
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}
	/**  
	 * @return  
	 */
	public String getProFactoryPrice() {
		return Tools.moneyFenToYuan2(proFactoryPrice);
	}
	/**
	 * @param proFactoryPrice 
	 */
	public void setProFactoryPrice(String proFactoryPrice) {
		this.proFactoryPrice = proFactoryPrice;
	}
	/**  
	 * @return  
	 */
	public String getProPrice() {
		return Tools.moneyFenToYuan2(proPrice);
	}
	/**
	 * @param proPrice 
	 */
	public void setProPrice(String proPrice) {
		this.proPrice = proPrice;
	}
    
}
