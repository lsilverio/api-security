package br.com.lstecnologia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lstecnologia.model.PermissionModel;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionModel, Long> {

}
