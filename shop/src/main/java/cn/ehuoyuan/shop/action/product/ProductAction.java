/**
 * 
 */
package cn.ehuoyuan.shop.action.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.ehuoyuan.common.CommomUtils;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhyManager;
import cn.ehuoyuan.shop.domain.EhyProType;
import cn.ehuoyuan.shop.domain.EhyProduct;
import cn.ehuoyuan.shop.domain.EhyProductSpecificationPrice;
import cn.ehuoyuan.shop.domain.EhyProductSpecificationValue;
import cn.ehuoyuan.shop.service.proType.ProTypeService;
import cn.ehuoyuan.shop.service.product.ProductService;
import cn.ehuoyuan.shop.service.productSpecificationPrice.ProductSpecificationPriceService;
import cn.ehuoyuan.shop.service.productSpecificationValue.ProductSpecificationValueService;

/**
 * 产品action
 * @author 欧阳丰
 * @data 2017年10月11日
 */
@Controller
@RequestMapping("/product")
public class ProductAction {
	@Resource
	ProductService productService;
	@Resource
	private ProTypeService proTypeService ;//定义一个产品类型service
	@Resource
	private ProductSpecificationPriceService specificationPriceService ;//定义一个产品规格价格service
	@Resource
	private ProductSpecificationValueService specificationValueService ;//定义一个产品规格service
	/*@Resource
	ProductPriceService productPriceService;*/
	
	/**
	 * 修改产品基本信息
	 * @param str 当前页数
	 * @param limit 显示行数
	 * @param priductData 查询参数
	 * @return 产品集合
	 */
	@RequestMapping("/back/updateInfo")
	@ResponseBody
	public int updateInfo(EhyProduct product,HttpSession session){
		EhyManager manager = (EhyManager) session.getAttribute("manager");

		//出厂价格(分)
		BigDecimal price = new BigDecimal(product.getProFactoryPrice().toString());
		//厂家直销价格(普通会员价格)
		BigDecimal price1 = new BigDecimal("1.2");
		BigDecimal proPrice0 = price.multiply(price1);
		//市场价(产品显示价格)
		BigDecimal price2 = new BigDecimal("1.5");
		BigDecimal proPrice = price.multiply(price2);
		//银牌、金牌会员价
		BigDecimal price3 = new BigDecimal("1.05");
		BigDecimal proPrice1 = price.multiply(price3);
		
		product.setProFactoryPrice(price);//出厂价格(分)
		product.setProPrice(proPrice);//市场价(产品显示价格)
		product.setProPrice0(proPrice0);//厂家直销价格(普通会员价格)
		product.setProPrice1(proPrice1);//银牌会员价格
		product.setProPrice2(proPrice1);//金牌会员价格
		
		product.setOptime(new Date());
		product.setOper(manager.getManId());
		int rows = productService.updateByPrimaryKeySelective(product);
		return rows;
	}
	
	/**
	 * 上架或下架
	 * @param str 当前页数
	 * @param limit 显示行数
	 * @param priductData 查询参数
	 * @return 产品集合
	 */
	@RequestMapping("/back/upOrDown")
	@ResponseBody
	public int upOrDown(String proId,Integer par){
		EhyProduct product = new EhyProduct();
		product.setProId(proId);
		if(par==1){//上架
			product.setIsva(CommomUtils.ISVA_YES);
		}else if(par==2){//下架
			product.setIsva(CommomUtils.ISVA_NO);
		}
		int rows = productService.updateByPrimaryKeySelective(product);
		return rows;
	}
	
