package com.makersacademy.acebook.controller;

import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.view.RedirectView;

@Controller

public class HomeController {
	@RequestMapping(value = "/")
	public RedirectView index() {
		return new RedirectView("/posts");
	}

}
