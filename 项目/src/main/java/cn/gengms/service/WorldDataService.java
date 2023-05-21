package cn.gengms.service;

import java.sql.SQLException;
import java.util.List;

import cn.gengms.entity.ChinaData;
import cn.gengms.entity.MapEntity;

public interface WorldDataService {

	List<ChinaData> ListWorldData() throws SQLException;

	List<MapEntity> listWorldNowData();

	List<MapEntity> listWorldTotalData();
}
