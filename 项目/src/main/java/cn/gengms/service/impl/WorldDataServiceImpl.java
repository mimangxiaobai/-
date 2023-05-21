package cn.gengms.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.gengms.dao.WorldDataDao;
import cn.gengms.entity.ChinaData;
import cn.gengms.entity.MapEntity;
import cn.gengms.service.WorldDataService;

public class WorldDataServiceImpl implements WorldDataService {

	private WorldDataDao WorldDataDao = new WorldDataDao();

	@Override
	public List<ChinaData> ListWorldData() throws SQLException {
		// TODO 自动生成的方法存根
		return WorldDataDao.listWorldData();
	}

	@Override
	public List<MapEntity> listWorldNowData() {
		// TODO 自动生成的方法存根
		return WorldDataDao.listWorldNowData();
	}

	@Override
	public List<MapEntity> listWorldTotalData() {
		// TODO 自动生成的方法存根
		return WorldDataDao.listWorldTotalData();
	}

}
