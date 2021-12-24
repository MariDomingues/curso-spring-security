package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@GetMapping
	@RequestMapping("/login")
	public String login() {

		return loginService.login();
	}
}
