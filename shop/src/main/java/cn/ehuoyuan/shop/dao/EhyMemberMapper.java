package cn.ehuoyuan.shop.dao;

import java.util.List;
import java.util.Map;

import cn.ehuoyuan.shop.domain.EhyMember;

public interface EhyMemberMapper {
	/**
	 * 根据id伤处删除
	 * @param mbId
	 * @return
	 */
    int deleteByPrimaryKey(String mbId,String oper);

    int insert(EhyMember record);
    /**
     * 前台的用户注册
     * @param record
     * @return
     */
    int insertSelective(EhyMember record);

    

    
    /**
     * 根据ID修改
     * @param record
     * @return
     */
    int updateByPrimaryKey(EhyMember record);
    
    /**
     * 会员登录
     * @param record
     * @return
     */
    EhyMember selectLogin(EhyMember record);

    /**
     * 后台的修改会员信息和前台个人中心修改
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(EhyMember record);
    /**
     * 根据id查对象
     * @param mbId
     * @return
     */
    EhyMember selectByPrimaryKey(String mbId);
    
    /**
	 * 模糊查询
	 * @param map
	 * @return
	 */
	List<Map> findAll(Map<String ,Object> map);
	/**
	 * 模糊查询得到总行数
	 * @param record
	 * @return
	 */
	int getTatolRows(EhyMember record);

    
    /**
     * 查询注册的手机号码
     * @param mbPhone
     * @return
     */
    int selectPhone(String mbPhone);

    /**
     * 查询所有会员
     * @author 邓丽杰
	 * @date 2017年10月12日16:12:06
	 * @version 1.1
     */
    List<EhyMember> findMember();
    
    /**
     * 根据会员id判断邀请码是否存在
     * @param mbId 会员id
     * @return
     * @author 邓丽杰
	 * @date 2017年10月12日16:12:06
	 * @version 1.1
     */
    int isCode(String mbId);
    
    /**
     * 根据ID会员信息
     * @param mbId
     * @return
     */
    List<EhyMember> findMenberBy(String mbId);
    
    /**
     * 根据手机号码修改会员关键信息
     * @param mbPhone
     * @return
     */
    int updateMemberKey(EhyMember record);
    /**
     * 查询登录账号是否存在
     * @param mbLogin
     * @return
     */
    int isMbLogin(String mbLogin,String mbId);
  
}