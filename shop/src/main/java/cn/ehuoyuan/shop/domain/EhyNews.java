package cn.ehuoyuan.shop.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/***
 * 公告表的模型
 */
public class EhyNews {
	//公告ID
    private String newsId;
    ///公告标题
    private String newsTitle;
    //公告类型
    private String newsType;
    //公告正文
    private String newsContent;
    //公告定时发时间
    private String newsTime;
    //站点标识码
    private String station;
    //是否有效
    private Integer isva;
//    /操作时间
    private Date optime;
    //操作人
    private String oper;
    //排序
    private Integer sort;
    //编辑框内容
    private String content;
    
    
    
    /**
     * 编辑框内容
     * @return
     */
    public String getContent() {
		return content;
	}
    /**
     * 编辑框内容
     * @param content
     */
	public void setContent(String content) {
		this.content = content;
	}
	/**
     * 
     * @return 公告ID
     */
    public String getNewsId() {
        return newsId;
    }
    /**
     * 
     * @param 公告ID
     */
    public void setNewsId(String newsId) {
        this.newsId = newsId == null ? null : newsId.trim();
    }
    /**
     * 
     * @return 公告标题
     */
    public String getNewsTitle() {
        return newsTitle;
    }
    /**
     * 
     * @param 公告标题
     */
    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }
    /**
     * 
     * @return 公告类型
     */
    public String getNewsType() {
        return newsType;
    }
	/**
	 * 
	 * @param 公告类型
	 */
    public void setNewsType(String newsType) {
        this.newsType = newsType == null ? null : newsType.trim();
    }
    /**
     * 
     * @return 公告正文
     */
    public String getNewsContent() {
        return newsContent;
    }
    /**
     * 
     * @param 公告正文
     */
    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent == null ? null : newsContent.trim();
    }
    /**
     * 
     * @return 公告定时发时间
     */
    public String getNewsTime() {
        return newsTime;
    }
    /**
     * 
     * @param 公告定时发时间
     */
    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime == null ? null : newsTime.trim();
    }
    /**
     * 
     * @return 站点标识码
     */
    public String getStation() {
        return station;
    }
    /**
     * 
     * @param 站点标识码
     */
    public void setStation(String station) {
        this.station = station == null ? null : station.trim();
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
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