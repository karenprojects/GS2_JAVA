package com.example.gs2.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "tb_gs2_conteudo")
@Table(name = "tb_gs2_conteudo")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Conteudo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome_conteudo;

    private String corpo;
}
