package cn.ehuoyuan.shop.domain;

import java.io.Serializable;

/**
 * 用户角色表的模型
 */
public class EhyManagerRole implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5203315661197126144L;
	//用户角色主键
    private String mrId;
    //用户ID
    private String manId;
    //角色ID
    private String roleId;
    /**
     * 
     * @return 用户角色主键
     */
    public String getMrId() {
        return mrId;
    }
    /**
     * 
     * @param 用户角色主键
     */
    public void setMrId(String mrId) {
        this.mrId = mrId == null ? null : mrId.trim();
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
}