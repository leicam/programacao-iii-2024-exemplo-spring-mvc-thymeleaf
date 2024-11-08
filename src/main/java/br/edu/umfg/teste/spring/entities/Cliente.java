package br.edu.umfg.teste.spring.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id // Indica que este atributo é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Geração automática do ID
    @Column(name = "ID") //coluna obrigatorio
    private Long id;

    @Column(name = "NM_CLIENTE", nullable = false) //coluna obrigatorio
    private String nome;

    @Column(name = "NR_CPF", nullable = false) //coluna obrigatorio
    private String cpf;

    @Column(name = "DS_EMAIL", nullable = false, unique = true)//coluna obrigatorio e unica
    private String email;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
