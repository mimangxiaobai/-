package cn.gengms.service;

import java.sql.SQLException;
import java.util.List;

import cn.gengms.entity.ChinaData;
import cn.gengms.entity.MapEntity;

public interface ChinaDataService {

	List<ChinaData> ListChinaData() throws SQLException;

	List<MapEntity> ListChinaNowData();

	List<MapEntity> listChinaTotalData();

}
