package com.offcn.controlier.front;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.offcn.Dao.BaseDao;

@WebServlet(urlPatterns="/AddpublishServlet_front")
@MultipartConfig
public class AddpublishServlet_front extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			Part part=null;
			//1.获取用户上传图片对应的part对象
			try {
				part = req.getPart("idleimg");
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
				String realPath = req.getServletContext().getRealPath("/idleimg")+"\\"+filename;
				part.write(realPath);
			} catch (Exception e) {
				e.printStackTrace();
			}

	
		
		req.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("name");
		String location = req.getParameter("location");
		String presentation = req.getParameter("presentation");
		String unit = req.getParameter("unit");
		String amount = req.getParameter("amount");
		String original_price = req.getParameter("original_price");
		String transfer_price = req.getParameter("transfer_price");
		
		String sql="INSERT INTO u_idle_info (name,idleimg,location,presentation,unit,amount,original_price,transfer_price,purchasing_date,create_date) VALUES('"+name+"','"+filename+"','"+location+"','"+presentation+"','"+unit+"','"+amount+"','"+original_price+"','"+transfer_price+"',CURRENT_DATE(),CURRENT_DATE())";
		int n = new BaseDao().executeUpdate(sql);
		if(n>0){
			System.out.println("添加成功");
			req.getRequestDispatcher("front/index.jsp").forward(req, resp);
		}else{
			System.out.println("添加失败");
		}
	}
}
