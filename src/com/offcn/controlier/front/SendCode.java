package com.offcn.controlier.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/SendCode")
public class SendCode extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone=request.getParameter("phone");
		request.getSession().setAttribute("phone", phone);
		
		//������֤��
		//String code = SmsUtils.SendSms(phone);

		String code = "123456";
		request.getSession().removeAttribute("code");
		
		request.getSession().setAttribute("code",code);
		
		response.getWriter().write("ok");
	}
}
