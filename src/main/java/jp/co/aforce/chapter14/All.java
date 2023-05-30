package jp.co.aforce.chapter14;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import jp.co.aforce.tool.Page;

/**
 * Servlet implementation class All
 */
@WebServlet(urlPatterns = { "/chapter14/all" })
public class All extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		Page.header(out);
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/login_db");
			Connection con = ds.getConnection();
			
			PreparedStatement st = con.prepareStatement("select * from login");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				out.println(rs.getInt("id"));
				out.println(":");
				out.println(rs.getString("name"));
				out.println(":");
				out.println(rs.getString("password"));
				out.println("<br>");
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
