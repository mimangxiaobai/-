package cn.gengms.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.gengms.dao.ForeignCovidDataDao;
import cn.gengms.entity.ForeignCovidData;
import cn.gengms.entity.WorldDataFront;
import cn.gengms.service.ForeignCovidDataService;

public class ForeignCovidDataServiceImpl implements ForeignCovidDataService {

	private ForeignCovidDataDao foreignCovidDataDao = new ForeignCovidDataDao();

	@Override
	public Boolean saveForeignCovidData(ForeignCovidData foreignCovidData) throws SQLException {
		// TODO 自动生成的方法存根
		Integer had = foreignCovidDataDao.countForeignCovidDataByDate(foreignCovidData.getDate());
		if (had != 1) {
			Integer isSaved = foreignCovidDataDao.saveForeignCovidData(foreignCovidData);
			if (isSaved != 1) {
				return false;
			} else {
				return true;
			}
		} else {
			Integer isUpdated = foreignCovidDataDao.updateForeignCovidData(foreignCovidData);
			if (isUpdated != 1) {
				return false;
			} else {
				return true;
			}
		}

	}

	@Override
	public List<WorldDataFront> listWorldDataFronts() {
		// TODO 自动生成的方法存根
		try {
			return foreignCovidDataDao.listForeignCovidData();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<String> listWorldNowSure() {
		// TODO 自动生成的方法存根
		return foreignCovidDataDao.listForeignNowSure();
	}

	@Override
	public List<String> listWorldDate() {
		// TODO 自动生成的方法存根
		return null;
	}

}
