package cn.ehuoyuan.shop.domain;

import java.util.Date;
/**
 * 评论或分享图片表的模型类
 */
public class EhyProductCommentImg {
	//图片id
    private String id;
    //商品评论或者分享id
    private String commId;
    //图片地址
    private String path;
    //图片种类暂时无用
    private String type;
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
     * @return 图片id
     */
    public String getId() {
        return id;
    }
    /**
     * 
     * @param 图片id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }
    /**
     * 
     * @return 商品评论或者分享id
     */
    public String getCommId() {
        return commId;
    }
    /**
     * 图片的外键id
     * @param 传入评论id或者分享id
     */
    public void setCommId(String commId) {
        this.commId = commId == null ? null : commId.trim();
    }
    /**
     * 
     * @return 图片地址
     */
    public String getPath() {
        return path;
    }
    /**
     * 
     * @param 图片地址
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }
    /**
     * 
     * @return 图片种类暂时无用
     */
    public String getType() {
        return type;
    }
    /**
     * 
     * @param 图片种类暂时无用
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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
     * @param 操作时间
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}