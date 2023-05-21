package cn.gengms.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.gengms.entity.HomeArticle;
import cn.gengms.util.C3p0Util;

public class HomeArticleDao {
	private QueryRunner queryRunner = new QueryRunner(C3p0Util.getDtaDataSource());

	public Integer saveHomeArticle(HomeArticle homeArticle) throws SQLException {
		String sqlString = "insert into home_article(title, article_url , img_url ) values(?,?,?)";
		return queryRunner.update(sqlString, homeArticle.getTitle(), homeArticle.getArticleUrl(),
				homeArticle.getImgUrl());
	}

	public Integer removeHomeArticle(Integer id) throws SQLException {
		String sqlString = "delete from home_article where id = ?";
		return queryRunner.update(sqlString, id);
	}

	public Integer updateHomeArticle(HomeArticle homeArticle) throws SQLException {
		String sql = "update home_article set title = ?,article_url = ?, img_url = ? where id = ?";
		return queryRunner.update(sql, homeArticle.getTitle(), homeArticle.getArticleUrl(), homeArticle.getImgUrl(),
				homeArticle.getId());
	}

	public List<HomeArticle> listHomeArticle() {
		String sqlString = "select id,title, article_url articleUrl, img_url imgUrl from home_article";
		try {
			return queryRunner.query(sqlString, new BeanListHandler<HomeArticle>(HomeArticle.class));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
}
