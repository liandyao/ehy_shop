package cn.ehuoyuan.shop.dao;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.shop.domain.EhyProType;

public interface EhyProTypeMapper {
	/**
	 * 根据id删除
	 * @author 胡鑫
	 * @date 2017年10月17日08:48:06
	 * @param proTypeId 传入的产品类型id
	 * @return 返回执行的行数
	 */
	int deleteByPrimaryKey(String proTypeId);
	/**
	 * 增加
	 * @author 胡鑫
	 * @date 2017年10月12日22:28:09
	 * @param record
	 * @return
	 */
    int insert(EhyProType record);
    
    /**
     * 判断增加 
     * @author 胡鑫
     * @date 2017年10月12日22:28:09
     * @param record 类型
     * @return 返回执行的行数
     */
    public int insertSelective(EhyProType record);
    /**
     * 根据id查询
     * @author 胡鑫
     * @date 2017年10月10日15:18:29
     * @param proTypeId 传入的id
     * @return 返回查询的类型
     */
    EhyProType selectByPrimaryKey(String proTypeId);
    /**
     * 条件有值修改 无值不修改 
     * @author Administrator
     * @date 2017年10月12日22:28:09
     * @param record 产品类型
     * @param sptId 数组类型的规格id
     * @return 返回执行的行数
     */
    int updateByPrimaryKeySelective(EhyProType record);
    /**
     * 修改 无判断修改
     * @author 胡鑫
     * @date 2017年10月17日08:46:21
     * @param record 产品类型
     * @return 返回执行的行数
     */
    int updateByPrimaryKey(EhyProType record);
    /**
     * 分页查询 
     * 模糊查询
     * 查询全部
     * @author 胡鑫
     * @date 2017年10月12日22:28:09
     * @param map2 传入的参数 
     * @return 返回类型集合
     */
    List<EhyProType>selectAllProType(Map<String, Object> map);
    /**
     * 得到行数
     * @author 胡鑫
     * @date 2017年10月17日08:46:40
     * @return 返回查询的行数
     */
    int selectCountProType();
    /**
     * 根据上级id得到上级信息
     * @author 胡鑫
     * @date 2017年10月17日08:46:49
     * @param proTypeId 产品的主键id
     * @return 返回查询到的产品信息
     */
    EhyProType selectByPtId(String proTypeId);
    
    /**
     * 根据上级分类ID查询分类
     * @param ptId 上级分类ID
     * @return 分类集合
     * @author 欧阳丰
	 * @date 2017年10月1日 16:58:20
	 * @version 1.1
     */
    public List<EhyProType> findChildren(String ptId);
    
    /**
     * 下拉框赋值查询
     * @author 胡鑫
     * @date 2017年10月16日09:03:36
     * @return 返回查询得到的类型集合
     */
    public List<EhyProType> selectIdOrName();
    
    /**
     * 三表关联查询
     * @author 胡鑫
     * @date 2017年10月16日18:56:47
     * @param map 传入的map集合 用于设置参数
     * @return 返回查询的行数
     */
    public int SelectByKey(Map<String,Object>map);
    
    /**
     * 根据类型id进行删除
     * 修改isva为0
     * @author 胡鑫
     * @date 2017年10月16日19:04:47
     * @param map Hash集合
     * @return 执行的行数
     */
    public int deleteByPrimaryKey(Map<String,Object>map);
    
    /**
     * 根据站点id查询该站点有无类别
     * @author 胡鑫
     * @date 2017年10月24日18:26:18
     * @param stId 站点id
     * @return 查询到的行数
     */
    public int selectByStation(String stId);
    
    /**
     * @title 查询上级ID
     * @description 根据上级ID查询产品类型集合
     * @param ptId 上级ID
     * @return 返回一个Map对象
     * @author 罗海兵
     * @dateTime 2017年10月24日 下午5:18:13
     * @versions 1.0
     */
    public List<Map<String, Object>> findSubordinate(String ptId);
    
    /**
     * @title 查询站点ID
     * @description 根据站点ID查询该站点的产品类型
     * @param stId 站点ID
     * @return 返回一个Map对象
     * @author 罗海兵
     * @dateTime 2017年10月24日 下午4:55:41
     * @versions 1.0
     */
    public List<Map<String, Object>> findByStId(String stId);
}