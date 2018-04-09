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

@WebServlet(urlPatterns="/DeleteKeyWords")
public class DeleteKeyWords extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=utf-8");
		
		String id=req.getParameter("id");
		String sql="DELETE FROM u_keywords WHERE id='"+id+"'";
		int n = new BaseDao().executeUpdate(sql);
		if(n>0){
			String sql_Query="SELECT * FROM u_keywords";
			List<Map<String, Object>> list = new BaseDao().executeQuery(sql_Query);
			//��list����ת����json���ݣ���Ҫ����jar����
			String str=JSONArray.fromObject(list).toString();
			resp.getWriter().write(str);
		}
	}
}
