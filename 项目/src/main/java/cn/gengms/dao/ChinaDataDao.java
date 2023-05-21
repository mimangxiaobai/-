package cn.gengms.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.gengms.entity.ChinaData;
import cn.gengms.entity.MapEntity;
import cn.gengms.util.C3p0Util;

public class ChinaDataDao {

	QueryRunner queryRunner = new QueryRunner(C3p0Util.getDtaDataSource());

	public List<ChinaData> listChinaData() throws SQLException {
		String sqlString = "select name,now_have,total_have from china_data ";
		return queryRunner.query(sqlString, new BeanListHandler<ChinaData>(ChinaData.class));
	}

	public Integer updateChinaData(ChinaData chinaData) throws SQLException {
		System.out.println(chinaData);
		String sqlString = "update china_data set now_have =?, total_have = ? where name = ?";
		return queryRunner.update(sqlString, chinaData.getNow_have(), chinaData.getTotal_have(), chinaData.getName());
	}

	public List<MapEntity> ListChinaNowData() {
		String sqlString = "select name,now_have value from china_data";
		try {
			return queryRunner.query(sqlString, new BeanListHandler<MapEntity>(MapEntity.class));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}

	public List<MapEntity> listChinaTotalData() {
		String sqlString = "select name, total_have value from china_data";
		try {
			return queryRunner.query(sqlString, new BeanListHandler<MapEntity>(MapEntity.class));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}

}
