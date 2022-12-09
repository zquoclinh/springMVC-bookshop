package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import models.DB;
import models.Product;

public class ProductBL {
	public final int SO_DONG_TRANG = 12;
	private static DriverManagerDataSource dataSource = DB.getDataSource();
	private static JdbcTemplate jdbc = new JdbcTemplate(dataSource);
	
	//get product
	//get product
		public List<Product> getProduct (String sql){
			return jdbc.query(sql, new RowMapper<Product>() {

				@Override
				public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
					Product p = new Product();
					p.setProductId(rs.getInt("productid"));
					p.setCategoryId(rs.getInt("categoryid"));
					p.setPublisherId(rs.getInt("publisherid"));
					p.setAuthorId(rs.getInt("authorid"));
					p.setIsbn(rs.getString("isbn"));
					p.setTitle(rs.getString("title"));
					p.setPages(rs.getInt("pages"));
					p.setYear(rs.getInt("year"));
					p.setWeight(rs.getString("weight"));
					p.setSize(rs.getString("size"));
					p.setDescription(rs.getString("description"));
					p.setContent(rs.getString("content"));
					p.setImageUrl(rs.getString("imageurl"));
					p.setPrice(rs.getInt("price"));
					return p;
				}			
			});
		}
		
		//get all products
		public List<Product> getAllProducts(){
			String sql="select * from product";
			return getProduct(sql);
		}
			//tong so dong
			public int totalRow() {
				String sql = "select count(*) as totalRow from product";
				return jdbc.queryForObject(sql, new RowMapper<Integer>() {

					@Override
					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
						return rs.getInt("totalRow");
					}
				});
			}
			
			public List<Product> productPage(Integer page){
				int vt = (page-1)*SO_DONG_TRANG;
				String sql = "select * from product limit "+vt+","+SO_DONG_TRANG;
				return getProduct(sql);
			}
			
}
