/**
 * 
 */
package cn.ehuoyuan.shop.service.station;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyStation;

/**
 * 站点管理的Service接口
 * @author denglijie
 * @date 2017年9月30日
 * version v1.0
 */
public interface StationService {
	
	/**
	 * 查询所有站点
	 * @return
	 */
	List<EhyStation> findStation();
	
	/**
	 *  查询全部
	 * @param map
	 * @return
	 */
    List<EhyStation> findAll(Map<String, Object> map);
    
    /**
     * 查询总行数
     * @return
     */
    int findRowCount(Map<String, Object> map);
    
    /**
     * 修改
     * @param record
     * @return
     */
    int update(EhyStation record);
    
    /**
     * 增加
     * @param record
     * @return
     */
    int insertSelective(EhyStation record);
    
    /**
     * 根据id查找数据
     * @param stId
     * @return
     */
    EhyStation findById(String stId);
    
    
    
    /**
     * 根据站点ID查询站点
     * @param stId 站点ID
     * @author 欧阳丰
	 * @date 2017年10月9日 16:42:26
	 * @version 1.1
     */
    public EhyStation selectByPrimaryKey(String stId);
    
    /**
     * 根据站点名称判断站点名称是否存在
     * @param stName
     * @return
     */
    int isStation(String stName);
    
    /**
     * 排序
     * @param startNum
     * @param endNum
     * @param stId
     * @return
     */
    int sortStation(Integer startNum, Integer endNum, String stId);
}
