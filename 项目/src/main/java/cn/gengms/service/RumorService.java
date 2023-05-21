package cn.gengms.service;

import java.sql.SQLException;
import java.util.List;

import cn.gengms.entity.Rumor;

public interface RumorService {
	Boolean SaveRumor(String content, Integer isRumor) throws SQLException;

	Boolean removeRumor(Integer id) throws SQLException;

	Boolean updateRumor(Integer id, String content, Integer isRumor) throws SQLException;

	List<Rumor> listRumor();

	List<Rumor> listRumorByFuzzy(String con);
}
