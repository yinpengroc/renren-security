package io.renren.common.utils;

import com.baomidou.mybatisplus.toolkit.StringUtils;

/**
 * 字符串相关方法
 *
 */
public class StringUtil {

	/**
	 * 将以逗号分隔的字符串转换成字符串数组
	 * @param valStr
	 * @return String[]
	 */
	public static String[] StrList(String valStr){
	    int i = 0;
	    String TempStr = valStr;
	    String[] returnStr = new String[valStr.length() + 1 - TempStr.replace(",", "").length()];
	    valStr = valStr + ",";
	    while (valStr.indexOf(',') > 0)
	    {
	        returnStr[i] = valStr.substring(0, valStr.indexOf(','));
	        valStr = valStr.substring(valStr.indexOf(',')+1 , valStr.length());
	        
	        i++;
	    }
	    return returnStr;
	}
	/**
	 * 
	 * @param str
	 * @param pro
	 * @return
	 */
	public static String  getRidOfPro(String str,String pro) {
 
		if(StringUtils.isNotEmpty(str)&&str.indexOf(pro)>-1){
		String reString=str.replace( pro,"").trim();
		return	reString;
		}
		return str;
		
	}
	

}
