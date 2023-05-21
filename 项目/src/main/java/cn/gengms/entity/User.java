package cn.gengms.entity;

public class User {
	private String uId;
	private String user;
	private String password;

	public User() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public User(String uId, String user, String password) {
		super();
		this.uId = uId;
		this.user = user;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", user=" + user + ", password=" + password + "]";
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
