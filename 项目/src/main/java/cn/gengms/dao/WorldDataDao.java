package cn.gengms.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.gengms.entity.ChinaData;
import cn.gengms.entity.MapEntity;
import cn.gengms.util.C3p0Util;

public class WorldDataDao {

	QueryRunner queryRunner = new QueryRunner(C3p0Util.getDtaDataSource());

	public List<ChinaData> listWorldData() throws SQLException {
		String sqlString = "select name,now_have,total_have from world_data ";
		return queryRunner.query(sqlString, new BeanListHandler<ChinaData>(ChinaData.class));
	}

	public Integer updateWorldData(ChinaData chinaData) throws SQLException {
		String sqlString = "update world_data set now_have =?, total_have = ? where name = ?";
		return queryRunner.update(sqlString, chinaData.getNow_have(), chinaData.getTotal_have(), chinaData.getName());
	}

	public List<MapEntity> listWorldNowData() {
		String sqlString = "select name,now_have value from world_data";
		try {
			return queryRunner.query(sqlString, new BeanListHandler<MapEntity>(MapEntity.class));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}

	public List<MapEntity> listWorldTotalData() {
		String sqlString = "select name, total_have value from world_data";
		try {
			return queryRunner.query(sqlString, new BeanListHandler<MapEntity>(MapEntity.class));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
}
