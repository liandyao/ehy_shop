/**
 * 
 */
package cn.ehuoyuan.shop.service.privilege;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.shop.dao.EhyManagerMapper;
import cn.ehuoyuan.shop.domain.EhyManager;

/**
 * 后台用户管理Service接口的实现类
 * @author zengren
 * @date 2017年9月28日
 * version v1.0
 */
@Service
public class ManagerServiceImpl implements ManagerService{
	
	@Resource
	private EhyManagerMapper ehyManagerMapper;
	
	@Override
	public EhyManager isLogin(EhyManager record){
		EhyManager manager = ehyManagerMapper.isLogin(record);
		return manager;
	}

	@Override
	public boolean addManager(EhyManager record) {
		if("".equals(record.getStId())){
			record.setStId(null);
		}
		return ehyManagerMapper.insertSelective(record)>0;
	}

	@Override
	public boolean deleteManager(String manId) {
		return ehyManagerMapper.delete(manId)>0;
	}

	@Override
	public boolean updateManager(EhyManager record) {
		if("".equals(record.getStId())){
			record.setStId(null);
		}
		return ehyManagerMapper.updateByPrimaryKey(record)>0;
	}

	@Override
	public List<EhyManager> findAllPage(EhyManager record, Pages pages) {
		return ehyManagerMapper.findAllPage(record, pages);
	}

	@Override
	public EhyManager findById(String manId) {
		// TODO Auto-generated method stub
		return ehyManagerMapper.selectByPrimaryKey(manId);
	}

	@Override
	public int countRows(EhyManager record) {
		// TODO Auto-generated method stub
		return ehyManagerMapper.countRows(record);
	}

	@Override
	public boolean findByName(String manUser) {
		// TODO Auto-generated method stub
		return ehyManagerMapper.findByName(manUser)>0;
	};
	
	
	
}
