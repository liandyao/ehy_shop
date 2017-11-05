/**
 * 
 */
package cn.ehuoyuan.shop.action.order.vo;


/**
 * 类的描述：页面显示的订单的商品模型
 * @author xym
 * @date 2017年10月19日
 * @version 1.0
 */
public class ProdutVo {
	//商品编号
	private String proId;
	//商品名称
	private String proName;
	//商品图片
	private String proPhotoPath;
	//商品实际价格
	private String cost;
	//实际付款
	private String payment;
	//订单的数量
	private String mxNum;
	/**
	 * @return 商品实际价格
	 */
	public String getCost() {
		return cost;
	}
	/**
	 * @param 商品实际价格
	 */
	public void setCost(String cost) {
		this.cost = cost;
	}
	/**
	 * @return 实际付款
	 */
	public String getPayment() {
		return payment;
	}
	/**
	 * @param 实际付款
	 */
	public void setPayment(String payment) {
		this.payment = payment;
	}
	/**
	 * @return 订单的数量
	 */
	public String getMxNum() {
		return mxNum;
	}
	/**
	 * @param 订单的数量
	 */
	public void setMxNum(String mxNum) {
		this.mxNum = mxNum;
	}
	/**
	 * @return 商品的编号
	 */
	public String getProId() {
		return proId;
	}
	/**
	 * @param 商品的编号
	 */
	public void setProId(String proId) {
		this.proId = proId;
	}
	/**
	 * @return 商品的名称
	 */
	public String getProName() {
		return proName;
	}
	/**
	 * @param 商品的名称
	 */
	public void setProName(String proName) {
		this.proName = proName;
	}
	/**
	 * @return 商品图片的地址
	 */
	public String getProPhotoPath() {
		return proPhotoPath;
	}
	/**
	 * @param 商品图片的地址
	 */
	public void setProPhotoPath(String proPhotoPath) {
		this.proPhotoPath = proPhotoPath;
	}
	
	
}
