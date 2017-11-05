package cn.ehuoyuan.shop.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import cn.ehuoyuan.shop.domain.EhyAddress;

@Service
public interface EhyAddressMapper {
	
	/**
	 * 根据ID删除
	 * @param addId
	 * @return
	 */
    int deleteByPrimaryKey(String addId);

    int insert(EhyAddress record);

    /**
     * 增加收货地址
     * @param record
     * @return
     */
    int insertSelective(EhyAddress record);
    
    /**
     * 根据ID查询收货地址
     * @param addId
     * @return
     */
    List<EhyAddress> selectByPrimaryKey(String addId);

    int updateByPrimaryKeySelective(EhyAddress record);
    
    /**
     * 修改收货地址
     * @param record
     * @return
     */
    int updateByPrimaryKey(EhyAddress record);
    
    /**
     * 根据会员ID查询收货地址
     * @param mbId
     * @return
     */
    List<EhyAddress> selectByMbId(String mbId);
    
    
    /**
     * 根据收货地址ID修改排序
     * @param addId
     * @return
     */
    int updateSortById(String addId);
    
    
    int updateSort();
    
}