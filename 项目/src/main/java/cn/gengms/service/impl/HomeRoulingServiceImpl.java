package cn.gengms.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import cn.gengms.dao.HomeRoulingDao;
import cn.gengms.service.HomeRoulingService;

public class HomeRoulingServiceImpl implements HomeRoulingService {

	private HomeRoulingDao homeRoulingDao = new HomeRoulingDao();

	@Override
	public Boolean HomeRoulingSave(String imgUrl, String articleUrl) throws SQLException {
		// TODO 自动生成的方法存根
		int count = homeRoulingDao.HomgRoulingSave(imgUrl, articleUrl);
		if (count != 1) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<HashMap<String, String>> listHomeRouling() throws SQLException {
		// TODO 自动生成的方法存根
		return homeRoulingDao.listHomeRouling();
	}

	@Override
	public Boolean homeRoulingUpdate(Integer rId, String imgUrl, String articleUrl) throws SQLException {
		// TODO 自动生成的方法存根
		Integer countInteger = homeRoulingDao.HomeRoulingUpdate(rId, imgUrl, articleUrl);
		System.out.println(countInteger);
		if (countInteger <= 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Boolean removeHomeRouling(Integer index) throws SQLException {
		// TODO 自动生成的方法存根
		Integer count = homeRoulingDao.removeHomeRouling(index);
		System.out.println(count);
		if (count != 1) {
			return false;
		} else {
			return true;
		}
	}

}
