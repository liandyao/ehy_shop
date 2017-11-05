package cn.ehuoyuan.shop.action.logs.vo;

import java.util.Date;
/**
 * 类的描述：日志表的模型类Vo
 * @author 罗海兵
 * @date 2017年10月1日
 * @version 1.0
 */
public class EhyLogsVo {
	//日志主键
    private String logsId;
    //操作模块
    private String logsModule;
    //日志明细
    private String logsRemark;
    //操作日期
    private Date logsDatetime;
    //操作人
    private String logsOper;
    //操作代码
    private String logsCode;
    


	public EhyLogsVo() {
		super();
	}
	public EhyLogsVo(String logsModule, String logsRemark, Date logsDatetime, String logsOper, String logsCode) {
		super();
		this.logsModule = logsModule;
		this.logsRemark = logsRemark;
		this.logsDatetime = logsDatetime;
		this.logsOper = logsOper;
		this.logsCode = logsCode;
	}
	/***
     * 
     * @return 日志主键
     */
    public String getLogsId() {
        return logsId;
    }
    /**
     * 
     * @param 日志主键
     */
    public void setLogsId(String logsId) {
        this.logsId = logsId == null ? null : logsId.trim();
    }
    /**
     * 
     * @return 操作模块
     */
    public String getLogsModule() {
        return logsModule;
    }
    /**
     * 
     * @param 操作模块
     */
    public void setLogsModule(String logsModule) {
        this.logsModule = logsModule == null ? null : logsModule.trim();
    }
    /**
     * 
     * @return 日志明细
     */
    public String getLogsRemark() {
        return logsRemark;
    }
    /**
     * 
     * @param 日志明细
     */
    public void setLogsRemark(String logsRemark) {
        this.logsRemark = logsRemark == null ? null : logsRemark.trim();
    }
    /**
     * 
     * @return 操作日期
     */
    public Date getLogsDatetime() {
        return logsDatetime;
    }
    /**
     * 
     * @param 操作日期
     */
    public void setLogsDatetime(Date logsDatetime) {
        this.logsDatetime = logsDatetime;
    }
    /**
     * 
     * @return 操作人
     */
    public String getLogsOper() {
        return logsOper;
    }
    /**
     * 
     * @param 操作人
     */
    public void setLogsOper(String logsOper) {
        this.logsOper = logsOper == null ? null : logsOper.trim();
    }
    /**
     * 
     * @return 操作代码
     */
    public String getLogsCode() {
        return logsCode;
    }
    /**
     * 
     * @param 操作代码
     */
    public void setLogsCode(String logsCode) {
        this.logsCode = logsCode == null ? null : logsCode.trim();
    }
}