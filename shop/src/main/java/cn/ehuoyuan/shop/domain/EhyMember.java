package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 会员表的模型类
 */
public class EhyMember implements Serializable{
	
	private static final long serialVersionUID = -9195622851413405412L;
	
	//会员主键
    private String mbId;
    //等级ID
    private String levelId;
    //登录账号
    private String mbLogin;
    //登录密码
    private String mbLoginPwd;
    //支付密码
    private String mbPayPwd;
    //微信号
    private String mbWeixin;
    //QQ号
    private String mbQq;
    //邮箱
    private String mbEmail;
    //会员编码
    private String mbCode;
    //会员姓名
    private String mbName;
    //会员性别
    private String mbSex;
    //会员生日
    private String mbBirthday;
    //身份证号
    private String mbCardid;
    //余额
    private BigDecimal mbBalance;
    //积分
    private Long mbJifen;
    //会员等级
    private Integer mbLevel;
    //会员电话
    private String mbPhone;
    //会员地址
    private String mbAddr;
    //来源分站
    private String mbStation;
    //邀请码
    private String invitationCode;
    //会员头像
    private String mbRemark;
    //备注
    private String mbExp;
    //是否缴纳保证金
    private Integer mbIsbzj;
    //是否有效
    private Integer isva;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
    
    private String mbPhones;
    
    private String mbPayPwds;

    
    private String mbLoginPwds;
    //黄金会员
    private String gold;
    //白银会员
    private String silver;
  
	//普通会员
    private String ordinary;
    
    
    public String getMbPhones() {
  		return mbPhones;
  	}
  	public void setMbPhones(String mbPhones) {
  		this.mbPhones = mbPhones;
  	}
    
  	
  	
  	
  	
