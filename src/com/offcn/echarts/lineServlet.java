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

@WebServlet(urlPatterns="/lineServlet")
public class lineServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String sql="SELECT CONCAT(MONTH(u_reg_datetime),'月') AS month ,COUNT(MONTH(u_reg_datetime)) AS count FROM u_idle_user GROUP BY MONTH(u_reg_datetime)";
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		String str=JSONArray.fromObject(list).toString();
		response.getWriter().write(str);
		
		//模拟查询利用的时间间隔
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}	
