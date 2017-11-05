/**
 * 
 */
package cn.ehuoyuan.shop.service.member;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.shop.dao.EhyMemberMapper;
import cn.ehuoyuan.shop.domain.EhyMember;

/**
 * @author WangGuanfu
 *
 */
@Service
public class MemberServiceImpl implements MemberService{
	
	@Resource
	private  EhyMemberMapper ehyMemberMapper;
	
	
	@Override
	public int insertSelective(EhyMember record) { 
		int member =  ehyMemberMapper.insertSelective(record);
		return member;
	}


	@Override
	public EhyMember selectLogin(EhyMember record) {

		EhyMember member =  ehyMemberMapper.selectLogin(record);
		
		return member;
		
	}



	@Override
	public EhyMember selectByPrimaryKey(String mbId) {
		
		return ehyMemberMapper.selectByPrimaryKey(mbId);
	}


	


	@Override
	public int getTatolRows(EhyMember record) {
		
		return ehyMemberMapper.getTatolRows(record);
	}


	@Override
	public List<Map> findAll(Map<String, Object> map) {
		
		return ehyMemberMapper.findAll(map);
	}


	@Override
	public int updateByPrimaryKeySelective(EhyMember record) {
		
		return ehyMemberMapper.updateByPrimaryKeySelective(record);
	}



	@Override
	public int selectPhone(String mbPhone) {
		
		return ehyMemberMapper.selectPhone(mbPhone);
	}


	/**
     * 查询所有会员
     * @author 邓丽杰
	 * @date 2017年10月12日16:12:06
	 * @version 1.1
     */
	public List<EhyMember> findMember() {
		return ehyMemberMapper.findMember();
	}


	@Override
	public int deleteByPrimaryKey(String mbId,String oper) {
		
		return ehyMemberMapper.deleteByPrimaryKey(mbId,oper);
	}


	@Override
	public List<EhyMember> findMenberBy(String mbId) {
			
		return ehyMemberMapper.findMenberBy(mbId);
	}

	/**
     * 根据会员id判断邀请码是否存在
     * @param mbId 会员id
     * @return
     * @author 邓丽杰
	 * @date 2017年10月12日16:12:06
	 * @version 1.1
     */
	@Override
	public int isCode(String mbId) {
		return ehyMemberMapper.isCode(mbId);
	}


	@Override
	public int updateByPrimaryKey(EhyMember record) {
		return ehyMemberMapper.updateByPrimaryKey(record);
	}


	@Override
	public int updateMemberKey(EhyMember record) {
		System.out.println("--------------------来了service修改方法");
		return ehyMemberMapper.updateMemberKey(record);
	}


	@Override
	public int isMbLogin(String mbLogin,String mbId) {
		// TODO Auto-generated method stub
		return ehyMemberMapper.isMbLogin(mbLogin,mbId);
	}


}
