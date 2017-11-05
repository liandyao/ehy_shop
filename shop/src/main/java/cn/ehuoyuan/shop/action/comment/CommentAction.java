/**
 * 
 */
package cn.ehuoyuan.shop.action.comment;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.ehuoyuan.common.EhyMessage;
import cn.ehuoyuan.shop.service.comment.CommentService;

/**
 * 类的描述：评论的action
 * @author xym
 * @date 2017年11月3日
 * @version 1.0
 */
@Controller
@RequestMapping("/comment")
public class CommentAction {
	@Resource
	private CommentService commentService;
	@RequestMapping("front/comment")
	@ResponseBody
	public EhyMessage comment(@RequestParam Map<String, Object> map,String[] commDesc,@RequestParam MultipartFile[] photo){
		
		System.out.println("=============================================");
		for(String key:map.keySet()){
			System.out.println(key+"               "+map.get(key));;
		}
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		for (int i = 0; i < commDesc.length; i++) {
			System.out.println(commDesc[i]+"                               "+photo[i].getOriginalFilename());
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		return null;
	}
}
