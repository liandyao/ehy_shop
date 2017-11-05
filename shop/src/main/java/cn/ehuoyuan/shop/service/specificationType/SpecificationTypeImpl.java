/**
 * 
 */
package cn.ehuoyuan.shop.service.specificationType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.common.CommomUtils;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.dao.EhySpecificationMapper;
import cn.ehuoyuan.shop.dao.EhySpecificationTypeMapper;
import cn.ehuoyuan.shop.domain.EhySpecification;
import cn.ehuoyuan.shop.domain.EhySpecificationType;

/**
 * 规格类型service实现类
 * @author HuXin
 * @date 2017年10月10日
 */
@Service
public class SpecificationTypeImpl implements SpecificationTypeService{
	
	@Resource
	private EhySpecificationTypeMapper dao;//规格类型dao
	@Resource
	private EhySpecificationMapper ehySpecificationDao;//规格值dao
	

	@Override
	public int insert(EhySpecificationType record) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
     * 判断增加 有值增加 无值不加
     * @author 胡鑫
     * @date 2017年10月18日19:11:27
     * @param map map集合
     * @return 返回执行的行数
     */
	@Override
	public int insertSelective(Map<String, Object> map) {
		//得到map集合中的规格类型
		EhySpecificationType ehySpecificationType = (EhySpecificationType) map.get("ehySpecificationType");
		//得到map集合中的规格值数组
		String[] spValue = (String[]) map.get("spValue");
		//规格类型增加   rows 得到执行的行数
		int rows = dao.insertSelective(ehySpecificationType);
		//循环遍历出规格值
		for(String spValues : spValue){
			EhySpecification ehySpecification = new EhySpecification();//定义一个规格值类
			ehySpecification.setSpValue(spValues);//设置规格值
			ehySpecification.setSptId(ehySpecificationType.getSptId());//设置规格类型id 为外键
			//规格值增加
			ehySpecificationDao.insertSelective(ehySpecification);
		}
		return rows;
	}
	/**
     * 根据规格类型id得到该规格的所有信息
     * @author 胡鑫
     * @date 2017年10月19日09:42:06
     * @param sptId 规格类型id
     * @return 返回规格类型
     */
	@Override
	public EhySpecificationType selectByPrimaryKey(String sptId) {
		//创建一个map集合用于存放sql参数
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("sptId", sptId);//规格类型id
		map.put("isva", CommomUtils.ISVA_YES);//是否有效   有效
		return dao.selectByPrimaryKey(map);
	}
	/**
     * 判断修改 有值则改 无值保留原值
     * @author 胡鑫
     * @date 2017年10月19日09:59:51
     * @param map map集合用于存放sql参数
     * @return 返回执行的行数
     */
	@Override
	public int updateByPrimaryKeySelective(Map<String, Object> map) {
		//将map集合中的规格类型取出
		EhySpecificationType ehySpecificationType = (EhySpecificationType) map.get("ehySpecificationType");
		//得到map集合 中的规格值
		String[] spValue = (String[]) map.get("spValue");
		//进行修改的方法  返回执行的行数
		int rows = dao.updateByPrimaryKeySelective(ehySpecificationType);
		map.put("isva", CommomUtils.ISVA_NO);//将isva 设置为无效 用于删除
		map.put("sptId", ehySpecificationType.getSptId());//将规格类型id传入map
		ehySpecificationDao.deleteByPrimaryKey(map);//执行删除方法(修改)
		for(String spValues:spValue){//循环遍历规格值
			EhySpecification ehySpecification = new EhySpecification();//定义一个规格值类
			ehySpecification.setSpValue(spValues);//将规格值设置参数   
			ehySpecification.setSptId(ehySpecificationType.getSptId());//将规格值类中规格id设置参数
			ehySpecificationDao.insertSelective(ehySpecification);//执行增加
		}
		
		
		return rows;
	}

	@Override
	public int updateByPrimaryKey(EhySpecificationType record) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
     * 得到规格类型集合
     * @author 胡鑫
     * @date 2017年10月10日16:26:12
     * @return 返回规格类型集合
     */
	@Override
	public List<EhySpecificationType> findSpecificationTypeList(Map<String, Object> map) {
		return dao.findSpecificationTypeList(map);
	}

	/**
	 * 得到总行数
	 * @author 胡鑫
	 * @date 2017年10月18日09:15:47
	 * @return 查询到的行数
	 */
	@Override
	public int selectCountSpecificationType(Map<String, Object> map) {
		 return dao.selectCountSpecificationType(map);
	}
	/**
     * 分页、模糊查询规格类型集合
     * @author 胡鑫
     * @param map2 
     * @date 2017年10月18日10:05:42
     * @return 返回规格类型集合
     */
	@Override
	public List<EhySpecificationType> selectAll(Map<String, Object> map) {
		
		return dao.selectAll(map);
	}
	/**
     * 删除查询 执行修改状态为0之前进行该方法查询返回的值大于0则不能删除
     * @author 胡鑫
     * @date 2017年10月20日01:00:51
     * @param sptId 规格类型id
     * @return 返回执行的行数
     */
	@Override
	public int deleteSelect(String sptId) {
		return dao.deleteSelect(sptId);
	}
	/**
     * 根据规格id进行规格删除
     * @author 胡鑫
     * @date 2017年10月21日09:46:51
     * @param map 传入的map集合
     * @return 返回执行的行数
     */
	@Override
	public int deleteByPrimaryKey(Map<String, Object> map) {
		return dao.deleteByPrimaryKey(map);
	}
	@Override
	public List<Map<String, Object>> findByStId(String stId) {
		List<Map<String, Object>> sptList=dao.findByStId(stId);
		List<Map<String, Object>> specificationList=new ArrayList<Map<String, Object>>();
		for(int i=0;i<sptList.size();i++){
			Map<String, Object> map=sptList.get(i);
			String sptId=(String) map.get("sptId");
			List<Map<String, String>> spList=ehySpecificationDao.findBySptId(sptId);
			map.put("spList", spList);
			specificationList.add(map);
		} 
		return specificationList;
	}

}
