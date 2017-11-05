package cn.ehuoyuan.shop.dao;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyDatadic;

public interface EhyDatadicMapper {
    int deleteByPrimaryKey(String dicId);


    /**
     * 增加的方法
     * @param record
     * @return
     */
    int insertSelective(EhyDatadic record);
    /**
	 * 查询所有
	 * @param map
	 * @return
	 */
	List<EhyDatadic> findAll(Map<String, Object> map);
	/**
	 * 总行数
	 * @param map
	 * @return
	 */
	int findRowCount(Map<String, Object> map);
    /**
     * 根据id查询
     * @param dicId
     * @return
     */
    EhyDatadic selectByPrimaryKey(String dicId);
    /**
	 * 删除和修改方法
	 * @param dicId
	 * @return
	 */
    int updateByPrimaryKeySelective(EhyDatadic record);

    
    /**
	 * 增加方法
	 * @param record
	 * @return
	 */
	int insert(EhyDatadic record);
	
	
    
    int updateByPrimaryKey(EhyDatadic record);

    
    /**
	 * @title 查询字典名称
	 * @description 根据字典名称查询数据字典的对象集合
	 * @param dicName 字典名称
	 * @return 返回一个数据字典的List集合
	 * @author 罗海兵
	 * @dateTime 2017年10月23日 下午3:47:35
	 * @versions 1.0
	 */
	List<EhyDatadic> findByDicName(String dicName);
	
	
	/**
	 *  根据会员等级id删除
	 * @param code
	 * @return
	 */
	int deleteLevelId (String code);
	
	/**
	 * 根据名称和编号查询是否存在该条信息 返回查询到的行数
	 * @author 胡鑫
	 * @date 2017年11月4日10:38:45
	 * @param record 字典对象
	 * @return 返回查询到的行数
	 */
	public int selectNameAndCodeIsva(EhyDatadic record);
}