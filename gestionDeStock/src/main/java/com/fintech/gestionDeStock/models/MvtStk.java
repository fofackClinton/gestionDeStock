package com.fintech.gestionDeStock.models;

import java.math.BigDecimal;
import java.time.Instant;

import com.fintech.gestionDeStock.enums.TypeMvtStk;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Builder
@Setter
@Table(name = "mvt_stk")
public class MvtStk extends AbstractEntity {

    @Column(name = "date_mvt_stk")
    private Instant dateMvtStk;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @ManyToOne
    @JoinColumn(name = "id_article")
    private Article article;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @Column(name = "type_mvt_stk")
    private TypeMvtStk typeMvtStk;

}
