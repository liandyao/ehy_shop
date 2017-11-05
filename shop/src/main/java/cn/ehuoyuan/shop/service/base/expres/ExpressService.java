/**
 * 
 */
package cn.ehuoyuan.shop.service.base.expres;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyExpress;

/**
 * 物流service
 * @author dong
 * @da2017年10月7日
 * @version 1.0
 */
public interface ExpressService {

	/**
	 * 查询所有方法
	 * @param area
	 * @return
	 */
	List<EhyExpress> findAll(Map<String, Object> map);

	/**
	 * 总行数
	 * @return
	 */
	int findRowCount(Map<String, Object> map);
	/**
	 * 删除
	 * @param name
	 * @return
	 */
	int updateByPrimaryKeySelective(EhyExpress record);
	/**
	 * 增加方法
	 * @param record
	 * @return
	 */
	int insert(EhyExpress record);
	/**
	 * 根据ID查询
	 * @param expreessId
	 * @return
	 */
	EhyExpress selectByPrimaryKey(String expreessId);
	
	
	/**
	 * 修改
	 * @param record
	 * @return
	 */
    int update(EhyExpress record);
    
    /**
     * 查询所有的快递
     * @author 邓丽杰
     * @date 2017年10月18日13:58:10
	 * @version 1.1
     */
    List<EhyExpress> findExpress();
}
