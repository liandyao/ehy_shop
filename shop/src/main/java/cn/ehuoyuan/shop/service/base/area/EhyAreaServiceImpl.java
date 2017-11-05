/**
 * 
 */
package cn.ehuoyuan.shop.service.base.area;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import java.util.List;

import cn.ehuoyuan.shop.action.base.area.AreaVo;
import cn.ehuoyuan.shop.action.base.area.CityVo;
import cn.ehuoyuan.shop.action.base.area.ProvinceVo;
import cn.ehuoyuan.shop.dao.EhyAreaMapper;
import cn.ehuoyuan.shop.domain.EhyArea;

/**
 * 地区service接口
 * @author dong
 * @date 2017年9月29日 上午11:30:10
 * @version 1.0 
 */
@Service
public class EhyAreaServiceImpl implements EhyAreaService{

	@Resource
	private EhyAreaMapper ehyAreaMapper;
	
	
	/**
	 * 查询所有
	 */
	public List<EhyArea> findAll(Map<String, Object> map) {
		List<EhyArea> list=ehyAreaMapper.findAll(map);
		
		return list;
		
	}

	/**
	 * 总行数
	 */
	@Override
	public int findRowCount(Map<String, Object> map) {
		int i=ehyAreaMapper.findRowCount(map);
		return i;
	}

	/**
	 * 删除方法
	 */
	@Override
	public int updateByPrimaryKeySelective(EhyArea record) {
		
		return ehyAreaMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 下拉框查询
	 */
	@Override
	public List<EhyArea> findshow() {
		
		return ehyAreaMapper.findshow();
	}
	

	/**
	 * 增加
	 */
	@Override
	public int insert(EhyArea record) {
		
		return ehyAreaMapper.insert(record);
	}

	/**
	 * 修改
	 */
	@Override
	public int update(EhyArea record) {
		
		return ehyAreaMapper.update(record);
	}

	/**
	 * 根据ID查询
	 */
	@Override
	public EhyArea selectByPrimaryKey(String areaId) {
		
		return ehyAreaMapper.selectByPrimaryKey(areaId);
	}

	@Override
	public List<EhyArea> selectArea(EhyArea record) {
		return ehyAreaMapper.selectArea(record);
	}

	@Override
	public List<EhyArea> selectAreaById(String record) {
		
		List<EhyArea> list=ehyAreaMapper.selectAreaById(record);
		for (EhyArea ehyArea : list) {
			System.out.println(ehyArea.getAreaName()+"----------------------service");
		}
		
		System.out.println("--------------service"+record);
		// TODO Auto-generated method stub
		return list;
	}

	/**
	 * 查询省区
	 */
	@Override
	public List<Map<String, Object>> findProvince() {
		// TODO Auto-generated method stub
		return ehyAreaMapper.findProvince();
	}

	/**
	 * 查询城市
	 */
	@Override
	public List<Map<String, Object>> findCity(String provinceId) {
		// TODO Auto-generated method stub
		return ehyAreaMapper.findCity(provinceId);
	}

	/**
	 * 查询区县
	 */
	@Override
	public List<Map<String, Object>> findArea(String cityId) {
		// TODO Auto-generated method stub
		return ehyAreaMapper.findArea(cityId);
	}




}
