package cn.gengms.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gengms.service.HomeRoulingService;
import cn.gengms.service.impl.HomeRoulingServiceImpl;
import cn.gengms.util.ResultUtil;

/**
 * Servlet implementation class RemoveHomeRouling
 */
@WebServlet("/RemoveHomeRouling")
public class RemoveHomeRouling extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomeRoulingService homeRoulingService = new HomeRoulingServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveHomeRouling() {
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
		try {

			Integer index = Integer.valueOf(request.getParameter("index"));
			Boolean isDel = homeRoulingService.removeHomeRouling(index);
			if (isDel) {
				response.getWriter().print(ResultUtil.success());
			} else {
				response.getWriter().print(ResultUtil.fail("201", "删除失败"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			response.getWriter().print(ResultUtil.fail());
		}

	}

}
