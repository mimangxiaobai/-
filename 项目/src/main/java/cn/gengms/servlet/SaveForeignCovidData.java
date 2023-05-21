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

import cn.gengms.entity.ForeignCovidData;
import cn.gengms.service.ForeignCovidDataService;
import cn.gengms.service.impl.ForeignCovidDataServiceImpl;
import cn.gengms.util.ResultUtil;

/**
 * Servlet implementation class SaveForeignCovidData
 */
@WebServlet("/SaveForeignCovidData")
public class SaveForeignCovidData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ForeignCovidDataService foreignCovidDataService = new ForeignCovidDataServiceImpl();
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveForeignCovidData() {
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
		ForeignCovidData foreignCovidData = new ForeignCovidData();
		foreignCovidData.setDate(simpleDateFormat.format(new Date()));
		foreignCovidData.setNewAdd(request.getParameter("newAdd"));
		foreignCovidData.setNewDied(request.getParameter("newDied"));
		foreignCovidData.setNewSave(request.getParameter("newSave"));
		foreignCovidData.setNowSure(request.getParameter("nowSure"));
		try {
			Boolean isSaved = foreignCovidDataService.saveForeignCovidData(foreignCovidData);
			if (isSaved) {
				response.getWriter().print(ResultUtil.success());
			} else {
				response.getWriter().print(ResultUtil.fail("201", "插入错误"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			response.getWriter().print(ResultUtil.success());
		}
	}

}
