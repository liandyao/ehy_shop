package cn.ehuoyuan.shop.service.member.address;

import java.util.List;

import cn.ehuoyuan.shop.domain.EhyAddress;

/**
 * 收货地址的接口类
 * @author WangGuanfu
 *
 */
public interface AddressService {

	/**
	 * 增加收货地址
	 * @param record
	 * @return
	 */
	int  insertSelective(EhyAddress record);
	
	
	/**
     * 根据会员ID查询收货地址
     * @param mbId
     * @return
     */
	List<EhyAddress> selectByMbId(String mbId);
	
	  /**
     * 根据ID查询收货地址
     * @param addId
     * @return
     */
	 List<EhyAddress> selectByPrimaryKey(String addId);
	 
	 
	   /**
	     * 修改收货地址
	     * @param record
	     * @return
	     */
	    int updateByPrimaryKeySelective(EhyAddress record);
	    

		/**
		 * 根据ID删除
		 * @param addId
		 * @return
		 */
	    int deleteByPrimaryKey(String addId);
	    
	    
	    
	    /**
	     * 根据收货地址ID修改排序
	     * @param addId
	     * @return
	     */
	    int updateSortById(String addId);
	    
	    
	    int updateSort();
}
