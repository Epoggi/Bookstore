package hh.swd20.nh1900646.Bookstore.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
//CrudRepository-rajapinnan parametrisoinnissa annetaan Entity-luokan nimi: Book
	// ja toisena parametrina pääavainsarakkeen luokkatietotyyppi, Long
List <Book> findByTitle(String title);
List <Book> findByAuthor(String author);
	// BookRepository periytyy (extends) CrudRepositorystä ja perii mm.
	// metodiesittelyt
	// findAll(), findById(), save(), deleteById()

}
