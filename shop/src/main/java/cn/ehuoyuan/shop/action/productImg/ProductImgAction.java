/**
 * 
 */
package cn.ehuoyuan.shop.action.productImg;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.ehuoyuan.common.FileTools;
import cn.ehuoyuan.shop.domain.EhyManager;
import cn.ehuoyuan.shop.domain.EhyProductBand;
import cn.ehuoyuan.shop.domain.EhyProductImg;
import cn.ehuoyuan.shop.service.productImg.ProductImgService;

/**
 * 产品图片action
 * @author 欧阳丰
 * @data 2017年10月10日
 */
@Controller
@RequestMapping("/productImg")
public class ProductImgAction {
	
	@Resource
	ProductImgService service;
	
	/**
     * 根据图片ID修改图片为无效
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年10月18日18:21:15
	 * @version 1.1
     */
	@ResponseBody
	@RequestMapping("/back/updateIsvaByImgId")
	public int updateIsvaByImgId(String imgId){
		return service.updateIsvaByImgId(imgId);
	}
	
	/**
     * 根据图片ID修改图片序号
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年10月18日15:01:47
	 * @version 1.1
     */
	@ResponseBody
	@RequestMapping("/back/updateSortByImgId")
	public int updateSortByImgId(@RequestParam(value = "imgId[]") String[] imgId,@RequestParam(value = "sort[]") Integer[] sort){
		return service.updateSortByImgId(imgId,sort);
	}
	
	/**
     * 根据产品ID和类型ID查询图片
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年10月17日 8:54:24
	 * @version 1.1
     */
	@ResponseBody
	@RequestMapping("/back/findImgByProIdAndImgType")
	public List<EhyProductImg> findImgByProIdAndImgType(String proId,int imgType){
		return service.findImgByProIdAndImgType(proId, imgType);
	}
	
	/**
     * 根据产品ID和类型ID修改图片为无效
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年10月19日10:10:19
	 * @version 1.
     */
	@ResponseBody
	@RequestMapping("/back/updateIsvaByProIdAndImgType")
	public int updateIsvaByProIdAndImgType(String proId,int imgType){
		return service.updateIsvaByProIdAndImgType(proId, imgType);
	}
	
	/**
     * 增加产品图片
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年10月10日 18:28:20
	 * @version 1.1
     */
	@ResponseBody
	@RequestMapping("/back/addProductImg")
	public int addProductImg(@RequestParam(value = "fileList", required = false) MultipartFile file, 
			String proId,Integer imgType,HttpServletRequest request){
		int sort = service.findImgByProIdAndImgTypeSize(proId, imgType)+1;//图片序号
        //保存
		try {
			String path = FileTools.saveFile("product", file);
			 EhyManager manager = (EhyManager) request.getSession().getAttribute("manager");
		        EhyProductImg productImg= new EhyProductImg();
		        productImg.setImgId(UUID.randomUUID()+"");		//产品图片ID
		        productImg.setProId(proId);						//产品ID
		        productImg.setImgPath(path);		//图片地址
		        productImg.setImgType(imgType);					//图片类型
		        productImg.setImgRemark("无");					//图片说名
		        productImg.setIsva(1);							//是否有效
		        productImg.setOptime(new Date());				//操作时间
		        productImg.setOper(manager.getManId());			//操作人
		        productImg.setSort(sort); 							//排序
		        int row = service.insert(productImg);//新增图片
		        return row;
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
       
		
	}
	
	
}
