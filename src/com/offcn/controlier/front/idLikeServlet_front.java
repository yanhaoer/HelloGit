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

@WebServlet(urlPatterns="/idLikeServlet_front")
public class idLikeServlet_front extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		
		String sql="SELECT id,idleimg,NAME,original_price,amount,transfer_price FROM u_idle_info WHERE fk_idletype LIKE '%"+id+"%';";
		List<Map<String, Object>> list = new BaseDao().executeQuery(sql);
		req.setAttribute("list", list);
		req.getRequestDispatcher("front/like_list.jsp").forward(req, resp);
	}
}
