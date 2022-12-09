package controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import businessLogics.AuthorBL;
import models.Author;

@RestController
public class AuthorRestController {
	@GetMapping(path= "/author-rest")
	public List<Author> getAllAuthor() {
		return AuthorBL.docTatCa();
	}
	
	@GetMapping(path = "author-rest/{id}")
	public ResponseEntity<Author> getAuthor(@PathVariable(name = "id") int id) {
		
		return ResponseEntity.status(HttpStatus.OK).body(AuthorBL.docTheoId(id));
	}
}
