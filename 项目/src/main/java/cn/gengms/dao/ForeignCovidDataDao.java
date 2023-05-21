package cn.gengms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.gengms.entity.ForeignCovidData;
import cn.gengms.entity.WorldDataFront;
import cn.gengms.util.C3p0Util;

public class ForeignCovidDataDao {
	QueryRunner queryRunner = new QueryRunner(C3p0Util.getDtaDataSource());

	public Integer saveForeignCovidData(ForeignCovidData foreignCovidData) throws SQLException {
		String sqlString = "insert into foreigncoviddata values(?,?,?,?,?)";
		return queryRunner.execute(sqlString, foreignCovidData.getDate(), foreignCovidData.getNowSure(),
				foreignCovidData.getNewAdd(), foreignCovidData.getNewDied(), foreignCovidData.getNewSave());
	}

	public Integer countForeignCovidDataByDate(String date) throws SQLException {
		String sqlString = "select count(date) from foreigncoviddata where date = ?";
		return queryRunner.query(sqlString, new ResultSetHandler<Integer>() {
			@Override
			public Integer handle(ResultSet arg0) throws SQLException {
				// TODO 自动生成的方法存根
				while (arg0.next()) {
					return arg0.getInt(1);
				}
				return null;
			}
		}, date);
	}

	public Integer updateForeignCovidData(ForeignCovidData foreignCovidData) throws SQLException {
		String sqlString = "update foreigncoviddata set now_sure = ? , new_add = ?, new_died = ?, new_save = ? where date = ?";
		return queryRunner.execute(sqlString, foreignCovidData.getNowSure(), foreignCovidData.getNewAdd(),
				foreignCovidData.getNewDied(), foreignCovidData.getNewSave(), foreignCovidData.getDate());
	}

	public List<WorldDataFront> listForeignCovidData() throws SQLException {
		String sqString = "select (a.now_sure-b.now_sure) nowSureMore, a.now_sure nowSure,(select sum(new_add) from foreigncoviddata) addSure, a.new_add addSureMore,(select sum(new_died) from foreigncoviddata) addDied, a.new_died addDiedMore,(select sum(new_save) from foreigncoviddata) addSave,a.new_save addSaveMore from(select * from foreigncoviddata where date = curdate()) a,  (select * from foreigncoviddata where date = curdate()-1) b;";
		return queryRunner.query(sqString, new BeanListHandler<WorldDataFront>(WorldDataFront.class));
	}

	public List<String> listForeignNowSure() {
		String sqlString = "select now_sure from foreigncoviddata where date_sub(curdate(), INTERVAL 7 DAY) <= date(`date`)";
		try {
			return queryRunner.query(sqlString, new ResultSetHandler<List<String>>() {

				@Override
				public List<String> handle(ResultSet arg0) throws SQLException {
					// TODO 自动生成的方法存根
					List<String> strings = new ArrayList<String>();
					while (arg0.next()) {
						strings.add(arg0.getString(1));
					}
					return strings;
				}
			});
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}

	public List<String> listWorldDate() {
		String sqlString = "select date from foreigncoviddata";
		try {
			return queryRunner.query(sqlString, new ResultSetHandler<List<String>>() {

				@Override
				public List<String> handle(ResultSet arg0) throws SQLException {
					// TODO 自动生成的方法存根
					List<String> strings = new ArrayList<String>();
					while (arg0.next()) {
						strings.add(arg0.getString(1));
					}
					return strings;
				}
			});
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}
}
