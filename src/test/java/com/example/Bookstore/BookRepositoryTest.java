package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootTest(classes = BookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

	@Autowired
	private BookRepository brepository;

	@Autowired
	private CategoryRepository crepository;

	@Test
	public void findByTitleShouldReturnAuthor() {
		List<Book> books = brepository.findByTitle("Paasikivi");
		assertThat(books.get(0).getAuthor()).isEqualTo("Alpo Juntunen");
	}

	@Test
	public void createNewBook() {
		Category category = new Category("Educational");
		crepository.save(category);
		Book book = new Book("Tuloksellinen Java-Ohjelmointi", "Jukka Juslin", 2006, 97895, 42, crepository.findByName("Educational").get(0));
		brepository.save(book);
		assertThat(book.getId()).isNotNull();		
	}
	
	@Test
	public void deleteNewBook() {
		List<Book> books = brepository.findByTitle("Paasikivi");
		Book book = books.get(0);
		brepository.delete(book);
		List<Book> newBooks = brepository.findByTitle("Paasikivi");
		assertThat(newBooks).hasSize(0);
	}
}