	/**
	 * 查询所有产品(包括未上架的)
	 * @param page 当前页数
	 * @param limit 显示行数
	 * @param priductData 查询参数
	 * @param proTypeId 产品类型
	 * @param stId 站点ID
	 * @param isva 是否上架
	 * @param proFactoryPriceMix 最小出厂价
	 * @param proFactoryPriceMax 最大出厂价
	 * @param proPriceMix 最小市场价
	 * @param proPriceMax 最大市场价
	 * @param proPrice0Mix 最小产家直销价
	 * @param proPrice0Max 最大产家直销价
	 * @param proPrice1Mix 最小银、金牌会员价
	 * @param proPrice1Max 最大银、金牌会员价
	 * @return 产品集合
	 */
	@RequestMapping("/back/findAll")
	@ResponseBody
	public Map<String,Object> findAll(int page,int limit,String priductData,String proTypeId,String stId,Integer isva,Double proFactoryPriceMix,Double proFactoryPriceMax,Double proPriceMix,Double proPriceMax,Double proPrice0Mix,Double proPrice0Max,Double proPrice1Mix,Double proPrice1Max){
		Map<String,Object> map = new HashMap<String,Object>();
		//如果最小价格大于最大价格，则交换位置
		if(proFactoryPriceMix!=null && proFactoryPriceMax!=null && proFactoryPriceMix>proFactoryPriceMax){
			map.put("proFactoryPriceMix",new BigDecimal(proFactoryPriceMax.toString()));
			map.put("proFactoryPriceMax",new BigDecimal(proFactoryPriceMix.toString()));
		}else if(proFactoryPriceMix!=null && proFactoryPriceMax!=null && proFactoryPriceMix<proFactoryPriceMax){
			map.put("proFactoryPriceMix",new BigDecimal(proFactoryPriceMix.toString()));
			map.put("proFactoryPriceMax",new BigDecimal(proFactoryPriceMax.toString()));
		}else if(proFactoryPriceMix!=null && proFactoryPriceMax==null){
			map.put("proFactoryPriceMix",new BigDecimal(proFactoryPriceMix.toString()));
		}else if(proFactoryPriceMix==null && proFactoryPriceMax!=null){
			map.put("proFactoryPriceMax",new BigDecimal(proFactoryPriceMax.toString()));
		}
		if(proPriceMix!=null && proPriceMax!=null && proPriceMix>proPriceMax){
			map.put("proPriceMix", new BigDecimal(proPriceMax.toString()));
			map.put("proPriceMax", new BigDecimal(proPriceMix.toString()));
		}else if(proPriceMix!=null && proPriceMax!=null && proPriceMix<proPriceMax){
			map.put("proPriceMix",new BigDecimal(proPriceMix.toString()));
			map.put("proPriceMax",new BigDecimal(proPriceMax.toString()));
		}else if(proPriceMix!=null && proPriceMax==null){
			map.put("proPriceMix",new BigDecimal(proPriceMix.toString()));
		}else if(proPriceMix==null && proPriceMax!=null){
			map.put("proPriceMax",new BigDecimal(proPriceMax.toString()));
		}
		if(proPrice0Mix!=null && proPrice0Max!=null && proPrice0Mix>proPrice0Max){
			map.put("proPrice0Mix", new BigDecimal(proPrice0Max.toString()));
			map.put("proPrice0Max", new BigDecimal(proPrice0Mix.toString()));
		}else if(proPrice0Mix!=null && proPrice0Max!=null && proPrice0Mix<proPrice0Max){
			map.put("proPrice0Mix",new BigDecimal(proPrice0Mix.toString()));
			map.put("proPrice0Max",new BigDecimal(proPrice0Max.toString()));
		}else if(proPrice0Mix!=null && proPrice0Max==null){
			map.put("proPrice0Mix",new BigDecimal(proPrice0Mix.toString()));
		}else if(proPrice0Mix==null && proPrice0Max!=null){
			map.put("proPrice0Max",new BigDecimal(proPrice0Max.toString()));
		}
		if(proPrice1Mix!=null && proPrice1Max!=null && proPrice1Mix>proPrice1Max){
			map.put("proPrice1Mix", new BigDecimal(proPrice1Max.toString()));
			map.put("proPrice1Max", new BigDecimal(proPrice1Mix.toString()));
		}else if(proPrice1Mix!=null && proPrice1Max!=null && proPrice1Mix<proPrice1Max){
			map.put("proPrice0Mix",new BigDecimal(proPrice0Mix.toString()));
			map.put("proPrice0Max",new BigDecimal(proPrice0Max.toString()));
		}else if(proPrice1Mix!=null && proPrice1Max==null){
			map.put("proPrice1Mix",new BigDecimal(proPrice1Mix.toString()));
		}else if(proPrice1Mix==null && proPrice1Max!=null){
			map.put("proPrice1Max",new BigDecimal(proPrice1Max.toString()));
		}
		
		if(!Tools.isEmpty(proTypeId)){
			List<EhyProType> proTypeList = new ArrayList<EhyProType>();
			EhyProType proType = new EhyProType();
			proType.setProTypeId(proTypeId);
			proTypeList.add(proType);
			proTypeService.findAllByPtId(proTypeId,proTypeList);
			map.put("proTypeList", proTypeList);
		}
		map.put("firstRows", limit*(page-1));
		map.put("limit", limit);
		map.put("priductData", priductData);
		map.put("stId", stId);
		map.put("isva", isva);
		
		
		List<EhyProduct> data = productService.findAll(map);
		int count = productService.findAllSize(map);
		
		Map<String,Object> mapResult = new HashMap<String, Object>();
		//layui数据表格需要返回的参数
		map.put("count", count);
		map.put("data", data);
		map.put("code",0);
		map.put("msg", "");
		return map;
	}
	
