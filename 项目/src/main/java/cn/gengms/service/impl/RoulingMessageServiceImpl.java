package cn.gengms.service.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import cn.gengms.dao.RoulingMessageDao;
import cn.gengms.service.RoulingMessageService;

public class RoulingMessageServiceImpl implements RoulingMessageService {

	private RoulingMessageDao roulingMessageDao = new RoulingMessageDao();

	@Override
	public Boolean saveRouling(String title, String content) throws SQLException {
		// TODO 自动生成的方法存根
		Integer count = roulingMessageDao.saveRoulingMessage(title, content);
		if (count != 1) {
			return false;
		}
		return true;
	}

	@Override
	public List<HashMap<String, Object>> listRoulingMessage() throws SQLException {
		// TODO 自动生成的方法存根
		return roulingMessageDao.listRoulingMessage();
	}

	@Override
	public Boolean updateRoulingMessage(Integer index, String title, String content) throws SQLException {
		// TODO 自动生成的方法存根
		Integer countInteger = roulingMessageDao.updateRoulingMessage(index, title, content);
		if (countInteger != 1) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean removeRoulingMessage(Integer index) throws SQLException {
		// TODO 自动生成的方法存根
		Integer countInteger = roulingMessageDao.removeRoulingMessage(index);
		if (countInteger != 1) {
			return false;
		} else {
			return true;
		}
	}

}
