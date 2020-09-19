package com.souza.manutencao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.souza.manutencao.entity.enums.OrdemStatus;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "ordens_servico")
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditingEntityListener.class)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255)
    private String descricao;

    @NotNull
    @ManyToOne
    private Cliente cliente;

    @NotNull
    @ManyToOne
    private Equipamento equipamento;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime inicioServico;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime finalServico;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    @CreatedDate
    private LocalDateTime createdAt;

    @NotNull
    @Builder.Default
    private OrdemStatus ordemStatus = OrdemStatus.CRIADA;
}
