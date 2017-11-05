package cn.ehuoyuan.shop.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 商品展示列表的模型
 */
public class EhyProShow implements Serializable{
	/**
	 *  IO流序列化随机序号
	 */
	private static final long serialVersionUID = -7207989393740858069L;
	//展示ID
    private String showId;
    //产品ID
    private String proId;
    //站点ID
    private String stId;
    //展示序号
    private Integer showOrder;
    //展示类型
    private Integer showType;
    //展示开始时间
    private String showStartTime;
    //展示结束时间
    private String showEndTime;
    //是否展示
    private Integer showIsva;
    //是否有效
    private Integer isva=1;
    //操作时间
    private Date optime;
    //操作人
    private String oper;
    //排序
    private Integer sort;
    /**
     * 
     * @return 展示ID
     */
    public String getShowId() {
        return showId;
    }
    /**
     * 
     * @param 展示ID
     */
    public void setShowId(String showId) {
        this.showId = showId == null ? null : showId.trim();
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
     * @return 展示序号
     */
    public Integer getShowOrder() {
        return showOrder;
    }
    /**
     * 
     * @param 展示序号
     */
    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }
    /**
     * 
     * @return 展示类型
     */
    public Integer getShowType() {
        return showType;
    }
    /**
     * 
     * @param 展示类型
     */
    public void setShowType(Integer showType) {
        this.showType = showType;
    }
    /**
     * 
     * @return 展示开始时间
     */
    public String getShowStartTime() {
        return showStartTime;
    }
    /**
     * 
     * @param 展示开始时间
     */
    public void setShowStartTime(String showStartTime) {
        this.showStartTime = showStartTime == null ? null : showStartTime.trim();
    }
    /**
     * 
     * @return 展示结束时间
     */
    public String getShowEndTime() {
        return showEndTime;
    }
    /**
     * 
     * @param 展示结束时间
     */
    public void setShowEndTime(String showEndTime) {
        this.showEndTime = showEndTime == null ? null : showEndTime.trim();
    }
    /**
     * 
     * @return 是否展示
     */
    public Integer getShowIsva() {
        return showIsva;
    }
    /**
     * 
     * @param 是否展示
     */
    public void setShowIsva(Integer showIsva) {
        this.showIsva = showIsva;
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