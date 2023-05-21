package cn.gengms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gengms.service.QuestionService;
import cn.gengms.service.impl.QuestionServiceImpl;
import cn.gengms.util.ResultUtil;

/**
 * Servlet implementation class RemoveQuestion
 */
@WebServlet("/RemoveQuestion")
public class RemoveQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionService questionService = new QuestionServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveQuestion() {
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
		System.out.println("----------");
		response.setCharacterEncoding("utf-8");
		Boolean isRemoved = questionService.removeQuestion(Integer.valueOf(request.getParameter("id")));
		if (isRemoved) {
			response.getWriter().print(ResultUtil.success());
		} else {
			response.getWriter().print(ResultUtil.fail());
		}
	}

}
