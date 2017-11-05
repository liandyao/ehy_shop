package cn.ehuoyuan.shop.domain;

import java.math.BigDecimal;
import java.util.Date;
/**
 *	会员等级
 */
public class EhyMemberLevel {
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 4324059101659460956L;
	//等级ID
    private String levelId;
    //等级名称
    private String levelName;
    //消费金额
    private BigDecimal money;
    //优惠比例
    private BigDecimal scale;
    //操作人
    private String oper;
    //操作时间
    private Date optime;
    //是否有效
    private Integer isva;
    //排序
    private Integer sort;
    /**
     * 
     * @return 等级ID
     */
    public String getLevelId() {
        return levelId;
    }
    /**
     * 
     * @param 等级ID
     */
    public void setLevelId(String levelId) {
        this.levelId = levelId == null ? null : levelId.trim();
    }
    /**
     * 
     * @return 等级名称
     */
    public String getLevelName() {
        return levelName;
    }
    /**
     * 
     * @param 等级名称
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }
    /**
     * 
     * @return 消费金额
     */
    public BigDecimal getMoney() {
        return money;
    }
    /**
     * 
     * @param 消费金额
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }
    /**
     * 
     * @return 优惠比例
     */
    public BigDecimal getScale() {
        return scale;
    }
    /**
     * 
     * @param 优惠比例
     */
    public void setScale(BigDecimal scale) {
        this.scale = scale;
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