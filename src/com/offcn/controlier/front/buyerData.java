package com.offcn.controlier.front;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.Dao.BaseDao;

import net.sf.json.JSONArray;
@WebServlet(urlPatterns="/buyerData")
public class buyerData extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid=req.getParameter("uid");
		//等待发货的数量
		String sql_dengdaifahuo="SELECT COUNT(1) AS 'dengdaifahuo' FROM u_idle_orders WHERE purchaser_id="+uid+" AND order_state='未发货'";
		//购买记录的数量
		String sql_goumaijilu="SELECT COUNT(1) AS 'goumaijilu' FROM u_idle_orders WHERE purchaser_id="+uid+" AND order_state='已签收'";
		
		BaseDao dao = new BaseDao();
		List<Map<String, Object>> list_dengdaifahuo = dao.executeQuery(sql_dengdaifahuo);
		List<Map<String, Object>> list_goumaijilu = dao.executeQuery(sql_goumaijilu);
		
		String dengdaifahuo=list_dengdaifahuo.get(0).get("dengdaifahuo")+"";
		String goumaijilu = list_goumaijilu.get(0).get("goumaijilu")+"";
		
		Map<String, String> buyerMap = new HashMap<String, String>();
		buyerMap.put("dengdaifahuo", dengdaifahuo);
		buyerMap.put("goumaijilu", goumaijilu);
		
		String str=JSONArray.fromObject(buyerMap).toString();
		resp.getWriter().write(str);
	}
}
