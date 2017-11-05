package cn.ehuoyuan.shop.domain;

import java.util.Date;

/**
 * 会员收货地址表的模型
 */
public class EhyAddress {
	

	private static final long serialVersionUID = -9195622851413405411L;
	//地址ID
    private String addId;
    //会员主键
    private String mbId;
    //省份
    private String addProvince;
    //城市
    private String addCity;
    //县区域
    private String addCounty;
    //详细地址
    private String addAddress;
    //国家
    private String addNation;
    //收货人
    private String addEmp;
    //收货人电话
    private String addPhone;
    //备用电话
    private String addPhone2;
    //备注
    private String addRemark;
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
     * @return 地址ID
     */
    public String getAddId() {
        return addId;
    }
    /**
     * 
     * @param 地址ID
     */
    public void setAddId(String addId) {
        this.addId = addId == null ? null : addId.trim();
    }
    /**
     * 
     * @return 会员主键
     */
    public String getMbId() {
        return mbId;
    }
    /**
     * 
     * @param 会员主键
     */
    public void setMbId(String mbId) {
        this.mbId = mbId == null ? null : mbId.trim();
    }
    /**
     * 
     * @return 省份
     */
    public String getAddProvince() {
        return addProvince;
    }
    /**
     * 
     * @param 省份
     */
    public void setAddProvince(String addProvince) {
        this.addProvince = addProvince == null ? null : addProvince.trim();
    }
    /**
     * 
     * @return 城市
     */
    public String getAddCity() {
        return addCity;
    }
    /**
     * 
     * @param 城市
     */
    public void setAddCity(String addCity) {
        this.addCity = addCity == null ? null : addCity.trim();
    }
    /**
     * 
     * @return 县区域
     */
    public String getAddCounty() {
        return addCounty;
    }
    /**
     * 
     * @param 县区域
     */
    public void setAddCounty(String addCounty) {
        this.addCounty = addCounty == null ? null : addCounty.trim();
    }
    /**
     * 
     * @return 详细地址
     */
    public String getAddAddress() {
        return addAddress;
    }
    /**
     * 
     * @param 详细地址
     */
    public void setAddAddress(String addAddress) {
        this.addAddress = addAddress == null ? null : addAddress.trim();
    }
    /**
     * 
     * @return 国家
     */
    public String getAddNation() {
        return addNation;
    }
    /**
     * 
     * @param 国家
     */
    public void setAddNation(String addNation) {
        this.addNation = addNation == null ? null : addNation.trim();
    }
    /**
     * 
     * @return 收货人
     */
    public String getAddEmp() {
        return addEmp;
    }
    /**
     * 
     * @param 收货人
     */
    public void setAddEmp(String addEmp) {
        this.addEmp = addEmp == null ? null : addEmp.trim();
    }
    /**
     * 
     * @return 收货人电话
     */
    public String getAddPhone() {
        return addPhone;
    }
    /**
     * 
     * @param 收货人电话
     */
    public void setAddPhone(String addPhone) {
        this.addPhone = addPhone == null ? null : addPhone.trim();
    }
    /**
     * 
     * @return 备用电话
     */
    public String getAddPhone2() {
        return addPhone2;
    }
    /**
     * 
     * @param 备用电话
     */
    public void setAddPhone2(String addPhone2) {
        this.addPhone2 = addPhone2 == null ? null : addPhone2.trim();
    }
    /**
     * 
     * @return 备注
     */
    public String getAddRemark() {
        return addRemark;
    }
    /**
     * 
     * @param 备注
     */
    public void setAddRemark(String addRemark) {
        this.addRemark = addRemark == null ? null : addRemark.trim();
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