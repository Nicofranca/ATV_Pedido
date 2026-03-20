package com.weg.pedido.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "departamento")
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String nome;

    @OneToMany(mappedBy = "departamento")
    private List<Funcionario> listaFuncionario;

    public Departamento(String nome) {
        this.nome = nome;
    }
}
