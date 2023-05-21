package cn.gengms.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.excel.EasyExcel;

import cn.gengms.entity.ChinaData;
import cn.gengms.service.WorldDataService;
import cn.gengms.service.impl.WorldDataServiceImpl;
import cn.gengms.util.ResultUtil;

/**
 * Servlet implementation class GetWorldDataExcel
 */
@WebServlet("/GetWorldDataExcel")
public class GetWorldDataExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WorldDataService worldDataService = new WorldDataServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetWorldDataExcel() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setContentType("application/vnd.ms-excel");
			response.setCharacterEncoding("utf-8");
			// 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
			String fileName = URLEncoder.encode("国际数据", "UTF-8").replaceAll("\\+", "%20");
			response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
			List<ChinaData> data = worldDataService.ListWorldData();
			EasyExcel.write(response.getOutputStream(), ChinaData.class).sheet("国际数据").doWrite(data);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			response.reset();
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(ResultUtil.fail());
		}
	}

}
