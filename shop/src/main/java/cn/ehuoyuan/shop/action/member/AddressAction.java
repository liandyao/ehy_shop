/**
 * 
 */
package cn.ehuoyuan.shop.action.member;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.common.Tools;
import cn.ehuoyuan.shop.domain.EhyAddress;
import cn.ehuoyuan.shop.domain.EhyMember;
import cn.ehuoyuan.shop.service.member.address.AddressService;

/**
 * 收货地址
 * @author WangGuanfu
 *
 */
@Controller
@RequestMapping("/address")
public class AddressAction {

	@Resource
	private AddressService addressService;
	
	
	
	/**
	 * 增加收货地址
	 * @param address
	 * @return
	 */
	@RequestMapping("/front/addAddress")
	@ResponseBody
	public EhyMessage addAddress(EhyAddress address,HttpServletRequest request,String he){
		EhyMessage mes = new EhyMessage();
			EhyMember address1 = (EhyMember) request.getSession().getAttribute("login");
			try {
				String ss=new String(he.getBytes("ISO-8859-1"),"utf-8");
				String[] adress = ss.split(",");
				for (int i = 0; i < adress.length; i++) {
				   address.setAddProvince(adress[0]);
				   address.setAddCity(adress[1]);
				   address.setAddCounty(adress[2]);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			address.setMbId(address1.getMbId());
			int row=  addressService.insertSelective(address);
			if(row>0){
				mes.setState(1);
			}else{
				mes.setState(0);
			}
		
		
		
		return mes;
		
	}
	
	@RequestMapping("/front/updateAddress")
	@ResponseBody
	public EhyMessage updateAddress(EhyAddress address,HttpServletRequest request,String he,String addIid){
		EhyMessage mes = new EhyMessage();
	
			address.setAddId(addIid);
			String ss;
			try {
				ss = new String(he.getBytes("ISO-8859-1"),"utf-8");
				String[] adress = ss.split(",");
				for (int i = 0; i < adress.length; i++) {
				   address.setAddProvince(adress[0]);
				   address.setAddCity(adress[1]);
				   address.setAddCounty(adress[2]);
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			int row = addressService.updateByPrimaryKeySelective(address);
			System.out.println("row是====================================================:"+row);
			if(row>0){
				mes.setState(1);
			}
			return mes;
	
	}
	
	/**
	 * 根据会员ID查询收货地址
	 */
	@ResponseBody
	@RequestMapping("/front/selectByMbId")
	public List<EhyAddress> selectByMbId(String mbId,HttpServletRequest request){
		EhyMember address1 = (EhyMember) request.getSession().getAttribute("login");
		List<EhyAddress> member=  addressService.selectByMbId(address1.getMbId());
		return member;
		
	}
	
	
	/**
	 * 根据ID查询收货地址
	 */
	@RequestMapping("/front/selectByAddId")
	@ResponseBody
	public List<EhyAddress> selectByAddId(String addId){
		System.out.println("=============================="+addId);
		List<EhyAddress> address= addressService.selectByPrimaryKey(addId);
		
		return address;
	}
	/**
	 * 根据ID删除
	 * @param addId
	 * @param address
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/front/deleteByPrimaryKey")
	public EhyMessage deleteByPrimaryKey(String addId, EhyAddress address){
		EhyMessage mes = new EhyMessage();
		int row = addressService.deleteByPrimaryKey(addId);
		if(row>0){
			mes.setState(1);
		}
		return mes;
		
	}
	
	
	/**
	 * 根据ID修改排序
	 * @param addId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/front/updateSortById")
	public EhyMessage updateSortById(String addId,EhyAddress address){
		EhyMessage mes = new EhyMessage();
		 addressService.updateSort();
	 int row = addressService.updateSortById(addId);
	 if(row>0){
		 mes.setState(1);
		 System.out.println("====================================================修改成功");
	 }
		return mes;
		
	}
}
