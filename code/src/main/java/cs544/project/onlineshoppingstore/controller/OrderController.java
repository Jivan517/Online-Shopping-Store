package cs544.project.onlineshoppingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.project.onlineshoppingstore.model.Customer;
import cs544.project.onlineshoppingstore.model.Order;
import cs544.project.onlineshoppingstore.service.CustomerService;
import cs544.project.onlineshoppingstore.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;

	
	@RequestMapping(value = "/order/orderhistory", method = RequestMethod.GET)
	public String viewOrderHistory( Model model){
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		long id = customerService.findByUsername(username).getId();
		
		Customer customer = customerService.get(id);
		List<Order> orders = customer.getOrder();
	    System.out.println("Number of orders " + orders.size());
		model.addAttribute("orders", orders);
	
		return "order/orderHistory";
	}
}