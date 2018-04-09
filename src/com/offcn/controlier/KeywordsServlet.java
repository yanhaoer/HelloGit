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

@WebServlet(urlPatterns="/KeywordsServlet")
public class KeywordsServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=utf-8");
		
		String sql="SELECT * FROM u_keywords";
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		//将list数据转换成json数据（需要引用jar包）
		String str=JSONArray.fromObject(list).toString();
		resp.getWriter().write(str);
	}
}
