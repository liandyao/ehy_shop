package cn.ehuoyuan.shop.dao;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhySpecificationType;

public interface EhySpecificationTypeMapper {
    int deleteByPrimaryKey(String sptId);

    int insert(EhySpecificationType record);

    int insertSelective(EhySpecificationType record);
    
    /**
     * 根据规格类型id得到该规格的所有信息
     * @author 胡鑫
     * @date 2017年10月19日09:54:16
     * @param map map集合用于存放sql参数
     * @return 返回规格类型
     */
    public EhySpecificationType selectByPrimaryKey(Map<String, Object> map);

    int updateByPrimaryKeySelective(EhySpecificationType record);

    int updateByPrimaryKey(EhySpecificationType record);
    /**
     * 得到规格类型集合
     * @author 胡鑫
     * @param map 
     * @date 2017年10月10日16:26:12
     * @return 返回规格类型集合
     */
    public List<EhySpecificationType> findSpecificationTypeList(Map<String, Object> map);
    
    /**
     * 得到查询到的行数
     * @author 胡鑫
     * @param map2 
     * @date 2017年10月18日09:05:48
     * @return 返回查询到的行数
     */
    public int selectCountSpecificationType(Map<String, Object> map);
    
    /**
     * 分页、模糊查询规格类型集合
     * @author 胡鑫
     * @date 2017年10月18日10:05:42
     * @return 返回规格类型集合
     */
    public List<EhySpecificationType> selectAll(Map<String, Object> map);
    
    /**
     * 删除查询 执行修改状态为0之前进行该方法查询返回的值大于0则不能删除
     * @author 胡鑫
     * @date 2017年10月20日01:00:51
     * @param sptId 规格类型id
     * @return 返回执行的行数
     */
    public int deleteSelect(String sptId);
    
    /**
     * 根据规格id进行规格删除
     * @author 胡鑫
     * @date 2017年10月21日09:46:51
     * @param map 传入的map集合
     * @return 返回执行的行数
     */
    public int deleteByPrimaryKey(Map<String, Object> map);
    
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