/**
 * 
 */
package cn.ehuoyuan.shop.service.memberLevel;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.shop.dao.EhyMemberLevelMapper;
import cn.ehuoyuan.shop.domain.EhyMemberLevel;

/**
 * 会员等级Service 实现类
 * @author Weimianwu
 * 2017年10月9日 下午6:12:36
 * version v1.0
 */
@Service
public class MemberLevelServiceImpl implements MemberLevelService{
	
	@Resource
	private EhyMemberLevelMapper ehyMemberLevelMapper ;
	
	@Override
	public List<Map> findAll(Map<String, Object> map) {
		
		return ehyMemberLevelMapper.findAll(map);
	}
	
	@Override
	public int getTatolRows(Map<String, Object> map) {
		
		return ehyMemberLevelMapper.getTatolRows(map);
	}

	public int insertSelective(EhyMemberLevel record) {
	
		return ehyMemberLevelMapper.insertSelective(record);
	}

	@Override
	public Map<String ,Object> selectByPrimaryKey(String levelId) {
		
		return ehyMemberLevelMapper.selectByPrimaryKey(levelId);
	}

	@Override
	public int updateByPrimaryKeySelective(EhyMemberLevel record) {
		
		return ehyMemberLevelMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public List<EhyMemberLevel> ehyMemberLevelFindAll() {
		
		return ehyMemberLevelMapper.ehyMemberLevelFindAll();
	}

	@Override
	public int deleteByPrimaryKey(String levelId) {
		
		return ehyMemberLevelMapper.deleteByPrimaryKey(levelId);
	}

	@Override
	public int sortMemberLevel(int start, int end, String levelId) {
		// TODO Auto-generated method stub
		return ehyMemberLevelMapper.sortMemberLevel(start, end, levelId);
	}

	@Override
	public int isLevelName(String LevelName) {
		
		return ehyMemberLevelMapper.isLevelName(LevelName);
	}

	@Override
	public int maxSort() {
		// TODO Auto-generated method stub
		return ehyMemberLevelMapper.maxSort();
	}

	

}
