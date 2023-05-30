package jp.co.aforce.userlogin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.Product;
import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class Register
 */
@WebServlet("/jp.co.aforce.userlogin/Register")
public class Register extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		Page.header(out);

		try {
			String user_name = request.getParameter("user_name");
			String password = request.getParameter("password");
			
			ProductDAO dao = new ProductDAO();
//			List<Product> list = dao.search(user_name);
			
			//nameが重複していないかの検査
			
			//登録処理
			Product p = new Product();
			p.setName(user_name);
			p.setPassword(password);
			
			int line = dao.insert(p);

			if (line > 0) {
				request.getRequestDispatcher("../jsp/login.jsp?status=regist_success&login_id="+user_name)
				.forward(request,response);
			}
		}catch(Exception e){
			e.printStackTrace(out);
		}
		Page.footer(out);
	}

}
