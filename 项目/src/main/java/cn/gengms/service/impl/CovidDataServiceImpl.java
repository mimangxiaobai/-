package cn.gengms.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.gengms.dao.CovidDataDao;
import cn.gengms.entity.ChinaDataFront;
import cn.gengms.entity.CovidData;
import cn.gengms.service.CovidDataService;

public class CovidDataServiceImpl implements CovidDataService {

	private CovidDataDao covidDataDao = new CovidDataDao();

	@Override
	public Boolean saveCovidData(CovidData covidData) throws SQLException {
		Integer haveNowData = covidDataDao.countCovidDataByDate(covidData.getDate());
		System.out.println(haveNowData);
		if (haveNowData != 1) {
			Integer count = covidDataDao.saveCovidData(covidData);
			if (count != 1) {
				return false;
			} else {
				return true;
			}
		} else {
			Integer count = covidDataDao.updateCovidData(covidData);
			if (count != 1) {
				return false;
			} else {
				return true;
			}
		}

	}

	@Override
	public List<ChinaDataFront> listCovidData(String date) throws SQLException {
		// TODO 自动生成的方法存根
		Integer haveData = covidDataDao.countCovidDataByDate(date);
		if (haveData != 1) {
			return null;
		} else {
			return covidDataDao.listCovidData();
		}
	}

	@Override
	public List<String> listChinaDate() {
		// TODO 自动生成的方法存根
		return covidDataDao.listChinaDate();
	}

	@Override
	public List<String> listChinaAddSure() {
		// TODO 自动生成的方法存根
		return covidDataDao.listChinaAddSure();
	}

	@Override
	public List<String> listChinaNowSure() {
		// TODO 自动生成的方法存根
		return covidDataDao.listChinaNowSure();
	}

	@Override
	public List<String> listChinaAddSave() {
		// TODO 自动生成的方法存根
		return covidDataDao.listChinaAddSave();
	}

	@Override
	public List<String> listChinaAddDied() {
		// TODO 自动生成的方法存根
		return covidDataDao.listChinaAddDied();
	}

}
