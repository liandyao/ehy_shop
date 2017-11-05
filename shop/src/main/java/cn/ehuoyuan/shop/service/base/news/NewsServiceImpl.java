/**
 * 
 */
package cn.ehuoyuan.shop.service.base.news;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import cn.ehuoyuan.shop.dao.EhyNewsMapper;
import cn.ehuoyuan.shop.domain.EhyNews;

/**
 * 公告service接口
 * @author dong
 * @da2017年10月12日
 * @version 1.0
 */
@Service
public class NewsServiceImpl implements NewsService{

	@Resource
	private EhyNewsMapper ehyNewsMapper;
	
	
	/**
	 * 增加方法
	 */
	@Override
	public int insert(EhyNews record) {
		
		return ehyNewsMapper.insert(record);
	}

	
	/**
	 * 查询所有
	 */
	@Override
	public List<EhyNews> findAll(Map<String, Object> map) {
		List<EhyNews> list=ehyNewsMapper.findAll(map);
		return list;
	}


	/**
	 * 总行数
	 */
	@Override
	public int findRowCount(Map<String, Object> map) {
		
		return ehyNewsMapper.findRowCount(map);
	}


	/**
	 * 修改或删除方法
	 */
	@Override
	public int updateByPrimaryKeySelective(EhyNews record) {
		
		return ehyNewsMapper.updateByPrimaryKeySelective(record);
	}


	/**
	 * 根据ID查询
	 */
	@Override
	public EhyNews selectByPrimaryKey(String newsId) {
		// TODO Auto-generated method stub
		return ehyNewsMapper.selectByPrimaryKey(newsId);
	}


	
	/**
	 * 修改，取消置顶
	 */
	@Override
	public int updateByPrimaryKey(String newsId) {
		// TODO Auto-generated method stub
		return ehyNewsMapper.updateByPrimaryKey(newsId);
	}

	/**
	 * 修改，置顶
	 */
	@Override
	public int update(String newsId) {
		return ehyNewsMapper.update(newsId);
	}

	/**
	 * 根据站点查询是否该站点存在置顶 
	 */
	@Override
	public String showstation(String station) {
		
		return ehyNewsMapper.showstation(station);
	}


	/**
	 * 根据站点标识码查询公告
	 */
	@Override
	public List<EhyNews> shownews(String station) {
		// TODO Auto-generated method stub
		return ehyNewsMapper.shownews(station);
	}

	/**
	 * 根据站点标识码查询更多公告
	 */
	@Override
	public List<EhyNews> show(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ehyNewsMapper.show(map);
	}


	/**
	 * 更多公告总行数
	 */
	@Override
	public int showRowCount(String newsId) {
		// TODO Auto-generated method stub
		return ehyNewsMapper.showRowCount(newsId);
	}

}
