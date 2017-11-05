/**
 * 
 */
package cn.ehuoyuan.shop.service.proTypeSpecification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.dao.EhyProTypeSpecificationMapper;
import cn.ehuoyuan.shop.domain.EhyProTypeSpecification;

/**
 * 产品类型规格service实现接口
 * @author 欧阳丰
 * @data 2017年10月11日
 */
@Service
public class ProTypeSpecificationServiceImpl implements ProTypeSpecificationService{
	@Resource
	EhyProTypeSpecificationMapper dao;
	
	@Override
	public Map<String, List<String>> findAll(String proTypeId) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		List<Map<String, Object>> listMap = dao.findAll(proTypeId);
		
		for(Map<String,Object> mapp:listMap){
			String sptName = (String) mapp.get("SPT_NAME");
			String spName = (String) mapp.get("SP_VALUE");
			String key =sptName;
			String value = spName;
			
			List<String> list = map.get(key);
			if(Tools.isEmpty(list)){
				list = new ArrayList<>(); 
			}
			list.add(value);
			map.put(key, list);
		}
		
		
		/**/
		return map;
	}
	
	
	/**
	 * 判断增加 有值增加 无值不增加
	 * @author 胡鑫
	 * @date 2017年10月14日10:29:17
	 * @param record 传入的规格类型
	 * @return 返回执行的行数
	 */
	@Override
	public int insertSelective(EhyProTypeSpecification record) {
		// TODO Auto-generated method stub
		return dao.insertSelective(record);
	}
	/**判断修改
	 * @author 胡鑫
	 * @date 2017年10月14日10:29:17
	 * @param record 传入的规格类型
	 * @return 返回执行的行数
	 */
	@Override
	public int updateByPrimaryKeySelective(EhyProTypeSpecification record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
