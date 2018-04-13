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

@WebServlet(urlPatterns="/sellServlet")
public class sellServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String u_nickname=req.getParameter("u_nickname");
		String sql="SELECT * FROM u_idle_info WHERE fk_fisher=(SELECT u_id FROM u_idle_user WHERE u_nickname='"+u_nickname+"')";
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		req.setAttribute("list", list);
		req.getRequestDispatcher("front/like_list.jsp").forward(req, resp);
	}
}
