package hh.swd20.nh1900646.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//h2 testidatabase käyttöön
//Merkitään olio database olioksi
@Entity
public class Book {
//Atribuutit
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String title, author,isbn;
	private int year;
	private double price;
	

//Konstruktorit

	public Book() {
		super();
		this.id = 0;
		this.title = null;
		this.author = null;
		this.isbn = null;
		this.year = 0;
		this.price = 0.0;
	}

	public Book(String title, String author, String isbn, int year, double price) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.price = price;
	}
	
//Getterit ja Setterit
	
//toString
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", year=" + year
				+ ", price=" + price + "]";
	}	
}
