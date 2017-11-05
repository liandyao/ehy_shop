/**
 * 
 */
package cn.ehuoyuan.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

 
/**
 * 定义常量类,需要使用的常量在这里取到
 * @author liandyao
 * @date 2017年9月29日 上午11:52:25
 * @version 1.0
 */
public class CommomUtils {
	
	
	/**
	 * 系统配置
	 */
	public static Properties CONF = new Properties();
	
	static{
		try {
			CONF.load(CommomUtils.class.getClassLoader().getResourceAsStream("config/conf.properties"));
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
	
	/**
	 * 分页每页显示条数
	 */
	public final static int PAGES_MAX_RESULT=5; 
	
	/**
	 * 是否有效 有效
	 */
	public final static int ISVA_YES = 1 ;
	
	/**
	 * 是否有效 无效
	 */
	public final static int ISVA_NO = 0;
	
	/**
	 * 订单确认.待付款
	 */
	public final static int STATE_ORDER_OK = 10;
	
	/**
	 * 已付款
	 */
	public final static int STATE_PAY_OK = 20;
	
	/**
	 * 申请退款
	 */
	public final static int STATE_REFUND_REQ = 30;
	
	/**
	 * 退款成功
	 */
	public final static int STATE_REFUND_OK = 40;
	
	/**
	 * 订单中文描述
	 */
	public final static Map<Integer, String> STATE_MAP = new HashMap<Integer, String>();
	static{
		STATE_MAP.put(STATE_ORDER_OK,"已下单未付款");
		STATE_MAP.put(STATE_PAY_OK,"已付款");
		STATE_MAP.put(STATE_REFUND_REQ,"申请退款");
		STATE_MAP.put(STATE_REFUND_OK,"退款成功"); 
	}
	
	/**
	 * 日期格式
	 * yyyy-MM-dd
	 */
	public static SimpleDateFormat SDF_DATE = new SimpleDateFormat("yyyy-MM-dd");
	
	/**
	 * 时间格式
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static SimpleDateFormat SDF_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
