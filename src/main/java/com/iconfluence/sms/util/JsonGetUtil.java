package com.iconfluence.sms.util;

import net.sf.json.JSONObject;

import java.util.Date;
import java.util.List;

public class JsonGetUtil extends StringUtil{
	

	
	public Integer getInt(JSONObject json, String key) {
		return json.has(key) ? json.getInt(key) : null;
	}
	
	public Integer getInt(JSONObject json, String key, int value) {
		Integer s = getInt(json, key);
		return s != null ? s : value;
	}
	
	
	public String getString(JSONObject json, String key) {
		return json.has(key) ? json.getString(key) : null;
	}
	
	
	public String getString(JSONObject json, String key, String value) {
		String s = getString(json, key);
		return s != null ? s : value;
	}
	
	
	
	public Date getDate(JSONObject json, String key) {
		return json.has(key) ? DateUtil.toDate( json.getString(key) ) : null;
	}
	
	public Date getDate(JSONObject json, String key, Date time) {
		Date s = getDate(json, key);
		return s != null ? s : time;
	}
	
	
	
	
	
	public JSONObject errorRes() {
		JSONObject resultJson = new JSONObject();
		resultJson.put("error", "操作失败");
		return resultJson;
	}
	
	
	
	
	
	
	public JSONObject errorRes(String value) {
		JSONObject resultJson = errorRes();
		resultJson.put("error", value);
		return resultJson;
	}
	
	
	
	public JSONObject succRes(List items) {
		JSONObject resultJson = new JSONObject();
		resultJson.put("items", items);
		return resultJson;
	}
	
	
	public JSONObject succRes(int total, int page, int pageSize, List items) {
		JSONObject resultJson = new JSONObject();
		resultJson.put("total", total);
		resultJson.put("page", page);
		resultJson.put("pageSize", pageSize);
		resultJson.put("items", items);
		return resultJson;
	}
	

	
	
	
	
	
	
	
	
	
}
