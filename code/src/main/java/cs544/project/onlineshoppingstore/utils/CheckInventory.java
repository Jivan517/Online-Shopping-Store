package cs544.project.onlineshoppingstore.utils;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cs544.project.onlineshoppingstore.model.Customer;
import cs544.project.onlineshoppingstore.model.Order;
import cs544.project.onlineshoppingstore.model.OrderStatus;
import cs544.project.onlineshoppingstore.service.CustomerService;
import cs544.project.onlineshoppingstore.service.OrderService;
import cs544.project.onlineshoppingstore.service.ScheduledTaskService;


 
@Component
@Configuration
@EnableScheduling
public class CheckInventory {
 
    @Autowired
	private OrderService orderService;
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private ScheduledTaskService scheduledTaskService;
    
	CheckInventory() {
		System.out.println("timer initialized ********** ");
		//updateEmployeeInventory();
	}
	//@Scheduled(fixedRate=1000)
	@Scheduled(cron="0/50 * * * * *")
    public void checkInventoryForNewOrders(){
        
		System.out.println("checking new orders");
		List<Order> newOrders = orderService.findByOrderStatus(OrderStatus.NEW);
		for(Order order : newOrders){
			Customer customer = order.getCustomer();
			String email = customer.getEmail();
			System.out.println("Sending email confirmation to customer " + email);
			order.setOrderStatus(OrderStatus.HOLD);
			orderService.update(order.getId(),order);
			scheduledTaskService.sendEmail("write2miki@gmail.com");
			
		}		
		
    }
}
