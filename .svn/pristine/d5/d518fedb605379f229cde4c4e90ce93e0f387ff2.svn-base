package com.rj.bd.utils;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ToJson {
	public static JSONObject MapToJson(Map<String, Object> Object){
		JSONObject jsonObject = JSONObject.fromObject(Object);
//		String rslt = jsonObject.toString();
		return jsonObject;
	}
	@SuppressWarnings("rawtypes")
	public static JSONArray ListToJson(List list){
		// list转JSONArray  
        JSONArray jsArr = JSONArray.fromObject(list);
//	/	JSONArray rslt = jsArr.toString();
		return jsArr;
	}
}
