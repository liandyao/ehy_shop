package cn.ehuoyuan.shop.dao;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyProTypeSpecification;

public interface EhyProTypeSpecificationMapper {
    int deleteByPrimaryKey(EhyProTypeSpecification eps);

    int insert(EhyProTypeSpecification record);
    /**
     * 条件有值修改 无值不修改 
     * @author 胡鑫
     * @date 2017年10月12日22:28:09
     * @param record 产品类型
     * @param sptId 数组类型的规格id
     * @return 返回执行的行数
     */
    int insertSelective(EhyProTypeSpecification record);

    EhyProTypeSpecification selectByPrimaryKey(String ptsId);

    int updateByPrimaryKeySelective(EhyProTypeSpecification record);

    int updateByPrimaryKey(EhyProTypeSpecification record);
    
    /**
     * 根据产品类型ID查询该类型所有的规格以及规格值
     * @return 类型规格集合
     * @author 欧阳丰
	 * @date 2017年10月10日 21:28:20
	 * @version 1.1
     */
    public List<Map<String,Object>> findAll(String proTypeId);
      
    /**
     * 根据类型id查询该类型的关联的规格
     * @author 胡鑫
     * @date 2017年10月16日11:46:35
     * @param proTypeId 类型id
     * @return 返回类型规格集合
     */
    public List<EhyProTypeSpecification> findByTypeIdAll(String proTypeId);
}