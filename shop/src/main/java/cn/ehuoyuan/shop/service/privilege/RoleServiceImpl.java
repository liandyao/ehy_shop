/**
 * 
 */
package cn.ehuoyuan.shop.service.privilege;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.shop.dao.EhyRoleMapper;
import cn.ehuoyuan.shop.domain.EhyRole;

/**
 * 角色Service接口实现类
 * @author zengren
 * @date 2017年10月10日
 * version v1.0
 */
@Service
public class RoleServiceImpl implements RoleService{
	
	@Resource
	private EhyRoleMapper ehyRoleMapper;
	
	@Override
	public int addRole(EhyRole role) {
		// TODO Auto-generated method stub
		return ehyRoleMapper.insertSelective(role);
	}

	@Override
	public int deleteRole(String roleId) {
		// TODO Auto-generated method stub
		return ehyRoleMapper.deleteRole(roleId);
	}

	@Override
	public int updateRole(EhyRole role) {
		// TODO Auto-generated method stub
		return ehyRoleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public Map<String, Object> findAllPage(EhyRole role, Pages pages) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", "");
		map.put("msg", "");
		map.put("count", ehyRoleMapper.countRows(role));
		map.put("data", ehyRoleMapper.findAllPage(role, pages));
		return map;
	}

	@Override
	public int countRows(EhyRole role) {
		// TODO Auto-generated method stub
		return ehyRoleMapper.countRows(role);
	}

	@Override
	public EhyRole findById(String roleId) {
		// TODO Auto-generated method stub
		return ehyRoleMapper.selectByPrimaryKey(roleId);
	}
	
}
