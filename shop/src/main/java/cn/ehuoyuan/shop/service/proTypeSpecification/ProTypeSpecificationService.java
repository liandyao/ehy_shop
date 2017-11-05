/**
 * 
 */
package cn.ehuoyuan.shop.service.proTypeSpecification;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyProTypeSpecification;


/**
 * 产品类型规格service接口
 * @author 欧阳丰
 * @data 2017年10月10日
 */
public interface ProTypeSpecificationService {
	/**
     * 根据产品类型ID查询该类型所有的规格以及规格值
     * @return 类型规格集合
     * @author 欧阳丰
	 * @date 2017年10月11日 21:10:20
	 * @version 1.1
     */
    public Map<String, List<String>> findAll(String proTypeId);
    
    /**
	 * 判断增加 有值增加 无值不增加
	 * @author 胡鑫
	 * @date 2017年10月14日10:29:17
	 * @param record 传入的规格类型
	 * @return 返回执行的行数
	 */
	int insertSelective(EhyProTypeSpecification record);
	/**判断修改
	 * @author 胡鑫
	 * @date 2017年10月14日10:29:17
	 * @param record 传入的规格类型
	 * @return 返回执行的行数
	 */
	int updateByPrimaryKeySelective(EhyProTypeSpecification record);
}