	/**
	 * 进入到发布产品页面
	 * @return
	 */
	@RequestMapping("/back/releaseProduct")
	public ModelAndView releaseProduct(){
		ModelAndView view = new ModelAndView("back/product/releaseProduct");
		String proId = UUID.randomUUID()+"";//随机生成一个产品id
		return view.addObject("proId", proId);
	}
	
	/**
	 * 进入到修改产品页面
	 * @return
	 */
	@RequestMapping("/back/updateProduct")
	public ModelAndView updateProduct(String proId){
		ModelAndView view = new ModelAndView("back/product/updateProduct");
		Map<String,Object> map = productService.findProductAndBandByProId(proId);
		view.addObject("map", map);
		return view;
	}
	
	/**
	 * 发布产品
	 * @param product 产品实体类
	 * @param addOrUpdate 增加或修改参数
	 * @param session HttpSession
	 * @param guigeRemark 规格值描述
	 * @param spePrice 所有组合规格
	 * @return
	 */
	@RequestMapping("/back/insertSelective")
	@ResponseBody
	public String addOrUpdate(EhyProduct product,@RequestParam(value = "guigeRemark[]") String[] guigeRemark,@RequestParam(value = "spePrice[]") String[] spePrice,String addOrUpdate,HttpSession session){
		EhyManager manager = (EhyManager) session.getAttribute("manager");
		//出厂价格(分)
		BigDecimal price = new BigDecimal(product.getProFactoryPrice().toString());
		//厂家直销价格(普通会员价格)
		BigDecimal price1 = new BigDecimal("1.2");
		BigDecimal proPrice0 = price.multiply(price1);
		//市场价(产品显示价格)
		BigDecimal price2 = new BigDecimal("1.5");
		BigDecimal proPrice = price.multiply(price2);
		//银牌、金牌会员价
		BigDecimal price3 = new BigDecimal("1.05");
		BigDecimal proPrice1 = price.multiply(price3);
		
		product.setProFactoryPrice(price);//出厂价格(分)
		product.setProPrice(proPrice);//市场价(产品显示价格)
		product.setProPrice0(proPrice0);//厂家直销价格(普通会员价格)
		product.setProPrice1(proPrice1);//银牌会员价格
		product.setProPrice2(proPrice1);//金牌会员价格
		product.setIsva(CommomUtils.ISVA_NO);
		product.setOptime(new Date());
		product.setOper(manager.getManId());
		
		if("update".equals(addOrUpdate)){//修改产品信息
			//把该产品的所有规格设为无效
			specificationValueService.updateIsvaByProId(product.getProId());
			//把该产品的所有规格价格设为无效
			specificationPriceService.updateIsvaByProId(product.getProId());
			//修改产品信息
			productService.updateByProId(product);
		}else{//增加产品
			//增加产品表
			productService.insertSelective(product);
		}
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
				spValue.setProId(product.getProId());
				spValue.setSptName(sptName);
				spValue.setSpName(spName);
				spValue.setIsva(CommomUtils.ISVA_YES);
				spValue.setOptime(new Date());
				spValue.setOper(manager.getManId());
				specificationValueService.insertSelective(spValue);
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
				spPice.setProId(product.getProId());
				spPice.setProName(product.getProName());
				spPice.setPspName(pspName);
				spPice.setPspGroupName(pspGroupName);
				spPice.setPspFactoryPrice(pspFactoryPrice);
				spPice.setPspPrice(pspPrice);
				spPice.setIsva(CommomUtils.ISVA_YES);
				spPice.setOper(manager.getManId());
				spPice.setOper(manager.getManId());
				specificationPriceService.insertSelective(spPice);
			}
		}
		
		
		return "操作成功！";
	}
	
	/**
	 * 根据产品id得到产品信息
	 * @param proId 产品id
	 * @return 返回产品类
	 */
	@ResponseBody
	@RequestMapping("/back/findByIdProduct")
	public EhyProduct findByIdProduct(String proId){
		return productService.findByIdProduct(proId);
	}
}
