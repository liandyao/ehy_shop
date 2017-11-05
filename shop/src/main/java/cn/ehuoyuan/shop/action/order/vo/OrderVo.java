/**
 * 
 */
package cn.ehuoyuan.shop.action.order.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * 类的描述：页面显示的订单模型
 * @author xym
 * @date 2017年10月19日
 * @version 1.0
 */
public class OrderVo {
	//实付金额
	private BigDecimal totalMoney;
	//商品的总数量
	private int totalNum;
	//商品总条数
	private int totalSum;
	//快递单号
	private String expressCode;
	//收货地址
	private String ordAddress;
	//收货人
	private String ordMember;
	//是否分享
	private String isShare;
	//商品模型的字符串
	private String product;
	//订单状态
	private int ordState;
	//下单时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date opTime;
	//订单号
	private String ordCode;
	//站点名称
	private String stName;
	//快递名称
	private String expressName;
	//订单编号
	private String ordId;
	//页面显示的商品模型
	private List<ProdutVo> prolist;
	
	/**
	 * @return 订单编号
	 */
	public String getOrdId() {
		return ordId;
	}
	/**
	 * @param 订单编号
	 */
	public void setOrdId(String ordId) {
		this.ordId = ordId;
	}
	/**
	 * @return 0 已删除 1 申请退货 2 已退货 10 已确认待支付 20 已支付,待发货 30 已发货 40 已签收
	 */
	public int getOrdState() {
		return ordState;
	}
	/**
	 * @param 0 已删除 1 申请退货 2 已退货 10 已确认待支付 20 已支付,待发货 30 已发货 40 已签收
	 */
	public void setOrdState(int ordState) {
		this.ordState = ordState;
	}
	/**
	 * @return 下单时间
	 */
	public Date getOpTime() {
		return opTime;
	}
	/**
	 * @param 下单时间
	 */
	public void setOpTime(Date opTime) {
		this.opTime = opTime;
	}
	/**
	 * @return 订单号
	 */
	public String getOrdCode() {
		return ordCode;
	}
	/**
	 * @param 订单号
	 */
	public void setOrdCode(String ordCode) {
		this.ordCode = ordCode;
	}
	/**
	 * @return 站点名称
	 */
	public String getStName() {
		return stName;
	}
	/**
	 * @param 站点名称
	 */
	public void setStName(String stName) {
		this.stName = stName;
	}
	/**
	 * @return the 快递名称
	 */
	public String getExpressName() {
		return expressName;
	}
	/**
	 * @param 快递名称
	 */
	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}
	/**
	 * @return 商品模型的字符串
	 */
	public String getProduct() {
		return product;
	}
	/**
	 * @param 商品模型的字符串
	 */
	public void setProduct(String product) {
		this.product = product;
	}
	/**
	 * @return 实付金额
	 */
	public BigDecimal getTotalMoney() {
		return totalMoney;
	}
	/**
	 * @param 实付金额
	 */
	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}
	/**
	 * @return 商品的总数量
	 */
	public int getTotalNum() {
		return totalNum;
	}
	/**
	 * @param 商品的总数量
	 */
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	/**
	 * @return 商品总条数
	 */
	public int getTotalSum() {
		return totalSum;
	}
	/**
	 * @param 商品总条数
	 */
	public void setTotalSum(int totalSum) {
		this.totalSum = totalSum;
	}
	/**
	 * @return 快递单号
	 */
	public String getExpressCode() {
		return expressCode;
	}
	/**
	 * @param 快递单号
	 */
	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}
	/**
	 * @return 收货地址
	 */
	public String getOrdAddress() {
		return ordAddress;
	}
	/**
	 * @param 收货地址
	 */
	public void setOrdAddress(String ordAddress) {
		this.ordAddress = ordAddress;
	}
	/**
	 * @return 收货人
	 */
	public String getOrdMember() {
		return ordMember;
	}
	/**
	 * @param 收货人
	 */
	public void setOrdMember(String ordMember) {
		this.ordMember = ordMember;
	}
	/**
	 * @return 是否分享
	 */
	public String getIsShare() {
		return isShare;
	}
	/**
	 * @param 是否分享
	 */
	public void setIsShare(String isShare) {
		this.isShare = isShare;
	}
	/**
	 * @return 页面显示的商品模型
	 */
	public List<ProdutVo> getProlist() {
		return prolist;
	}
	/**
	 * @param 页面显示的商品模型
	 */
	public void setProlist(List<ProdutVo> prolist) {
		this.prolist = prolist;
	}
	
	
}
