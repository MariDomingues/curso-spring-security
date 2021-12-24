package br.com.alura.mvc.mudi.service;

import br.com.alura.mvc.mudi.model.dto.RequisicaoNovoPedidoDto;
import br.com.alura.mvc.mudi.model.entity.PedidoEntity;
import br.com.alura.mvc.mudi.model.entity.UserEntity;
import br.com.alura.mvc.mudi.model.enums.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import br.com.alura.mvc.mudi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UserRepository userRepository;

    public String formulario(RequisicaoNovoPedidoDto requisicao) {

        return "pedido/formulario";
    }

    public String novo(RequisicaoNovoPedidoDto pRequisicao, BindingResult pResult) {

        if (pResult.hasErrors()) {
            return "pedidoEntity/formulario";
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntity usuario = userRepository.findByUsername(username);

        PedidoEntity pedidoEntity = pRequisicao.toPedido();
        pedidoEntity.setUsuario(usuario);
        pedidoRepository.save(pedidoEntity);

        return "redirect:/home";
    }

    public List<PedidoEntity> getPedidoAguardandoOferta() {

        Sort sort = Sort.by("id").descending();
        PageRequest paginacao = PageRequest.of(0, 10, sort);

        return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, paginacao);
    }
}
