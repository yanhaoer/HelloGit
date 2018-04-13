package com.offcn.controlier.front;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.Dao.BaseDao;

@WebServlet(urlPatterns="/loginServlet_front")
public class loginServlet_front extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String u_phonenum=req.getParameter("phonenum");
	 	String u_password = req.getParameter("password");
	 	
	 	String sql="SELECT * FROM u_idle_user WHERE u_phonenum='"+u_phonenum+"' AND u_password='"+u_password+"'";
	 	List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
	 	
	 	if(list!=null && list.size()>0){
	 		Map<String, Object> map = list.get(0);
	 		if(map!=null){
	 		req.getSession().setAttribute("u_map", map); 
	 		
	 		req.getRequestDispatcher("front/index.jsp").forward(req, resp);
	 		}
	 	}
	 	else{
	 		resp.sendRedirect("front/login.jsp");
	 	}
	}
}
