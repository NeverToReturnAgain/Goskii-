package com.rj.bd.utils;
/**
 * @desc   解析属性配置文件(mail.properties)的工具类
 * @author WYH
 * @time   2019年12月12日下午2:42:36
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class PropertuUtils {
	/**
	 * public static void main(String[] args) throws IOException {
	 * 
	 * String propertyPath="mail.properties"; Map<String, Object> map =
	 * getInfoFromProperties(propertyPath); System.out.println("map："+map); }
	 **/

	/**
	 * @throws IOException
	 * @desc 1.解析获取Mail.properties中的数据
	 */
	public static Map<String, Object> getInfoFromProperties(String propertyPath) throws IOException {
		// 1.创建一个Map用于装入解析获取到的数据
		Map<String, Object> map = new HashMap<String, Object>();

		// 2.初始化Properties
		Properties props = new Properties();

		// 3.解析:将mail.properties文件转变为输入流对象
		InputStream inputStream = PropertuUtils.class.getClassLoader().getResourceAsStream(propertyPath);

		// 4.将流对象读取缓存区中
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));

		// 5.加载缓存区读对象
		props.load(bufferedReader);

		// 6.读取并获取到一个迭代器
		Iterator<String> it = props.stringPropertyNames().iterator();

		while (it.hasNext()) {
			String key = (String) it.next();
			// System.out.println(key+"\t"+props.getProperty(key));
			map.put(key, props.getProperty(key));
		}

		return map;

	}

}
