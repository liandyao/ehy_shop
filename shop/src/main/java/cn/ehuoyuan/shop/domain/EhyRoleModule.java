package cn.ehuoyuan.shop.domain;

import java.io.Serializable;

/**
 * 模块角色表
 */
public class EhyRoleModule implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2686462838590252876L;
	//主键
    private String rmId;
    //模块ID
    private String modId;
    //角色ID
    private String roleId;
    /**
     * 
     * @return 主键
     */
    public String getRmId() {
        return rmId;
    }
    /**
     * 
     * @param 主键
     */
    public void setRmId(String rmId) {
        this.rmId = rmId == null ? null : rmId.trim();
    }
    /**
     * 
     * @return 模块ID
     */
    public String getModId() {
        return modId;
    }
    /**
     * 
     * @param 模块ID
     */
    public void setModId(String modId) {
        this.modId = modId == null ? null : modId.trim();
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