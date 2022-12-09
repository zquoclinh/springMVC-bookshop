package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import businessLogics.CategoryBL;
import businessLogics.ProductBL;
import models.Category;

@Controller
@RequestMapping(path="/category")
public class CategoryController {
	
	@Autowired
	private CategoryBL category;
	
	@Autowired
	private ProductBL product;
	
	//get category
		@RequestMapping(path = "", method = RequestMethod.GET)
		public String getCategory(@RequestParam(name="page", required = false) String page, Model model) {
			int currentPage = 1;
			int totalRow = product.totalRow();
			int totalPage = totalRow/product.SO_DONG_TRANG + (totalRow%product.SO_DONG_TRANG!=0?1:0);
			if(page!=null) {
				currentPage=Integer.parseInt(page);
			}
			model.addAttribute("previousPage", currentPage>1?currentPage-1:currentPage);
			model.addAttribute("childrens", category.getChildrensCategory());
			model.addAttribute("parents", category.getParentsCategory());
			model.addAttribute("products", product.productPage(currentPage));
			model.addAttribute("nextPage", currentPage<totalPage?currentPage+1:currentPage);
			model.addAttribute("totalPage", totalPage);
		
			return "category/index";
			
		}
	
	//add-category
	@RequestMapping(path="/add-category", method = RequestMethod.GET)
	public String addcategory(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("parents", category.getParentsCategory());
		return "add-category";
	}
	
//	@RequestMapping(path="/add-category", method = RequestMethod.POST)
//	public String addcategory(Category c) {
//		category.addCategory(c);
//		return "redirect:/category";
//	}
}
