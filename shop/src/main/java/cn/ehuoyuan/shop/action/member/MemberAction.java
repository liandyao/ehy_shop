/**
 * 
 */
package cn.ehuoyuan.shop.action.member;

import java.io.File;
import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import java.io.PrintWriter;


import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.apache.log4j.TTCCLayout;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.FileTools;
import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.common.PhoneMessageUtils;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhyArea;
import cn.ehuoyuan.shop.domain.EhyInvitationCode;
import cn.ehuoyuan.shop.domain.EhyManager;
import cn.ehuoyuan.shop.domain.EhyMember;
import cn.ehuoyuan.shop.domain.EhyMemberLevel;
import cn.ehuoyuan.shop.domain.EhyStation;
import cn.ehuoyuan.shop.service.base.area.EhyAreaService;
import cn.ehuoyuan.shop.service.invitationCode.InvitationCodeService;
import cn.ehuoyuan.shop.service.member.MemberService;
import cn.ehuoyuan.shop.service.station.StationService;

/**
*
* @author WangGuanfu
* @date 2017年10月2日
* version v1.0
*/
@Controller
@RequestMapping("/member")
public class MemberAction {
	
	@Resource
	private MemberService memberService;
	/**
	 * 注入站点的service
	 */
	@Resource
	private StationService stationService;
	/**
	 * 注入邀请码的service
	 */
	@Resource
	private InvitationCodeService invitationCodeService;
	/**
	 * 注入地区的ID
	 */
	@Resource
	private EhyAreaService ehyAreaService;
	
	EhyMessage mes = new EhyMessage();
	
	/**
	 * 验证会员是否登陆
	 * @param session HttpSession会话对象
	 * @return 已登陆返回true,未登陆返回false
	 * @author 罗海兵
	 * @dateTime 2017年10月30日 上午9:41:11
	 * @versions 1.0
	 */
	@RequestMapping("front/isLogin")
	@ResponseBody
	public boolean isLogin(HttpSession session){
		EhyMember login=(EhyMember) session.getAttribute("login");
		return login!=null;
	}
	
