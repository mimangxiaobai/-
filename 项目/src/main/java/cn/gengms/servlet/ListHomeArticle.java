package cn.gengms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gengms.entity.HomeArticle;
import cn.gengms.service.HomeArticleService;
import cn.gengms.service.impl.HomeArticleServiceImpl;
import cn.gengms.util.ResultUtil;

/**
 * Servlet implementation class ListHomeArticle
 */
@WebServlet("/ListHomeArticle")
public class ListHomeArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomeArticleService homeArticleService = new HomeArticleServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListHomeArticle() {
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
		List<HomeArticle> homeArticles = homeArticleService.listHomeArticle();
		if (homeArticles == null) {
			response.getWriter().print(ResultUtil.fail());
		} else {
			response.getWriter().print(ResultUtil.success(homeArticles));
		}
	}

}
