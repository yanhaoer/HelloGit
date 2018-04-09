package com.offcn.controlier;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/CheckOriPwd")
public class CheckOriPwd extends HttpServlet {
	@SuppressWarnings("unchecked")
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		//������Ӧ����
		response.setContentType("text/html;charset=utf-8");
			
		//�û������ԭʼ����
		String oripwd =request.getParameter("oripwd");
		
		Map<String, Object> map = (Map<String, Object>) request.getSession().getAttribute("map");

		// ���ݿ��У���ʵ��ԭʼ����
		String password = map.get("password") + "";

		String msg = "";
		if (oripwd.equals(password)) {
			//msg = "<font color='green'>��</font>";
			msg="ok";
		} else {
			msg="error";
			//msg = "<font color='red'>��</font>";
		}
		
		//��Ϊajax�첽�������Ӧ����
		response.getWriter().write(msg);
	}
}
