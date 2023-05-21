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
 * Servlet implementation class SaveHomeArticle
 */
@MultipartConfig
@WebServlet("/SaveHomeArticle")
public class SaveHomeArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomeArticleService homeArticleService = new HomeArticleServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveHomeArticle() {
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
		Part part = request.getPart("file");
		String url = AliOssUtil.upload(part);
		HomeArticle homeArticle = new HomeArticle(null, request.getParameter("title"),
				request.getParameter("artcleUrl"), url);
		try {
			Boolean hasSaved = homeArticleService.saveHomeArticle(homeArticle);
			if (hasSaved) {
				response.getWriter().print(ResultUtil.success());
			} else {
				response.getWriter().print(ResultUtil.fail("201", "添加错误"));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			response.getWriter().print(ResultUtil.fail());
		}
	}

}
