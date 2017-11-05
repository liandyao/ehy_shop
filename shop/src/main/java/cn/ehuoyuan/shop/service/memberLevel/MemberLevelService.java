/**
 * 
 */
package cn.ehuoyuan.shop.service.memberLevel;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyMemberLevel;

/**
 * 会员等级Service 接口
 * @author Weimianwu
 * 2017年10月9日 下午6:07:46
 * version v1.0
 */
public interface MemberLevelService {
	/**
	 * 模糊查询
	 * @param map
	 * @return
	 */
	List<Map> findAll(Map<String ,Object> map);
	/**
	 * 模糊查询总行数
	 * @param record
	 * @return
	 */
	int getTatolRows(Map<String ,Object> map);

	/**
	 * 增加的方法
	 * @param record
	 * @return
	 */
	int insertSelective(EhyMemberLevel record);

	/**
	 * 根据ID查对象
	 * @param levelId
	 * @return
	 */
	Map<String ,Object> selectByPrimaryKey(String levelId);
	/**
	 * 修改的方法
	 * @param record 参数
	 * @return
	 */
	int updateByPrimaryKeySelective(EhyMemberLevel record);
	
	/**
	 * 下拉框的查询方法
	 * @return
	 */
	List<EhyMemberLevel> ehyMemberLevelFindAll();
	
	/**
	 * 删数
	 * @param levelId
	 * @return
	 */
	int deleteByPrimaryKey(String levelId);

	/**
	 * 排序
	 * @param start
	 * @param end
	 * @param levelId
	 * @return
	 */
	int sortMemberLevel(int start, int end, String levelId);
	
	/**
	 * 查询会员等级是否存在
	 * @param LevelName
	 * @return
	 */
	int isLevelName(String LevelName);
	
	/**
	 * 查询最大的排序值
	 * @return
	 */
	int maxSort();
	
}
