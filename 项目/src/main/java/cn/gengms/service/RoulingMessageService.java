package cn.gengms.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface RoulingMessageService {
	Boolean saveRouling(String title, String content) throws SQLException;

	List<HashMap<String, Object>> listRoulingMessage() throws SQLException;

	Boolean updateRoulingMessage(Integer index, String title, String content) throws SQLException;

	Boolean removeRoulingMessage(Integer index) throws SQLException;
}
