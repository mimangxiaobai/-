package cn.gengms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import cn.gengms.util.C3p0Util;

public class HomeRoulingDao {
	QueryRunner queryRunner = new QueryRunner(C3p0Util.getDtaDataSource());

	public Integer HomgRoulingSave(String imgUrl, String articleUrl) throws SQLException {
		String sqlString = "insert into home_rouling(img_url,article_url) values(?,?)";

		return queryRunner.execute(sqlString, imgUrl, articleUrl);
	}

	public Integer HomeRoulingUpdate(Integer rId, String imgUrl, String articleUrl) throws SQLException {
		String sqString = "update home_rouling set img_url = ?,article_url=? where r_id = (select r_id from (select * from home_rouling) a limit ?,1)";
		return queryRunner.execute(sqString, imgUrl, articleUrl, rId - 1);
	}

	public Integer removeHomeRouling(Integer index) throws SQLException {
		String sqlString = "delete from home_rouling where r_id = (select r_id from (select * from home_rouling) a limit ?,1)";
		return queryRunner.update(sqlString, index - 1);
	}

	public List<HashMap<String, String>> listHomeRouling() throws SQLException {
		String sqString = "select r_id rId,img_url imgUrl,article_url articleUrl from home_rouling";

		List<HashMap<String, String>> resultMap = queryRunner.query(sqString,
				new ResultSetHandler<List<HashMap<String, String>>>() {
					@Override
					public List<HashMap<String, String>> handle(ResultSet arg0) throws SQLException {
						// TODO 自动生成的方法存根
						List<HashMap<String, String>> hashMap = new ArrayList<HashMap<String, String>>();
						while (arg0.next()) {
							HashMap<String, String> hMap = new HashMap<String, String>();
							hMap.put("rId", arg0.getString(1));
							hMap.put("imgUrl", arg0.getString(2));
							hMap.put("articleUrl", arg0.getString(3));
							hashMap.add(hMap);
						}
						return hashMap;
					}

				});
		return resultMap;
	}

}
