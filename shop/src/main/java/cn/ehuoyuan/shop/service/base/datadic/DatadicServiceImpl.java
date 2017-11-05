/**
 * 
 */
package cn.ehuoyuan.shop.service.base.datadic;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.shop.dao.EhyDatadicMapper;
import cn.ehuoyuan.shop.domain.EhyDatadic;

/**
 * 数据字典service接口
 * @author dong
 * @da2017年10月16日
 * @version 1.0
 */
@Service
public class DatadicServiceImpl implements DatadicService{

	@Resource
	private EhyDatadicMapper ehyDatadicMapper;
	
	
	/**
	 * 查询所有
	 */
	@Override
	public List<EhyDatadic> findAll(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ehyDatadicMapper.findAll(map);
	}

	
	/**
	 * 总行数
	 */
	@Override
	public int findRowCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ehyDatadicMapper.findRowCount(map);
	}


	/**
	 * 删除和修改方法
	 */
	@Override
	public int updateByPrimaryKeySelective(EhyDatadic record) {
		// TODO Auto-generated method stub
		return ehyDatadicMapper.updateByPrimaryKeySelective(record);
	}


	/**
	 * 增加方法
	 */
	@Override
	public int insert(EhyDatadic record) {
		// TODO Auto-generated method stub
		return ehyDatadicMapper.insert(record);
	}


	/**
	 * 根据ID查询
	 */
	@Override
	public EhyDatadic selectByPrimaryKey(String dicId) {
		// TODO Auto-generated method stub
		return ehyDatadicMapper.selectByPrimaryKey(dicId);
	}


	@Override
	public int insertSelective(EhyDatadic record) {
		
		return ehyDatadicMapper.insertSelective(record);
	}


	@Override
	public List<EhyDatadic> findByDicName(String dicName) {
		
		return ehyDatadicMapper.findByDicName(dicName);
	}


	@Override
	public int deleteLevelId(String code) {
		// TODO Auto-generated method stub
		return ehyDatadicMapper.deleteLevelId(code);
	}

	/**
	 * 根据名称和编号查询是否存在该条信息 返回查询到的行数
	 * @author 胡鑫
	 * @date 2017年11月4日10:38:45
	 * @param record 字典对象
	 * @return 返回查询到的行数
	 */
	@Override
	public int selectNameAndCodeIsva(EhyDatadic record) {
		return ehyDatadicMapper.selectNameAndCodeIsva(record);
	}

}
