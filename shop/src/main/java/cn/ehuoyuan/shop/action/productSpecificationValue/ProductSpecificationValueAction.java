/**
 * 
 */
package cn.ehuoyuan.shop.action.productSpecificationValue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ehuoyuan.common.CommomUtils;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhyManager;
import cn.ehuoyuan.shop.domain.EhyProductSpecificationPrice;
import cn.ehuoyuan.shop.domain.EhyProductSpecificationValue;
import cn.ehuoyuan.shop.service.productSpecificationPrice.ProductSpecificationPriceService;
import cn.ehuoyuan.shop.service.productSpecificationValue.ProductSpecificationValueService;

/**
 * 产品规格表action
 * @author 欧阳丰
 * @data 2017年10月28日16:23:08
 */
@Controller
@RequestMapping("/productSpecificationValue")
public class ProductSpecificationValueAction {
	@Resource
	ProductSpecificationValueService valueService;
	@Resource
	ProductSpecificationPriceService priceService;
	
	/**
     * 修改产品的所有规格
     * @param proId 产品ID
     * @param proName 产品名
     * @param guigeRemark 规格值描述
     * @param spePrice 组合规格价格
     * @param session HttpSession
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年10月31日16:00:50
	 * @version 1.1
     */
	@ResponseBody
	@RequestMapping("/back/updateValueAndPrice")
	public int updateValueAndPrice(String proId,String proName,@RequestParam(value = "guigeRemark[]") String[] guigeRemark,@RequestParam(value = "spePrice[]") String[] spePrice,HttpSession session){
		EhyManager manager = (EhyManager) session.getAttribute("manager");
		//把该产品的所有规格设为无效
		valueService.updateIsvaByProId(proId);
		//把该产品的所有规格价格设为无效
		priceService.updateIsvaByProId(proId);
		if(!guigeRemark[0].equals("null")){
			//增加产品规格表
			for(int i =0;i<guigeRemark.length;i++){
				EhyProductSpecificationValue spValue = new EhyProductSpecificationValue();
				String sptName = guigeRemark[i].split("@")[0];//规格类型名称
				String spName = guigeRemark[i].split("@")[1];//规格值名称
				if(guigeRemark[i].split("@").length==3){
					String remark = guigeRemark[i].split("@")[2];//规格值描述
					spValue.setRemark(remark);
				}
				spValue.setPriId(UUID.randomUUID()+"");
				spValue.setProId(proId);
				spValue.setSptName(sptName);
				spValue.setSpName(spName);
				spValue.setIsva(CommomUtils.ISVA_YES);
				spValue.setOptime(new Date());
				spValue.setOper(manager.getManId());
				valueService.insertSelective(spValue);
			}
		}
		
		if(!spePrice[0].equals("null")){
			//增加产品规格价格表
			for(int i = 0;i<spePrice.length;i++){
				EhyProductSpecificationPrice spPice = new EhyProductSpecificationPrice();
				int size = spePrice[i].split("@").length;
				String pspGroupName ="";//规格值名称
				for(int j=0;j<size-3;j++){
					if("".equals(pspGroupName)){
						pspGroupName=spePrice[i].split("@")[j];
					}else{
						pspGroupName+="@"+spePrice[i].split("@")[j];
					}
				}
				String pspName = spePrice[i].split("@")[size-1];//组合名称
				BigDecimal pspFactoryPrice = new BigDecimal(Tools.moneyYuanToFen(spePrice[i].split("@")[size-2]));//出厂价格
				BigDecimal pspPrice = new BigDecimal(Tools.moneyYuanToFen(spePrice[i].split("@")[size-3]));//厂家直销价
				
				spPice.setPspId(UUID.randomUUID()+"");
				spPice.setProId(proId);
				spPice.setProName(proName);
				spPice.setPspName(pspName);
				spPice.setPspGroupName(pspGroupName);
				spPice.setPspFactoryPrice(pspFactoryPrice);
				spPice.setPspPrice(pspPrice);
				spPice.setIsva(CommomUtils.ISVA_YES);
				spPice.setOper(manager.getManId());
				priceService.insertSelective(spPice);
			}
		}
		return 1;
	}
	
	/**
     * 查询产品的所有规格
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年10月31日16:00:50
	 * @version 1.1
     */
	@ResponseBody
	@RequestMapping("/back/findAllByProId")
	public Map<String,Object> findAll(String proId){
		List<EhyProductSpecificationValue> valueList = valueService.findAllByProId(proId);
		Map<String, List<String>> valueMap = new HashMap<String, List<String>>();
		for (Iterator iterator = valueList.iterator(); iterator.hasNext();) {
			EhyProductSpecificationValue ehyProductSpecificationValue = (EhyProductSpecificationValue) iterator.next();
			String key = ehyProductSpecificationValue.getSptName();
			String value = ehyProductSpecificationValue.getSpName()+"@"+ehyProductSpecificationValue.getRemark();
			
			List<String> list = valueMap.get(key);
			if(Tools.isEmpty(list)){
				list = new ArrayList<String>();
			}
			list.add(value);
			valueMap.put(key, list);
		}
		
		
		List<EhyProductSpecificationPrice> priceList = priceService.findAllByProId(proId);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("valueMap", valueMap);
		map.put("priceList", priceList);
		return map;
	}
}
