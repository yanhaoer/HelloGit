package com.offcn.controlier.front;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/ExitServlet_front")
public class ExitServlet_front extends HttpServlet {
	
	protected void service(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,IOException {
		//1.Ïú»Ùsession
		HttpSession session=req.getSession();
		session.invalidate();
		//2.ÖØµÇµÇÂ¼Ò³Ãæ
		try {
			resp.sendRedirect("front/login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	};
}
