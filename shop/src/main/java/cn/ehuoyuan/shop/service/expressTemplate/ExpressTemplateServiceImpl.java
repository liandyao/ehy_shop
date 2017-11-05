/**
 * 
 */
package cn.ehuoyuan.shop.service.expressTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.shop.dao.EhyExpressTemplateMapper;
import cn.ehuoyuan.shop.domain.EhyExpressTemplate;

/**
 * 运费模版的service接口实现类
 * @author denglijie
 * @date 2017年10月17日 下午 15:29:09
 * @version 1.0
 */
@Service
public class ExpressTemplateServiceImpl implements ExpressTemplateService{

	@Resource
	private EhyExpressTemplateMapper ehyExpressTemplateMapper;
	
	/**
	 * 查询运费模版
	 */
	public List<Map> findAll(Map<String, Object> map) {
		return ehyExpressTemplateMapper.findAll(map);
	}

	/**
	 * 查询总行数
	 */
	public int findRowCount(Map<String, Object> map) {
		return ehyExpressTemplateMapper.findRowCount(map);
	}

	/**
	 * 增加运费模版
	 */
	@Override
	public int insertSelective(EhyExpressTemplate expressTemplate) {
		return ehyExpressTemplateMapper.insertSelective(expressTemplate);
	}

	/**
	 * 根据id查找运费模版
	 */
	@Override
	public EhyExpressTemplate findById(String tempId) {
		return ehyExpressTemplateMapper.findById(tempId);
	}

	/**
	 * 修改运费模版
	 */
	@Override
	public int updateSelective(EhyExpressTemplate expressTemplate) {
		return ehyExpressTemplateMapper.updateSelective(expressTemplate);
	}

	@Override
	public List<EhyExpressTemplate> findByStId(String stId) {
		List<EhyExpressTemplate> list = ehyExpressTemplateMapper.findByStId(stId);
		List<EhyExpressTemplate> listVo = new ArrayList<EhyExpressTemplate>();
		BigDecimal num = new BigDecimal("100");
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			EhyExpressTemplate ehyExpressTemplate = (EhyExpressTemplate) iterator.next();
			if(ehyExpressTemplate.getMoney()!=null && !"".equals(ehyExpressTemplate.getMoney())){
				ehyExpressTemplate.setMoney(new BigDecimal(ehyExpressTemplate.getMoney().toString()).divide(num,2));
			}
			listVo.add(ehyExpressTemplate);
		}
		return listVo;
	}

	/**
	 * 排序
	 */
	@Override
	public int sortTemplate(Integer startNum, Integer endNum, String tempId) {
		return ehyExpressTemplateMapper.sortTemplate(startNum, endNum, tempId);
	}

}
