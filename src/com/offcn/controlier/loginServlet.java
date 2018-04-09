package com.offcn.controlier;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.loginService;

@WebServlet(urlPatterns="/loginServlet")
public class loginServlet extends HttpServlet {

	loginService loginService=new loginService();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String, Object> map=loginService.login(request, response);
		if(map!=null){
			request.getSession().setAttribute("map", map);
			request.getRequestDispatcher("index/index.jsp").forward(request, response);
		}
		else{
			response.sendRedirect("login.jsp");
		}	
	}
	
	
}
