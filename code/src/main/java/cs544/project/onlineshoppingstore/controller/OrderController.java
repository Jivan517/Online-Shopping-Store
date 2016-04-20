package cs544.project.onlineshoppingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	
	@RequestMapping(value = "/order/orderhistory/{id}", method = RequestMethod.GET)
	public String viewOrderHistory(@PathVariable int id, Model model){
		
		Customer customer = customerService.get(id);
		List<Order> orders = customer.getOrder();
		for(Order o : orders){
			System.out.println(o.getDelivaryDate());
			o.getCustomer().getName();
		}
		model.addAttribute("orders", orders);
	
		return "order/orderHistory";
	}
}