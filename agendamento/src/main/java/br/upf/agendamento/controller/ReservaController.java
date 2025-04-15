package br.upf.agendamento.controller;

import br.upf.agendamento.model.Reserva;
import br.upf.agendamento.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    // Criar reserva
    @PostMapping
    public Reserva createReserva(@RequestBody Reserva reserva) {
        return reservaService.criarReserva(reserva);
    }

    // Listar todas as reservas
    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.listarReservas();
    }

    // Buscar reserva por ID
    @GetMapping("/{id}")
    public Optional<Reserva> getReservaById(@PathVariable Long id) {
        return Optional.ofNullable(reservaService.listarReservas()
                .stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null));
    }

    // Atualizar reserva
    @PutMapping("/{id}")
    public Reserva updateReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        return reservaService.editarReserva(id, reserva);
    }

    // Deletar reserva
    @DeleteMapping("/{id}")
    public void deleteReserva(@PathVariable Long id) {
        reservaService.deletarReserva(id);
    }

    // Buscar por data/hora de início exata
    @GetMapping("/inicio")
    public List<Reserva> buscarPorDataHoraInicio(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataHoraInicio) {
        return reservaService.buscarPorDataHoraInicio(dataHoraInicio);
    }

    // Buscar por intervalo de datas
    @GetMapping("/periodo")
    public List<Reserva> buscarPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fim) {
        return reservaService.buscarPorPeriodo(inicio, fim);
    }

    // Buscar por usuário
    @GetMapping("/usuario/{usuarioId}")
    public List<Reserva> buscarPorUsuario(@PathVariable Long usuarioId) {
        return reservaService.buscarPorUsuario(usuarioId);
    }

    // Buscar por espaço
    @GetMapping("/espaco/{espacoId}")
    public List<Reserva> buscarPorEspaco(@PathVariable Long espacoId) {
        return reservaService.buscarPorEspaco(espacoId);
    }
}
