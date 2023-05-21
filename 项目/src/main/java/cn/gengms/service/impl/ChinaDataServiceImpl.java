package cn.gengms.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.gengms.dao.ChinaDataDao;
import cn.gengms.entity.ChinaData;
import cn.gengms.entity.MapEntity;
import cn.gengms.service.ChinaDataService;

public class ChinaDataServiceImpl implements ChinaDataService {

	private ChinaDataDao chinaDataDao = new ChinaDataDao();

	@Override
	public List<ChinaData> ListChinaData() throws SQLException {
		// TODO 自动生成的方法存根

		return chinaDataDao.listChinaData();
	}

	@Override
	public List<MapEntity> ListChinaNowData() {
		// TODO 自动生成的方法存根
		return chinaDataDao.ListChinaNowData();
	}

	@Override
	public List<MapEntity> listChinaTotalData() {
		// TODO 自动生成的方法存根
		return chinaDataDao.listChinaTotalData();
	}

}
