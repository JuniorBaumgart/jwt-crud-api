package br.upf.agendamento.service;

import br.upf.agendamento.model.Reserva;
import br.upf.agendamento.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    // Criar uma nova reserva
    public Reserva criarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Editar uma reserva
    public Reserva editarReserva(Long id, Reserva reserva) {
        Optional<Reserva> existingReserva = reservaRepository.findById(id);
        if (existingReserva.isPresent()) {
            Reserva updatedReserva = existingReserva.get();
            updatedReserva.setEspaco(reserva.getEspaco());
            updatedReserva.setUsuario(reserva.getUsuario());
            updatedReserva.setDataHoraInicio(reserva.getDataHoraInicio());
            updatedReserva.setDataHoraFim(reserva.getDataHoraFim());
            updatedReserva.setObservacoes(reserva.getObservacoes());
            return reservaRepository.save(updatedReserva);
        } else {
            throw new RuntimeException("Reserva não encontrada");
        }
    }

    // Listar todas as reservas
    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    // Deletar uma reserva
    public void deletarReserva(Long id) {
        reservaRepository.deleteById(id);
    }

    // Buscar reservas por data/hora de início
    public List<Reserva> buscarPorDataHoraInicio(LocalDateTime dataHoraInicio) {
        return reservaRepository.findByDataHoraInicio(dataHoraInicio);
    }

    // Buscar reservas por intervalo de tempo
    public List<Reserva> buscarPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        return reservaRepository.findByPeriodo(inicio, fim);
    }

    // Buscar reservas por espaço
    public List<Reserva> buscarPorEspaco(Long espacoId) {
        return reservaRepository.findByEspacoId(espacoId);
    }

    // Buscar reservas por usuário
    public List<Reserva> buscarPorUsuario(Long usuarioId) {
        return reservaRepository.findByUsuarioId(usuarioId);
    }
}
