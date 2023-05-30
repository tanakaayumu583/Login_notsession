package jp.co.aforce.userlogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.bean.Product;
import jp.co.aforce.dao.ProductDAO;
import jp.co.aforce.tool.Page;

@WebServlet("/jp.co.aforce.userlogin/Login")
public class Login extends HttpServlet {

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
			List<Product> list = dao.search(user_name);

			for(Product p : list) {
				if(p.getPassword().equals(password)) {
					out.println("ログイン成功");
					
					Product pd = new Product();
					pd.setName(user_name);
					
					request.setAttribute("product", pd);
					
					request.getRequestDispatcher("../jsp/mymenu.jsp")
					.forward(request,response);
					
//					response.sendRedirect("../jsp/mymenu.jsp");
				}else {
					out.println("ログイン失敗");
					request.getRequestDispatcher("../jsp/login.jsp?status=fail&login_id="+user_name)
					.forward(request,response);
				}
			}

			
		}catch(Exception e){
			e.printStackTrace(out);
		}
		Page.footer(out);
	}

}
