/**
 * 
 */
package cn.ehuoyuan.common;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件工具类
 * @author liandyao
 * @date 2017年10月12日 下午3:28:42
 * @version 1.0
 */
public class FileTools {

	public static  String PATH = CommomUtils.CONF.getProperty("upload_path");
	
	/**
	 * 需要保存的文件地址和文件
	 * @param path 传入的地址名称,例如,会员模块,传入的地址是member,也可以是member/2017/这样的多重文件夹
	 * @param file
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	public static String saveFile(String path,MultipartFile file) throws IllegalStateException, IOException{
		
		String OriFileName = file.getOriginalFilename();//原文件名
		//得到后缀
		String hz = OriFileName.split("\\.")[1];
		//新文件名
		String newFileName = Tools.getTimeStamp()+"_"+Tools.getRandomString(8)+"."+hz;
		
		String targetPath = PATH ; //存储的目标地址
		if(Tools.isEmpty(PATH)){ //如果配置的文件为空
			WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
			ServletContext servletContext = webApplicationContext.getServletContext();
			targetPath = servletContext.getRealPath("/upload"); 
		}
		File fileNew=new File(targetPath+"//"+path);
		if(!fileNew.exists()){
			fileNew.mkdirs();//创建新的文件夹
		}
		
		
		String dataBasePath = path+"/"+newFileName;//数据库保存地址
		targetPath +="/"+dataBasePath;
		File targetFile = new File(targetPath);
		file.transferTo(targetFile); 
		dataBasePath = "/upload/"+dataBasePath;
		return dataBasePath;
	}
	
}