	/**
	 * 获取手机验证码
	 * @author WangGuanfu
	 * @param mbPhone
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping("/front/yzm")
	@ResponseBody
	public EhyMessage getYzm(String mbPhone,HttpSession session,HttpServletRequest request) {
		
		System.out.println(mbPhone);
		EhyMessage mes = new EhyMessage();
		String yzm = Tools.getRandomString(4);
		System.out.println("---------"+yzm);
		try {
			String sun =PhoneMessageUtils.sms(mbPhone,"您注册的验证码是:"+yzm);
			if(sun!=null){
				mes.setState(1);
				HttpSession  sessionYzm =request.getSession();
				sessionYzm.setAttribute("yzm", yzm);
			}
		} catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mes;
	}
	
	/**
	 * 前台注册
	 * @author WangGuanfu
	 * @param record
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/front/register")
	@ResponseBody
	public EhyMessage register(EhyMember record , HttpServletRequest request,HttpSession session){
			EhyMessage mes = new EhyMessage();
			HttpSession session1 = request.getSession();
			String mbyzm = request.getParameter("yzm");
			String se  =  (String) session1.getAttribute("yzm");
			System.out.println("========"+record.getMbPhone());
			//查询数据库手机号码注册的条数
			int codeRow = 0 ;
			int row=memberService.selectPhone(record.getMbPhone());
			
			if(record.getInvitationCode()==null || record.getInvitationCode().equals("")){
				record.setLevelId("1");
				record.setMbIsbzj(0);
				if(se.equals(mbyzm) && row==0){
					String m = Tools.password(record.getMbLoginPwd());
					record.setMbName("USER_"+Tools.getRandomString(5));//默认会员姓名
					record.setMbLoginPwd(m);//会员登录密码
					record.setMbLevel(1);//默认会员等级
					record.setMbRemark("/upload/member/1508546596_xq92ugo5.jpg");
					record.setInvitationCode(record.getInvitationCode());//会员邀请码
					String path = "member";
				
					int rows =memberService.insertSelective(record);
					EhyMember member =memberService.selectByPrimaryKey(record.getMbId());
					System.out.println("==================================================="+member.getMbId());
					HttpSession  sessionYzm =request.getSession();
					sessionYzm.setAttribute("login", member);
					mes.setState(1);
				}
			}else{
				codeRow= invitationCodeService.selectByCode(record.getInvitationCode());
				if(codeRow>0){
					record.setLevelId("2");
					record.setMbIsbzj(0);
					if(se.equals(mbyzm) && row==0){
						String m = Tools.password(record.getMbLoginPwd());
						record.setMbName("USER_"+Tools.getRandomString(5));//默认会员姓名
						record.setMbLoginPwd(m);//会员登录密码
						record.setMbLevel(1);//默认会员等级
						record.setInvitationCode(record.getInvitationCode());//会员邀请码
						record.setMbRemark("/upload/member/1508546596_xq92ugo5.jpg");
						int rows =memberService.insertSelective(record);
						EhyMember member =memberService.selectByPrimaryKey(record.getMbId());
						
						HttpSession  sessionYzm =request.getSession();
						sessionYzm.setAttribute("login", member);
						mes.setState(1);
					
					}else{
						mes.setState(0);
					}	
				}else{
					mes.setState(2);
				}
				
				
			}

		return mes;
		
	}
	
	/**
	 * 前台登录
	 * @author WangGuanfu
	 * @param record
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping("/front/login")
	@ResponseBody
	public EhyMessage login(EhyMember record ,HttpServletRequest request , HttpSession session){
		    
			EhyMessage mes = new EhyMessage();
			String loginName = request.getParameter("mbPhones");
			record.setMbPhone(loginName);
			record.setMbLogin(loginName);
			String m = Tools.password(record.getMbLoginPwd());
			record.setMbLoginPwd(m);
			EhyMember login= memberService.selectLogin(record);
			if(login!=null){
				
				HttpSession  sessionYzm =request.getSession();
				sessionYzm.setAttribute("login", login);
				mes.setState(1);
			}else{
				mes.setState(0);
			}
			return mes;
		
	}
	
	
	
	/**
	 * 查询所有
	 * @param page 开始的页数
	 * @param limit 结束的页数
	 * @param member 查询的参数
	 * @return map 返回值
	 */
	@RequestMapping("/back/findAll")
	@ResponseBody  
	public Map<String,Object> findAll(int page,int limit,EhyMember member){
		Map<String,Object> map = new HashMap<String, Object>();
		/*Tools.isEmpty(memberLevel.getLevelName());*/
		if(Tools.isEmpty(member.getMbName())==true)member.setMbName(null);
		if(Tools.isEmpty(member.getMbPhone())==true)member.setMbPhone(null);
		if(Tools.isEmpty(member.getLevelId())==true)member.setLevelId(null);
		//if(Tools.isEmpty(member.getMbIsbzj()==true)member.setLevelId(null);
		
		
		


		Pages pages=new Pages();
		pages.setCurPage(page);
		pages.setMaxResult(limit);
		Map<String,Object> mapParam = new HashMap<String, Object>();
		mapParam.put("firstRows", pages.getFirstRows());
		mapParam.put("maxResult", pages.getMaxResult());
		mapParam.put("mbName", member.getMbName());
		mapParam.put("mbPhone", member.getMbPhone());
		mapParam.put("levelId", member.getLevelId());
		mapParam.put("mbIsbzj", member.getMbIsbzj());
		List<Map> list  = memberService.findAll(mapParam);
		int totalRows = memberService.getTatolRows(member);


		map.put("count", totalRows);
		map.put("data", list);
		map.put("code",0);
		map.put("msg", "");
		return map;

	}
	
