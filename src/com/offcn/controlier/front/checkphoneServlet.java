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

@WebServlet(urlPatterns="/checkphoneServlet")
public class checkphoneServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phonenum = request.getParameter("phonenum");
		String sql="SELECT * FROM u_idle_user WHERE u_phonenum='"+phonenum+"'";
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		
		if(list!=null && list.size()>0){
			response.getWriter().write("no");
		}else{
			response.getWriter().write("yes");
		}
	}
}
