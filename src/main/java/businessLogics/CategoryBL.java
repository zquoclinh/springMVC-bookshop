package businessLogics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import models.Category;
import models.DB;

public class CategoryBL {
	private static DriverManagerDataSource dataSource = DB.getDataSource();
	private static JdbcTemplate jdbc = new JdbcTemplate(dataSource);
	public List<Category> getCategory(String sql){
		return jdbc.query(sql, new RowMapper<Category>() {

			@Override
			public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Category(rs.getInt("CategoryId"),rs.getString("CategoryName"), rs.getInt("parentid"));
			}
		});
	}
	
	//get all categories
	public List<Category> getAllCategories(){
		String sql = "select * from category";
		return getCategory(sql);
	}
	
	//get parent category
	public List<Category> getParentsCategory(){
		String sql = "select * from category where parentid is null";
		return getCategory(sql);
	}
	
	//get children category
	public List<Category> getChildrensCategory(){
		String sql = "select * from category where parentid is not null";
		return getCategory(sql);
	}
	
	
	
}
