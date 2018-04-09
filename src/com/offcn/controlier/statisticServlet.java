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

@WebServlet(urlPatterns="/statisticServlet")
public class statisticServlet extends HttpServlet {
	
	pfUserService service=new pfUserService();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Map<String, Object>> list=service.statisticServlet(req, resp);
		req.setAttribute("list", list);
		req.getRequestDispatcher("module_pfuser/statistic.jsp").forward(req, resp);
	}
}
