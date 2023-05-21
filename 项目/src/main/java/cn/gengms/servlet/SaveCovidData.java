package cn.gengms.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gengms.entity.CovidData;
import cn.gengms.service.CovidDataService;
import cn.gengms.service.impl.CovidDataServiceImpl;
import cn.gengms.util.ResultUtil;

/**
 * Servlet implementation class saveCovidData
 */
@WebServlet("/SaveCovidData")
public class SaveCovidData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CovidDataService covidDataService = new CovidDataServiceImpl();
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveCovidData() {
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
		request.setCharacterEncoding("utf-8");
		CovidData covidData = new CovidData();

		covidData.setDate(simpleDateFormat.format(new Date()));
		covidData.setNowSure(request.getParameter("nowSure"));
		covidData.setNowAdd(request.getParameter("nowAdd"));
		covidData.setNowIcu(request.getParameter("nowIcu"));
		covidData.setAddSure(request.getParameter("addSure"));
		covidData.setAddDied(request.getParameter("addDied"));
		covidData.setAddSave(request.getParameter("addSave"));

		try {
			Boolean isSaved = covidDataService.saveCovidData(covidData);
			if (isSaved) {
				response.getWriter().print(ResultUtil.success());
			} else {
				response.getWriter().print(ResultUtil.fail("201", "插入错误"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			response.getWriter().print(ResultUtil.fail());
		}
	}

}
