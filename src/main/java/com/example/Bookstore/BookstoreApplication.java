package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b1 = new Book("Paasikivi", "Alpo Juntunen", 2021, 100001, 79);
			Book b2 = new Book("Samuli", "Alpo Juntunen", 2021, 100002, 79);
			repository.save(b1);
			repository.save(b2);
		};
	}
}
