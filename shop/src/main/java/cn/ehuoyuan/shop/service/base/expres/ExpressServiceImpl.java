/**
 * 
 */
package cn.ehuoyuan.shop.service.base.expres;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.shop.dao.EhyExpressMapper;
import cn.ehuoyuan.shop.domain.EhyExpress;

/**
 * 物流service接口
 * @author dong
 * @da2017年10月7日
 * @version 1.0
 */
@Service
public class ExpressServiceImpl implements ExpressService{

	@Resource
	private EhyExpressMapper ehyExpressMapper;
	
	
	/**
	 * 查询所有
	 */
	@Override
	public List<EhyExpress> findAll(Map<String, Object> map) {
		List<EhyExpress> list=ehyExpressMapper.findAll(map);
		return list;
	}


	/**
	 * 总行数
	 */
	@Override
	public int findRowCount(Map<String, Object> map) {
		int i=ehyExpressMapper.findRowCount(map);
		return i;
	}

	/**
	 * 删除方法
	 */
	@Override
	public int updateByPrimaryKeySelective(EhyExpress record) {
		return ehyExpressMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 增加方法
	 */
	@Override
	public int insert(EhyExpress record) {
		System.out.println("来了service"+record.getName());
		return ehyExpressMapper.insert(record);
	}


	/**
	 * 根据ID查询
	 */
	@Override
	public EhyExpress selectByPrimaryKey(String expreessId) {
		
		return ehyExpressMapper.selectByPrimaryKey(expreessId);
	}

	/**
	 * 修改
	 */
	@Override
	public int update(EhyExpress record) {
		// TODO Auto-generated method stub
		return ehyExpressMapper.update(record);
	}

	/**
     * 查询所有的快递
     * @author 邓丽杰
     * @date 2017年10月18日13:58:10
	 * @version 1.1
     */
	@Override
	public List<EhyExpress> findExpress() {
		return ehyExpressMapper.findExpress();
	}



	
		
	
}
