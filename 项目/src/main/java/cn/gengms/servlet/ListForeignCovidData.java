package cn.gengms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gengms.entity.WorldDataFront;
import cn.gengms.service.ForeignCovidDataService;
import cn.gengms.service.impl.ForeignCovidDataServiceImpl;
import cn.gengms.util.ResultUtil;

/**
 * Servlet implementation class ListForeignCovidData
 */
@WebServlet("/ListForeignCovidData")
public class ListForeignCovidData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ForeignCovidDataService foreignCovidData = new ForeignCovidDataServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListForeignCovidData() {
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
		List<WorldDataFront> foreignCovidDatas = foreignCovidData.listWorldDataFronts();
		if (foreignCovidDatas != null) {
			response.getWriter().print(ResultUtil.success(foreignCovidDatas));
		} else {
			response.getWriter().print(ResultUtil.fail("201", "获取错误"));
		}
	}

}
