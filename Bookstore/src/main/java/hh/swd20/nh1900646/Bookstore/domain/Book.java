package hh.swd20.nh1900646.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

//h2 testidatabase käyttöön
//Merkitään olio database olioksi
@Entity
public class Book {
//Atribuutit
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title, author, isbn;
	private int year;
	private double price;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryid")
	private Category category;

//Konstruktorit

	public Book() {
		super();
		this.title = null;
		this.author = null;
		this.isbn = null;
		this.year = 0;
		this.price = 0.0;
	}

	public Book(String title, String author, String isbn, int year, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
		this.price = price;
		this.category = category;
	}

//Getterit ja Setterit

	public long getId() {
		return id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", year=" + year
				+ ", price=" + price + ", category=" + category + "]";
	}

}
