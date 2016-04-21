package cs544.project.onlineshoppingstore.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.velocity.app.event.ReferenceInsertionEventHandler.referenceInsertExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		model.addAttribute("authors", authorService.getAll());
		model.addAttribute("publishers", publisherService.getAll());
		

		return "Book/addBook";
	}

	@RequestMapping(value = "/books/add", method = RequestMethod.POST)
	public String add(@Valid Book book, BindingResult result, Model model) {

		System.out.println("has error? " + result.hasErrors());
		if (result.hasErrors()) {
			model.addAttribute("bookTypes", Arrays.asList(BookType.values()));
			model.addAttribute("bookCategories", Arrays.asList(BookCategory.values()));
			model.addAttribute("authors", authorService.getAll());
			model.addAttribute("publishers", publisherService.getAll());
			return "Book/addBook";
		}

		bookService.create(book);
		return "redirect:/books";
	}

	@RequestMapping(value = { "/books/update/{id}" }, method = RequestMethod.GET)
	public String update(@PathVariable long id, Model model) {

		Book book = bookService.get(id);
		model.addAttribute("bookTypes", Arrays.asList(BookType.values()));
		model.addAttribute("bookCategories", Arrays.asList(BookCategory.values()));
		model.addAttribute("book", book);
		model.addAttribute("authors", authorService.getAll());
		model.addAttribute("publishers", publisherService.getAll());
		return "Book/updateBook";
	}

	@RequestMapping(value = { "/books/update/{id}" }, method = RequestMethod.POST)
	public String update(@PathVariable int id, @Valid Book book, BindingResult result, Model model) {

		if (result.hasErrors()){
		
			model.addAttribute("bookTypes", Arrays.asList(BookType.values()));
			model.addAttribute("bookCategories", Arrays.asList(BookCategory.values()));
			model.addAttribute("authors", authorService.getAll());
			model.addAttribute("publishers", publisherService.getAll());
			return "redirect:/books/update/" + id;
			
		}

		bookService.update(id, book);
		return "redirect:/books";
	}

	@RequestMapping(value = "/books/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable int id) {

		bookService.delete(id);
		return "redirect:/books";
	}

	@RequestMapping(value = { "/books/category/{categoryName}" }, method = RequestMethod.GET)
	public String childrenCatagory(@PathVariable String categoryName, Model model) {
		
		List<Book> books = bookService.findBybookCategory(BookCategory.valueOf(categoryName.toUpperCase()));
	
		model.addAttribute("category",StringUtils.capitalize(categoryName));
		model.addAttribute("books", books);
		return "Search/catogoryBook";

	}
	
	
	//REST API
	
	@ExceptionHandler(IllegalArgumentException.class)
	@RequestMapping(value = {"/api/books/{id}"}, method = RequestMethod.GET)
	public @ResponseBody Book getBook(@PathVariable long id){
	
		try {
			return bookService.get(id);
		} catch (Exception e) {
			throw new IllegalArgumentException("Illegal Argument");
		}
	}
	
	@RequestMapping(value = {"/api/books"}, method = RequestMethod.GET)
	public @ResponseBody List<Book> getAllBooks(){
		
		return bookService.getAll();
	}
	
	
}
