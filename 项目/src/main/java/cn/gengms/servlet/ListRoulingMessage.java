package cn.gengms.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gengms.service.RoulingMessageService;
import cn.gengms.service.impl.RoulingMessageServiceImpl;
import cn.gengms.util.ResultUtil;

/**
 * Servlet implementation class ListRoulingMessage
 */
@WebServlet("/ListRoulingMessage")
public class ListRoulingMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RoulingMessageService roulingMessageService = new RoulingMessageServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListRoulingMessage() {
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
			List<HashMap<String, Object>> listRoulingMessage = roulingMessageService.listRoulingMessage();
			response.getWriter().print(ResultUtil.success(listRoulingMessage));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			response.getWriter().print(ResultUtil.fail());
		}
	}

}
