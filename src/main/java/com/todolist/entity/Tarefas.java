package com.todolist.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_tarefas")
public class Tarefas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String nome;
    private String email;
    private String senha;

}
