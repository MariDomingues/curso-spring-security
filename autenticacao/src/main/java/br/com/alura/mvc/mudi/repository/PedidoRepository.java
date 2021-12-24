package br.com.alura.mvc.mudi.repository;

import java.util.List;

import br.com.alura.mvc.mudi.model.entity.PedidoEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.enums.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
	
	@Cacheable("books")
	List<PedidoEntity> findByStatus(StatusPedido status, Pageable sort);

	@Query("SELECT p FROM PedidoEntity p JOIN p.usuario u WHERE u.username = :username")
	List<PedidoEntity> findAllByUsuario(@Param("username")String username);

	@Query("SELECT p FROM PedidoEntity p JOIN p.usuario u WHERE u.username = :username AND p.status = :status")
	List<PedidoEntity> findByStatusEUsuario(@Param("status")StatusPedido status, @Param("username")String username);
}
