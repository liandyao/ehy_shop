package cn.ehuoyuan.shop.dao;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyProductImg;

public interface EhyProductImgMapper {
    int deleteByPrimaryKey(String imgId);
    
    /**
     * 根据图片ID修改图片序号
     * @param productImg 产品图片实体类
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年10月18日14:57:49
	 * @version 1.1
     */
    public int updateSortByImgId(EhyProductImg productImg);
    
    /**
     * 增加产品图片
     * @param productImg 产品图片实体类
     * @return 影响行数
     * @author 欧阳丰
	 * @date 2017年10月10日 18:28:20
	 * @version 1.1
     */
    int insert(EhyProductImg productImg);
    
    /**
     * 根据产品ID和图片类型修改图片为无效
     * @param proId 产品ID
     * @param imgType 图片类型
     * @date 2017年10月10日 18:28:20
	 * @version 1.1
     * @return 影响行数
     */
    public int updateIsvaByProIdAndImgType(String proId,int imgType);
    
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

    int insertSelective(EhyProductImg record);

    EhyProductImg selectByPrimaryKey(String imgId);
    
    /**
     * 根据图片ID修改图片信息
     * @param productImg 产品图片实体类
     * @date 2017年10月18日18:10:35
	 * @version 1.1
     * @return 影响行数
     */
    int updateByPrimaryKeySelective(EhyProductImg productImg);

    int updateByPrimaryKey(EhyProductImg record);
    
    /**
     * @title 根据产品ID和图片类型查询产品图片
     * @param map 封装了产品ID和图片类型的Map对象
     * @return 返回一个图片地址的Map的List集合
     * @author 罗海兵
     * @dateTime 2017年10月26日 下午2:57:03
     * @versions 1.0
     */
    List<Map<String, Object>> findImgByProId(Map<String, Object> map);
}