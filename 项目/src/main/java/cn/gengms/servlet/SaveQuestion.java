package cn.gengms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import cn.gengms.entity.Question;
import cn.gengms.service.QuestionService;
import cn.gengms.service.impl.QuestionServiceImpl;
import cn.gengms.util.AliOssUtil;
import cn.gengms.util.ResultUtil;

/**
 * Servlet implementation class SaveQuestion
 */
@MultipartConfig
@WebServlet("/SaveQuestion")
public class SaveQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionService questionService = new QuestionServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SaveQuestion() {
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
		Question question = new Question();
		question.setTitle(request.getParameter("title"));
		question.setContent(request.getParameter("content"));
		Part file = request.getPart("img");
		String imgUrl = AliOssUtil.upload(file);
		question.setImgUrl(imgUrl);
		System.out.println(question);
		Boolean isSaved = questionService.saveQuestion(question);
		if (isSaved) {
			response.getWriter().print(ResultUtil.success());
		} else {
			response.getWriter().print(ResultUtil.fail());
		}
	}
}
