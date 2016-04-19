package cs544.project.onlineshoppingstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

	
	@RequestMapping(value = "/orderHistory/{id}", method = RequestMethod.GET)
	public String update(@PathVariable int id, Model model){
		
		Customer customer = customerService.get(id);
		List<Order> order = customer.getOrder();
		model.addAttribute("order", order);
		
		return "customer/orderHistory";
	}
}