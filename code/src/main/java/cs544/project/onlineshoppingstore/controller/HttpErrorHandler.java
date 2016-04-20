package cs544.project.onlineshoppingstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HttpErrorHandler {

	String path = "exception";

	@RequestMapping(value = "/exception/400")
	public String error400() {
		
		return path + "/error400";
	}

	@RequestMapping(value = "/exception/404")
	public String error404() {
		return path + "/error404";
	}

	@RequestMapping(value="/exception/500")
	 public String error500(){
	  return path+"/error500";
	}
}
