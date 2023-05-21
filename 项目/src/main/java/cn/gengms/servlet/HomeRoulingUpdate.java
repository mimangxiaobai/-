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

import cn.gengms.service.HomeRoulingService;
import cn.gengms.service.impl.HomeRoulingServiceImpl;
import cn.gengms.util.AliOssUtil;
import cn.gengms.util.ResultUtil;

/**
 * Servlet implementation class HomeRoulingUpdate
 */
@MultipartConfig
@WebServlet("/HomeRoulingUpdate")
public class HomeRoulingUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HomeRoulingService homeRoulingService = new HomeRoulingServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeRoulingUpdate() {
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
		try {
			request.setCharacterEncoding("utf-8");
			Part part = request.getPart("file");
			System.out.println(request.getPart("file"));
			String imgUrl = AliOssUtil.upload(part);
			Integer rIdInteger = Integer.valueOf(request.getParameter("rId"));
			String articleUrl = request.getParameter("article");
			boolean resultBoolean = homeRoulingService.homeRoulingUpdate(rIdInteger, imgUrl, articleUrl);
			if (resultBoolean) {
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
