package cn.gengms.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface HomeRoulingService {
	Boolean HomeRoulingSave(String imgUrl, String articleUrl) throws SQLException;

	List<HashMap<String, String>> listHomeRouling() throws SQLException;

	Boolean homeRoulingUpdate(Integer rId, String imgUrl, String articleUrl) throws SQLException;

	Boolean removeHomeRouling(Integer index) throws SQLException;
}
