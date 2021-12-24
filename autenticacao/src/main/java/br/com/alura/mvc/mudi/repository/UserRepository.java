package br.com.alura.mvc.mudi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

	UserEntity findByUsername(String username);
}
