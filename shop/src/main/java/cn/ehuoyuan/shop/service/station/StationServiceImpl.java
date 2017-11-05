/**
 * 
 */
package cn.ehuoyuan.shop.service.station;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.shop.dao.EhyStationMapper;
import cn.ehuoyuan.shop.domain.EhyStation;

/**
 * 站点管理的Service接口的实现类
 * @author denglijie
 * @date 2017年9月30日
 * version v1.0
 */
@Service
public class StationServiceImpl implements StationService{
	
	@Resource
	private EhyStationMapper ehyStationMapper;
	
	/**
	 *  查询全部
	 * @param map
	 * @return list
	 */
	public List<EhyStation> findAll(Map<String, Object> map) {
		List<EhyStation> list = ehyStationMapper.findAll(map);
		return list;
	}

	/**
     * 查询总行数
     * @return
     */
	public int findRowCount(Map<String, Object> map) {
		return ehyStationMapper.findRowCount(map);
	}


	/**
	 * 修改或删除
	 */
	public int update(EhyStation record) {
		
		return ehyStationMapper.update(record);
	}

	/**
	 * 增加
	 */
	public int insertSelective(EhyStation record) {
	
		return ehyStationMapper.insertSelective(record);
	}

	/**
	 * 根据id查找数据
	 */
	public EhyStation findById(String stId) {
		
		return ehyStationMapper.findById(stId);
	}



	@Override
	public EhyStation selectByPrimaryKey(String stId) {
		return ehyStationMapper.selectByPrimaryKey(stId);
	}

	/**
	 * 查询所有站点
	 */
	public List<EhyStation> findStation() {
		// TODO Auto-generated method stub
		return ehyStationMapper.findStation();
	}

	/**
	 * 根据站点名称判断站点名称是否存在
	 */
	@Override
	public int isStation(String stName) {
		return ehyStationMapper.isStation(stName);
	}

	/**
	 * 排序
	 */
	@Override
	public int sortStation(Integer startNum, Integer endNum, String stId) {
		return ehyStationMapper.sortStation(startNum, endNum, stId);
	}

	

}
