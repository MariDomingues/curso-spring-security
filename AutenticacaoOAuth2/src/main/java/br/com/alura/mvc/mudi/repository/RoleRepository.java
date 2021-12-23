package br.com.alura.mvc.mudi.repository;

import br.com.alura.mvc.mudi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
