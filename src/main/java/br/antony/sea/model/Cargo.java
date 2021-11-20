package br.antony.sea.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cargo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @ManyToOne()
    @JoinColumn(name = "id_setor")
    private Setor setor;

    @OneToMany(mappedBy = "cargo")
    @JsonIgnore
    private List<Trabalhador> trabalhadores;

    public Cargo(){}

    public Cargo(Integer id, String nome, Setor setor) {
        this.id = id;
        this.nome = nome.toUpperCase();
        this.setor = setor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public List<Trabalhador> getTrabalhadores() {
        return trabalhadores;
    }

    public void setTrabalhadores(List<Trabalhador> trabalhadores) {
        this.trabalhadores = trabalhadores;
    }
}
