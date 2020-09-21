package com.souza.manutencao.repository;

import com.souza.manutencao.entity.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

    List<OrdemServico> findByInicioServicoIsNullOrderByCreatedAtDesc();

    List<OrdemServico> findByInicioServicoIsNotNullAndFinalServicoIsNullOrderByCreatedAtDesc();

}
