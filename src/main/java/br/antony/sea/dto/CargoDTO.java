package br.antony.sea.dto;

import java.util.List;

public class CargoDTO {
    private Integer id;
    private String nome;
    private Integer idSetor;

    public CargoDTO(){}

    public CargoDTO(Integer id, String nome, Integer idSetor) {
        this.id = id;
        this.nome = nome;
        this.idSetor = idSetor;
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

    public Integer getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idSetor = idSetor;
    }
}
