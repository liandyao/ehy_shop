/**
 * 
 */
package cn.ehuoyuan.shop.service.invitationCode;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.ehuoyuan.shop.domain.EhyInvitationCode;

/**
 * 站点代理人的service接口类
 * @author denglijie
 * @2017年10月11日
 * @version v1.0
 */
public interface InvitationCodeService {
	
	/**
	 * 显示代理人
	 * @param map
	 * @return
	 */
	List<Map> findAll(Map<String, Object> map);
	
	/**
	 * 显示总行数
	 * @param map
	 * @return
	 */
	int findRowCount(Map<String, Object> map);
	
	 /**
     * 根据邀请码查询邀请码是否存在
     * @param code
     * @return
     */
    int selectByCode(String code);
    
    /**
     * 根据代理人id查询对象
     * @param inviId
     * @return
     */ 
    EhyInvitationCode selectByPrimaryKey(String inviId);
	
    /**
     * 增加
     * @param record
     * @return
     */
    int insertSelective(EhyInvitationCode invitationCode);
    
	/**
     * 修改或删除
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(EhyInvitationCode record);
    /**
     * 根据会员id修改是否有效
     * @param mbId
     * @return
     */
    int deleteRec(String mbId);

    /**
     * 排序
     * @param startNum
     * @param endNum
     * @param inviId
     * @return
     */
    int sortInvitationCode(Integer startNum,Integer endNum,String inviId);
}
