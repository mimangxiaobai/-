package cn.gengms.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gengms.service.HomeArticleService;
import cn.gengms.service.impl.HomeArticleServiceImpl;
import cn.gengms.util.ResultUtil;

/**
 * Servlet implementation class RemoveHomeArticle
 */
@WebServlet("/RemoveHomeArticle")
public class RemoveHomeArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomeArticleService homeArticleService = new HomeArticleServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveHomeArticle() {
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
		Integer id = Integer.valueOf(request.getParameter("id"));
		System.out.println(id);
		try {
			Boolean hasRemoved = homeArticleService.removeHomeArticle(id);
			if (hasRemoved) {
				response.getWriter().print(ResultUtil.success());
			} else {
				response.getWriter().print(ResultUtil.fail("201", "删除错误"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			response.getWriter().print(ResultUtil.fail());
		}
	}

}
