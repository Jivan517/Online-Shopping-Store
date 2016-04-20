package cs544.project.onlineshoppingstore.service.aop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

import cs544.project.onlineshoppingstore.model.Customer;
import cs544.project.onlineshoppingstore.model.Order;
import cs544.project.onlineshoppingstore.model.OrderStatus;
import cs544.project.onlineshoppingstore.model.Orderline;
import cs544.project.onlineshoppingstore.service.BookService;
import cs544.project.onlineshoppingstore.service.CustomerService;
import cs544.project.onlineshoppingstore.service.OrderService;

@Aspect
public class TraceAdviceController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired 
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;
	
	@Before("execution(* cs544.project.onlineshoppingstore.controller.PaymentController.checkout(..)) && args(model,bookIds,quantities)")
	public void setOrders(JoinPoint joinPoint, Model model, List<Integer> bookIds, List<Integer> quantities){
	
		System.out.println("Executing order processing in background");
		
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		String username = authentication.getName();
//		Customer customer = customerService.findByUsername(username);
//		
//		Order order = new Order();
//		List<Orderline> orderLine = new ArrayList<Orderline>();
//		double total_amt = 0;
//		int total_qty = 0;
//		
//		
//		
//		int size = bookIds.size();
//		for(int i = 0; i < size; i++){
//			Orderline ol = new Orderline();
//			ol.setBook(bookService.get(bookIds.get(i)));
//			ol.setQuantity(quantities.get(i));			
//			orderLine.add(ol);
//			total_qty += quantities.get(i);
//			total_amt += (bookService.get(bookIds.get(i))).getPrice();
//		}
//		
//		order.setCustomer(customer);
//		order.setOrderDate(new Date());
//		order.setDelivaryDate(new Date());
//		order.setOrderlines(orderLine);		
//		order.setTotal(total_amt);
//		order.setTotalQuantity(total_qty);
//		order.setOrderStatus(OrderStatus.DELIVERED);		
//		orderService.create(order);
		System.out.println("DOne with executing and processing orders");
	}

}
