package com.offcn.controlier;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.Dao.BaseDao;
import com.offcn.service.AdminService;

@WebServlet(urlPatterns="/UpdateAdmin")
public class UpdateAdmin extends HttpServlet {
	AdminService service =new AdminService();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int n=service.UpdateAdmin(req, resp);
		if(n>0){
			//更新session 中的map
			String account=req.getParameter("account");
			String sql="SELECT	* FROM u_sys_admin where account='"+account+"'";
		    Map<String, Object> map=new BaseDao().executeQuery(sql).get(0);
		    req.getSession().setAttribute("map", map);
		    
		    req.getRequestDispatcher("module_geren/gerenxinxi.jsp").forward(req, resp);

		}
		
	}
}
