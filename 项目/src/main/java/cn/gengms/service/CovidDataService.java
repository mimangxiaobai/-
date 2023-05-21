package cn.gengms.service;

import java.sql.SQLException;
import java.util.List;

import cn.gengms.entity.ChinaDataFront;
import cn.gengms.entity.CovidData;

public interface CovidDataService {

	Boolean saveCovidData(CovidData covidData) throws SQLException;

	List<ChinaDataFront> listCovidData(String date) throws SQLException;

	List<String> listChinaDate();

	List<String> listChinaAddSure();

	List<String> listChinaNowSure();

	List<String> listChinaAddSave();

	List<String> listChinaAddDied();
}
