package cn.gengms.service;

import java.sql.SQLException;
import java.util.List;

import cn.gengms.entity.WorldDataFront;

public interface ForeignCovidDataService {
	Boolean saveForeignCovidData(cn.gengms.entity.ForeignCovidData ForeignCovidData) throws SQLException;

	List<WorldDataFront> listWorldDataFronts();

	List<String> listWorldNowSure();

	List<String> listWorldDate();
}
