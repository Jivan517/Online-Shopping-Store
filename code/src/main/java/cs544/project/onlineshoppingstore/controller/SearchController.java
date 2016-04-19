package cs544.project.onlineshoppingstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import cs544.project.onlineshoppingstore.model.Book;
import cs544.project.onlineshoppingstore.service.AuthorService;
import cs544.project.onlineshoppingstore.service.BookService;

@Controller
@SessionAttributes({ "cart" })
public class SearchController {

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	@RequestMapping(value = { "/search" }, method = RequestMethod.GET)
	public String index(@RequestParam("q") String query, Model model) {

		List<Book> books = bookService.findByFullTextSearch(query);
		model.addAttribute("books", books);
		if (books.size() > 0) {
			System.out.println(books.get(0).getUrl());
		}

		model.addAttribute("totalCount", books.size());
		return "Search/browseBook";
	}

	@RequestMapping(value = { "/details" }, method = RequestMethod.GET)
	public String bookDetails(@RequestParam("i") long id, Model model) {

		Book book = bookService.get(id);
		model.addAttribute("book", book);

		return "Search/detailsBook";
	}

	@RequestMapping(value = {
			"/addToCart/{id}" }, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String addToCart(@PathVariable int id, ModelMap model) {

		if(!model.containsAttribute("cart")){
			model.addAttribute("cart", new ArrayList<Integer>());
		}
		
		List<Integer> cart = (List<Integer>) model.get("cart");
		if(!cart.contains(id))
			cart.add(id);
		
		model.put("cart",cart);
		
		System.out.println(id);
		return "";
	}

	

}
