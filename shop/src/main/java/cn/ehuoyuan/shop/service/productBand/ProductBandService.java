/**
 * 
 */
package cn.ehuoyuan.shop.service.productBand;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyProductBand;

/**
 * 产品品牌service接口
 * @author 欧阳丰
 * @data 2017年10月9日
 */
public interface ProductBandService {
	 /**
     * 查询所有商品品牌(不分页)
     * @return 品牌集合
     * @author 欧阳丰
	 * @date 2017年10月9日 11:28:20
	 * @version 1.1
     */
    public List<EhyProductBand> findAll();
    
    /**
     * 分页查询品牌信息、搜索查询
     * @return 品牌集合
     * @author 胡鑫
	 * @date 2017年10月9日16:33:51
	 * @version 1.1
     * @param map2 
     */
    public List<EhyProductBand> findProductBandList(Map<String, Object> map2);
    
    /**
     * 得到品牌行数
     * @author 胡鑫
     * @param map2 
     * @date 2017年10月9日16:33:51
     * @return
     */
    public int selectCountProband(Map<String, Object> map2);
    
    /**
     * 根据id查询品牌信息
     * @author 胡鑫
     * @date 2017年10月12日09:47:35
     * @param bandId 品牌id
     * @return 返回品牌对象
     */
    public EhyProductBand selectByPrimaryKey(String bandId);
    
    /**
     * 判断增加 
     * @author 胡鑫
     * @date 2017年10月12日11:18:32
     * @param record 品牌对象
     * @return 返回执行的行数
     */
    public int insertSelective(EhyProductBand record);
    
    /**
     * 根据id 判断修改
     * @author 胡鑫
     * @date 2017年10月12日14:00:48
     * @param record 品牌对象
     * @return 返回执行的行数
     */
    public int updateByPrimaryKeySelective(EhyProductBand record);
}
