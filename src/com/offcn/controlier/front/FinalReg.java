package com.offcn.controlier.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.Dao.BaseDao;

@WebServlet(urlPatterns="/FinalReg")
public class FinalReg extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password=req.getParameter("pwd");
		String phone=req.getSession().getAttribute("phone")+"";
		
		String sql="INSERT INTO u_idle_user(u_phonenum,u_password,u_state) VALUES('"+phone+"','"+password+"','正常')";
		int n = new BaseDao().executeUpdate(sql);
		if(n>0){
			//注册成功，跳转跳转到登录页面
			req.getRequestDispatcher("front/login.jsp").forward(req, resp);
		}
	}
}
