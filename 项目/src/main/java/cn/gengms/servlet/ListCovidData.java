package cn.gengms.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gengms.entity.ChinaDataFront;
import cn.gengms.service.CovidDataService;
import cn.gengms.service.impl.CovidDataServiceImpl;
import cn.gengms.util.ResultUtil;

/**
 * Servlet implementation class ListCovidData
 */
@WebServlet("/ListCovidData")
public class ListCovidData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CovidDataService covidDataService = new CovidDataServiceImpl();
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListCovidData() {
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
			List<ChinaDataFront> chinaDataFronts = covidDataService.listCovidData(simpleDateFormat.format(new Date()));
			if (chinaDataFronts == null) {
				response.getWriter().print(ResultUtil.fail("201", "获取错误"));
			} else {
				response.getWriter().print(ResultUtil.success(chinaDataFronts));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			response.getWriter().print(ResultUtil.fail());
		}
	}

}
