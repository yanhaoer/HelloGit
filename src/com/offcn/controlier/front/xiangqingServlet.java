package com.offcn.controlier.front;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.Dao.BaseDao;

@WebServlet(urlPatterns="/xiangqingServlet")
public class xiangqingServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id= req.getParameter("id");
		String sql="SELECT * FROM u_idle_info WHERE id='"+id+"'";
		Map<String, Object> map = new BaseDao().executeQuery(sql).get(0);
		req.setAttribute("map",map);
		req.getRequestDispatcher("front/xiangqing.jsp").forward(req, resp);
	}
}
