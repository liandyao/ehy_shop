/**
 * 
 */
package cn.ehuoyuan.shop.service.proType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.common.CommomUtils;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.common.TreeNode;
import cn.ehuoyuan.shop.dao.EhyDatadicMapper;
import cn.ehuoyuan.shop.dao.EhyProTypeMapper;
import cn.ehuoyuan.shop.dao.EhyProTypeSpecificationMapper;
import cn.ehuoyuan.shop.dao.EhyStationMapper;
import cn.ehuoyuan.shop.domain.EhyDatadic;
import cn.ehuoyuan.shop.domain.EhyProType;
import cn.ehuoyuan.shop.domain.EhyProTypeSpecification;
import cn.ehuoyuan.shop.domain.EhyStation;
import cn.ehuoyuan.shop.service.base.datadic.DatadicService;

/**
 * 产品类型service实现类
 * @author HuXin
 * @date 2017年9月29日
 */
@Service
public class ProTypeServiceImpl implements ProTypeService{
	@Resource
	private EhyProTypeMapper dao;//产品类型dao类
	@Resource
	private EhyStationMapper stationDao;//站点dao
	@Resource
	private EhyDatadicMapper ehyDatadicMapper;//字典dao
	//类型规格dao
	@Resource
	private EhyProTypeSpecificationMapper typeSpecificationdao ;
	/**
	 * 根据id删除
	 * @author 胡鑫
	 * @date 2017年10月17日08:48:06
	 * @param proTypeId 传入的产品类型id
	 * @return 返回执行的行数
	 */
	@Override
	public int deleteByPrimaryKey(String proTypeId) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 增加
	 * @author 胡鑫
	 * @date 2017年10月12日22:28:09
	 * @param record
	 * @return
	 */
	@Override
	public int insert(EhyProType record) {
		// TODO Auto-generated method stub
		return 0;
	}
	 /**
     * 判断增加 
     * @author 胡鑫
     * @date 2017年10月12日22:28:09
     * @param record 类型
     * @return 返回执行的行数
     */
	@Override
	public int insertSelective(EhyProType record,String[] sptId,String[] proTypeRemarks) {
		String val = "";//定义一个字符串存放站点id
		if(proTypeRemarks!=null && !"".equals(proTypeRemarks)){
			for(String remarks:proTypeRemarks){//循环遍历站点id
				EhyStation station = stationDao.findById(remarks);//根据站点id查询站点信息
				EhyDatadic datadic = new EhyDatadic();//定义一个字典实体类
				datadic.setDicCode("ST_"+station.getStCode());//设置字典编号 默认加上 ST_
				datadic.setDicName(record.getProTypeName());
				datadic.setDicRemark("站点对应产品类型设置");
				int ros = ehyDatadicMapper.selectNameAndCodeIsva(datadic);//根据 站点编号and类型名称查询 是否存在该条信息 返回int
				if(ros==0){//返回的行数 == 0 执行
					ehyDatadicMapper.insertSelective(datadic);//增加字典
				}
				val+=","+remarks;
				/* 判断是否存在
				if(dao.selectByStation("%"+remarks+"%")>0){
					return -1;
				}*/
			}
			record.setProTypeRemark(val.substring(1));//将站点id赋值
		}
		
		int rows = dao.insertSelective(record);
		if(sptId !=null && sptId.length!=0){
			for(int i=0;i<sptId.length;i++){
				EhyProTypeSpecification pts = new EhyProTypeSpecification();
				pts.setTypeId(record.getProTypeId());
				pts.setSpeId(sptId[i]);
				typeSpecificationdao.insertSelective(pts);
			}
		}
		
		return rows;
	}
	/**
     * 根据id查询
     * @author 胡鑫
     * @date 2017年10月10日15:18:29
     * @param proTypeId 传入的id
     * @return 返回查询的类型
     */
	@Override
	public EhyProType selectByPrimaryKey(String proTypeId) {
		// TODO Auto-generated method stub
		EhyProType ept = dao.selectByPrimaryKey(proTypeId);//根据id得到类型信息
		if(ept.getPtId().equals("0")){
			ept.setTypeName("产品");
			ept.setTypeId("0");
		}
		//根据类型id得到该类型规格
		List<EhyProTypeSpecification> list = typeSpecificationdao.findByTypeIdAll(proTypeId);
		if(Tools.isEmpty(list)){
			
		}else{
			ept.setProTypeSpecification(list);//设置类型规格集合信息
		}
		return ept ;
	}
	 /**
     * 条件有值修改 无值不修改 
     * @author 胡鑫
     * @date 2017年10月12日22:28:09
     * @param record 产品类型
     * @param sptId 数组类型的规格id
     * @return 返回执行的行数
     */
	@Override
	public int updateByPrimaryKeySelective(EhyProType record,String[] sptId,String[] proTypeRemarks) {
		String val = "";//定义一个字符串存放站点id
		if(proTypeRemarks!=null){
			for(String remarks:proTypeRemarks){//循环遍历站点id
				val+=","+remarks;
				if(Tools.isEmpty(remarks)){
					return -2;
				}/*else{
					
					if(dao.selectByStation("%"+remarks+"%")>0){
						return -1;
					}
				}*/
				
			}
			record.setProTypeRemark(val.substring(1));//将站点id赋值
		}else{
			record.setProTypeRemark("");//将站点id赋值
		}
		
		
		//修改信息
		int rows = dao.updateByPrimaryKeySelective(record);
		//将类型规格信息进行删除
		EhyProTypeSpecification eps = new EhyProTypeSpecification();
		eps.setTypeId(record.getProTypeId());
		eps.setIsva(CommomUtils.ISVA_NO);
		int rows2 = typeSpecificationdao.deleteByPrimaryKey(eps);
		if(sptId !=null && sptId.length!=0){//选择的id 不能为空 and 长度不能为0
			for(int i=0;i<sptId.length;i++){
				//将规格类型设值
				EhyProTypeSpecification pts = new EhyProTypeSpecification();
				pts.setTypeId(record.getProTypeId());
				pts.setSpeId(sptId[i]);
				//进行增加
				typeSpecificationdao.insertSelective(pts);
			}
		}
		return rows;
	}
	/**
     * 修改 无判断修改
     * @author 胡鑫
     * @date 2017年10月17日08:46:21
     * @param record 产品类型
     * @return 返回执行的行数
     */
	@Override
	public int updateByPrimaryKey(EhyProType record) {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
     * 分页查询 
     * 模糊查询
     * 查询全部
     * @author 胡鑫
     * @date 2017年10月12日22:28:09
     * @param map2 传入的参数 
     * @return 返回类型集合
     */
	@Override
	public List<EhyProType> selectAllProType(Map<String, Object> map2) {
		return dao.selectAllProType(map2);
	}
	/**
     * 得到行数
     * @author 胡鑫
     * @date 2017年10月17日08:46:40
     * @return 返回查询的行数
     */
	@Override
	public int selectCountProType() {
		
		return dao.selectCountProType();
	}
	/**
     * 根据上级id得到上级信息
     * @author 胡鑫
     * @date 2017年10月17日08:46:49
     * @param proTypeId 产品的主键id
     * @return 返回查询到的产品信息
     */
	@Override
	public EhyProType selectByPtId(String proTypeId) {
		return dao.selectByPtId(proTypeId);
	}
	/**
     * 产品分类的树形菜单
     * @author 欧阳丰
	 * @date 2017年10月1日 17:54:26
	 * @version 1.1
     */
	@Override
	public void getTreeNode(TreeNode node) {
		List<EhyProType> list = dao.findChildren(node.getId());
		if(!list.isEmpty()){
			List<TreeNode> child = new ArrayList<TreeNode>();
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				EhyProType ehyProType = (EhyProType) iterator.next();
				TreeNode n = new TreeNode();
				n.setId(ehyProType.getProTypeId());
				n.setName(ehyProType.getProTypeName());
				child.add(n);
			}
			node.setChildren(child);
			for (Iterator iterator = child.iterator(); iterator.hasNext();) {
				TreeNode treeNode = (TreeNode) iterator.next();
				
				getTreeNode(treeNode);//自己调用自己
			}
		}
	}
	
