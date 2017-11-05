/**
 * 
 */
package cn.ehuoyuan.shop.service.proshow;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.shop.action.proshow.ProshowVo;
import cn.ehuoyuan.shop.dao.EhyProShowMapper;
import cn.ehuoyuan.shop.dao.EhyProductImgMapper;
import cn.ehuoyuan.shop.dao.EhyProductSpecificationValueMapper;
import cn.ehuoyuan.shop.domain.EhyProShow;

/**
 * 产品展示service接口
 * @author dong
 * @da2017年10月18日
 * @version 1.0
 */
@Service
public class ProshowServiceImpl implements ProshowService{

	@Resource
	private EhyProShowMapper ehyProShowMapper;
	
	@Resource
	private EhyProductImgMapper ehyProductImgMapper;
	
	@Resource
	private EhyProductSpecificationValueMapper ehyProductSpecificationValueMapper;
	
	/**
	 * 增加
	 */
	@Override
	public int insertSelective(EhyProShow record) {
		
		return ehyProShowMapper.insertSelective(record);
	}

	/**
	 * 查询所有
	 */
	@Override
	public List<EhyProShow> findAllshow(Map<String, Object> map) {
		List<EhyProShow> list=ehyProShowMapper.findAllshow(map);
		return list;
	}

	/**
	 * 总行数
	 */
	@Override
	public int findRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ehyProShowMapper.findRowCount(map);
	}

	/**
	 * 根据ID查询
	 */
	@Override
	public EhyProShow selectByPrimaryKey(String showId) {
		EhyProShow list=ehyProShowMapper.selectByPrimaryKey(showId);
		return list;
	}

	/**
	 * 修改或删除方法
	 */
	@Override
	public int updateByPrimaryKeySelective(EhyProShow record) {
		
		return ehyProShowMapper.updateByPrimaryKeySelective(record);
	}

	
	/**
	 * 排序
	 */
	@Override
	public int sortModule(int start, int end, String showId) {
		// TODO Auto-generated method stub
		return ehyProShowMapper.sortModule(start, end, showId);
	}
	
	@Override
	public List<EhyProShow> findAll(EhyProShow proShow) {
		return ehyProShowMapper.findAll(proShow);
	}

	@Override
	public int findTotalRows(EhyProShow proShow) {
		return ehyProShowMapper.findTotalRows(proShow);
	}

	@Override
	public List<ProshowVo> showAll(String stId) {
		
		return ehyProShowMapper.showAll(stId);
	}

	@Override
	public ProshowVo findById(String proId) {
		
		return ehyProShowMapper.findById(proId);
	}

	@Override
	public List<Map<String, Object>> findImgByProId(Map<String, Object> map) {
		
		return ehyProductImgMapper.findImgByProId(map);
	}

	@Override
	public List<Map<String, Object>> findByProId(String proId) {
		// TODO Auto-generated method stub
		return ehyProductSpecificationValueMapper.findByProId(proId);
	}

	

	
	
	
	
}
