package com.offcn.controlier.front;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.offcn.Dao.*;

@SuppressWarnings("unused")
@WebServlet(urlPatterns = "/PayServlet")
public class PayServlet extends HttpServlet {

	BaseDao dao = new BaseDao();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("֧���ɹ�");

		String order_sql = request.getSession().getAttribute("order_sql") + "";
		dao.executeUpdate(order_sql);
		//request.getSession().setAttribute("order_sql", null);

		String u_idle_id = request.getSession().getAttribute("u_idle_id") + "";
		
		//����������Ϣ��״̬������ѽ��ף�
		//String s = "UPDATE u_idle_info SET transfer_state = '�ѽ���' WHERE id = "+u_idle_id+"";
		//new BaseDao().executeUpdate(s);
		response.sendRedirect(request.getContextPath() + "/front/index.jsp");
	}

}
