package tools;

import net.sf.json.JSONObject;

public class JsonTools {

	public JsonTools() {
	}
	/**
	 * 生成JSON字符串
	 * @param key
	 * @param object
	 * @return
	 */
	public static String createJsonString(String key,Object value){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(key, value);
		return jsonObject.toString();
	}
}
