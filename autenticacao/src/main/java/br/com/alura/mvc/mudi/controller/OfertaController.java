package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.service.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oferta")
public class OfertaController {

	@Autowired
	private OfertaService ofertaService;

	@GetMapping
	public String getFormularioOferta() {

		return ofertaService.getFormularioOferta();
	}
}
