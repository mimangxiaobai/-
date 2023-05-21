package cn.gengms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gengms.service.CovidDataService;
import cn.gengms.service.impl.CovidDataServiceImpl;
import cn.gengms.util.ResultUtil;

/**
 * Servlet implementation class ListChinaNowSure
 */
@WebServlet("/ListChinaNowSure")
public class ListChinaNowSure extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CovidDataService covidDataService = new CovidDataServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListChinaNowSure() {
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
		List<String> listChinaNowSure = covidDataService.listChinaNowSure();
		if (listChinaNowSure != null) {
			response.getWriter().print(ResultUtil.success(listChinaNowSure));
		} else {
			response.getWriter().print(ResultUtil.fail());
		}
	}

}
