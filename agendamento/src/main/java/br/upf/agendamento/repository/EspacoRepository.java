package br.upf.agendamento.repository;

import br.upf.agendamento.model.Espaco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspacoRepository extends JpaRepository<Espaco, Long> {

    // Busca por nome (Spring Data JPA gera a query automaticamente)
    List<Espaco> findByNome(String nome);

    // Busca por espaços com capacidade maior que um valor
    List<Espaco> findByCapacidadeGreaterThan(Integer capacidade);
}
