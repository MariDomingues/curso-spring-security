package br.com.alura.mvc.mudi.service;

import br.com.alura.mvc.mudi.model.dto.RequisicaoNovaOfertaDto;
import br.com.alura.mvc.mudi.model.entity.OfertaEntity;
import br.com.alura.mvc.mudi.model.entity.PedidoEntity;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfertaService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public String getFormularioOferta() {

		return "oferta/home";
	}

	public OfertaEntity criaOferta(RequisicaoNovaOfertaDto pRequisicao) {

		Optional<PedidoEntity> pedidoBuscado = pedidoRepository.findById(pRequisicao.getPedidoId());
		if (!pedidoBuscado.isPresent()) {
			return null;
		}

		PedidoEntity pedidoEntity = pedidoBuscado.get();

		OfertaEntity nova = pRequisicao.toOferta();
		nova.setPedido(pedidoEntity);
		pedidoEntity.getOfertas().add(nova);

		pedidoRepository.save(pedidoEntity);

		return nova;
	}
}
