package com.bn.school.repositories;

import com.bn.school.models.EstudanteModel;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Model, TipoDoID> - T de entidade
public interface EstudanteRepository extends JpaRepository<EstudanteModel, Long> {
}