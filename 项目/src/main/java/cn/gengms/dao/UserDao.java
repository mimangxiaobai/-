package cn.gengms.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.gengms.entity.User;
import cn.gengms.util.C3p0Util;

public class UserDao {

	private QueryRunner queryRunner = new QueryRunner(C3p0Util.getDtaDataSource());

	public User getUser(User user) throws SQLException {
		String sql = "select u_id uId, user, password from user where user = ? and password = ?";
		User user2 = queryRunner.query(sql, new BeanHandler<User>(User.class), user.getUser(), user.getPassword());
		return user2;
	}
}
