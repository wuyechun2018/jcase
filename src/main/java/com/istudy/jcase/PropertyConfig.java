package com.istudy.jcase;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;
/**
 * 
 * Property文件路径问题
 * @desc: itools
 * @author: wyc
 * @createTime: 2016年10月24日 下午5:22:21
 * @history:
 * @version: v1.0
 */
public class PropertyConfig {
	
	
	public static void main(String[]args){
		
		try {
			//InputStream input = PropertyConfig.class.getResourceAsStream("/config/test/database.properties");
			// path 不以’/'开头时默认是从此类所在的包下取资源，以’/'开头则是从ClassPath根下获取
			// 不以’/'需要将database.properties放到当前包下
			InputStream input = PropertyConfig.class.getResourceAsStream("database.properties");
			//等价于
			PropertyConfig.class.getClassLoader().getResourceAsStream("database.properties");
			//最好的是PropertyConfig.class.getResourceAsStream("/config/test/database.properties");
			Properties prop=new Properties();
			prop.load(input);
			String name=prop.getProperty("username");
			System.out.println(name);
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

	/**
	 * 
	 * 从指定的Property文件中读取配置项
	 * @author: wyc
	 * @createTime: 2016年10月24日 下午5:41:15
	 * @history:
	 * @param propFileName
	 * @param key
	 * @return String
	 */
	public static String getProp(String propFileName,String key){
		String value="";
		try {
			String file=MessageFormat.format("/config/test/{0}.properties",propFileName);
			InputStream input = PropertyConfig.class.getResourceAsStream(file);
			Properties prop=new Properties();
			prop.load(input);
			value=prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	

}
