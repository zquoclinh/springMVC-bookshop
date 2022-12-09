package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import businessLogics.AuthorBL;
import models.Author;

@Controller
@RequestMapping("/authors")
public class AuthorController {

	@RequestMapping(path="")
	public String authors(Model model) {
		model.addAttribute("authors", AuthorBL.docTatCa());
		return "authors";
	}
	
//add author
	@RequestMapping(path="/add-author", method = RequestMethod.GET)
	public String addAuthor() {
		return "add-author";
	}
	
	@RequestMapping(path="/add-author", method = RequestMethod.POST)
	public String addAuthor(HttpServletRequest req, Model model) {
		String name = req.getParameter("authorName");
		System.out.println(name);
		Author au = new Author();
		au.setId(0);
		au.setName(name);
		AuthorBL.addAuthor(au);
		return "redirect:/authors";
	}
	
//delete author
	@RequestMapping(path="/delete-author")
	public String deleteAuthor(HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		AuthorBL.deleteAuthor(id);
		return "redirect:/authors";
	}
	
//update author
	@RequestMapping(path="/edit-author")
	public String updateAuthor(Model model, HttpServletRequest req) {
		int id = Integer.parseInt(req.getParameter("id"));
		Author au = AuthorBL.docTheoId(id);
		model.addAttribute("author",au);
		
		return "edit-author";
	}
	
	@RequestMapping(path="/edit-author", method = RequestMethod.POST)
	public String updateAuthor(HttpServletRequest req) {
		String name = req.getParameter("authorName");
		int id = Integer.parseInt(req.getParameter("authorId"));
		Author au = new Author();
		
		au.setName(name);
		au.setId(id);
		
		AuthorBL.updateAuthor(au);
		
		return "redirect:/authors";
	}
}
