package kr.spring.sample.excel.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DataUtil {

	// request 로 넘어온 객체를 Map 형태로 변환
	public static Map<String, Object> getParameter(Map<String, String[]> requestMap) {
		Map<String, Object> param = new HashMap<String, Object>();
		Set<String> keySet = requestMap.keySet();
		Iterator<String> iter = keySet.iterator();
		while(iter.hasNext()) {
			String key = iter.next();
			String value = requestMap.get(key)[0];
			param.put(key, value);
		}
		return param;
	}
}
