package com.offcn.controlier;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.idleService;

@WebServlet(urlPatterns="/QueryServlet")
public class QueryServlet extends HttpServlet {
	idleService service=new idleService();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 List<Map<String, Object>> list=service.QueryServlet();
		 
		 req.setAttribute("list", list);
		 req.getRequestDispatcher("module_idle/idlelist.jsp").forward(req, resp);
	}
}
