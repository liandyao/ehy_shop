/**
 * 
 */
package cn.ehuoyuan.shop.service.order;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.common.CommomUtils;
import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.shop.action.order.vo.OrderVo;
import cn.ehuoyuan.shop.action.order.vo.ProdutVo;
import cn.ehuoyuan.shop.dao.EhyOrderItemMapper;

/**
 * 类的描述：订单service的实现类
 * @author xym
 * @date 2017年10月19日
 * @version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {
	@Resource
	private EhyOrderItemMapper ehyOrderItemMapper;

	/* (non-Javadoc)
	 * @see cn.ehuoyuan.shop.service.order.OrderService#showAll()
	 */
	@Override
	public Map<String, Object> frontShowAll(Map<String, Object> parameter) {
		//新建一个map对象
		Map<String, Object> map =new HashMap<String, Object>();
		//使用当前页数算出起始行数放入参数中
		/*parameter.put("firstRows", parameter.get("curPage")==null?0:(((int)parameter.get("curPage")-1)*10));*/
		//得到会员订单的集合
		List<OrderVo> orderlist=ehyOrderItemMapper.frontShowAll(parameter);
		//循环将所有的订单查出将内部字符串分割成一个对象
		for (Iterator iterator = orderlist.iterator(); iterator.hasNext();) {
			OrderVo orderVo = (OrderVo) iterator.next();
			List<ProdutVo> produtlist=new ArrayList<ProdutVo>();
			//将查询出来的字符串使用","分割成一个数组
			String[] products=orderVo.getProduct().split(",");
			//将分割出来的字符串继续拆分将它包装成一个对象
			for(int i=0;i<products.length;i++){
				ProdutVo produt=new ProdutVo();
				//使用'|'将字符串进行分割因为使用"|"进行分割会出现问题所以使用"\\"进行转义
				String[] strProduct=products[i].split("\\|");
				produt.setProId(strProduct[0]);
				produt.setProName(strProduct[1]);
				produt.setProPhotoPath(strProduct[2]);
				produt.setPayment(strProduct[3]);
				produt.setCost(strProduct[5]);
				produt.setMxNum(strProduct[4]);
				produtlist.add(produt);
				orderVo.setProlist(produtlist);
				//将查询出来的字符串清空
				orderVo.setProduct(null);
			}
		}
		int totalRows=ehyOrderItemMapper.ordersCount(parameter);
		Pages page=new Pages();
		//将当前页数传入
		page.setCurPage(((Pages)parameter.get("page")).getCurPage());
		page.setTotalRows(totalRows);
		map.put("orderList", orderlist);
		map.put("pages", page);
		return map;
	}

	@Override
	public Map<String, Object> backShowAll(Map<String, Object> map, Pages pages, int state) {
		// TODO Auto-generated method stub
		Map<String, Object> hashMap = new HashMap<String, Object>();
		map.put("firstRows", pages.getFirstRows());
		map.put("maxResult", pages.getMaxResult());
		if(state==1){
			hashMap.put("data", ehyOrderItemMapper.overhangShowAll(map));
		}else if(state==2){
			hashMap.put("data", ehyOrderItemMapper.deliveredShowAll(map));
		}else if(state==3){
			hashMap.put("data", ehyOrderItemMapper.receivedShowAll(map));
		}
		hashMap.put("code", 0);
		hashMap.put("count", 10);
		hashMap.put("msg", "");
		return hashMap;
	}

	@Override
	public Map<String, Object> deliveredShowAll(Map<String, Object> map, Pages pages) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> overhangShowAll(Map<String, Object> map, Pages pages) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> receivedShowAll(Map<String, Object> map, Pages pages) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see cn.ehuoyuan.shop.service.order.OrderService#receipt(java.util.Map)
	 */
	@Override
	public EhyMessage receipt(Map<String, Object> map) {
		EhyMessage mes=new EhyMessage();
		//调用方法并取得返回值做比较。执行行数大于0则返回成功消息。否则返回失败消息
		if(ehyOrderItemMapper.receipt(map)>0){
			mes.setMes(EhyMessage.SUCCESS_MES);
			mes.setState(EhyMessage.SUCCESS);
		}else{
			mes.setMes(EhyMessage.ERROR_MES);
			mes.setState(EhyMessage.ERROR);
		}
		return mes;
	}
	
	
}
