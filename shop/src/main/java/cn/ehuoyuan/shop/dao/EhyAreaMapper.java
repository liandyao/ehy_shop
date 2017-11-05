package cn.ehuoyuan.shop.dao;


import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.action.base.area.AreaVo;
import cn.ehuoyuan.shop.action.base.area.CityVo;
import cn.ehuoyuan.shop.action.base.area.ProvinceVo;
import cn.ehuoyuan.shop.domain.EhyArea;

public interface EhyAreaMapper {
    int deleteByPrimaryKey(String areaId);
    //增加
   int insert(EhyArea record);

    int insertSelective(EhyArea record);
    //根据ID查询
    EhyArea selectByPrimaryKey(String areaId);
    //删除方法
    int updateByPrimaryKeySelective(EhyArea record);
    //下拉框查询
    List<EhyArea> findshow();
  //修改方法
    int update(EhyArea record);
    
    int updateByPrimaryKey(EhyArea record);
    //查询方法
	List<EhyArea> findAll(Map<String, Object> map);
	//总行数
	int findRowCount(Map<String, Object> map);
	
	
	
	 List<EhyArea> selectArea(EhyArea record);
	 
	 List<EhyArea> selectAreaById(String record);
	 
	//查询省区
	List<Map<String, Object>> findProvince();
	
	List<Map<String, Object>> findCity(String provinceId);
	
	List<Map<String, Object>> findArea(String cityId);
}