    public String getMbPayPwds() {
		return mbPayPwds;
	}
	public void setMbPayPwds(String mbPayPwds) {
		this.mbPayPwds = mbPayPwds;
	}
	public String getMbLoginPwds() {
		return mbLoginPwds;
	}
	public void setMbLoginPwds(String mbLoginPwds) {
		this.mbLoginPwds = mbLoginPwds;
	}
	/**
     * 黄金会员
     * @return
     */
    public String getGold() {
		return gold;
	}
    /**
     * 黄金会员
     * @param gold
     */
	public void setGold(String gold) {
		this.gold = gold;
	}
	/**
	 *  白银会员
	 * @return
	 */
	public String getSilver() {
		return silver;
	}
	/**
	 * 白银会员
	 * @param silver
	 */
	public void setSilver(String silver) {
		this.silver = silver;
	}
	/**
	 * 普通会员
	 * @return
	 */
	public String getOrdinary() {
		return ordinary;
	}
	/**
	 * 普通会员
	 * @param ordinary
	 */
	public void setOrdinary(String ordinary) {
		this.ordinary = ordinary;
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
     * @return 等级ID
     */
    public String getLevelId() {
        return levelId;
    }
    /**
     * 
     * @param 等级ID
     */
    public void setLevelId(String levelId) {
        this.levelId = levelId == null ? null : levelId.trim();
    }
    /**
     * 
     * @return 登录账号
     */
    public String getMbLogin() {
        return mbLogin;
    }
    /**
     * 
     * @param 登录账号
     */
    public void setMbLogin(String mbLogin) {
        this.mbLogin = mbLogin == null ? null : mbLogin.trim();
    }
    /**
     * 
     * @return 登录密码
     */
    public String getMbLoginPwd() {
        return mbLoginPwd;
    }
    /**
     * 
     * @param 登录密码
     */
    public void setMbLoginPwd(String mbLoginPwd) {
        this.mbLoginPwd = mbLoginPwd == null ? null : mbLoginPwd.trim();
    }
    /**
     * 
     * @return 支付密码
     */
    public String getMbPayPwd() {
        return mbPayPwd;
    }
    /**
     * 
     * @param 支付密码
     */
    public void setMbPayPwd(String mbPayPwd) {
        this.mbPayPwd = mbPayPwd == null ? null : mbPayPwd.trim();
    }
    /**
     * 
     * @return 微信号
     */
    public String getMbWeixin() {
        return mbWeixin;
    }
    /**
     * 
     * @param 微信号
     */
    public void setMbWeixin(String mbWeixin) {
        this.mbWeixin = mbWeixin == null ? null : mbWeixin.trim();
    }
    /**
     * 
     * @return QQ
     */
    public String getMbQq() {
        return mbQq;
    }
    /**
     * 
     * @param QQ
     */
    public void setMbQq(String mbQq) {
        this.mbQq = mbQq == null ? null : mbQq.trim();
    }
    /**
     * 
     * @return 邮箱
     */
    public String getMbEmail() {
        return mbEmail;
    }
    /**
     * 
     * @param 邮箱
     */
    public void setMbEmail(String mbEmail) {
        this.mbEmail = mbEmail == null ? null : mbEmail.trim();
    }
    /**
     * 
     * @return 会员编码
     */
    public String getMbCode() {
        return mbCode;
    }
    /**
     * 
     * @param 会员编码
     */
    public void setMbCode(String mbCode) {
        this.mbCode = mbCode == null ? null : mbCode.trim();
    }
    /**
     * 
     * @return 会员姓名
     */
    public String getMbName() {
        return mbName;
    }
    /**
     * 
     * @param 会员姓名
     */
    public void setMbName(String mbName) {
        this.mbName = mbName == null ? null : mbName.trim();
    }
    /**
     * 
     * @return 会员性别
     */
    public String getMbSex() {
        return mbSex;
    }
    /**
     * 
     * @param 会员性别
     */
    public void setMbSex(String mbSex) {
        this.mbSex = mbSex == null ? null : mbSex.trim();
    }
    /**
     * 
     * @return 会员生日
     */
    public String getMbBirthday() {
        return mbBirthday;
    }
    /**
     * 
     * @param 会员生日
     */
    public void setMbBirthday(String mbBirthday) {
        this.mbBirthday = mbBirthday == null ? null : mbBirthday.trim();
    }
    /**
     * 
     * @return 身份证号
     */
    public String getMbCardid() {
        return mbCardid;
    }
    /**
     * 
     * @param 身份证号
     */
    public void setMbCardid(String mbCardid) {
        this.mbCardid = mbCardid == null ? null : mbCardid.trim();
    }
    /**
     * 
     * @return 余额
     */
    public BigDecimal getMbBalance() {
        return mbBalance;
    }
    /**
     * 
     * @param 余额
     */
    public void setMbBalance(BigDecimal mbBalance) {
        this.mbBalance = mbBalance;
    }
    /**
     * 
     * @return 积分
     */
    public Long getMbJifen() {
        return mbJifen;
    }
    /**
     * 
     * @param 积分
     */
    public void setMbJifen(Long mbJifen) {
        this.mbJifen = mbJifen;
    }
    /**
     * 
     * @return 会员等级
     */
    public Integer getMbLevel() {
        return mbLevel;
    }
    /**
     * 
     * @param 会员等级
     */
    public void setMbLevel(Integer mbLevel) {
        this.mbLevel = mbLevel;
    }
    /**
     * 
     * @return 会员电话
     */
    public String getMbPhone() {
        return mbPhone;
    }
    /**
     * 
     * @param 会员电话
     */
    public void setMbPhone(String mbPhone) {
        this.mbPhone = mbPhone == null ? null : mbPhone.trim();
    }
    /**
     * 
     * @return 会员地址
     */
    public String getMbAddr() {
        return mbAddr;
    }
    /**
     * 
     * @param 会员地址
     */
    public void setMbAddr(String mbAddr) {
        this.mbAddr = mbAddr == null ? null : mbAddr.trim();
    }
    /**
     * 
     * @return 来源分站
     */
    public String getMbStation() {
        return mbStation;
    }
    /**
     * 
     * @param 来源分站
     */
    public void setMbStation(String mbStation) {
        this.mbStation = mbStation == null ? null : mbStation.trim();
    }
    /**
     * 
     * @return 邀请码
     */
    public String getInvitationCode() {
        return invitationCode;
    }
    /**
     * 
     * @param 邀请码
     */
    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode == null ? null : invitationCode.trim();
    }
    /**
     * 原备注1改为会员头像
     * @return 会员头像
     */
    public String getMbRemark() {
        return mbRemark;
    }
    /**
     * 原备注1现在改为会员头像
     * @param 会员头像
     */
    public void setMbRemark(String mbRemark) {
        this.mbRemark = mbRemark == null ? null : mbRemark.trim();
    }
    /**
     * 
     * @return 备注
     */
    public String getMbExp() {
        return mbExp;
    }
    /**
     * 
     * @param 备注
     */
    public void setMbExp(String mbExp) {
        this.mbExp = mbExp == null ? null : mbExp.trim();
    }
    /**
     * 
     * @return 是否缴纳保证金
     */
    public Integer getMbIsbzj() {
        return mbIsbzj;
    }
    /**
     * 
     * @param 是否缴纳保证金
     */
    public void setMbIsbzj(Integer mbIsbzj) {
        this.mbIsbzj = mbIsbzj;
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
}