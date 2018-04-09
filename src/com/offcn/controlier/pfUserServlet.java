package com.offcn.controlier;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.pfUserService;

@WebServlet(urlPatterns="/pfUserServlet")
public class pfUserServlet extends HttpServlet {
	pfUserService service=new pfUserService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, Object>> list=service.queryPfUserServlet(request, response);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("module_pfuser/pfuserlist.jsp").forward(request, response);
	}
}
