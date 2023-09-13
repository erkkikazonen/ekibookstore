package com.example.Bookstore.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int isbn;
	private String title;
	private String author;
	private int publicationYear;
	private double price;
	
	public Book(int isbn, String title, String author, int publicationYear) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
	}
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public class BookCommandLineRunner implements CommandLineRunner {

	    @Autowired
	    private BookRepository bookRepository;

	    @Override
	    public void run(String... args) throws Exception {
	        bookRepository.save(new Book( 0001, "Paasikivi", "Alpo Juntunen", 2021));
	        bookRepository.save(new Book(0002, "Samuli", "Johannes Lahtela", 2021));
	    }
	}
}
