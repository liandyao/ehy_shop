/**
 * 
 */
package cn.ehuoyuan.common;

import java.io.Serializable;

/**
 * 消息类
 * @author liandyao
 * @date 2017年9月29日 下午6:16:30
 * @version 1.0
 */
public class EhyMessage implements Serializable{

	private static final long serialVersionUID = -9195622851411405412L;
	
	/**
	 * 操作信息成功
	 */
	public static final String SUCCESS_MES="操作成功！";
	/**
	 * 操作信息失败
	 */
	public static final String ERROR_MES="操作失败！";
	
	/**
	 * 操作成功
	 */
	public static final int SUCCESS=1;
	/**
	 * 操作失败
	 */
	public static final int ERROR = 0;
	

	private String mes; //消息内容
	private int state ; //消息状态
	
	
	public EhyMessage() {
		super();
	}
	public EhyMessage(String mes, int state) {
		super();
		this.mes = mes;
		this.state = state;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
