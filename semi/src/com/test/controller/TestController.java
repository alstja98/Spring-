package com.test.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.TestDao;
import com.test.dto.TestDto;

@WebServlet("/TestController")
public class TestController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String command = request.getParameter("command");
		TestDao dao = new TestDao();

		if(command.equals("output")) {
			List<TestDto> list = dao.selectAll();
			request.setAttribute("list", list);
			dispatch("output.jsp",request,response);
		}

	}

	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String str = "<script type='text/javascript'> " + 
					"alert('"+msg+"');" + "location.href='"+url+"';" + "</script>";
		
		PrintWriter out = response.getWriter();
		out.print(str);
	}
	
	private void dispatch(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
