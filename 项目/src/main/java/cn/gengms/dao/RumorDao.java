package cn.gengms.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.gengms.entity.Rumor;
import cn.gengms.util.C3p0Util;

public class RumorDao {
	QueryRunner queryRunner = new QueryRunner(C3p0Util.getDtaDataSource());

	public Integer saveRumorDao(String content, Integer isRumor) throws SQLException {
		String sqlString = "insert into rumor(content, is_rumor) values(?,?)";
		return queryRunner.execute(sqlString, content, isRumor);
	}

	public Integer removeRumor(Integer id) throws SQLException {
		String sqlString = "delete from rumor where id = ?";
		return queryRunner.execute(sqlString, id);
	}

	public Integer updateRumor(Integer id, String content, Integer isRumor) throws SQLException {
		String sqlString = "update rumor set content = ?, is_rumor = ?  where id = ? ";
		return queryRunner.execute(sqlString, content, isRumor, id);
	}

	public List<Rumor> listRumor() {
		String sqlString = "select id, content , is_rumor isRumor from rumor";
		try {
			return queryRunner.query(sqlString, new BeanListHandler<Rumor>(Rumor.class));
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}

	public List<Rumor> listRumorByFuzzy(String con) {
		String sqlString = "select id, content , is_rumor isRumor from rumor where  content like ?";
		String param = "%" + con + "%";
		try {
			return queryRunner.query(sqlString, new BeanListHandler<Rumor>(Rumor.class), param);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
}
