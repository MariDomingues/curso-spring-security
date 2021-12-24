package br.com.alura.mvc.mudi.service;

import br.com.alura.mvc.mudi.model.entity.AuthorityEntity;
import br.com.alura.mvc.mudi.model.entity.PedidoEntity;
import br.com.alura.mvc.mudi.model.entity.UserEntity;
import br.com.alura.mvc.mudi.model.enums.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import br.com.alura.mvc.mudi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UserRepository userRepository;

    public String home(Model pModel, String pNome) {

        List<PedidoEntity> pedidoEntities = pedidoRepository.findAllByUsuario(pNome);
        pModel.addAttribute("pedidos", pedidoEntities);

        return "usuario/home";
    }

    @GetMapping("pedido/{status}")
    public String porStatus(@PathVariable("status") String status, Model pModel, Principal principal) {

        List<PedidoEntity> pedidoEntities = pedidoRepository.findByStatusEUsuario(StatusPedido.valueOf(status.toUpperCase()), principal.getName());
        pModel.addAttribute("pedidos", pedidoEntities);
        pModel.addAttribute("status", status);

        return "usuario/home";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/usuario/home";
    }

    @GetMapping("/cadastrar")
    public ModelAndView login() {

        ModelAndView mv = new ModelAndView("/usuario/formulario");
        mv.addObject("user", new UserEntity());

        return mv;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid UserEntity userEntity, BindingResult result) {

        if (result.hasErrors()) {
            return "/usuario/formulario";
        }

        userEntity.setPassword(new BCryptPasswordEncoder().encode(userEntity.getPassword()));
        userEntity.setEnabled(true);
        userEntity.setAuthorities(new AuthorityEntity("USER"));
        userRepository.save(userEntity);

        return "redirect:/login";
    }
}
