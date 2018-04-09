package com.offcn.controlier.front;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.Dao.BaseDao;

@WebServlet(urlPatterns="/UpdateUserServlet_front")
public class UpdateUserServlet_front extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String u_phonenum=req.getParameter("u_phonenum");
		String u_account=req.getParameter("u_account");
		String u_nickname=req.getParameter("u_nickname");
		String u_birthday=req.getParameter("u_birthday");
		//String u_headimg=req.getParameter("u_headimg");
		
		String sql="UPDATE u_idle_user SET  u_nickname='"+u_nickname+"',u_account='"+u_account+"',u_birthday='"+u_birthday+"' WHERE u_phonenum='"+u_phonenum+"'";
		int n = new BaseDao().executeUpdate(sql);
		if(n>0){
			//更新session 中的map
			String sql1="SELECT * FROM u_idle_user WHERE u_phonenum='"+u_phonenum+"'";
		    Map<String, Object> u_map=new BaseDao().executeQuery(sql1).get(0);
		    req.getSession().setAttribute("u_map", u_map);
		    
		    req.getRequestDispatcher("front/wanshan.jsp").forward(req, resp);
		}
	}
}
