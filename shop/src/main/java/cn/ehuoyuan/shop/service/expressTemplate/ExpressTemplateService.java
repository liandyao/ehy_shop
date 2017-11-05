/**
 * 
 */
package cn.ehuoyuan.shop.service.expressTemplate;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.ehuoyuan.shop.domain.EhyExpress;
import cn.ehuoyuan.shop.domain.EhyExpressTemplate;

/**
 * 运费模版的service接口类
 * @author denglijie
 * @date 2017年10月17日 下午 15:29:09
 * @version 1.0
 */
public interface ExpressTemplateService {
	
	/**
     * 根据站点ID查询所有运费模板
     * @param stId 站点ID
     * @return 运费模板集合
     * @author 欧阳丰
	 * @date 2017年10月19日18:20:09
	 * @version 1.1
     */
	public List<EhyExpressTemplate> findByStId(String stId);
	
	/**
	 * 运费模版查询
	 * @param map
	 * @return
	 */
	List<Map> findAll(Map<String, Object> map);
	
	/**
	 * 查询总行数
	 * @param map
	 * @return
	 */
	int findRowCount(Map<String, Object> map);
	
	/**
     * 增加运费模版
     * @param expressTemplate
     * @return
     */
    int insertSelective(EhyExpressTemplate expressTemplate);

    /**
     * 根据id查询运费模版
     * @param tempId
     * @return
     */
    EhyExpressTemplate findById(String tempId);
    
    /**
     * 修改运费模版
     * @param expressTemplate
     * @return
     */
    int updateSelective(EhyExpressTemplate expressTemplate);
	
    
    /**
     * 排序
     * @param startNum
     * @param endNum
     * @param tempId
     * @return
     */
    int sortTemplate(Integer startNum, Integer endNum, String tempId);
}
