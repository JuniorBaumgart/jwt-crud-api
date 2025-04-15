package br.upf.agendamento.controller;

import br.upf.agendamento.model.Espaco;
import br.upf.agendamento.service.EspacoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/espacos")
public class EspacoController {

    @Autowired
    private EspacoService espacoService;

    // Criar espaço
    @PostMapping
    public Espaco createEspaco(@RequestBody Espaco espaco) {
        return espacoService.criarEspaco(espaco);
    }

    // Listar todos os espaços
    @GetMapping
    public List<Espaco> getAllEspacos() {
        return espacoService.listarEspacos();
    }

    // Buscar espaço por ID
    @GetMapping("/{id}")
    public Espaco getEspacoById(@PathVariable Long id) {
        return espacoService.listarEspacos()
                .stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Espaço com ID " + id + " não encontrado"));
    }

    // Atualizar espaço
    @PutMapping("/{id}")
    public Espaco updateEspaco(@PathVariable Long id, @RequestBody Espaco espaco) {
        return espacoService.editarEspaco(id, espaco);
    }

    // Deletar espaço
    @DeleteMapping("/{id}")
    public void deleteEspaco(@PathVariable Long id) {
        espacoService.deletarEspaco(id);
    }

    // Consultar espaço por nome
    @GetMapping("/buscar-por-nome")
    public List<Espaco> getEspacoByNome(@RequestParam String nome) {
        return espacoService.listarEspacos()
                .stream()
                .filter(e -> e.getNome().equalsIgnoreCase(nome))
                .toList();
    }

    // Consultar espaços por capacidade mínima
    @GetMapping("/capacidade")
    public List<Espaco> getEspacosPorCapacidade(@RequestParam Integer capacidade) {
        return espacoService.consultarEspacosPorCapacidade(capacidade);
    }
}
