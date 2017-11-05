package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 代理人表的模型
 */
public class EhyInvitationCode implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2251088411503388567L;
	//代理人主键
    private String inviId;
    //站点ID
    private String stId;
    //邀请码
    private String code;
    //会员ID
    private String mbId;
    //会员名称
    private String mbName;
    //代理人
    private String invitationMember;
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
     * @return 代理人主键
     */
    public String getInviId() {
        return inviId;
    }
    /**
     * 
     * @param 代理人主键
     */
    public void setInviId(String inviId) {
        this.inviId = inviId == null ? null : inviId.trim();
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
     * @return 邀请码
     */
    public String getCode() {
        return code;
    }
    /**
     * 
     * @param 邀请码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
    /**
     * 
     * @return 会员ID
     */
    public String getMbId() {
        return mbId;
    }
    /**
     * 
     * @param 会员ID
     */
    public void setMbId(String mbId) {
        this.mbId = mbId == null ? null : mbId.trim();
    }
    /***
     * 
     * @return 会员名称
     */
    public String getMbName() {
        return mbName;
    }
    /**
     * 
     * @param 会员名称
     */
    public void setMbName(String mbName) {
        this.mbName = mbName == null ? null : mbName.trim();
    }
    /**
     * 
     * @return 代理人
     */
    public String getInvitationMember() {
        return invitationMember;
    }
    /**
     * 
     * @param 代理人
     */
    public void setInvitationMember(String invitationMember) {
        this.invitationMember = invitationMember == null ? null : invitationMember.trim();
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