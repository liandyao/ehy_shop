/**
 * 
 */
package cn.ehuoyuan.shop.action.proTypeSpecification;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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

import cn.ehuoyuan.shop.domain.EhyManager;
import cn.ehuoyuan.shop.domain.EhyProductImg;
import cn.ehuoyuan.shop.domain.EhySpecification;
import cn.ehuoyuan.shop.domain.EhySpecificationType;
import cn.ehuoyuan.shop.service.proTypeSpecification.ProTypeSpecificationService;

/**
 * 产品类型规格action
 * @author 欧阳丰
 * @data 2017年10月10日
 */
@Controller
@RequestMapping("/proTypeSpecification")
public class ProTypeSpecificationAction {
	@Resource
	ProTypeSpecificationService service;
	
	/**
     * 查询该产品类型的所有规格
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年10月11日 9:23:20
	 * @version 1.1
     */
	@ResponseBody
	@RequestMapping("/back/findAll")
	public Map<String, List<String>> findAll(String proTypeId){
		Map<String, List<String>> map = service.findAll(proTypeId);
		return map;
	}
	
	
}
