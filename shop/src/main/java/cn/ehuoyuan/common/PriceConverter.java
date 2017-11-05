/**
 * 
 */
package cn.ehuoyuan.common;

import java.math.BigDecimal;

import org.springframework.core.convert.converter.Converter;


/**
 * 类的描述：金额元转分(String转BigDecimal)
 * @author 罗海兵
 * @dateTime 2017年10月25日 上午8:44:51
 * @version 1.0
 */
public class PriceConverter implements Converter<String, BigDecimal>{

	@Override
	public BigDecimal convert(String doublePrice) {
		System.out.println("\n\n===========  开始金额元转分(String转BigDecimal)  =========\n\n");
		System.out.println("传入的金额是："+doublePrice+"  =========\n\n");
		try {
			BigDecimal newPrice=new BigDecimal(Tools.moneyYuanToFen(doublePrice.toString()));
			System.out.println("转化后的金额是："+newPrice+"  =========\n\n");
            return newPrice;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}

}
