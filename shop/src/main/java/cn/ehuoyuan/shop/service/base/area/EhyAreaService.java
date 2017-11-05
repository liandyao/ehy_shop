/**
 * 
 */
package cn.ehuoyuan.shop.service.base.area;



import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.action.base.area.AreaVo;
import cn.ehuoyuan.shop.action.base.area.CityVo;
import cn.ehuoyuan.shop.action.base.area.ProvinceVo;
import cn.ehuoyuan.shop.domain.EhyArea;

/**
 * 地区service
 * @author dong
 * @date 2017年9月29日 上午11:30:10
 * @version 1.0 
 */
public interface EhyAreaService {
		
	/**
	 * 查询方法
	 * @param area
	 * @return
	 */
	List<EhyArea> findAll(Map<String, Object> map);
	
	/**
	 * 总行数
	 * @return
	 */
	int findRowCount(Map<String, Object> map);
	


	/**
	 * 删除方法
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(EhyArea record);
	
	/**
	 * 下拉框查询
	 * @return
	 */
	 List<EhyArea> findshow();
	 
	 /**
	  * 增加
	  * @param record
	  * @return
	  */
	 int insert(EhyArea record);
	 
	 /**
	  * 修改方法
	  * @param record
	  * @return
	  */
	 int update(EhyArea record);
	 
	 /**
	  * 根据ID查询
	  * @param areaId
	  * @return
	  */
	 EhyArea selectByPrimaryKey(String areaId);
	
	/**
	 * 查询省区倒出到json
	 * @return
	 */
	List<Map<String, Object>> findProvince();
	
	/**
	 * 查询城市导出到json 
	 * @param provinceId
	 * @return
	 */
	List<Map<String, Object>> findCity(String provinceId);
	
	
	/**
	 * 查询区县导出到json
	 * @param cityId
	 * @return
	 */
	List<Map<String, Object>> findArea(String cityId);
	 
	 
	 /**
	  * 收货地址
	  * @param record
	  * @return
	  */
	 List<EhyArea> selectArea(EhyArea record);
	 
	 List<EhyArea> selectAreaById(String record);
}
