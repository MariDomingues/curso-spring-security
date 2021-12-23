package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.User;
import br.com.alura.mvc.mudi.model.consts.Const;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user-auth")
public class SecurityController {

    @GetMapping
    @Secured({Const.ROLE_CLIENT, Const.ROLE_ADMIN})
    public User user() {

        return (User) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
    }
}
