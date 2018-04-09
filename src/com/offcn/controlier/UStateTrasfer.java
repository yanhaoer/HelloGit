package com.offcn.controlier;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.offcn.Dao.BaseDao;
@WebServlet(urlPatterns="/UStateTrasfer")
public class UStateTrasfer extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u_id=request.getParameter("u_id");
		String sql="UPDATE u_idle_user SET u_state=IF(u_state='正常','锁定','正常') WHERE u_id='"+u_id+"'";
		int n = new BaseDao().executeUpdate(sql);
		
		if(n>0){
			System.out.println("更改成功");
			request.getRequestDispatcher("pfUserServlet").forward(request, response);
		}else{
			System.out.println("更改失败");
		}
			
	}
}
