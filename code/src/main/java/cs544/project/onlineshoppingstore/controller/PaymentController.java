package cs544.project.onlineshoppingstore.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.engine.spi.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import cs544.project.onlineshoppingstore.model.Book;
import cs544.project.onlineshoppingstore.service.BookService;

@Controller
@SessionAttributes({ "cart" })
public class PaymentController {

	@Autowired
	private BookService bookService;
	
	
	
	@RequestMapping(value = { "/shoppingcart" }, method = RequestMethod.GET)
	public String shoppingCart(Model model) {

		List<Book> books = new ArrayList<>();
		double totalPrice = 0;
		if(model.containsAttribute("cart")){
			List<Integer> ids = (List<Integer>)model.asMap().get("cart");
			for(int id: ids){
				Book book = bookService.get(id);
				books.add(book);
				totalPrice += book.getPrice();
			}
			
			
		}
		model.addAttribute("totalCost", totalPrice);
		model.addAttribute("books", books);
		return "Search/shoppingCart";
	}
	
	@RequestMapping(value = { "/shoppingcart/remove/{id}" }, method = RequestMethod.POST)
	public String removeCartItem(@PathVariable int id, ModelMap model){
		
		if(model.containsAttribute("cart")){
			List<Integer> ids = (List<Integer>)model.get("cart");
			if(ids.contains(id))
				ids.removeAll(Arrays.asList(id));
			
			model.put("cart", ids);
		}
		
		
		return "redirect:/shoppingcart";
	}
	
	
	public String checkout(Model model){
		
		
		return "";
	}
	
	public void clear(SessionStatus session){

		session.setComplete();
	}
}
