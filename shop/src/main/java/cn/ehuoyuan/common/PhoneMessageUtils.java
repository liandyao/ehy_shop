/**
 * 
 */
package cn.ehuoyuan.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List; 
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 * 短信发送端
 * @author liandyao
 * @date 2017年9月29日
 * @version 1.0
 */
public class PhoneMessageUtils {

	/**
	 * 短信验证码的KEY
	 */
	public static final String account="csjxth" ;
	public static final String password ="csjxth2017";
	
	static String httpUrl = "http://sdk.shmyt.cn:8080/manyousms/sendsms";
	static String httpArg = "?account="+account+"&password="+password;
	
	public final static String MODEL = "【e货源】";
	
	public static void main(String[] args) {
		
		try {
			//String httpUrl = "http://sdk.shmyt.cn:8080/manyousms/sendsms";
			//String  result= SmsTest(httpUrl, account, password, "13357225692", "您的验证码是：4875【满友科技】"); 
			//System.out.println(result); 
			
			String  result= sms("13357225692", "您的验证码是：5201314"+MODEL); 
			String result2 = getBalance();
			
			System.out.println(result+"  余额：   "+result2); 
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	 
	public static String  getBalance() throws ClientProtocolException, IOException{
		 
		String httpUrl="http://sdk.shmyt.cn:8080/manyousms/getbalance";
		return requestPost(httpUrl, httpArg);
		
		
		//return SendMsg.sendBatch(sendUrl, account, password, mobile, content) ;
	}
	
	/**
	 * 发送信息
	 * @param mobile 手机号码
	 * @param content 发送的正文,注意不需要带【e货源】,本方法自己会加上
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String  sms(String mobile,String content) throws ClientProtocolException, IOException{
		if(Tools.isEmpty(mobile)) return null;
		//content=URLEncoder.encode(content, "UTF-8");
		String outData = httpArg+"&mobiles="+mobile+"&content="+content+MODEL;
		//httpUrl = "http://localhost:8080/wexin/pay/test.do";
		return requestPost(httpUrl, outData); 
	} 
	 
    /**
     * 使用httpClient的post请求url
     * @param url
     * @param paramsStr
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String requestPost(String url,String paramsStr) throws ClientProtocolException, IOException {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();
        List<NameValuePair> params = new ArrayList<NameValuePair>();     
        
        if(paramsStr!=null && !"".equals(paramsStr)){
        	if(paramsStr.indexOf("?")>-1){
        		paramsStr = paramsStr.substring(1);//将?去掉
        	}
        	String p[] = paramsStr.split("&");
        	for(String s:p){
        		String pa[] = s.split("=");
        		System.out.println(pa[0]+"   "+pa[1]);
        		NameValuePair np = new BasicNameValuePair(pa[0], pa[1]);
        		params.add(np);
        	}
        }
       
        HttpPost httppost = new HttpPost(url);
        httppost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
         
        CloseableHttpResponse response = httpclient.execute(httppost);
        System.out.println(response.toString()); 
        HttpEntity entity = response.getEntity();
        String jsonStr = EntityUtils.toString(entity, "utf-8");
        System.out.println(jsonStr);
         
        httppost.releaseConnection();
		return jsonStr;
    }
	
}
