package cn.gengms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gengms.entity.User;
import cn.gengms.service.UserService;
import cn.gengms.service.impl.UserServiceImpl;
import cn.gengms.util.ResultUtil;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		User user = new User();
		user.setUser(request.getParameter("user"));
		user.setPassword(request.getParameter("password"));
		try {
			User resultUser = userService.getUserByInfor(user);
			if (resultUser == null) {
				String fail = ResultUtil.fail("201", "账号或密码错误");

				response.getWriter().print(fail);
			} else {

				response.getWriter().print(ResultUtil.success());
			}

		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			response.getWriter().print(ResultUtil.fail());
		}
	}

}
