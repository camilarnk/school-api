package com.bn.school.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // mapeando como entidade
public class EstudanteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gerando o ID automaticamente
    // atalho = GeneratedValue(), Ctrl+Space: strategy, Ctrl+Space: identity
    private Long id;
    private String nome;
    private String email;
    private Integer idade;

    public EstudanteModel() {} // construtor vazio necessario

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}