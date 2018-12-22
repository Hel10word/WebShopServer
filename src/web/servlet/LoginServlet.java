package web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GoodDao;
import dao.GoodTypeDao;
import dao.UserinfoDao;
import domain.Good;
import domain.GoodType;

/**
 * 作者 : 张不凡
 *  
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		// 获得提交的用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserinfoDao userDao =new UserinfoDao();
		
		if(password.equals(userDao.queryPassWordByUserName(username))) {
			System.out.println("密码输入正确!");
			
			//设置用户名 session 对象
			HttpSession session = request.getSession();
			session.setAttribute("username",username);
			
			//调用 AdminServlet 类 讲请求消息 发往 ShowGoods 页面
//			AdminServlet adminServlet = new AdminServlet();
//			adminServlet.doGet(request, response);
			
			response.sendRedirect("AdminServlet");
		}else {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	
		
		//request.getRequestDispatcher("ShowGoods.jsp").forward(request, response);

	}

}
