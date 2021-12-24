package br.com.alura.mvc.mudi.api;

import br.com.alura.mvc.mudi.model.entity.PedidoEntity;
import br.com.alura.mvc.mudi.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping("aguardando")
	public List<PedidoEntity> getPedidosAguardandoOfertas() {

		return pedidoService.getPedidoAguardandoOferta();
	}
}
