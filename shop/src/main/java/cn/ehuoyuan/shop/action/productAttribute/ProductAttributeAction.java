/**
 * 
 */
package cn.ehuoyuan.shop.action.productAttribute;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ehuoyuan.common.CommomUtils;
import cn.ehuoyuan.shop.domain.EhyManager;
import cn.ehuoyuan.shop.domain.EhyProduct;
import cn.ehuoyuan.shop.domain.EhyProductAttribute;
import cn.ehuoyuan.shop.service.productAttribute.ProductAttributeService;

/**
 * 产品属性action
 * @author 欧阳丰
 * @data 2017年11月2日10:40:47
 */
@Controller
@RequestMapping("/productAttribute")
public class ProductAttributeAction{
	@Resource
	ProductAttributeService service;//产品属性
	
	/**
	 * 查询某产品的所有属性
	 * @param proId 产品ID
	 * @return 产品属性集合
	 * @date 2017年11月2日10:49:09
	 * @version 1.1
	 */
	@RequestMapping("/back/findAllByProId")
	@ResponseBody
	public List<EhyProductAttribute> findAllByProId(String proId){
		return service.findAllByProId(proId);
	}
	
	/**
	 * 更新产品属性
	 * @param attrList 产品属性集合
	 * @param proId 产品ID
	 * @param proName 产品名称
	 * @param session HttpSession
	 * @return int
	 * @date 2017年11月2日19:10:12
	 * @version 1.1
	 */
	@RequestMapping("/back/addList")
	@ResponseBody
	public int addList(@RequestParam(value = "attrList[]") String[] attrList,String proId,String proName,HttpSession session){
		EhyManager manager = (EhyManager) session.getAttribute("manager");
		List<EhyProductAttribute> list = new ArrayList<EhyProductAttribute>();
		for(int i =0;i<attrList.length;i++){
			EhyProductAttribute attribute = new EhyProductAttribute();
			attribute.setAttrId(UUID.randomUUID()+"");
			attribute.setAttrName(attrList[i].split("@")[0]);
			attribute.setAttrValue(attrList[i].split("@")[1]);
			attribute.setProId(proId);
			attribute.setProName(proName);
			attribute.setOper(manager.getManId());
			attribute.setOptime(new Date());
			attribute.setIsva(CommomUtils.ISVA_YES);
			list.add(attribute);
		}
		return service.addList(list, proId);
	}
}
