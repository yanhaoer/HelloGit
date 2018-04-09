package com.offcn.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.Dao.BaseDao;
public class pfUserService {

	public List<Map<String, Object>> queryPfUserServlet(HttpServletRequest request, HttpServletResponse response){
		String sql="SELECT u_id,u_nickname,u_phonenum,u_account,u_password,u_province,u_city,u_district,u_state FROM u_idle_user"; 
		List<Map<String, Object>> list=new BaseDao().executeQuery(sql);
		return list;
	}
	
	public List<Map<String, Object>> pfuserServlet(HttpServletRequest req, HttpServletResponse resp){
		String name=req.getParameter("name");
		
		String sql="SELECT * FROM u_idle_user WHERE u_state LIKE '%"+name+"%' OR u_id LIKE '%"+name+"%' OR u_nickname LIKE '%"+name+"%' OR u_phonenum LIKE '%"+name+"%' OR u_province LIKE '%"+name+"%' OR u_city LIKE '%"+name+"%' OR u_district LIKE '%"+name+"%'";
		List<Map<String, Object>> list=new BaseDao().executeQuery(sql);
		return list;
	}
	
	public List<Map<String, Object>> statisticServlet(HttpServletRequest req, HttpServletResponse resp){
		String sql="SELECT u_province,COUNT(u_province) AS amount FROM u_idle_user GROUP BY u_province";
		List<Map<String, Object>> list=new BaseDao().executeQuery(sql);
		return list;
	}
}
