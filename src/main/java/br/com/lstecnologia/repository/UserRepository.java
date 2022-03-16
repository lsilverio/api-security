package br.com.lstecnologia.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lstecnologia.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	Page<UserModel> findAllByUsername(Pageable pageable, String username);
	
	Page<UserModel> findByNameContaining(Pageable pageable, String name);
	
	Page<UserModel> findByUsernameAndNameContaining(Pageable pageable, String username, String name);
	
	Optional<UserModel> findByIdAndExcludedFalse(Long id);
	
	Optional<UserModel> findByUsernameAndActiveTrue(String username);
	
	Optional<UserModel> findByUuidPassword(String uuid);
	
}
