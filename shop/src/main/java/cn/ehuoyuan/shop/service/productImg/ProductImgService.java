/**
 * 
 */
package cn.ehuoyuan.shop.service.productImg;

import java.util.List;

import cn.ehuoyuan.shop.domain.EhyProductImg;

/**
 * 产品图片service接口
 * @author 欧阳丰
 * @data 2017年10月10日
 */
public interface ProductImgService {
	
	 /**
     * 根据图片ID修改图片为无效
     * @param productImg 产品图片实体类
     * @date 2017年10月18日18:10:35
	 * @version 1.1
     * @return 影响行数
     */
    public int updateIsvaByImgId(String imgId);
	
	/**
     * 根据图片ID修改图片序号
     * @param productImg 产品图片实体类
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年10月18日14:57:49
	 * @version 1.1
     */
    public int updateSortByImgId(String[] imgId,Integer[] sort);
	
	/**
     * 根据产品ID和类型ID查询图片
     * @param proId 产品ID
     * @param imgType 图片类型
     * @date 2017年10月17日 20:47:20
	 * @version 1.1
     * @return 图片集合
     */
    public List<EhyProductImg> findImgByProIdAndImgType(String proId,int imgType);
    
    /**
     * 根据产品ID和类型ID查询图片数量
     * @param proId 产品ID
     * @param imgType 图片类型
     * @date 2017年10月17日 20:47:20
	 * @version 1.1
     * @return 图片集合
     */
    public int findImgByProIdAndImgTypeSize(String proId,int imgType);
	
	/**
     * 增加产品图片
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年10月10日 18:28:20
	 * @version 1.1
     */
    public int insert(EhyProductImg productImg);
    
    /**
     * 根据产品ID和图片类型修改图片为无效
     * @param proId 产品ID
     * @param imgType 图片类型
     * @return
     */
    public int updateIsvaByProIdAndImgType(String proId,int imgType);
}
