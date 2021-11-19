package br.antony.sea.repository;

import br.antony.sea.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer> {
    Setor findByNome(String nome);
}
