package cn.gengms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gengms.entity.MapEntity;
import cn.gengms.service.ChinaDataService;
import cn.gengms.service.impl.ChinaDataServiceImpl;
import cn.gengms.util.ResultUtil;

/**
 * Servlet implementation class ListChinaNowData
 */
@WebServlet("/ListChinaNowData")
public class ListChinaNowData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ChinaDataService chinaDataService = new ChinaDataServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListChinaNowData() {
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

		List<MapEntity> chinaDatas = chinaDataService.ListChinaNowData();
		if (chinaDatas == null) {
			response.getWriter().print(ResultUtil.fail("201", "获取错误"));
		} else {
			response.getWriter().print(ResultUtil.success(chinaDatas));
		}

	}

}
