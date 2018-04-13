package com.offcn.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.offcn.Dao.BaseDao;
public class idleService {

	public int AddidleServlet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException{
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String name = request.getParameter("name");
		String presentation = request.getParameter("presentation");
		String unit = request.getParameter("unit");
		String amount = request.getParameter("amount");
		String location = request.getParameter("location");
		String purchasing_date = request.getParameter("purchasing_date");
		String original_price = request.getParameter("original_price");
		String transfer_price = request.getParameter("transfer_price");
		String transfer_mode = request.getParameter("transfer_mode");
		String percentage = request.getParameter("percentage");
		String fk_idletype = request.getParameter("fk_idletype");
		
		String filename=saveImg(request,response);
		
		String sql=" INSERT INTO u_idle_info "
				+ "(NAME,idleimg,presentation,unit,amount,location,purchasing_date,original_price,transfer_price,transfer_mode,transfer_state,percentage,fk_idletype,uidle_state,create_date,fk_fisher)  "
				+ " VALUES "
				+ " ('"+name+"','"+filename+"','"+presentation+"','"+unit+"',"+amount+",'"+location+"','"+purchasing_date+"',"+original_price+","+transfer_price+",'"+transfer_mode+"','未交易','"+percentage+"',"+fk_idletype+",'正常',CURRENT_DATE(),'3') ";
		
		int n=new BaseDao().executeUpdate(sql);
		return n;
	}
	
	public List<Map<String, Object>> QueryServlet(){
		String sql="SELECT id,name,idleimg,presentation,unit,amount,location FROM u_idle_info";
		List<Map<String, Object>> list=new BaseDao().executeQuery(sql);
		return list;
	}
	public int DeleteServlet(HttpServletRequest req, HttpServletResponse resp){
		String id=req.getParameter("id");
		String sql="DELETE	FROM u_idle_info WHERE id='"+id+"'";
		int n=new BaseDao().executeUpdate(sql);
		return n;
	}
	public List<Map<String, Object>> QueryLikeServlet(HttpServletRequest req, HttpServletResponse resp){
		String name=req.getParameter("name");
		String sql="SELECT id,name,presentation,unit,amount,location FROM  u_idle_info WHERE NAME LIKE '%"+name+"%'";
		List<Map<String, Object>> list =new BaseDao().executeQuery(sql);
		return list ;
	}
	
	
	public String saveImg(HttpServletRequest request, HttpServletResponse response){
		 	
			Part part=null;
			//1.获取用户上传图片对应的part对象
			try {
				part = request.getPart("idleimg");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//2.获取当前的时间
			Date date=new Date();
		 	SimpleDateFormat sf=new SimpleDateFormat("yyyyMMddhhmmss");
		 	String str = sf.format(date);
		 	
		 	//3.获取用户上传的图片的后缀名
		 	String cd=part.getHeader("Content-Disposition");
		 	//form-data; name="idleimg"; filename="20171108083623.jpg"
		 	String houzhui=cd.substring(cd.indexOf("."),cd.length()-1);
		 	String filename=str+houzhui;
			//4.将图片保存,利用生成的文件名
			try {
				//D:\apache-tomcat-9.0.0.M21\webapps\offcn_idle_sys\idleimg
				String realPath = request.getServletContext().getRealPath("/idleimg")+"\\"+filename;
				part.write(realPath);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		return filename;
	}
	
}
