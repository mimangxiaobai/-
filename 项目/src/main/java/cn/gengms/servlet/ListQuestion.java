package cn.gengms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.gengms.entity.Question;
import cn.gengms.service.QuestionService;
import cn.gengms.service.impl.QuestionServiceImpl;
import cn.gengms.util.ResultUtil;

/**
 * Servlet implementation class ListQuestion
 */
@WebServlet("/ListQuestion")
public class ListQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QuestionService questionService = new QuestionServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListQuestion() {
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
		List<Question> questions = questionService.listQuestion();
		if (questions != null) {
			response.getWriter().print(ResultUtil.success(questions));
		} else {
			response.getWriter().print(ResultUtil.fail());
		}
	}

}
