package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 产品图片信息
 */
public class EhyProductImg implements Serializable{
	/**
	 * 序列化编号
	 */
	private static final long serialVersionUID = -5461460933811119498L;
	//图片主键
    private String imgId;
    //产品ID
    private String proId;
    //图片地址
    private String imgPath;
    //图片类型
    private Integer imgType;
    //图片说明
    private String imgRemark;
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
     * @return 图片主键
     */
    public String getImgId() {
        return imgId;
    }
    /**
     * 
     * @param 图片主键
     */
    public void setImgId(String imgId) {
        this.imgId = imgId == null ? null : imgId.trim();
    }
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
     * @return 图片地址
     */
    public String getImgPath() {
        return imgPath;
    }	
    /**
     * 
     * @param 图片地址
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }
    /**
     * 
     * @return 图片类型
     */
    public Integer getImgType() {
        return imgType;
    }
    /**
     * 
     * @param 图片类型
     */
    public void setImgType(Integer imgType) {
        this.imgType = imgType;
    }
    /**
     * 
     * @return 图片说明
     */
    public String getImgRemark() {
        return imgRemark;
    }
    /**
     * 
     * @param 图片说明
     */
    public void setImgRemark(String imgRemark) {
        this.imgRemark = imgRemark == null ? null : imgRemark.trim();
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