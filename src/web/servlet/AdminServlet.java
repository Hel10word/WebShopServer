package web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GoodDao;
import dao.GoodTypeDao;
import domain.Good;
import domain.GoodType;

/**
 * 作者 : 张不凡
 *  
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 加载所有商品类型列表
		GoodTypeDao typeDao = new GoodTypeDao();
		// 调用业务逻辑获得商品类型列表
		List<GoodType> listTypes = typeDao.loadAllGoodTypes();
		//打印商品类型
		for(GoodType item:listTypes)
			System.out.println(item.getId()+"`````"+item.getTypeName());
		
		String  typeid = request.getParameter("typeid");
		
		// 获得商品列表
		GoodDao goodDao = new GoodDao();
		List<Good> goods = null;
		if(typeid == null){
			 goods = goodDao.queryGoods();
		}else{
			goods = goodDao.queryGoodByType(Integer.parseInt(typeid));
		}
		//答应商品信息
		for(Good item:goods)
			System.out.println(item.getId()+"`````"+item.getName());

		System.out.println("所有数据 获取完毕");
		
		
		request.setAttribute("types", listTypes);
		request.setAttribute("goods", goods);


		request.getRequestDispatcher("ShowGoods.jsp").forward(request, response);

	}

}
