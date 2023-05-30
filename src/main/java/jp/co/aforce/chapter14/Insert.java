package jp.co.aforce.chapter14;
//package chapter14;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//
//import javax.naming.InitialContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.sql.DataSource;
//
//import tool.Page;
//
///**
// * Servlet implementation class Insert
// */
//@WebServlet("/chapter14/insert")
//public class Insert extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public Insert() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		response.setContentType("text/html; charset=UTF-8");
//		request.setCharacterEncoding("UTF-8");
//
//		PrintWriter out = response.getWriter();
//		Page.header(out);
//		try {
//			InitialContext ic = new InitialContext();
//			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
//			Connection con = ds.getConnection();
//
//			String name = request.getParameter("name");
//			int price = Integer.parseInt(request.getParameter("price"));
//
//			PreparedStatement st = con.prepareStatement(
//					"insert into product values(null,?,?)");
//			st.setString(1, name);
//			st.setInt(2, price);
//			int line = st.executeUpdate();
//
//			if (line > 0) {
//				out.println("追加に成功しました");
//			}
//
//			st.close();
//			con.close();
//		} catch (Exception e) {
//			e.printStackTrace(out);
//		}
//		Page.footer(out);
//
//	}
//
//}
