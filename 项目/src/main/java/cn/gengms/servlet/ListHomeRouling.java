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
 * Servlet implementation class ListHomeRouling
 */
@WebServlet("/ListHomeRouling")
public class ListHomeRouling extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomeRoulingService listHomeRoulingService = new HomeRoulingServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListHomeRouling() {
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
		response.setCharacterEncoding("utf-8");
		try {
			response.getWriter().print(ResultUtil.success(listHomeRoulingService.listHomeRouling()));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			response.getWriter().print(ResultUtil.fail());
		}
	}

}
