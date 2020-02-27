package hh.swd20.nh1900646.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import hh.swd20.nh1900646.Bookstore.domain.Book;
import hh.swd20.nh1900646.Bookstore.domain.BookRepository;

@Controller

public class BookController {
	

	@RequestMapping(value = "/index")
	public String frontPage() {
		return "bookstorefrontpage";
	}
@Autowired
BookRepository bookRepository;
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getAllBooks(Model model) {
		// haetaan tietokannasta kirjat listaan
		List<Book> books =(List<Book>) bookRepository.findAll();
		// laitetaan model-mappin kirjalista templatea varten
		// palautetaan sopivan käyttöliittymätemplaten nimi
		model.addAttribute("books", books);
		return "booklist";

	}

}
