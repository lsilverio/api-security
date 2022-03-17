package br.com.lstecnologia.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lstecnologia.model.ProfileModel;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileModel, Long> {
	
	Page<ProfileModel> findByNameContaining(Pageable pageable, String name);
	
	Optional<ProfileModel> findByIdAndExcludedFalse(Long id);

}
