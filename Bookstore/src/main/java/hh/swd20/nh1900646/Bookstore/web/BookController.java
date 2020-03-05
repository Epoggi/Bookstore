package hh.swd20.nh1900646.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.nh1900646.Bookstore.domain.Book;
import hh.swd20.nh1900646.Bookstore.domain.BookRepository;
import hh.swd20.nh1900646.Bookstore.domain.Category;
import hh.swd20.nh1900646.Bookstore.domain.CategoryRepository;

@Controller

public class BookController {
	

	@RequestMapping(value = "/index")
	public String frontPage() {
		return "bookstorefrontpage";
	}

@Autowired
BookRepository bookRepository;
@Autowired
CategoryRepository categoryRepository;

//Kirjojen listaus
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getAllBooks(Model model) {
		// haetaan tietokannasta kirjat listaan
		List<Book> books =(List<Book>) bookRepository.findAll();
		// laitetaan model-mappin kirjalista templatea varten
		// palautetaan sopivan käyttöliittymätemplaten nimi
		model.addAttribute("books", books);
		return "booklist";
	}
	//Categorioiden listaus
	@RequestMapping(value="/categories", method = RequestMethod.GET)
	public String getCategories (Model model) {
		List<Category> categories =(List<Category>) categoryRepository.findAll();
		model.addAttribute("categories", categories);
		return "categorylist";
	}
	//Categorian lisäys
	@RequestMapping(value="/addcategory", method = RequestMethod.POST)
	public String addCategory(@ModelAttribute Category category) {
		categoryRepository.save(category);
		return "categorylist";
	}
	// tyhjän lomakkeen muodostaminen
	@RequestMapping(value= "/newbook", method = RequestMethod.GET)
	public String getNewBookForm (Model model) {
		model.addAttribute("book",new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "bookform";
	}
	//syötettyjen tietojen vastaanotto
	@RequestMapping(value= "/newbook", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book) {
	bookRepository.save(book);
	return "redirect:/books";
	}
	// poisto
	@RequestMapping(value= "/deletebook/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:../books";
	}
	// Edit!
	@RequestMapping(value="/newbook/{id}", method = RequestMethod.GET)
	public String getBooktoEdit(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));

		model.addAttribute("categories", categoryRepository.findAll());
		return "bookform";
	}

}
