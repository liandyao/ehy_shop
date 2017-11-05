/**
 * 
 */
package cn.ehuoyuan.shop.service.logs;

import java.util.List;

import cn.ehuoyuan.shop.action.logs.vo.EhyLogsVo;


/**
 * 类的描述：日志的Service接口
 * @author 罗海兵
 * @date 2017年9月30日
 */
public interface LogsService {
	
	/**
	 * 删除
	 * <p>根据id删除一条记录</p>
	 * @param logsId
	 * @return
	 */
	public int deleteByPrimaryKey(String logsId);
	
	/**
	 * 增加
	 * <p>填满所有的列</p>
	 * @param record
	 * @return
	 */
	public int insert(EhyLogsVo record);
	
	/**
	 * 增加
	 * <p>只填充某些列</p>
	 * @param record
	 * @return
	 */
	public int insertSelective(EhyLogsVo record);
	
	/**
	 * 查询一条记录
	 * <p>根据id查询</p>
	 * @param logsId
	 * @return
	 */
	public EhyLogsVo selectByPrimaryKey(String logsId);
    
	/**
	 * 查询多条记录
	 * <p>根据某些列查询</p>
	 * @param record
	 * @return
	 */
	public List<EhyLogsVo> select(EhyLogsVo record);
    
	/**
	 * 查询所有记录
	 * <p>无条件查询</p>
	 * @param record
	 * @return
	 */
	public List<EhyLogsVo> selectAll();
	
	/**
	 * 修改一条记录
	 * <p>根据id修改某些列</p>
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(EhyLogsVo record);
	
	/**
	 * 修改一条记录
	 * <p>根据id修改所有列</p>
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(EhyLogsVo record);
}
