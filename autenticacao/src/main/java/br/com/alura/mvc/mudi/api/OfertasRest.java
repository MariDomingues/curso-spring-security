package br.com.alura.mvc.mudi.api;

import br.com.alura.mvc.mudi.model.dto.RequisicaoNovaOfertaDto;
import br.com.alura.mvc.mudi.model.entity.OfertaEntity;
import br.com.alura.mvc.mudi.service.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

    @Autowired
    private OfertaService ofertaService;

    @PostMapping
    public OfertaEntity criaOferta(@Valid @RequestBody RequisicaoNovaOfertaDto pRequisicao) {

        return ofertaService.criaOferta(pRequisicao);
    }
}
