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

@WebServlet(urlPatterns="/CheckOriPwd_front")
public class CheckOriPwd_front extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				//������Ӧ����
				resp.setContentType("text/html;charset=utf-8");			
				//�û������ԭʼ����
				String oripwd =req.getParameter("oripwd");
				String u_id = req.getParameter("u_id");
				String sql="SELECT *FROM u_idle_user WHERE u_id='"+u_id+"'";
				Map<String, Object> map = new BaseDao().executeQuery(sql).get(0);

				// ���ݿ��У���ʵ��ԭʼ����
				String password = map.get("u_password") + "";
				
				String msg = "";
				if (oripwd.equals(password)) {				
					msg="ok";
				} else {
					msg="error";
				}
				
				//��Ϊajax�첽�������Ӧ����
				resp.getWriter().write(msg);
	}
}
