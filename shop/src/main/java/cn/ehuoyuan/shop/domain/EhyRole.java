package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 角色表的模型
 */
public class EhyRole implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5931610881093003919L;
	//角色ID
    private String roleId;
//    /角色名称
    private String roleName;
    //角色编码
    private String roleCode;
    //角色描述
    private String roleDesc;
    //是否有效
    private Integer isva;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
    /**
     * 
     * @return 角色ID
     */
    public String getRoleId() {
        return roleId;
    }
    /**
     * 
     * @param 角色ID
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
    /**
     * 
     * @return 角色名称
     */
    public String getRoleName() {
        return roleName;
    }
    /**
     * 
     * @param 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
    /**
     * 
     * @return 角色编码
     */
    public String getRoleCode() {
        return roleCode;
    }
    /**
     * 
     * @param 角色编码
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }
    /**
     * 
     * @return 角色描述
     */
    public String getRoleDesc() {
        return roleDesc;
    }
    /**
     * 
     * @param 角色描述
     */
    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
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