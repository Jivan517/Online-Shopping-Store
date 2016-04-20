package cs544.project.onlineshoppingstore.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import cs544.project.onlineshoppingstore.model.Book;
import cs544.project.onlineshoppingstore.model.Customer;
import cs544.project.onlineshoppingstore.model.Order;
import cs544.project.onlineshoppingstore.model.OrderStatus;
import cs544.project.onlineshoppingstore.model.Orderline;
import cs544.project.onlineshoppingstore.model.ShippingType;
import cs544.project.onlineshoppingstore.service.BookService;
import cs544.project.onlineshoppingstore.service.CustomerService;
import cs544.project.onlineshoppingstore.service.OrderService;

@Controller
@SessionAttributes({ "cart" })
public class PaymentController {

	@Autowired
	private BookService bookService;
	
	@Autowired 
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;
	
	
	
	
	
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
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		System.out.println(username);
		Customer customer = customerService.findByUsername(username);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 7); // Adding 7 days
		
		model.addAttribute("totalCost", totalPrice);
		model.addAttribute("books", books);
		model.addAttribute("shippingAddress", customer.getShipingAddress());
		model.addAttribute("shippingType", ShippingType.USPS);
		model.addAttribute("deliveryDate", sdf.format(c.getTime()));
		
		return "Search/shoppingCart";
	}
	
	@RequestMapping(value={"/checkout"}, method = RequestMethod.POST)
	public String checkout(Model model, @RequestParam List<Integer> bookIds, @RequestParam List<Integer> quantities){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		Customer customer = customerService.findByUsername(username);
		
		Order order = new Order();
		List<Orderline> orderLine = new ArrayList<Orderline>();
		double total_amt = 0;
		int total_qty = 0;
		
		
		
		int size = bookIds.size();
		for(int i = 0; i < size; i++){
			Orderline ol = new Orderline();
			ol.setBook(bookService.get(bookIds.get(i)));
			ol.setQuantity(quantities.get(i));			
			orderLine.add(ol);
			total_qty += quantities.get(i);
			total_amt += (bookService.get(bookIds.get(i))).getPrice();
		}
		
		order.setCustomer(customer);
		order.setOrderDate(new Date());
		order.setDelivaryDate(new Date());
		order.setOrderlines(orderLine);		
		order.setTotal(total_amt);
		order.setTotalQuantity(total_qty);
		order.setOrderStatus(OrderStatus.DELIVERED);		
		orderService.create(order);
		//System.out.println(bookIds);
		//System.out.println(quantities);
		
		return "redirect:/shoppingcart";
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
	
	/*@RequestMapping(value={"/shoppingcart/checkout/"},method = RequestMethod.GET)
	public String getCheckout(Model model){
		//System.out.println("Total ordered quantity " + order.getTotalQuantity());
		Order o = new Order();
		model.addAttribute("order",o);
		//orderService.create(order);
		return "Search/shoppingCart";
	}*/
	
//	@RequestMapping(value={"/shoppingcart/checkout/"},method = RequestMethod.POST)
//	public String checkout(@Valid Order order){
//		System.out.println("Total ordered quantity " + order.getTotalQuantity());
//		orderService.create(order);
//		return "";
//	}
//	
	public void clear(SessionStatus session){

		session.setComplete();
	}
}
