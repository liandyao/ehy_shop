package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 站点列表的模型
 */
public class EhyStation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5733739552552982478L;
	//站点ID
    private String stId;
    //站点名称
    private String stName;
    //站点编码
    private String stCode;
    //上级站点
    private String stPid;
    //站点类型
    private Integer stType;
    //站点邀请码标识
    private String stFlag;
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
     * @return 站点名称
     */
    public String getStName() {
        return stName;
    }
    /**
     * 
     * @param 站点名称
     */
    public void setStName(String stName) {
        this.stName = stName == null ? null : stName.trim();
    }
    /**
     * 
     * @return 站点编码
     */
    public String getStCode() {
        return stCode;
    }
    /**
     * 
     * @param 站点编码
     */
    public void setStCode(String stCode) {
        this.stCode = stCode == null ? null : stCode.trim();
    }
    /**
     * 
     * @return 上级站点
     */
    public String getStPid() {
        return stPid;
    }
    /**
     * 
     * @param 上级站点
     */
    public void setStPid(String stPid) {
        this.stPid = stPid == null ? null : stPid.trim();
    }
    /**
     * 
     * @return 站点类型
     */
    public Integer getStType() {
        return stType;
    }
    /**
     * 
     * @param 站点类型
     */
    public void setStType(Integer stType) {
        this.stType = stType;
    }
    /**
     * 
     * @return 站点邀请码标识
     */
    public String getStFlag() {
        return stFlag;
    }
    /**
     * 
     * @param 站点邀请码标识
     */
    public void setStFlag(String stFlag) {
        this.stFlag = stFlag == null ? null : stFlag.trim();
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