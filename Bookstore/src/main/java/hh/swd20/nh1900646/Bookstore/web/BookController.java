package hh.swd20.nh1900646.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class BookController {

	@RequestMapping(value = "/index")
	public String frontPage() {
		return "bookstorefrontpage";
	}
}
