package br.com.alura.mvc.mudi.service;

import br.com.alura.mvc.mudi.model.entity.PedidoEntity;
import br.com.alura.mvc.mudi.model.enums.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class HomeService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public String paginacaoOrdenacao(Model model) {

        Sort sort = Sort.by("dataEntrega").descending();
        PageRequest paginacao = PageRequest.of(0, 10, sort);

        List<PedidoEntity> pedidoEntities = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);
        model.addAttribute("pedidos", pedidoEntities);

        return "home";
    }
}
