package models;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DB {
private static DriverManagerDataSource dataSource;
	
	public static DriverManagerDataSource getDataSource() {
		
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mini_shop?useUnicode=true&characterEncoding=UTF-8");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}	
	
//	private static JdbcTemplate jdbc;
//	
//	public static JdbcTemplate getConnect() {
//		
//			DriverManagerDataSource ds = new DriverManagerDataSource();
//			ds.setDriverClassName("com.mysql.jdbc.Driver");
//			ds.setUrl("jdbc:mysql://localhost:3306/mini_shop?useUnicode=true&characterEncoding=UTF-8");
//			ds.setUsername("root");
//			ds.setPassword("");
//			
//			jdbc = new JdbcTemplate(ds);
//			return jdbc;
//	}	
//	
//	public static void main(String[] args) {
//		
//		JdbcTemplate jd = getConnect();
//		
//		if(jd==null) {
//			System.out.println("bi loi");
//		} else {
//			System.out.println("thanh cong");
//		}
//	}
}
