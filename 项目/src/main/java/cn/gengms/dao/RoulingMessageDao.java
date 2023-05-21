package cn.gengms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import cn.gengms.util.C3p0Util;

public class RoulingMessageDao {
	private QueryRunner queryRunner = new QueryRunner(C3p0Util.getDtaDataSource());

	public Integer saveRoulingMessage(String title, String content) throws SQLException {
		String sqlString = "insert into rouling_message(title,content) values(?,?)";
		return queryRunner.execute(sqlString, title, content);
	}

	public Integer updateRoulingMessage(Integer index, String title, String content) throws SQLException {
		String sqlString = "update rouling_message set title = ?,content = ? where id = (select id from (select * from rouling_message) a limit ? , 1)";
		return queryRunner.execute(sqlString, title, content, index);
	}

	public Integer removeRoulingMessage(Integer index) throws SQLException {
		String sqString = "delete from rouling_message where id = (select id from (select * from rouling_message) a limit ? , 1)";
		return queryRunner.execute(sqString, index);
	}

	public List<HashMap<String, Object>> listRoulingMessage() throws SQLException {
		String sqlString = "select id,title,content from rouling_message";
		List<HashMap<String, Object>> dataList = queryRunner.query(sqlString,
				new ResultSetHandler<List<HashMap<String, Object>>>() {

					@Override
					public List<HashMap<String, Object>> handle(ResultSet arg0) throws SQLException {
						// TODO 自动生成的方法存根
						List<HashMap<String, Object>> hashMap = new ArrayList<>();
						while (arg0.next()) {
							HashMap<String, Object> hMap = new HashMap<>();
							hMap.put("id", arg0.getString(1));
							hMap.put("title", arg0.getString(2));
							hMap.put("content", arg0.getString(3));
							hashMap.add(hMap);
						}
						return hashMap;
					}
				});
		return dataList;
	}
}
