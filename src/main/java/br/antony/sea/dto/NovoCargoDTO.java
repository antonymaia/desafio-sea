package br.antony.sea.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoCargoDTO {
    private Integer id;
    @NotBlank(message = "Informe o nome do Cargo")
    private String nome;
    @NotNull(message = "Informe o id do Setor")
    private Integer idSetor;

    public NovoCargoDTO(){}

    public NovoCargoDTO(Integer id, String nome, Integer idSetor) {
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
