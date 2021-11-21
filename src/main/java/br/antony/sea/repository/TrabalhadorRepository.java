package br.antony.sea.repository;

import br.antony.sea.model.Trabalhador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface TrabalhadorRepository extends JpaRepository<Trabalhador, Integer> {
    Optional<Trabalhador> findByCpf(String cpf);

    @Modifying
    @Transactional
    @Query(value = " UPDATE trabalhador SET ativo = :ativo WHERE id = :id", nativeQuery = true)
    void updateAtivo(@Param("id") Integer id, @Param("ativo") boolean ativo);
}
