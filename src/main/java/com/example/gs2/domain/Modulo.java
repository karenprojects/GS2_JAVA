package com.example.gs2.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "tb_gs2_modulo")
@Table(name = "tb_gs2_modulo")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome_modulo;

    private String descricao;
}
