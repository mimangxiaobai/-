package cn.gengms.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.gengms.dao.HomeArticleDao;
import cn.gengms.entity.HomeArticle;
import cn.gengms.service.HomeArticleService;

public class HomeArticleServiceImpl implements HomeArticleService {

	private HomeArticleDao homeArticleDao = new HomeArticleDao();

	@Override
	public Boolean saveHomeArticle(HomeArticle homeArticle) throws SQLException {
		// TODO 自动生成的方法存根
		Integer count = homeArticleDao.saveHomeArticle(homeArticle);
		if (count != 1) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Boolean removeHomeArticle(Integer id) throws SQLException {
		// TODO 自动生成的方法存根
		Integer count = homeArticleDao.removeHomeArticle(id);
		if (count != 1) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Boolean updateHomeArticle(HomeArticle homeArticle) throws SQLException {
		// TODO 自动生成的方法存根
		Integer count = homeArticleDao.updateHomeArticle(homeArticle);
		if (count != 1) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<HomeArticle> listHomeArticle() {
		// TODO 自动生成的方法存根
		List<HomeArticle> homeArticles = homeArticleDao.listHomeArticle();
		return homeArticles;
	}

	/*
	 * @Override public Boolean saveHomeArticle(HomeArticle homeArticle) throws
	 * SQLException { // TODO 自动生成的方法存根 Integer count =
	 * homeArticleDao.saveHomeArticle(homeArticle); if (count != 1) { return false;
	 * } else { return true; } }
	 */

}
