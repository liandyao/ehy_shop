/**
 * 
 */
package cn.ehuoyuan.shop.action.invitationCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ehuoyuan.common.CommomUtils;
import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Pages;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhyInvitationCode;
import cn.ehuoyuan.shop.domain.EhyMember;
import cn.ehuoyuan.shop.domain.EhyStation;
import cn.ehuoyuan.shop.service.invitationCode.InvitationCodeService;
import cn.ehuoyuan.shop.service.member.MemberService;
import cn.ehuoyuan.shop.service.station.StationService;

/**
 * 站点代理人管理的action
 * @author denglijie
 * @2017年10月11日
 * @version v1.0
 */
@Controller
@RequestMapping("invitationCode")
public class InvitationCodeAction {
	
	/**
	 * 注入代理人的service
	 */
	@Resource
	private InvitationCodeService invitationCodeService;
	
	/**
	 * 注入站点的service
	 */
	@Resource
	private StationService stationService;
	
	/**
	 * 注入会员的service
	 */
	@Resource
	private MemberService memberService;
	/**
	 * 显示列表
	 * @param page 
	 * @param limit
	 * @return map
	 */
	@RequestMapping("/back/showList")
	@ResponseBody
	public Map<String, Object> showList(int page,int limit,EhyInvitationCode code,String stName ){
		
		Map<String , Object> map = new HashMap<>();
		
		Pages p = new Pages();
		p.setCurPage(page);
		p.setMaxResult(limit);
		
		Map<String,Object> mapParam = new HashMap<String,Object>();
		
		mapParam.put("stName", stName);
		mapParam.put("code", code.getCode());
		mapParam.put("mbName", code.getMbName());
		
		
		mapParam.put("firstRows", p.getFirstRows());
		mapParam.put("maxResult", p.getMaxResult());
		
		List<Map> list = invitationCodeService.findAll(mapParam);
		
		int count = invitationCodeService.findRowCount(mapParam);
		map.put("data", list);
		map.put("count", count);
	
		map.put("code",0);
		map.put("msg", "");
		return map;
	}
	
	/**
	 * 显示所有站点
	 * @return
	 */
	@RequestMapping("/back/findStation")
	@ResponseBody
	public Map<String, Object> findStation(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<EhyStation> list = stationService.findStation();
		map.put("list",list);
		return map;
	}
	
	/**
	 * 显示所有会员
	 * @return
	 */
	@RequestMapping("/back/findMember")
	@ResponseBody
	public Map<String, Object> findMember(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<EhyMember> list = memberService.findMember();
		map.put("list",list);
		return map;
	}
	
	/**
	 * 删除
	 * @param code
	 * @return
	 */
	@RequestMapping("/back/delete")
	@ResponseBody
	public EhyMessage delete(EhyInvitationCode code){
		EhyMember mem = new EhyMember();
		mem.setMbId(code.getMbId());
		mem.setLevelId("1");
		mem.setMbStation("");
		mem.setInvitationCode("");
		memberService.updateByPrimaryKeySelective(mem); 
		
		code.setIsva(CommomUtils.ISVA_NO);
		int rows = invitationCodeService.updateByPrimaryKeySelective(code);
		EhyMessage message = new EhyMessage();
		if(rows>0){
			message.setState(EhyMessage.SUCCESS);
			message.setMes(EhyMessage.SUCCESS_MES);
		}else{
			message.setState(EhyMessage.ERROR);
			message.setMes(EhyMessage.ERROR_MES);
		}
		return message;
	}
	
