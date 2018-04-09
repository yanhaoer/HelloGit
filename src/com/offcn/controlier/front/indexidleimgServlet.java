package com.offcn.controlier.front;

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

@WebServlet(urlPatterns="/indexidleimgServlet")
public class indexidleimgServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		String sql="SELECT * FROM u_idle_info";
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		String str=JSONArray.fromObject(list).toString();
		resp.getWriter().write(str);
	}
}
