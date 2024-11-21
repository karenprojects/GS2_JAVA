package com.example.gs2.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "tb_gs2_app_user")
@Table(name = "tb_gs2_app_user")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    private String password;
}
