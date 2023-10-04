package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

import com.example.Bookstore.domain.AppUser;
import com.example.Bookstore.domain.AppUserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CategoryRepository crepository, BookRepository brepository, AppUserRepository urepository) {
		return (args) -> {
			
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Scifi"));
			crepository.save(new Category("Fantasy"));
			
			Book b1 = new Book("Paasikivi", "Alpo Juntunen", 2021, 100001, 79, crepository.findByName("Horror").get(0));
			Book b2 = new Book("Samuli", "Alpo Juntunen", 2021, 100002, 79, crepository.findByName("Horror").get(0));
			brepository.save(b1);
			brepository.save(b2);
			
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			};
	}
}
