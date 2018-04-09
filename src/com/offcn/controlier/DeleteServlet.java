package com.offcn.controlier;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.service.idleService;
@WebServlet(urlPatterns="/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	idleService service=new idleService();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int n=service.DeleteServlet(req,resp);
		if(n>0){
			System.out.println("É¾³ý³É¹¦");
			req.getRequestDispatcher("QueryServlet").forward(req, resp);
		}else{
			System.out.println("É¾³ýÊ§°Ü");
		}
	}
}
