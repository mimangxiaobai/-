package cn.gengms.util;

import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResultUtil {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static String success(Object object) throws JsonProcessingException {
		HashMap<String, Object> resutlMap = new HashMap<String, Object>();
		resutlMap.put("code", "200");
		resutlMap.put("data", object);
		return objectMapper.writeValueAsString(resutlMap);
	}

	public static String success() throws JsonProcessingException {
		HashMap<String, Object> resutlMap = new HashMap<String, Object>();
		resutlMap.put("code", "200");
		return objectMapper.writeValueAsString(resutlMap);
	}

	public static String fail(String code, String message) throws JsonProcessingException {
		HashMap<String, Object> resutlMap = new HashMap<String, Object>();
		resutlMap.put("code", code);
		resutlMap.put("message", message);
		return objectMapper.writeValueAsString(resutlMap);
	}

	public static String fail() throws JsonProcessingException {
		HashMap<String, Object> resutlMap = new HashMap<String, Object>();
		resutlMap.put("code", "500");
		resutlMap.put("message", "系统错误");
		return objectMapper.writeValueAsString(resutlMap);
	}
}
