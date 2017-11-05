/**
 * 
 */
package cn.ehuoyuan.shop.service.specificationType;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhySpecificationType;

/**
 * 规格类型接口
 * @author HuXin
 * @date 2017年10月10日
 */
public interface SpecificationTypeService {
	/**
     * 根据规格id进行规格删除
     * @author 胡鑫
     * @date 2017年10月21日09:46:51
     * @param map 传入的map集合
     * @return 返回执行的行数
     */
    public int deleteByPrimaryKey(Map<String, Object> map);

    int insert(EhySpecificationType record);
    /**
     * 判断增加 有值增加 无值不加
     * @author 胡鑫
     * @date 2017年10月18日19:11:27
     * @param map map集合
     * @return 返回执行的行数
     */
    public int insertSelective(Map<String, Object> map);
    /**
     * 根据规格类型id得到该规格的所有信息
     * @author 胡鑫
     * @date 2017年10月19日09:42:06
     * @param sptId 规格类型id
     * @return 返回规格类型
     */
    public EhySpecificationType selectByPrimaryKey(String sptId);
    
    /**
     * 判断修改 有值则改 无值保留原值
     * @author 胡鑫
     * @date 2017年10月19日09:59:51
     * @param map map集合用于存放sql参数
     * @return 返回执行的行数
     */
    public int updateByPrimaryKeySelective(Map<String, Object> map);

    int updateByPrimaryKey(EhySpecificationType record);
    /**
     * 得到规格类型集合
     * @author 胡鑫
     * @param map2 
     * @date 2017年10月10日16:26:12
     * @return 返回规格类型集合
     */
    public List<EhySpecificationType> findSpecificationTypeList(Map<String, Object> map2);
    
    /**
     * 得到查询到的行数
     * @author 胡鑫
     * @param map2 
     * @date 2017年10月18日09:05:48
     * @return 返回查询到的行数
     */
    public int selectCountSpecificationType(Map<String, Object> map2);
    
    /**
     * 分页、模糊查询规格类型集合
     * @author 胡鑫
     * @param map2 
     * @date 2017年10月18日10:05:42
     * @return 返回规格类型集合
     */
    public List<EhySpecificationType> selectAll(Map<String, Object> map2);
    
    /**
     * 删除查询 执行修改状态为0之前进行该方法查询返回的值大于0则不能删除
     * @author 胡鑫
     * @date 2017年10月20日01:00:51
     * @param sptId 规格类型id
     * @return 返回执行的行数
     */
    public int deleteSelect(String sptId);
    
    /**
     * @title 查询站点ID
     * @description 根据站点ID查询规格类型
     * @param stId 站点ID
     * @return 返回一个Map集合
     * @author 罗海兵
     * @dateTime 2017年10月25日 下午4:45:03
     * @versions 1.0
     */
    public List<Map<String, Object>> findByStId(String stId);

}
