package br.com.lstecnologia.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lstecnologia.model.PermissionModel;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionModel, Long> {

	Page<PermissionModel> findByNameContaining(Pageable pageable, String name);
	
	Optional<PermissionModel> findByIdAndExcludedFalse(Long id);
	
}
