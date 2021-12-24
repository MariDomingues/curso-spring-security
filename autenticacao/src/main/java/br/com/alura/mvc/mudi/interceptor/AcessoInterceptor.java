package br.com.alura.mvc.mudi.interceptor;

import br.com.alura.mvc.mudi.model.dto.AcessoDto;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AcessoInterceptor extends HandlerInterceptorAdapter {

    public static List<AcessoDto> vAcesso = new ArrayList<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        AcessoDto acesso = new AcessoDto();
        acesso.setPath(request.getRequestURI());
        acesso.setDataHora(LocalDateTime.now());

        request.setAttribute("acesso", acesso);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        AcessoDto acesso = (AcessoDto) request.getAttribute("acesso");
        acesso.setDuracao(Duration.between(acesso.getDataHora(), LocalDateTime.now()));

        vAcesso.add(acesso);
    }
}
