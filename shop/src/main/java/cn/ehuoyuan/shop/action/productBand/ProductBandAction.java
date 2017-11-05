/**
 * 
 */
package cn.ehuoyuan.shop.action.productBand;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.ehuoyuan.common.CommomUtils;
import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.FileTools;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhyProductBand;
import cn.ehuoyuan.shop.service.productBand.ProductBandService;

/**
 * 产品品牌的Action
 * @author 欧阳丰
 * @date 2017年10月9日 11:43:20
 * @version 1.1
 */
@Controller
@RequestMapping("/productBand")
public class ProductBandAction {
	//产品品牌接口
	@Resource
	private ProductBandService service;
	
	
	/**
	 * 查询全部
	 * @author 欧阳丰
	 * @date 2017年10月9日 11:43:20
	 * @return 返回产品品牌List集合
	 */
	@ResponseBody
	@RequestMapping("/back/findAll")
	public List<EhyProductBand> findAll(){
		return service.findAll();
	}
	
	/**
	 * 分页查询,搜索查询,
	 * @author 胡鑫
	 * @date 2017年10月9日16:26:18
	 * @return 返回HashMap集合
	 */
	@ResponseBody
	@RequestMapping("/back/findProductBandList")
	public Map<String,Object>findProductBandList(String keyWord,String page,String limit){
		Map<String,Object> map = new HashMap<String,Object>();//创建map集合
		Pages pages = new Pages();//创建分页对象
		pages.setCurPage(Integer.valueOf(page));//当前页数
		pages.setMaxResult(Integer.valueOf(limit));//每页显示的行数
		
		Map<String,Object> map2 = new HashMap<String,Object>();//创建map集合
		map2.put("pages", pages);
		if(Tools.isEmpty(keyWord)){
			map2.put("keyWord", "");
		}else{
			map2.put("keyWord", "%"+keyWord+"%");
		}
		
		List<EhyProductBand>list = service.findProductBandList(map2);//得到品牌信息集合
		int count = service.selectCountProband(map2);//得到总行数
		map.put("code","0");
		map.put("msg","");
		map.put("count", count);
		map.put("data", list);
		return map;
	}
	/**
	 * 增加or修改
	 * @author 胡鑫
	 * @date 2017年10月11日 09:44:12
	 * @return 返回Map集合
	 */
	@ResponseBody
	@RequestMapping("/back/addOrUpdate")
	public Map<String,Object> addOrUpdate(@RequestParam(value = "file",required = false) MultipartFile file,HttpServletRequest request,EhyProductBand productBand){
		System.out.println("进入了addOrUpdate"+productBand.getName());
		
		
		
		String fileName = file.getOriginalFilename();
		/*
		 * 
		 */
		if(fileName!=null && !"".equals(fileName)){
			
//			String uuid = UUID.randomUUID().toString();
//			
//			File targetFile = new File(path,"/"+uuid+".png");
//			if(targetFile.exists()){
//				targetFile.mkdirs();
//			}
//			try {
//				file.transferTo(targetFile);
//			} catch (IllegalStateException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			String path = "band";
			try {
				String dataBasePath = FileTools.saveFile(path, file);
				productBand.setLogo(dataBasePath);
				System.out.println("上传文件执行成功/////////////////////////////////"+dataBasePath);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		int rows = 0;
		if(Tools.isEmpty(productBand.getBandId())){
			rows = service.insertSelective(productBand);
		}else{
			rows = service.updateByPrimaryKeySelective(productBand);
		}
		Map<String,Object> map = new HashMap<String,Object>();
		if(rows>0){
			map.put("state", 1);
			map.put("info", "提交成功");
		}else{
			map.put("state", 0);
			map.put("info", "数据异常!");
		}
		return map;
	}
	/**
	 * 根据id删除该条信息
	 * @author 胡鑫
	 * @date 2017年10月12日16:40:08
	 * @return 返回消息类
	 */
	@ResponseBody
	@RequestMapping("/back/delete")
	public EhyMessage delete(EhyProductBand productBand){
		EhyMessage mes = new EhyMessage();//创建消息类
		productBand.setIsva(CommomUtils.ISVA_NO);//将类型 是否有效设值为 常量无效
		int rows = service.updateByPrimaryKeySelective(productBand);//进行修改方法 返回执行的行数
		if(rows>0){
			mes.setMes("删除成功");
			mes.setState(1);
		}else{
			mes.setMes("数据异常!");
			mes.setState(0);
		}
		return mes;
	}
	
	/**
	 * 显示修改信息
	 * @author 胡鑫
	 * @date 2017年10月12日09:43:43
	 * @return 返回 品牌对象
	 */
	@ResponseBody
	@RequestMapping("/back/showUpdate")
	public EhyProductBand showUpdate(String bandId){
		return service.selectByPrimaryKey(bandId);
	}
}