	/**
	 * 增加或修改
	 * @param invitationCode
	 * @return
	 */
	@RequestMapping("/back/addOrUpdate")
	@ResponseBody
	public EhyMessage addOrUpdate(EhyInvitationCode invitationCode,HttpSession session){
		
		EhyMessage message = new EhyMessage();
		EhyMember member = memberService.selectByPrimaryKey(invitationCode.getMbId());
		invitationCode.setMbName(member.getMbName()); 
		
		if(Tools.isEmpty(invitationCode.getInviId())){
			//如果页面传过来的是小写字母则自动转化为大写
			invitationCode.setCode(invitationCode.getCode().toUpperCase());
			
			String code = invitationCode.getCode()+"_"+Tools.getRandomString(6);
			
			EhyMember mem = new EhyMember();
			mem.setMbId(invitationCode.getMbId()); 
			if(invitationCode.getIsva()==1){
				mem.setLevelId("1");
			}else{
				mem.setLevelId("4");
			}
			
			EhyStation sta = stationService.findById(invitationCode.getStId());
			mem.setMbStation(sta.getStName());
			
			mem.setInvitationCode(code);
			memberService.updateByPrimaryKeySelective(mem);
			
			while(true){
				int row = invitationCodeService.selectByCode(code);
				if(row>0){
					code = invitationCode.getCode()+Tools.getRandomString(6);
				}else{
					invitationCode.setCode(code);
					break;
				}
			}
			
			int rows = invitationCodeService.insertSelective(invitationCode);
			if(rows>0){
				message.setState(EhyMessage.SUCCESS);
				message.setMes(EhyMessage.SUCCESS_MES);
			}else{
				message.setState(EhyMessage.ERROR);
				message.setMes(EhyMessage.ERROR_MES);
			}
		}
		return message;
	}
	
	/**
	 * 显示修改信息
	 * @param stId
	 * @return
	 */
	@RequestMapping("/back/showUpdate")
	@ResponseBody
	public EhyInvitationCode showUpdate(String inviId){
		EhyInvitationCode invitationCode =  invitationCodeService.selectByPrimaryKey(inviId);
		return invitationCode;
	}
	
	/**
	 * 根据会员id判断邀请码是否存在
	 * @param code
	 * @return
	 */
	@RequestMapping("/back/isCode")
	@ResponseBody
	public EhyMessage isCode(String mbId){
		EhyMessage message = new EhyMessage();
		int rows = memberService.isCode(mbId); 
		if(rows>0){
			message.setState(EhyMessage.SUCCESS);
		}else{
			message.setState(EhyMessage.ERROR);
		}
		return message;
	}
	
	/**
	 * 设为代理人
	 * @param code
	 * @return
	 */
	@RequestMapping("/back/setAgent")
	@ResponseBody
	public EhyMessage setAgent(EhyInvitationCode code){
		EhyMember mem = new EhyMember();
		mem.setMbId(code.getMbId());
		mem.setLevelId("4");
		memberService.updateByPrimaryKeySelective(mem);
		
		code.setIsva(2);
		int rows = invitationCodeService.updateByPrimaryKeySelective(code);
		EhyMessage message = new EhyMessage();
		if(rows>0){
			message.setState(EhyMessage.SUCCESS);
			message.setMes(EhyMessage.SUCCESS_MES);
		}else{
			message.setState(EhyMessage.ERROR);
			message.setMes(EhyMessage.ERROR_MES);
		}
		return message;
	}
	
	/**
	 * 取消代理人
	 * @param code
	 * @return
	 */
	@RequestMapping("/back/cancelAgent")
	@ResponseBody
	public EhyMessage cancelAgent(EhyInvitationCode code){
		EhyMember mem = new EhyMember();
		mem.setMbId(code.getMbId());
		mem.setLevelId("1");
		memberService.updateByPrimaryKeySelective(mem);
		code.setIsva(1);
		
		int rows = invitationCodeService.updateByPrimaryKeySelective(code);
		EhyMessage message = new EhyMessage();
		if(rows>0){
			message.setState(EhyMessage.SUCCESS);
			message.setMes(EhyMessage.SUCCESS_MES);
		}else{
			message.setState(EhyMessage.ERROR);
			message.setMes(EhyMessage.ERROR_MES);
		}
		return message;
	}
	
	/**
	 * 排序
	 * @param start
	 * @param end
	 * @param inviId
	 * @return
	 */
	@RequestMapping("/back/sortInvitationCode")
	@ResponseBody
	public EhyMessage sortInvitationCode(int start, int end, String inviId) {
		EhyMessage mes = new EhyMessage();
		int rows = invitationCodeService.sortInvitationCode(start, end, inviId);
		if(rows>0){
			mes.setState(EhyMessage.SUCCESS);
			mes.setMes(EhyMessage.SUCCESS_MES);
		}else{
			mes.setState(EhyMessage.ERROR);
			mes.setMes(EhyMessage.ERROR_MES);
		}
		return mes;
	}
	
}
