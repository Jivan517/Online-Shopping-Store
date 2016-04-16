package cs544.project.onlineshoppingstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.project.onlineshoppingstore.model.Admin;
import cs544.project.onlineshoppingstore.service.AdminService;

public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String index(Model model) {

		List<Admin> adminList = adminService.getAll();
		model.addAttribute("adminList", adminList);

		return "Admin/adminList";
	}
	
	@RequestMapping(value = "/admin/add", method = RequestMethod.GET)
	public String add(Model model) {
		
		model.addAttribute("admin", new Admin());
		return "Admin/addAdmin";
	}

	@RequestMapping(value = "/admin/add", method = RequestMethod.POST)
	public String add(@Valid Admin admin, BindingResult result) {

		System.out.println(result.hasErrors());
		if(result.hasErrors())
			return "Admin/addAdmin";
		
		adminService.create(admin);
		return "redirect:/admin";
	}
	
	@RequestMapping(value = "/admin/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable int id, Model model){
		
		Admin admin = adminService.get(id);
		model.addAttribute("admin", admin);
		
		return "Admin/updateAdmin";
	}
	
	@RequestMapping(value = "/admin/update/{id}", method = RequestMethod.POST)
	public String update(@Valid Admin admin,@PathVariable int id, BindingResult result){
		
		if(result.hasErrors())
			return "redirect:/admin/update/" + id;
		
		adminService.update(id, admin);
		
		return "redirect:/admin";
	}
	
	@RequestMapping(value = "/admin/delete/{id}", method = RequestMethod.POST )
	public String delete(@PathVariable int id){
		
		adminService.delete(id);
		return "redirect:/admin";
	}

}
