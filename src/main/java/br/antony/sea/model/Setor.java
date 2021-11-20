package br.antony.sea.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Setor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nome;

    @OneToMany(mappedBy = "setor", cascade = CascadeType.ALL)
    private List<Cargo> cargos;

    public Setor(){}

    public Setor(int id, String nome) {
        this.id = id;
        this.nome = nome!=null ? nome.toUpperCase() : null;
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

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }
}
