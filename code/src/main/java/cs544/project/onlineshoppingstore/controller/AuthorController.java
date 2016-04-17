package cs544.project.onlineshoppingstore.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.project.onlineshoppingstore.model.Author;
import cs544.project.onlineshoppingstore.service.AuthorService;

@Controller
@RequestMapping("/author")
public class AuthorController {
	
	
	private AuthorService authorService;
	
	@Autowired
	public void setAuthorService(AuthorService authorService){
		this.authorService = authorService;
	}
	
	@RequestMapping(value = {"/","/list","/auhtors","/all"})
	public String list(Model model){
		
		model.addAttribute("authorList", authorService.getAll());
		return "Author/listAuthor";
		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(Model model){
		
		Author author = new Author();
		model.addAttribute("author", author);
		
		return "Author/addAuthor";		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Valid Author author, BindingResult result){
		
		if(result.hasErrors()){
			return "redirect:/author/add";
		}
		else if(result.getSuppressedFields().length > 0){
			throw new RuntimeException("Attempting to bind and add disallowed field " 
										+ StringUtils.arrayToCommaDelimitedString(result.getSuppressedFields()));
		}
		
		authorService.create(author);		
		return "redirect:/author/";		
	}
	
	
	
	@RequestMapping(value= "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable long id,Model model){
		Author author = authorService.get(id);
		model.addAttribute(author);
		return "Author/updateAuthor";
		
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public String update(@Valid Author author, @PathVariable long id, BindingResult result){
		if(result.hasErrors())
			return "redirect:/author/update" + id;
		
		authorService.update(id, author);
		return "redirect:/author/";  // when redirect we are returning url, not a view
	}
	     
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
	public String delete(@PathVariable long id){
		System.out.println("delted id " + id);
		authorService.delete(id);
		return "redirect:/author/";	
		
	}
	@InitBinder
	public void initialiseBinder(WebDataBinder binder){
		binder.setDisallowedFields("id");
	}

}
