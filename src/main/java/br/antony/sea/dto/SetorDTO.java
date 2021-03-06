package br.antony.sea.dto;

import java.util.List;

public class SetorDTO {

    private Integer id;
    private String nome;
    private List<CargoDTO> cargos;

    public SetorDTO(){}

    public SetorDTO(Integer id, String nome) {
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

    public List<CargoDTO> getCargos() {
        return cargos;
    }

    public void setCargos(List<CargoDTO> cargos) {
        this.cargos = cargos;
    }
}
