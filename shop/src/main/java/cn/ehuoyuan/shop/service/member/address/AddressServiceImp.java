/**
 * 
 */
package cn.ehuoyuan.shop.service.member.address;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.shop.dao.EhyAddressMapper;
import cn.ehuoyuan.shop.domain.EhyAddress;

/**
 * 
 * @author WangGuanfu
 *
 */
@Service
public class AddressServiceImp implements AddressService{
	
	@Resource
	private EhyAddressMapper ehyAddressMapper;
	
	@Override
	public int insertSelective(EhyAddress record) {
		// TODO Auto-generated method stub
		return ehyAddressMapper.insertSelective(record);
	}

	@Override
	public List<EhyAddress> selectByMbId(String mbId) {
		// TODO Auto-generated method stub
		return ehyAddressMapper.selectByMbId(mbId);
	}

	@Override
	public List<EhyAddress> selectByPrimaryKey(String addId) {
		// TODO Auto-generated method stub
		return ehyAddressMapper.selectByPrimaryKey(addId);
	}

	@Override
	public int updateByPrimaryKeySelective(EhyAddress record) {
		// TODO Auto-generated method stub
		return ehyAddressMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPrimaryKey(String addId) {
		// TODO Auto-generated method stub
		return ehyAddressMapper.deleteByPrimaryKey(addId);
	}

	@Override
	public int updateSortById(String addId) {
		// TODO Auto-generated method stub
		return ehyAddressMapper.updateSortById(addId);
	}

	@Override
	public int updateSort() {
		// TODO Auto-generated method stub
		return ehyAddressMapper.updateSort();
	}

	
}
