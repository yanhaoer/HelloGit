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

@WebServlet(urlPatterns="/barServlet")
public class barServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		String sql="SELECT (SELECT typename FROM u_idletype WHERE id = fk_idletype) AS name ,COUNT(*) AS value FROM u_idle_info GROUP BY fk_idletype";
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		String str=JSONArray.fromObject(list).toString();
		resp.getWriter().write(str);
		
		//模拟查询利用的时间间隔
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
