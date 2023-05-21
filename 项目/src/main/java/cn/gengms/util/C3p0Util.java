package cn.gengms.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Util {
	private static final ComboPooledDataSource DATA_SOURCE = new ComboPooledDataSource();

	public static Connection getConnection() throws SQLException {
		return DATA_SOURCE.getConnection();
	}

	public static DataSource getDtaDataSource() {
		return DATA_SOURCE;
	}

	public static void release(Statement statement, Connection connection) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			statement = null;
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			connection = null;
		}
	}

	public static void release(ResultSet resultSet, Statement statement, Connection connection) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			resultSet = null;
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			statement = null;
		}

		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			connection = null;
		}
	}
}
