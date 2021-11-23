package br.antony.sea.repository;

import br.antony.sea.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
    Cargo findByNome(String nome);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TRABALHADOR SET id_cargo = null WHERE id_cargo = :id", nativeQuery = true)
    public void deleteCargoTrabalhador( @Param("id") Integer id);
}
