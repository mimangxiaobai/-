package cn.gengms.service.impl;

import cn.gengms.dao.UserDao;
import cn.gengms.entity.User;
import cn.gengms.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao UserDao = new UserDao();

	@Override
	public User getUserByInfor(User user) throws Exception {
		// TODO 自动生成的方法存根
		return UserDao.getUser(user);
	}

}