	@Override
	public void findAllByPtId(String ptId,List<EhyProType> proTypeList) {
		List<EhyProType> list = dao.findChildren(ptId);
		if(!list.isEmpty()){
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				EhyProType proType = (EhyProType) iterator.next();
				proTypeList.add(proType);
				findAllByPtId(proType.getProTypeId(),proTypeList);//自己调用自己
			}
		}
	}
	
	/**
     * 增加类型时 判断该类型有无子分类
     * @author 胡鑫
     * @date 2017年10月16日09:04:35
     * @param ptId 根据类型主键id查询类型上级id
     * @return
     */
	public int isSubClassExist (String ptId){
		
		List<EhyProType> list = dao.findChildren(ptId);
		return list.size();
	}
	/**
     * 下拉框赋值查询
     * @author 胡鑫
     * @date 2017年10月16日09:03:36
     * @return 返回产品类型集合
     */
	@Override
	public List<EhyProType> selectIdOrName() {
		
		return dao.selectIdOrName();
	}
	/**
	 * 三表关联查询 
	 * 查询返回的行数(等于0)进行删除
	 * @author 胡鑫
	 * @date 2017年10月16日18:56:47
	 * @param map Hash集合 
	 * @return 返回查询到的行数
	 */
	@Override
	public int deleteByKey(Map<String, Object> map) {
		int rows = 0;
		map.put("isva", CommomUtils.ISVA_YES);
		int row = dao.SelectByKey(map);
		
		if(row==0){
			map.put("isva", CommomUtils.ISVA_NO);
			rows = dao.deleteByPrimaryKey(map);
		}
		return rows;
	}
	
	/**
     * 根据类型id进行删除
     * 修改isva为0
     * @author 胡鑫
     * @date 2017年10月16日19:04:47
     * @param map Hash集合
     * @return 执行的行数
     */
	@Override
	public int deleteByPrimaryKey(Map<String, Object> map) {
		
		return 0;
	}
	
	/**
     * 根据站点id得到站点信息
     * @author 胡鑫
     * @date 2017年10月24日14:51:44
     * @param string 站点id 
     * @return 返回站点
     */
	@Override
	public String selectEhyStationList(String string) {
		
		String remak ="";//定义一个字符串
		if(Tools.isEmpty(string)){
			return "";
		}else{
			String[]stIds = string.split(",");//将站点id用逗号隔开存入数组
			for(String stId : stIds){
				if(Tools.isEmpty(stId)){
					
				}else{
					EhyStation station = stationDao.findById(stId);//根据站点id查询站点信息
					remak+=","+station.getStName();//将站点名称赋值
				}
			}
		}
		String remaks = remak.substring(1);
		return remaks;
	}
	
	@Override
	public List<Map<String, Object>> findSubordinate(String ptId) {
		
		return dao.findSubordinate(ptId);
	}
	
	@Override
	public List<Map<String, Object>> findByStId(String stId) {
		// TODO Auto-generated method stub
		return dao.findByStId(stId);
	}

}
