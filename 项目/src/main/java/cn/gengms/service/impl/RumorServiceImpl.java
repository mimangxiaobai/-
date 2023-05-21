package cn.gengms.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.gengms.dao.RumorDao;
import cn.gengms.entity.Rumor;
import cn.gengms.service.RumorService;

public class RumorServiceImpl implements RumorService {

	private RumorDao rumorDao = new RumorDao();

	@Override
	public Boolean SaveRumor(String content, Integer isRumor) throws SQLException {
		// TODO 自动生成的方法存根
		Integer count = rumorDao.saveRumorDao(content, isRumor);
		if (count != 1) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Boolean removeRumor(Integer id) throws SQLException {
		// TODO 自动生成的方法存根
		Integer countInteger = rumorDao.removeRumor(id);
		if (countInteger != 1) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Boolean updateRumor(Integer id, String content, Integer isRumor) throws SQLException {
		// TODO 自动生成的方法存根
		Integer countInteger = rumorDao.updateRumor(id, content, isRumor);
		if (countInteger != 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Rumor> listRumor() {
		// TODO 自动生成的方法存根
		System.out.println(rumorDao.listRumor());
		return rumorDao.listRumor();
	}

	@Override
	public List<Rumor> listRumorByFuzzy(String con) {
		// TODO 自动生成的方法存根
		return rumorDao.listRumorByFuzzy(con);
	}

}
