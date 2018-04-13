package com.offcn.echarts;

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

@WebServlet(urlPatterns="/PieServlet")
public class PieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		//切记：AS 后面名字一定要跟随js包数据规范命名。 name value
		String sql="SELECT * FROM(SELECT u_province AS name,COUNT(u_province) AS value FROM u_idle_user GROUP BY u_province) tt";
		//String sql ="SELECT * FROM(SELECT u_province AS sads,COUNT(u_province) AS userount FROM u_idle_user GROUP BY u_province) tt";
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		String str = JSONArray.fromObject(list).toString();
		resp.getWriter().write(str);
	}
}
