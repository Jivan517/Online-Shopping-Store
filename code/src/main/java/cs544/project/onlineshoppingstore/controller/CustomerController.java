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
import cs544.project.onlineshoppingstore.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String index(Model model) {

		List<Customer> customerList = customerService.getAll();
		model.addAttribute("customerList", customerList);

		return "Customer/customerList";
	}
	
	@RequestMapping(value = "/customer/add", method = RequestMethod.GET)
	public String add(Model model) {
		
		model.addAttribute("customer", new Customer());
		return "Customer/addCustomer";
	}

	@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
	public String add(@Valid Customer customer, BindingResult result) {

		System.out.println(result.hasErrors());
		if(result.hasErrors())
			return "Customer/addCustomer";
		
		customerService.create(customer);
		return "redirect:/customer";
	}
	
	@RequestMapping(value = "/customer/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable int id, Model model){
		
		Customer customer = customerService.get(id);
		model.addAttribute("customer", customer);
		
		return "Customer/updateCustomer";
	}
	
	@RequestMapping(value = "/customer/update/{id}", method = RequestMethod.POST)
	public String update(@Valid Customer customer,@PathVariable int id, BindingResult result){
		
		if(result.hasErrors())
			return "redirect:/customer/update/" + id;
		
		customerService.update(id, customer);
		
		return "redirect:/customer";
	}
	
	@RequestMapping(value = "/customer/delete/{id}", method = RequestMethod.POST )
	public String delete(@PathVariable int id){
		
		customerService.delete(id);
		return "redirect:/customer";
	}
}
