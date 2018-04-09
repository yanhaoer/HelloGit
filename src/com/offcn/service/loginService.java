package com.offcn.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.offcn.Dao.BaseDao;
public class loginService {

	public Map<String, Object> login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");
		
		String account=request.getParameter("account");
		String password=request.getParameter("password");
		
		String sql="SELECT * FROM u_sys_admin WHERE account='"+account+"' AND password='"+password+"'";
		
		List<Map<String, Object>> list=new BaseDao().executeQuery(sql);
		
		if(list!=null && list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	public void exitLogin(HttpServletRequest req, HttpServletResponse resp){
		//1.Ïú»Ùsession
		HttpSession session=req.getSession();
		session.invalidate();
		//2.ÖØµÇµÇÂ¼Ò³Ãæ
		try {
			resp.sendRedirect("login.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
