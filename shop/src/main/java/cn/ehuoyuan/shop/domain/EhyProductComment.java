package cn.ehuoyuan.shop.domain;

import java.util.Date;
/**
 *商品评论表的模型
 */
public class EhyProductComment {
	//商品评论ID
    private String commId;
    //会员主键
    private String mbId;
    //明细主键
    private String mxId;
    //评论时间
    private String commTime;
    //评论内容
    private String commDesc;
    //评价等级
    private String commLevel;
    //上级评论追评
    private String commParentId;
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
     * @return 商品评论ID
     */
    public String getCommId() {
        return commId;
    }
    /**
     * 
     * @param 商品评论ID
     */
    public void setCommId(String commId) {
        this.commId = commId == null ? null : commId.trim();
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
     * @return 明细主键
     */
    public String getMxId() {
        return mxId;
    }
    /**
     * 
     * @param 明细主键
     */
    public void setMxId(String mxId) {
        this.mxId = mxId == null ? null : mxId.trim();
    }
    /**
     * 
     * @return 评论时间
     */
    public String getCommTime() {
        return commTime;
    }
    /**
     * 
     * @param 评论时间
     */
    public void setCommTime(String commTime) {
        this.commTime = commTime == null ? null : commTime.trim();
    }
    /**
     * 
     * @return 评论内容
     */
    public String getCommDesc() {
        return commDesc;
    }
    /**
     * 
     * @param 评论内容
     */
    public void setCommDesc(String commDesc) {
        this.commDesc = commDesc == null ? null : commDesc.trim();
    }
    /**
     * 
     * @return 评价等级
     */
    public String getCommLevel() {
        return commLevel;
    }
    /**
     * 
     * @param 评价等级
     */
    public void setCommLevel(String commLevel) {
        this.commLevel = commLevel == null ? null : commLevel.trim();
    }
    /**
     * 
     * @return 上级评论追评
     */
    public String getCommParentId() {
        return commParentId;
    }
    /**
     * 
     * @param 上级评论追评
     */
    public void setCommParentId(String commParentId) {
        this.commParentId = commParentId == null ? null : commParentId.trim();
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