package cs544.project.onlineshoppingstore.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.validation.Valid;

import org.apache.velocity.app.event.ReferenceInsertionEventHandler.referenceInsertExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.project.onlineshoppingstore.model.Book;
import cs544.project.onlineshoppingstore.model.BookCategory;
import cs544.project.onlineshoppingstore.model.BookType;
import cs544.project.onlineshoppingstore.service.AuthorService;
import cs544.project.onlineshoppingstore.service.BookService;
import cs544.project.onlineshoppingstore.service.PublisherService;

@Controller
public class BookController {

	private BookService bookService;
	private AuthorService authorService;
	private PublisherService publisherService;

	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	@Autowired
	public void setAuthorService(AuthorService authorService) {
		this.authorService = authorService;
	}

	@Autowired
	public void setPublisherService(PublisherService publisherService) {
		this.publisherService = publisherService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true, 10));
	}

	@RequestMapping(value = { "/books", "/book" }, method = RequestMethod.GET)
	public String index(Model model) {

		model.addAttribute("bookList", bookService.getAll());
		return "Book/listBook";
	}

	@RequestMapping(value = "/books/add", method = RequestMethod.GET)
	public String add(Model model) {

		model.addAttribute("book", new Book());
		model.addAttribute("bookTypes", Arrays.asList(BookType.values()));
		model.addAttribute("bookCategories", Arrays.asList(BookCategory.values()));

		return "Book/addBook";
	}

	@RequestMapping(value = "/books/add", method = RequestMethod.POST)
	public String add(@Valid Book book, BindingResult result, Model model) {

		System.out.println(book.getTitle());
		if (result.hasErrors()) {
			model.addAttribute("bookTypes", Arrays.asList(BookType.values()));
			model.addAttribute("bookCategories", Arrays.asList(BookCategory.values()));
			return "Book/addBook";
		}

		bookService.create(book);
		return "redirect:/books";
	}

	@RequestMapping(value = { "/books/update/{id}" }, method = RequestMethod.GET)
	public String update(@PathVariable int id, Model model) {

		model.addAttribute("bookTypes", Arrays.asList(BookType.values()));
		model.addAttribute("bookCategories", Arrays.asList(BookCategory.values()));
		model.addAttribute("book", bookService.get(id));
		return "Book/updateBook";
	}

	@RequestMapping(value = { "/books/update/{id}" }, method = RequestMethod.POST)
	public String update(@PathVariable int id, @Valid Book book, BindingResult result, Model model) {

		if (result.hasErrors()){
		
			model.addAttribute("bookTypes", Arrays.asList(BookType.values()));
			model.addAttribute("bookCategories", Arrays.asList(BookCategory.values()));
			return "redirect:/books/update/" + id;
			
		}

		bookService.update(id, book);
		return "redirect:/books";
	}

	public String delete(@PathVariable int id) {

		bookService.delete(id);
		return "redirect:/books";
	}

}
