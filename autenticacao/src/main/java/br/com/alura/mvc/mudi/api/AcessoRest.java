package br.com.alura.mvc.mudi.api;

import br.com.alura.mvc.mudi.interceptor.AcessoInterceptor;
import br.com.alura.mvc.mudi.model.dto.AcessoDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//String Boot Actuator - monitoração da aplicação
@RestController
@RequestMapping("acesso")
public class AcessoRest {

    @GetMapping
    public List<AcessoDto> getAcesso() {

        return AcessoInterceptor.vAcesso;
    }
}
