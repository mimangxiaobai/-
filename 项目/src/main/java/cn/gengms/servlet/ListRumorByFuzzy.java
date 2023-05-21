package cn.gengms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gengms.entity.Rumor;
import cn.gengms.service.RumorService;
import cn.gengms.service.impl.RumorServiceImpl;

/**
 * Servlet implementation class ListRumorByFuzzy
 */

import cn.gengms.util.ResultUtil;

@WebServlet("/ListRumorByFuzzy")
public class ListRumorByFuzzy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RumorService rumorService = new RumorServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListRumorByFuzzy() {
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
		List<Rumor> rumors = rumorService.listRumorByFuzzy(request.getParameter("con"));
		if (rumors != null) {
			response.getWriter().print(ResultUtil.success(rumors));
		} else {
			response.getWriter().print(ResultUtil.fail());
		}
	}

}
