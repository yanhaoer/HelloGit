package com.offcn.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.offcn.Dao.BaseDao;

public class AdminService {

	public int UpdateAdmin(HttpServletRequest req, HttpServletResponse resp){
			
		try {
				req.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		String account=req.getParameter("account");
		String phonenum=req.getParameter("phonenum");
		String address=req.getParameter("address");
		String mailbox=req.getParameter("mailbox");
		
		String sql="UPDATE u_sys_admin SET phonenum='"+phonenum+"',address='"+address+"',mailbox='"+mailbox+"' WHERE account='"+account+"'";
		
		int n=new BaseDao().executeUpdate(sql);
		return n;
	}
}
