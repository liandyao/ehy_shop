package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 类的描述：后台登录用户-分站会员表
 * @author 谢一鸣
 * @date 2017年9月28日
 */
public class EhyManager implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3600652763633855904L;
	//用户ID
    private String manId;
    //站点ID
    private String stId;
    //用户账号
    private String manUser;	
    //用户密码
    private String manPwd;
    //用户手机号
    private String manPhone;
    //用户身份证号
    private String manCardid;
    //用户备注
    private String manRemark;
    //是否有效
    private Integer isva;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
    //站点对象
    private EhyStation station;
    //站点名
    private String stName;
    
    public String getStName() {
    	if(station!=null){
    		stName = station.getStName();
    	}
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	/**
     * 
     * @return 用户ID
     */
    public String getManId() {
        return manId;
    }
    /**
     * 
     * @param 用户ID
     */
    public void setManId(String manId) {
        this.manId = manId == null ? null : manId.trim();
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
     * @return 用户账号
     */
    public String getManUser() {
        return manUser;
    }
    /**
     * 
     * @param 用户账号
     */
    public void setManUser(String manUser) {
        this.manUser = manUser == null ? null : manUser.trim();
    }
    /**
     * 
     * @return 用户密码
     */
    public String getManPwd() {
        return manPwd;
    }
    /**
     * 
     * @param 用户密码
     */
    public void setManPwd(String manPwd) {
        this.manPwd = manPwd == null ? null : manPwd.trim();
    }
    /**
     * 
     * @return 用户手机号
     */
    public String getManPhone() {
        return manPhone;
    }
    /**
     * 
     * @param 用户手机号
     */
    public void setManPhone(String manPhone) {
        this.manPhone = manPhone == null ? null : manPhone.trim();
    }
    /**
     * 
     * @return 用户身份证号
     */
    public String getManCardid() {
        return manCardid;
    }
    /**
     * 
     * @param 用户身份证号
     */
    public void setManCardid(String manCardid) {
        this.manCardid = manCardid == null ? null : manCardid.trim();
    }
    /**
     * 
     * @return 用户备注
     */
    public String getManRemark() {
        return manRemark;
    }
    /**
     * 
     * @param 用户备注
     */
    public void setManRemark(String manRemark) {
        this.manRemark = manRemark == null ? null : manRemark.trim();
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
     * @return 站点
     */
	public EhyStation getStation() {
		return station;
	}
	/**
	 * 
	 * @param station 站点
	 */
	public void setStation(EhyStation station) {
		this.station = station;
	}
	@Override
	public String toString() {
		return "EhyManager [manId=" + manId + ", stId=" + stId + ", manUser=" + manUser + ", manPwd=" + manPwd
				+ ", manPhone=" + manPhone + ", manCardid=" + manCardid + ", manRemark=" + manRemark + ", isva=" + isva
				+ ", optime=" + optime + ", oper=" + oper + "]";
	}
    
    
}