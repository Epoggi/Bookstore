package hh.swd20.nh1900646.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.nh1900646.Bookstore.domain.Book;
import hh.swd20.nh1900646.Bookstore.domain.BookRepository;
import hh.swd20.nh1900646.Bookstore.domain.Category;
import hh.swd20.nh1900646.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class); // uusi loggeriattribuutti

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	// testidatan luonti H2-testitietokantaan aina sovelluksen käynnistyessä
	@Bean
	public CommandLineRunner bookDemo(BookRepository bRep, CategoryRepository cRep) {
		return (args) -> {
			log.info("save a couple of categories");
			Category category1 = new Category("Guide");
			cRep.save(category1);
			cRep.save(new Category("Comic"));
			cRep.save(new Category("Adult"));
			cRep.save(new Category("Educational"));

			log.info("fetch all categories");
			for (Category category : cRep.findAll()) {
				log.info(category.toString());
				}
			
			log.info("save a couple of books");
			bRep.save(new Book("When god was born", "R. Walker", "isbn123", 1989, 49.9, cRep.findByName("Comic").get(0)));
			bRep.save(new Book("When everything ends", "R. Walker", "isbn124", 2021, 34.9,cRep.findByName("Comic").get(0)));
			bRep.save(new Book("How I will save the universe", "N. H.", "isbn125", 2030, 69.9,cRep.findByName("Comic").get(0)));
			bRep.save(new Book("Better coding", "T. B.", "ibsn3125", 2020, 59.90, category1));
			
			
			log.info("fetch all books");
			for (Book book : bRep.findAll()) {
				log.info(book.toString());
			}

			
		};
	}
}
