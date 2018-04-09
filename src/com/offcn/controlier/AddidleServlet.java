package com.offcn.controlier;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.offcn.service.idleService;

@WebServlet(urlPatterns="/AddidleServlet")
@MultipartConfig
public class AddidleServlet extends HttpServlet {
	idleService idleService = new idleService();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = idleService.AddidleServlet(request, response);
		if(n>0){
			System.out.println("添加成功");
			request.getRequestDispatcher("QueryServlet").forward(request, response);
		}else{
			System.out.println("添加失败");
		}
	}
}
