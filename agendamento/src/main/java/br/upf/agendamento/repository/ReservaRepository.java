package br.upf.agendamento.repository;

import br.upf.agendamento.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    // Busca reservas com base na data/hora de início
    List<Reserva> findByDataHoraInicio(LocalDateTime dataHoraInicio);

    // Busca reservas com base na data/hora de fim
    List<Reserva> findByDataHoraFim(LocalDateTime dataHoraFim);

    // Busca reservas por espaço
    List<Reserva> findByEspacoId(Long espacoId);

    // Busca reservas por usuário
    List<Reserva> findByUsuarioId(Long usuarioId);

    // Consulta personalizada: reservas dentro de um intervalo
    @Query("SELECT r FROM Reserva r WHERE r.dataHoraInicio >= ?1 AND r.dataHoraFim <= ?2")
    List<Reserva> findByPeriodo(LocalDateTime inicio, LocalDateTime fim);
}
