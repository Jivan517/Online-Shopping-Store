package cs544.project.onlineshoppingstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import cs544.project.onlineshoppingstore.model.Publisher;
import cs544.project.onlineshoppingstore.service.PublisherService;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
	@Autowired
	private PublisherService publisherService;
	
	@RequestMapping(value = {"/","/list","/publishers","/all"})
	public String list(Model model){
		
		model.addAttribute("publisherList", publisherService.getAll());
		return "Publisher/listPublisher";
		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model){
		
		Publisher publisher = new Publisher();
		model.addAttribute("publisher", publisher);
		
		return "Publisher/addPublisher";		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid Publisher publisher, BindingResult result){
		
		if(result.hasErrors())
			return "redirect:/publisher/add";
		
		publisherService.create(publisher);		
		return "redirect:/publisher";		
	}
	
	@RequestMapping(value= "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable long id,Model model){
		Publisher publisher = publisherService.get(id);
		model.addAttribute(publisher);
		return "Publisher/updatePublisher";
		
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public String update(@Valid Publisher publisher, @PathVariable long id, BindingResult result){
		if(result.hasErrors())
			return "redirect:/publisher/update" + id;
		
		publisherService.update(id, publisher);
		return "redirect:/publisher/update";  // when redirect we are returning url, not a view
	}
	
	@RequestMapping(value = "/delete/{id}, method = Request.POST")
	public String delete(@PathVariable long id){
		
		publisherService.delete(id);
		return "redirect:/publisher";	
		
	}
	
	

}