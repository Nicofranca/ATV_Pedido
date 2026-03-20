package com.weg.pedido.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nome;

    @Column
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    public Funcionario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
}
