package cn.gengms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.gengms.entity.ChinaDataFront;
import cn.gengms.entity.CovidData;
import cn.gengms.util.C3p0Util;

public class CovidDataDao {
	private QueryRunner queryRunner = new QueryRunner(C3p0Util.getDtaDataSource());

	public Integer saveCovidData(CovidData covidData) throws SQLException {
		String sqlString = "insert into covid_data values(?,?,?,?,?,?,?)";
		return queryRunner.update(sqlString, covidData.getDate(), covidData.getNowSure(), covidData.getNowAdd(),
				covidData.getNowIcu(), covidData.getAddSure(), covidData.getAddDied(), covidData.getAddSave());
	}

	public Integer countCovidDataByDate(String date) throws SQLException {
		String sqString = "select count(date) from covid_data where date = ?";
		return queryRunner.query(sqString, new ResultSetHandler<Integer>() {

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

	public Integer updateCovidData(CovidData covidData) throws SQLException {
		String sqString = "update covid_data set now_sure = ? ,now_add = ?, now_icu = ?, add_sure = ?, add_died = ?,add_save = ? where date = ?";
		return queryRunner.update(sqString, covidData.getNowSure(), covidData.getNowAdd(), covidData.getNowIcu(),
				covidData.getAddSure(), covidData.getAddDied(), covidData.getAddSave(), covidData.getDate());
	}

	public List<ChinaDataFront> listCovidData() {
		String sqlString = "select  a.now_sure-b.now_sure nowSureMore,a.now_sure nowSure, a.now_add-b.now_add nowAddMore, a.now_add nowAdd, a.now_icu-b.now_icu nowIcuMore, a.now_icu nowIcu,(select sum(add_sure) from covid_data ) addSure,a.add_sure addSureMore,(select sum(add_died) from covid_data) addDied,a.add_died addDiedMore,(select sum(add_save) from covid_data) addSave,a.add_save addSaveMore from (select * from covid_data where date = curdate()) a , (select * from covid_data where date = curdate()-1) b";
		try {
			return queryRunner.query(sqlString, new BeanListHandler<ChinaDataFront>(ChinaDataFront.class));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}

	public List<String> listChinaDate() {
		String sqlString = "select date from covid_data";
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

	public List<String> listChinaAddSure() {
		String sqlString = "select add_sure from covid_data where date_sub(curdate(), INTERVAL 7 DAY) <= date(`date`)";
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

	public List<String> listChinaNowSure() {
		String sqlString = "select now_sure from covid_data where date_sub(curdate(), INTERVAL 7 DAY) <= date(`date`)";
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

	public List<String> listChinaAddSave() {
		String sqlString = "select add_save from covid_data where date_sub(curdate(), INTERVAL 7 DAY) <= date(`date`)";
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

	public List<String> listChinaAddDied() {
		String sqlString = "select add_died from covid_data where date_sub(curdate(), INTERVAL 7 DAY) <= date(`date`)";
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
