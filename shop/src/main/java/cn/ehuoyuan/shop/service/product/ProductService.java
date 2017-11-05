/**
 * 
 */
package cn.ehuoyuan.shop.service.product;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyProduct;
import cn.ehuoyuan.shop.domain.EhyProductBand;

/**
 * 产品service接口
 * @author 欧阳丰
 * @data 2017年10月10日
 */
public interface ProductService {
	
	 /**
     * 根据产品ID得到修改产品的信息
     * @return map
     * @author 欧阳丰
	 * @date 2017年10月15日 18:28:20
	 * @version 1.1
     */
    public Map<String,Object> findProductAndBandByProId(String proId);
	
	/**
     * 修改产品信息
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年10月14日 17:34:20
	 * @version 1.1
     */
    public int updateByPrimaryKeySelective(EhyProduct product);
    
	/**
     * 增加产品
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年10月10日 18:28:20
	 * @version 1.1
     */
	public int insertSelective(EhyProduct prodyct);
	
	/**
     * 查询所有产品(包括未上架的)
     * @return 产品集合
     * @author 欧阳丰
	 * @date 2017年10月13日 10:23:20
	 * @version 1.1
     */
    public List<EhyProduct> findAll(Map<String,Object> map);
    
    /**
     * 查询所有产品(包括未上架的)的总行数
     * @return 产品集合
     * @author 欧阳丰
	 * @date 2017年10月13日 10:23:20
	 * @version 1.1
     */
    public int findAllSize(Map<String,Object> map);
	
	/**
     * 根据产品ID修改产品信息
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年10月13日 20:32:20
	 * @version 1.1
     */
	public int updateByProId(EhyProduct prodyct);
	
	/**
	 * 根据产品id得到产品信息
	 * @author 胡鑫
	 * @date 2017年10月23日11:20:49
	 * @param 产品id
	 * @return 返回产品类
	 */
	public EhyProduct findByIdProduct(String proId);
}
