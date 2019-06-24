package com.iconfluence.sms.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

public abstract class JsonFormatUtil <T> extends JsonGetUtil{
	
	/**
	 * 将对象转换成json
	 * @param java
	 * @return
	 */
	abstract public JSONObject toJson(T java);

	public JSONArray toJsonArray(List<T> list) {
		JSONArray array = new JSONArray();
		if (list == null) {
			return array;
		}
		
		for (T java : list) {
			array.add(toJson(java));
		}
		return array;
	}
}
