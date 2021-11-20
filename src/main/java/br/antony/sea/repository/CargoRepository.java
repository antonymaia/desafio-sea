package br.antony.sea.repository;

import br.antony.sea.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
    Cargo findByNome(String nome);
}
