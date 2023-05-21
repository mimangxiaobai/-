package cn.gengms.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.gengms.entity.HomeArticle;
import cn.gengms.service.HomeArticleService;
import cn.gengms.service.impl.HomeArticleServiceImpl;
import cn.gengms.util.AliOssUtil;
import cn.gengms.util.ResultUtil;

/**
 * Servlet implementation class UpdateHomeArticle
 */
@MultipartConfig
@WebServlet("/UpdateHomeArticle")
public class UpdateHomeArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomeArticleService homeArticleService = new HomeArticleServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateHomeArticle() {
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
		Part file = request.getPart("file");
		String url = AliOssUtil.upload(file);
		Integer id = Integer.valueOf(request.getParameter("id"));
		String title = request.getParameter("title");
		String articleUrl = request.getParameter("articleUrl");
		HomeArticle homeArticle = new HomeArticle(id, title, articleUrl, url);
		try {
			Boolean isUpdated = homeArticleService.updateHomeArticle(homeArticle);
			if (isUpdated) {
				response.getWriter().print(ResultUtil.success());
			} else {
				response.getWriter().print(ResultUtil.fail("201", "修改错误"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			response.getWriter().print(ResultUtil.fail());
		}
	}

}
