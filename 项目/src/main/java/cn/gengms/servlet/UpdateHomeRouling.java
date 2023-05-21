package cn.gengms.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gengms.service.RoulingMessageService;
import cn.gengms.service.impl.RoulingMessageServiceImpl;
import cn.gengms.util.ResultUtil;

/**
 * Servlet implementation class UpdateHomeRouling
 */
@WebServlet("/UpdateHomeRouling")
public class UpdateHomeRouling extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoulingMessageService roulingMessageService = new RoulingMessageServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateHomeRouling() {
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
		Integer index = Integer.valueOf(request.getParameter("index"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		try {
			Boolean isUpdated = roulingMessageService.updateRoulingMessage(index, title, content);
			if (isUpdated) {
				response.getWriter().print(ResultUtil.success());
			} else {
				response.getWriter().print(ResultUtil.fail("201", "修改 错误"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			response.getWriter().print(ResultUtil.fail());
		}
	}

}
