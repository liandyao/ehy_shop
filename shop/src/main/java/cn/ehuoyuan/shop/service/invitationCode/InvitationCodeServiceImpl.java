/**
 * 
 */
package cn.ehuoyuan.shop.service.invitationCode;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.shop.dao.EhyInvitationCodeMapper;
import cn.ehuoyuan.shop.domain.EhyInvitationCode;

/**
 * 站点代理人的service实现类
 * @author denglijie
 * @2017年10月11日
 * @version v1.0
 */
@Service
public class InvitationCodeServiceImpl implements InvitationCodeService{

	@Resource
	private EhyInvitationCodeMapper ehyInvitationCodeMapper;
	
	/**
	 * 查询代理人
	 */
	public List<Map> findAll(Map<String, Object> map) {
		return ehyInvitationCodeMapper.findAll(map);
	}

	/**
	 * 查询总行数
	 */
	public int findRowCount(Map<String, Object> map) {
		return ehyInvitationCodeMapper.findRowCount(map);
	}

	/**
	 * 修改或删除
	 */
	public int updateByPrimaryKeySelective(EhyInvitationCode record) {
		
		return ehyInvitationCodeMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 根据邀请码查询邀请码是否存在
	 */
	public int selectByCode(String code) {
		return ehyInvitationCodeMapper.selectByCode(code);
	}

	/**
	 * 根据代理人id查询对象
	 */
	public EhyInvitationCode selectByPrimaryKey(String inviId) {
		return ehyInvitationCodeMapper.selectByPrimaryKey(inviId);
	}

	/**
	 * 增加
	 */
	public int insertSelective(EhyInvitationCode invitationCode) {
		return ehyInvitationCodeMapper.insertSelective(invitationCode);
	}

	@Override
	public int deleteRec(String mbId) {
		// TODO Auto-generated method stub
		return ehyInvitationCodeMapper.deleteRec(mbId);
	}

	/**
	 * 排序
	 */
	public int sortInvitationCode(Integer startNum, Integer endNum, String inviId) {
		return ehyInvitationCodeMapper.sortInvitationCode(startNum, endNum, inviId);
	}

}
