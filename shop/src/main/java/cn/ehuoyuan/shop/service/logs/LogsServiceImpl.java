/**
 * 
 */
package cn.ehuoyuan.shop.service.logs;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import cn.ehuoyuan.shop.action.logs.vo.EhyLogsVo;
import cn.ehuoyuan.shop.dao.EhyLogsMapper;
import cn.ehuoyuan.shop.domain.EhyLogs;

/**
 * 类的描述：日志的Service接口实现类
 * @author 罗海兵
 * @date 2017年9月30日
 */
@Service
public class LogsServiceImpl implements LogsService{
	
	@Resource
	private EhyLogsMapper ehyLogsMapper;

	@Override
	public int deleteByPrimaryKey(String logsId) {
		
		return ehyLogsMapper.deleteByPrimaryKey(logsId);
	}

	@Override
	public int insert(EhyLogsVo record) {
		EhyLogs logs=new EhyLogs();
		BeanUtils.copyProperties(record, logs);
		return ehyLogsMapper.insert(logs);
	}

	@Override
	public int insertSelective(EhyLogsVo record) {
		EhyLogs logs=new EhyLogs();
		BeanUtils.copyProperties(record, logs);
		return ehyLogsMapper.insertSelective(logs);
	}

	@Override
	public EhyLogsVo selectByPrimaryKey(String logsId) {
		EhyLogs logs=ehyLogsMapper.selectByPrimaryKey(logsId);
		EhyLogsVo vo=new EhyLogsVo();
		BeanUtils.copyProperties(logs, vo);
		return vo;
	}

	@Override
	public List<EhyLogsVo> select(EhyLogsVo record) {
		EhyLogs logs=new EhyLogs();
		BeanUtils.copyProperties(record, logs);
		List<EhyLogs> list=ehyLogsMapper.select(logs);
		List<EhyLogsVo> listVo=new ArrayList<EhyLogsVo>();
		for(EhyLogs po:list){
			EhyLogsVo vo=new EhyLogsVo();
			BeanUtils.copyProperties(po, vo);
			listVo.add(vo);
		}
		return listVo;
	}

	@Override
	public List<EhyLogsVo> selectAll() {
		List<EhyLogs> list=ehyLogsMapper.selectAll();
		List<EhyLogsVo> listVo=new ArrayList<EhyLogsVo>();
		for(EhyLogs po:list){
			EhyLogsVo vo=new EhyLogsVo();
			BeanUtils.copyProperties(po, vo);
			listVo.add(vo);
		}
		return listVo;
	}

	@Override
	public int updateByPrimaryKeySelective(EhyLogsVo record) {
		EhyLogs logs=new EhyLogs();
		BeanUtils.copyProperties(record, logs);
		return ehyLogsMapper.updateByPrimaryKeySelective(logs);
	}

	@Override
	public int updateByPrimaryKey(EhyLogsVo record) {
		EhyLogs logs=new EhyLogs();
		BeanUtils.copyProperties(record, logs);
		return ehyLogsMapper.updateByPrimaryKey(logs);
	}

	
}
