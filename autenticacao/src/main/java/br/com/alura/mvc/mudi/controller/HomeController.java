package br.com.alura.mvc.mudi.controller;

import java.security.Principal;
import java.util.List;

import br.com.alura.mvc.mudi.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mvc.mudi.model.entity.PedidoEntity;
import br.com.alura.mvc.mudi.model.enums.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping
    //principal - dados do usuario logado
    public String home(Model pModel, Principal pPrincipal) {

        return homeService.home(pModel);
    }
}
