package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import models.Author;
import models.DB;

public class AuthorBL {
	private static DriverManagerDataSource dataSource = DB.getDataSource();
	private static JdbcTemplate jdbc = new JdbcTemplate(dataSource);
//	private static JdbcTemplate jdbc = DB.getConnect();
	public static List<Author> docTatCa(){
		String sql ="select * from author";
		
		return jdbc.query(sql, new RowMapper<Author>() {

			@Override
			public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
				Author au = new Author();
				au.setId(rs.getInt("AuthorId"));
				au.setName(rs.getString("AuthorName"));
				return au;
			}
		});
	}
	
	public static Author docTheoId(int id) {
		String sql ="select * from author where authorid = ?";
		
		return jdbc.queryForObject(sql, new RowMapper<Author>() {

			@Override
			public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
				Author au = new Author();
				au.setId(rs.getInt("AuthorId"));
				au.setName(rs.getString("AuthorName"));
				return au;
			}
			
		}, id);
	}
	
	public static int addAuthor(Author au) {
		String sql ="insert into author(authorname) values (?)";
		return jdbc.update(sql, au.getName());
	}
	
	public static int updateAuthor(Author au) {
		String sql="update author set authorname=? where authorid = ?";
		
		return jdbc.update(sql, au.getName(), au.getId());
	}
	
	public static int deleteAuthor(int id) {
		String sql ="delete from author where authorid =?";
		return jdbc.update(sql, id);
	}
	
	//addAuthor dùng transaction
//	public static int addAuthor2() {
//		String sql ="insert into author(authorname) values (?)";
//		
//		int smt =0;
//		
//		DefaultTransactionDefinition td = new DefaultTransactionDefinition();
//		JdbcTransactionManager tm = new JdbcTransactionManager(dataSource);
//		TransactionStatus ts = tm.getTransaction(td);
//		try {
//			smt += jdbc.update(null)
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	
	public static void main(String[] args) {
//		List<Author> ds = docTatCa();
//		for(Author a: ds) {
//			System.out.println(a.getName());
//		}
//		
//		Author au = docTheoId(1);
//		System.out.println(au.getName());
		
//		Author au = new Author();
//		au.setId(0);
//		au.setName("test add author");
//		addAuthor(au);
		
		
//		Author au = docTheoId(27);
//		au.setName("test");
//		updateAuthor(au);

		deleteAuthor(27);
	}
}