	/**
	 * 修改会员照片
	 */
	@RequestMapping("/back/updateMemberPhoto")
	@ResponseBody  //ajax注解
	public EhyMessage updateMemberPhoto(@RequestParam(value = "file", required = false) MultipartFile file, 
					HttpServletRequest request, ModelMap model,EhyMember member){
		/*System.out.println("文件名："+file.getOriginalFilename());
	 	String path = request.getRealPath("upload/member/");
	 	System.out.println("路径是："+path);*/
		String  photo =null;
	 	String fileName = file.getOriginalFilename();
	 	if(fileName!=null || "".equals(fileName)){
	 		String path="member";
	 		try {
				 photo =FileTools.saveFile(path, file);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
	 	}
       /* File targetFile = new File(path,fileName);
       
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        EhyManager ehyManager = (EhyManager) request.getSession().getAttribute("manager");
        member.setOper(ehyManager.getManUser());
        member.setMbRemark(photo);
        int rows= memberService.updateByPrimaryKeySelective(member);
        if(rows>0){
			mes.setMes(EhyMessage.SUCCESS_MES);
			mes.setState(EhyMessage.SUCCESS);
		}else{
			mes.setMes(EhyMessage.ERROR_MES);
			mes.setState(EhyMessage.ERROR);
		}
        return mes;
	}
	
	
	/**
	 * 修改前台会员照片
	 */
	@RequestMapping("/front/updatePhoto")
	@ResponseBody
	public EhyMessage updatePhoto(@RequestParam(value = "file", required = false) MultipartFile file, 
					HttpServletRequest request, ModelMap model){
	
		String  photo =null;
	 	String fileName = file.getOriginalFilename();
	 	System.out.println("========================="+file);
	 	if(fileName!=null || "".equals(fileName)){
	 		String path="member";
	 		try {
				 photo =FileTools.saveFile(path, file);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
	 	}
      
        EhyMember member = (EhyMember) request.getSession().getAttribute("login");
       
        member.setMbId(member.getMbId());
        member.setMbRemark(photo);
        int rows= memberService.updateByPrimaryKeySelective(member);
        System.out.println("---------------------------------------------------"+member.getMbRemark());
        if(rows>0){
			mes.setMes(member.getMbRemark());
			mes.setState(EhyMessage.SUCCESS);
		}else{
			mes.setMes(EhyMessage.ERROR_MES);
			mes.setState(EhyMessage.ERROR);
		}
        return mes;
	}
	/**
	 * 根据id查对象
	 * @param levelId
	 * @return
	 */
	@RequestMapping("/back/findById")
	@ResponseBody  
	public EhyMember findById(String mbId){
		EhyMember member= memberService.selectByPrimaryKey(mbId);
		if(member!=null){
			return member;
		}else{
			return null;
		}
	}
	
	/**
	 * 根据id删除
	 * @param levelId
	 * @return
	 */
	@RequestMapping("/back/deleteRec")
	@ResponseBody  
	public EhyMessage deleteRec(String mbId,HttpServletRequest request){
		
		EhyManager ehyManager = (EhyManager) request.getSession().getAttribute("manager");
		
		int rows= memberService.deleteByPrimaryKey(mbId,ehyManager.getManUser());
		
		if(rows>0){
			int count = invitationCodeService.deleteRec(mbId);
			if(count>0){

				mes.setMes(EhyMessage.SUCCESS_MES);
				mes.setState(EhyMessage.SUCCESS);
			}else{
				mes.setMes(EhyMessage.ERROR_MES);
				mes.setState(EhyMessage.ERROR);
			}
		}else{
			mes.setMes(EhyMessage.ERROR_MES);
			mes.setState(EhyMessage.ERROR);
		}
		return mes;

	}
	/**
	 * 查询分站
	 * @return
	 */
	@RequestMapping("/back/selectStation")
	@ResponseBody 
	public List<EhyStation> selectStation(){
		List<EhyStation> list= stationService.findStation();
		return list;
		
	}
	
	/**
	 * 修改的方法
	 * @param member
	 * @return
	 */
	@RequestMapping("/back/update")
	@ResponseBody 
	public EhyMessage update(EhyMember member,HttpServletRequest request){
		EhyManager ehyManager = (EhyManager) request.getSession().getAttribute("manager");
		member.setOper(ehyManager.getManUser());
		String memberPwd = Tools.password(member.getMbLoginPwd());
		String memberzhifuPwd = Tools.password(member.getMbPayPwd());
		member.setMbLoginPwd(memberPwd);
		member.setMbPayPwd(memberzhifuPwd);
		int rows = memberService.updateByPrimaryKeySelective(member);
		if(rows>0){
			mes.setMes(EhyMessage.SUCCESS_MES);
			mes.setState(EhyMessage.SUCCESS);
		}else{
			mes.setMes(EhyMessage.ERROR_MES);
			mes.setState(EhyMessage.ERROR);
		}
		return mes;
		
	}
	
	/**
	 * 生成邀请码
	 * @param mbId 参数
	 * @return
	 */
	@RequestMapping("/back/addInvitationCode")
	@ResponseBody
	public EhyMessage addInvitationCode(EhyMember member,HttpServletRequest request,EhyInvitationCode ehyInvitationCode){
		
		EhyManager ehyManager = (EhyManager) request.getSession().getAttribute("manager");
		//会员id
		ehyInvitationCode.setMbId(member.getMbId());
		//会员姓名
		ehyInvitationCode.setMbName(member.getMbName());
		//操作人
		ehyInvitationCode.setOper(ehyManager.getManUser());
		//站点id
		ehyInvitationCode.setStId(ehyManager.getStId());
		//根据id查询
		EhyStation ehyStation = stationService.selectByPrimaryKey(ehyManager.getStId());
		//邀请码
		String invitationCode =ehyStation.getStCode()+"_"+Tools.getRandomString(6);
		//取邀请码
		ehyInvitationCode.setCode(invitationCode);
		member.setInvitationCode(invitationCode);
		//赋值来源分站
		member.setMbStation(ehyStation.getStName());
		
		EhyMember ehyMember=  memberService.selectByPrimaryKey(member.getMbId());
		if(Tools.isEmpty(ehyMember.getInvitationCode())==false){
			System.out.println("===========================================");
			mes.setMes("该会员已有邀请码");
			mes.setState(3);
		}else{
			//增加邀请码 到邀请码表
			int rows = invitationCodeService.insertSelective(ehyInvitationCode);
			//增加到会员列表
			int count = memberService.updateByPrimaryKeySelective(member);
			if(rows>0 || count>0){
				mes.setMes("邀请码生成：-"+invitationCode);
				mes.setState(EhyMessage.SUCCESS);
			}else{
				mes.setMes("请登录，在完成此次操作");
				mes.setState(EhyMessage.ERROR);
			}
			
		}
		return mes;
		
	}
	
	/**
	 * 根据Id查询会员信息
	 * @param mbId
	 * @param request
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/front/findMemberById")
	public String findMemberById(String mbId,HttpServletRequest request, HttpSession session){
		
			HttpSession sessionMember = request.getSession();
			
			
			EhyMember	member= (EhyMember) sessionMember.getAttribute("login");
			
			
			List<EhyMember> list = memberService.findMenberBy(member.getMbId());
			
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonString = null;
			try {
				jsonString = objectMapper.writeValueAsString(list);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return jsonString;
	}
	
	/**
	 * 修改会员信息
	 * @param member
	 * @return
	 */
	@RequestMapping("/front/updateMember")
	@ResponseBody
	public EhyMessage updateMember(EhyMember member ){

		int row = memberService.updateByPrimaryKey(member);
		if(row>0){
			mes.setState(1);
		}else{
			mes.setState(0);
		}
		return mes;
	}
	
	
	@RequestMapping("/front/loginPwdYzm")
	@ResponseBody
	public EhyMessage loginPwdYzm(HttpServletRequest request ,EhyMember record){
		HttpSession session1 = request.getSession();
		String se  =  (String) session1.getAttribute("yzm");
		String yzm =request.getParameter("mbPhoneYzm");
		String mbPhone = request.getParameter("mbPhone");
		if(se.equals(yzm) || se==yzm){
			mes.setState(1);
		}else{
			mes.setState(0);
		}
		return mes;
		
	}
	/**
	 * 修改手机号码
	 * @param member
	 * @return
	 */
	@RequestMapping("/front/updatePhone")
	@ResponseBody
	public EhyMessage updatePhone(EhyMember member,HttpServletRequest request){
		String mbPhone = request.getParameter("mbPhone");
		String mbPhones = request.getParameter("mbPhones");
		String mbLoginPwd = request.getParameter("mbLoginPwd");
		String mbLoginPwds = request.getParameter("mbLoginPwds");
		String mbLoginPayPwd = request.getParameter("mbLoginPayPwd");
		String mbLoginPayPwds = request.getParameter("mbLoginPayPwds");
		
		if(Tools.isEmpty(mbPhones)){
			EhyMember session = (EhyMember) request.getSession().getAttribute("login");
			member.setMbPhone(session.getMbPhone());
			member.setMbPhones(session.getMbPhone());
		}else{
			member.setMbPhones(mbPhones);
		}
		
		if(Tools.isEmpty(mbLoginPwd)){
			EhyMember session = (EhyMember) request.getSession().getAttribute("login");
			member.setMbLoginPwd(session.getMbLoginPwd());
			member.setMbLoginPwds(session.getMbLoginPwd());
		}else{
			String mbLoginPwd1 = Tools.password(mbLoginPwds);
			member.setMbLoginPwds(mbLoginPwd1);
		}
		
		
		
		if(Tools.isEmpty(mbLoginPayPwds)){
			member.setMbPayPwd(mbLoginPayPwds);
			member.setMbPayPwds(mbLoginPayPwds);
		}else{
			String mbLoginPwd1 = Tools.password(mbLoginPayPwds);
			member.setMbPayPwd(mbLoginPwd1);
		}
		
		int row = memberService.updateMemberKey(member);
		
		
		if(row>0){
			mes.setState(1);
		}else{
			mes.setState(0);
		}
		return mes;
	}
	
	/**
	 * 查询登录名是否存在
	 * @return
	 */
	@RequestMapping("back/isMbLogin")
	@ResponseBody 
	public EhyMessage islevelName(String mbLogin,String mbId){
		//增加会员等级查询 名字是否存在
		int rows = memberService.isMbLogin(mbLogin,mbId);
		//当返回的值大于0
		if(rows>0){
			//返回去页面的消息类赋值
			mes.setState(EhyMessage.SUCCESS);
		}else{
			//返回去页面的消息类赋值
			mes.setState(EhyMessage.ERROR);
		}
		//返回的值
		return mes;
		
	}
	

	@ResponseBody
	@RequestMapping("front/findArea")
	public String findArea(EhyArea area){
		List<EhyArea> list = ehyAreaService.selectArea(area);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = objectMapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jsonString);
		return jsonString;
	}
	

	
	@ResponseBody
	@RequestMapping("front/findAreaById")
	public String findAreaById(String areaId){
		System.out.println("==================--------------------"+areaId);
		
		List<EhyArea> list = ehyAreaService.selectAreaById(areaId);
		for (EhyArea ehyArea : list) {
			System.out.println("========================================"+ehyArea.getAreaName());
		}
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = objectMapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(jsonString);
		return jsonString;
	}
	
}
