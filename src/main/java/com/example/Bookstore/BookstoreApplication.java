package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CategoryRepository crepository, BookRepository brepository) {
		return (args) -> {
			
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Scifi"));
			crepository.save(new Category("Fantasy"));
			
			Book b1 = new Book("Paasikivi", "Alpo Juntunen", 2021, 100001, 79, crepository.findByName("Horror").get(0));
			Book b2 = new Book("Samuli", "Alpo Juntunen", 2021, 100002, 79, crepository.findByName("Horror").get(0));
			brepository.save(b1);
			brepository.save(b2);
			};
	}
}
