package jp.co.aforce.chapter14;
//package chapter14;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
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
// * Servlet implementation class Search
// */
//@WebServlet("/chapter14/search")
//public class Search extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public Search() {
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
//		response.setContentType("text/html; charset=UTF-8");
//		request.setCharacterEncoding("UTF-8");
//
//
//		PrintWriter out=response.getWriter();
//		Page.header(out);
//		try {
//			InitialContext ic = new InitialContext();
//			DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/book");
//			Connection con = ds.getConnection();
//			
//			String keyword = request.getParameter("keyword");
//			
//			PreparedStatement st = con.prepareStatement("select * from product where name like ?");
//			st.setString(1,"%"+keyword+"%");
//			
//			out.println(st);
//			ResultSet rs = st.executeQuery();
//			out.println("<br>");
//			out.println(rs);
//			while(rs.next()) {
//				out.println(rs.getInt("id"));
//				out.println(":");
//				out.println(rs.getString("name"));
//				out.println(":");
//				out.println(rs.getInt("price"));
//				out.println("<br>");
//			}
//			st.close();
//			con.close();
//		}catch(Exception e) {
//			e.printStackTrace(out);
//		}
//		Page.footer(out);
//	}
//
//}
