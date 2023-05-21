package cn.gengms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.alibaba.excel.EasyExcel;

import cn.gengms.entity.ChinaData;
import cn.gengms.util.ResultUtil;
import cn.gengms.util.WorldExcelListener;

/**
 * Servlet implementation class ReadWorldDataExcel
 */
@MultipartConfig
@WebServlet("/ReadWorldDataExcel")
public class ReadWorldDataExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadWorldDataExcel() {
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
		Part part = request.getPart("file");
		System.out.println(part.getName());
		EasyExcel.read(part.getInputStream(), ChinaData.class, new WorldExcelListener()).sheet().doRead();
		response.getWriter().print(ResultUtil.success());
	}

}
