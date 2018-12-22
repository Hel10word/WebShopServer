package web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeleteGood;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String  goodid = request.getParameter("goodid");
		
		System.out.println(goodid);
		DeleteGood deleteGood = new DeleteGood();
		deleteGood.deleteGoodsByGoodId(Integer.parseInt(goodid));
		
		response.sendRedirect("AdminServlet");
	}

}
