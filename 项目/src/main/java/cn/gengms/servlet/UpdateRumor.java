package cn.gengms.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gengms.service.RumorService;
import cn.gengms.service.impl.RumorServiceImpl;
import cn.gengms.util.ResultUtil;

/**
 * Servlet implementation class UpdateRumor
 */
@WebServlet("/UpdateRumor")
public class UpdateRumor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RumorService rumorService = new RumorServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateRumor() {
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
		Integer idInteger = Integer.valueOf(request.getParameter("id"));
		String content = request.getParameter("content");
		Integer isRumor = Integer.valueOf(request.getParameter("isRumors"));
		try {
			Boolean isUpdated = rumorService.updateRumor(idInteger, content, isRumor);
			if (isUpdated) {
				response.getWriter().print(ResultUtil.success());
			} else {
				response.getWriter().print(ResultUtil.fail("201", "更新失败"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			response.getWriter().print(ResultUtil.fail());
		}
	}

}
