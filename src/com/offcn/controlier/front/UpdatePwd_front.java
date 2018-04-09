package com.offcn.controlier.front;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.Dao.BaseDao;

@WebServlet(urlPatterns="/UpdatePwd_front")
public class UpdatePwd_front extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pwd=req.getParameter("pwd");
		String u_id = req.getParameter("u_id");

		String sql="UPDATE u_idle_user SET u_password='"+pwd+"' WHERE u_id='"+u_id+"'";
		int n =new BaseDao().executeUpdate(sql);
		
		if(n>0){
				resp.getWriter().write("ok");
		}else{
				resp.getWriter().write("error");
		}
	}
}
