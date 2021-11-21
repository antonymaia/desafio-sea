package br.antony.sea.dto;

import java.util.List;

public class CargoDTO {
    private Integer id;
    private String nome;

    public CargoDTO(){}

    public CargoDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
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

}
