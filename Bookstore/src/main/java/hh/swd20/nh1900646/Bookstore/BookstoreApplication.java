package hh.swd20.nh1900646.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hh.swd20.nh1900646.Bookstore.domain.Book;
import hh.swd20.nh1900646.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);  // uusi loggeriattribuutti

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	//  testidatan luonti H2-testitietokantaan aina sovelluksen käynnistyessä
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository) { 
		return (args) -> {
			log.info("save a couple of books");
			bookRepository.save(new Book("When god was born", "R. Walker", "isbn123", 1989, 49.9));
			bookRepository.save(new Book("When everything ends", "R. Walker", "isbn124", 2021, 34.9));	
			bookRepository.save(new Book("How I will save the universe", "N. H.", "isbn125", 2030, 69.9));
			log.info("fetch all books");
			for (Book book: bookRepository.findAll()) {
				log.info(book.toString());
			}

		};
}
}