package cn.gengms.service;

import java.sql.SQLException;
import java.util.List;

import cn.gengms.entity.HomeArticle;

public interface HomeArticleService {

	Boolean saveHomeArticle(HomeArticle homeArticle) throws SQLException;

	Boolean removeHomeArticle(Integer id) throws SQLException;

	Boolean updateHomeArticle(HomeArticle homeArticle) throws SQLException;

	List<HomeArticle> listHomeArticle();
}
