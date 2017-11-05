/**
 * 
 */
package cn.ehuoyuan.shop.service.privilege;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.dao.EhyManagerRoleMapper;
import cn.ehuoyuan.shop.dao.EhyModuleMapper;
import cn.ehuoyuan.shop.dao.EhyRoleMapper;
import cn.ehuoyuan.shop.dao.EhyRoleModuleMapper;
import cn.ehuoyuan.shop.domain.EhyManagerRole;
import cn.ehuoyuan.shop.domain.EhyModule;
import cn.ehuoyuan.shop.domain.EhyRole;
import cn.ehuoyuan.shop.domain.EhyRoleModule;

/**
 * 权限管理的Service接口的实现类
 * @author zengren
 * @date 2017年9月29日
 * version v1.0
 */
@Service
public class PrivilegeServiceImpl implements PrivilegeService{
	
	@Resource
	private EhyModuleMapper ehyModuleMapper;
	@Resource
	private EhyRoleModuleMapper ehyRoleModuleMapper;
	@Resource
	private EhyManagerRoleMapper ehyManagerRoleMapper;
	@Resource
	private EhyRoleMapper ehyRoleMapper;
	
	@Override
	public List<EhyModule> showMenuTree(String manId) {
		List<EhyModule> list = ehyModuleMapper.showMenuTree(manId);
		for(EhyModule mod : list){
			List<EhyModule> l = mod.getModuleList();
			for(int i=0; i<l.size(); i++){
				EhyModule m = l.get(i);
				if(m.getIsva()==0){
					l.remove(i);
				}
			}
			if(l.size()==0){
				l = null;
			}
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> moduleTree() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		List<EhyModule> moduleList = ehyModuleMapper.findAll();
		for(EhyModule m : moduleList){
			Map<String, Object> oneMap = new HashMap<String, Object>();//一级分类
			List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
			if(Tools.isEmpty(m.getEhyModId())){//一级分类
				if(m.getModuleList().size()>0){//二级分类
					for(EhyModule e : m.getModuleList()){
						Map<String, Object> twoMap = new HashMap<String, Object>();//二级分类
						twoMap.put("name", e.getModName());
						twoMap.put("id", e.getModId());
						twoMap.put("children", null);
						mapList.add(twoMap);
					}
				}
				oneMap.put("name", m.getModName());
				oneMap.put("id", m.getModId());
				oneMap.put("children", mapList);
			}
			if(Tools.isEmpty(m.getEhyModId())){
				list.add(oneMap);
			}
		}
		return list;
	}

	@Override
	public int updateModRole(String[] modIdArr, String roleId) {
		// TODO Auto-generated method stub
		int deleteRow = deleteModRole(roleId);//修改角色模块时，先删除该角色的全部模块，在添加
		int rows = 0;
		if(modIdArr==null){
			return deleteRow;
		}
		for(int i=0; i<modIdArr.length; i++){
			System.out.println(modIdArr[0]);
			EhyRoleModule ehyRoleModule = new EhyRoleModule();
			ehyRoleModule.setRmId(UUID.randomUUID().toString());
			ehyRoleModule.setModId(modIdArr[i]);
			ehyRoleModule.setRoleId(roleId);
			rows += ehyRoleModuleMapper.insertSelective(ehyRoleModule);
		}
		return rows;
	}

	@Override
	public int updateManMod(String[] roleIdArr, String manId) {
		int rows = 0;
		int deleteRows = ehyManagerRoleMapper.deleteRoleMan(manId);
		if(roleIdArr==null){
			return deleteRows;
		}
		for(int i=0; i<roleIdArr.length; i++){
			EhyManagerRole emr = new EhyManagerRole();
			emr.setMrId(UUID.randomUUID().toString());
			emr.setManId(manId);
			emr.setRoleId(roleIdArr[i]);
			rows += ehyManagerRoleMapper.insertSelective(emr);
		}
		return rows;
	}

	@Override
	public int deleteModRole(String roleId) {
		// TODO Auto-generated method stub
		int rows = ehyRoleModuleMapper.deleteModRole(roleId);
		return rows;
	}

	@Override
	public int deleteManMod(String manId) {
		int deleteRows = ehyManagerRoleMapper.deleteRoleMan(manId);
		return deleteRows;
	}

	@Override
	public List<String> findByRoleId(String roleId) {
		List<String> list = new ArrayList<String>();
		List<EhyRoleModule> list2 = ehyRoleModuleMapper.findByRoleId(roleId);
		for (Iterator<EhyRoleModule> iterator = list2.iterator(); iterator.hasNext();) {
			EhyRoleModule ehyRoleModule = (EhyRoleModule) iterator.next();
			list.add(ehyRoleModule.getModId());
			List<EhyModule> list3 = ehyModuleMapper.findInferior(ehyRoleModule.getModId());
			for (Iterator<EhyModule> iterator2 = list3.iterator(); iterator2.hasNext();) {
				EhyModule ehyRoleModule2 = (EhyModule) iterator2.next();
				list.add(ehyRoleModule2.getModId());
			}
		}
		return list;
	}

	@Override
	public List<String> findByManId(String manId) {
		List<String> list = new ArrayList<String>();
		List<EhyManagerRole> list2 = ehyManagerRoleMapper.findByManId(manId);
		for (Iterator<EhyManagerRole> iterator = list2.iterator(); iterator.hasNext();) {
			EhyManagerRole ehyRoleModule = (EhyManagerRole) iterator.next();
			list.add(ehyRoleModule.getRoleId());
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> showRole() {
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		List<EhyRole> list = ehyRoleMapper.findAll();
		for(EhyRole ro : list){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("name", ro.getRoleName());
			map.put("id", ro.getRoleId());
			map.put("children", null);
			mapList.add(map);
		}
		return mapList;
	}
	
}
