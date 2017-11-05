/**
 * 
 */
package cn.ehuoyuan.shop.service.privilege;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.dao.EhyModuleMapper;
import cn.ehuoyuan.shop.domain.EhyModule;

/**
 * 后台角色管理action
 * @author zengren
 * @date 2017年9月28日
 * @version v1.0
 */
@Service
public class ModuleServiceImpl implements ModuleService{
	
	@Resource
	private EhyModuleMapper ehyModuleMapper;

	@Override
	public int addEhyModule(EhyModule module) {
		if("".equals(module.getEhyModId())){
			module.setEhyModId(null);
		}
		module.setSort(this.maxSort());
		return ehyModuleMapper.insertSelective(module);
	}

	@Override
	public int deleteEhyModule(String modId) {
		
		return ehyModuleMapper.deleteEhyModule(modId);
	}

	@Override
	public int updateEhyModule(EhyModule module) {
		if("".equals(module.getEhyModId())){
			module.setEhyModId(null);
		}
		return ehyModuleMapper.updateByPrimaryKeySelective(module);
	}

	@Override
	public List<EhyModule> findAllPage(EhyModule module, Pages pages) {
		// TODO Auto-generated method stub
		if(Tools.isEmpty(module.getEhyModId())){
			module.setEhyModId(null);
		}
		return ehyModuleMapper.findAllPage(module, pages);
	}

	@Override
	public EhyModule findById(String modId) {
		// TODO Auto-generated method stub
		return ehyModuleMapper.selectByPrimaryKey(modId);
	}

	@Override
	public int conutRows(EhyModule module) {
		// TODO Auto-generated method stub
		if(Tools.isEmpty(module.getEhyModId())){
			module.setEhyModId(null);
		}
		return ehyModuleMapper.countRows(module);
	}

	@Override
	public List<EhyModule> findFirstLevel() {
		// TODO Auto-generated method stub
		return ehyModuleMapper.findFirstLevel();
	}

	@Override
	public List<EhyModule> findAll() {
		// TODO Auto-generated method stub
		return ehyModuleMapper.findAll();
	}

	@Override
	public int maxSort() {
		// TODO Auto-generated method stub
		return ehyModuleMapper.maxSort();
	}

	@Override
	public int sortModule(int start, int end, String modId) {
		// TODO Auto-generated method stub
		return ehyModuleMapper.sortModule(start, end, modId);
	}

	
	
}
