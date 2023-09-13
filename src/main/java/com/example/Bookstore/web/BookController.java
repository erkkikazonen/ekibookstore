package com.example.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;


@Controller
public class BookController {

	@Autowired
	private BookRepository repository;

	@GetMapping("/booklist")
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	@PostMapping("/addbook")
	 public String addbook(Book book) {
	  repository.save(book);
	  return "redirect:/booklist";
	 }
	@DeleteMapping("/deletebook/{isbn}")
	 public String deletebook(@PathVariable int isbn) {
	  repository.deleteById(isbn);
	  return "redirect:/booklist";
	 }
}
