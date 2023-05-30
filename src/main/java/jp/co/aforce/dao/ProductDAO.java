package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.bean.Product;

public class ProductDAO extends DAO {

	//ログイン時に使用
	public List<Product> search(String keyword) throws Exception {
		List<Product> list = new ArrayList<>();

		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"select * from login where name = ?");
		st.setString(1, keyword);
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Product p = new Product();

			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPassword(rs.getString("password"));
			list.add(p);
		}
		st.close();
		con.close();

		return list;

	}

	//会員登録時に使用
	public int insert(Product product) throws Exception {
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"insert into login values(null, ? ,?)");
		st.setString(1, product.getName());
		st.setString(2, product.getPassword());
		int line = st.executeUpdate();

		st.close();
		con.close();

		return line;
	}
}
