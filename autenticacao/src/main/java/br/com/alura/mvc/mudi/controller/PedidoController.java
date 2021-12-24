package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.dto.RequisicaoNovoPedidoDto;
import br.com.alura.mvc.mudi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedidoDto pRequisicao) {

        return pedidoService.formulario(pRequisicao);
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedidoDto pRequisicao, BindingResult pResult) {

        return pedidoService.novo(pRequisicao, pResult);
    }
}
