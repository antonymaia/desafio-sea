package br.antony.sea.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoTrabalhoDTO {

    private Integer id;
    @NotBlank(message = "Informe CPF do trabalhador")
    private String cpf;
    @NotBlank(message = "Informe o nome do trabalhador")
    private String nome;
    @NotBlank(message = "Informe o sexo do trabalhador")
    private String sexo;
    @NotNull(message = "Informe o id cargo")
    private Integer idCargo;

    public NovoTrabalhoDTO(){}

    public NovoTrabalhoDTO(Integer id, String cpf, String nome, String sexo, Integer idCargo) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.idCargo = idCargo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }
}
