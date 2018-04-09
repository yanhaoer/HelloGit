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

import net.sf.json.JSONArray;

@WebServlet(urlPatterns="/AddKeyWords")
public class AddKeyWords extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String keywords=req.getParameter("keywords");
		String sql="INSERT INTO u_keywords(keywords,createtime) VALUES('"+keywords+"',NOW())";
		
		int n = new BaseDao().executeUpdate(sql);
		
		if(n>0){
			String sql_Query="SELECT * FROM u_keywords";
			List<Map<String, Object>> list = new BaseDao().executeQuery(sql_Query);
			//将list数据转换成json数据（需要引用jar包）
			String str=JSONArray.fromObject(list).toString();
			resp.getWriter().write(str);
		}
	}
}
