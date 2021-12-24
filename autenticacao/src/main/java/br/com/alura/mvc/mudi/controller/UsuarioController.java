package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.entity.UserEntity;
import br.com.alura.mvc.mudi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("pedido")
	public String home(Model pModel, Principal pPrincipal) {

		return usuarioService.home(pModel, pPrincipal.getName());
	}
	
	@GetMapping("pedido/{status}")
	public String porStatus(@PathVariable("status") String status, Model pModel, Principal principal) {

		return usuarioService.porStatus(status, pModel, principal);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {

		return usuarioService.onError();
	}

	@GetMapping("/cadastrar")
	public ModelAndView login() {

		return usuarioService.login();
	}

	@PostMapping("/cadastrar")
	public String cadastrar(@Valid UserEntity userEntity, BindingResult result) {

		return usuarioService.cadastrar(userEntity, result);
	}
}
