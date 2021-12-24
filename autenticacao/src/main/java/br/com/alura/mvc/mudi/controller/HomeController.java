package br.com.alura.mvc.mudi.controller;

import java.security.Principal;

import br.com.alura.mvc.mudi.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping
    //principal - dados do usuario logado
    public String home(Model pModel, Principal pPrincipal) {

        return homeService.paginacaoOrdenacao(pModel);
    }
}
