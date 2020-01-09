package com.rj.bd.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @desc 产生验证码的工具类
 * @author WYH
 * @time 2019年12月12日下午2:13:16
 */
public class CodeUtils {
	
//	  public static void main(String[] args) {
//	  
//	  for(int i =0;i<10;i++) { createCode(0); }
//	  
//	  
//	  }
	 
	/**
	 * @desc 1.产生长度为[length]位的验证码
	 * @return
	 */
	public static String createCode(int length) {
		
		String[] beforeShuffle = new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
				"G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
		if(length<0) length=beforeShuffle.length;
		List<String> list = Arrays.asList(beforeShuffle);
		Collections.shuffle(list);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}

		String afterShuffle = sb.toString();
		String result = afterShuffle.substring(0,length);
		System.out.println(result);
		return result;
	}

}
