package br.antony.sea.dto;

import javax.validation.constraints.NotBlank;

public class NovoSetorDTO {

    private Integer id;

    @NotBlank(message = "Informe a descrição do setor")
    private String nome;

    public NovoSetorDTO(Integer id, String nome) {
        this.id = id;
        this.nome = nome.toUpperCase();
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
