package br.upf.agendamento.service;

import br.upf.agendamento.model.Espaco;
import br.upf.agendamento.repository.EspacoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspacoService {

    @Autowired
    private EspacoRepository espacoRepository;

    // Criar um novo espaço
    public Espaco criarEspaco(Espaco espaco) {
        return espacoRepository.save(espaco);
    }

    // Editar um espaço
    public Espaco editarEspaco(Long id, Espaco espaco) {
        Espaco existingEspaco = espacoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Espaço com ID " + id + " não encontrado"));

        existingEspaco.setNome(espaco.getNome());
        existingEspaco.setLocalizacao(espaco.getLocalizacao());
        existingEspaco.setCapacidade(espaco.getCapacidade());

        return espacoRepository.save(existingEspaco);
    }

    // Listar todos os espaços
    public List<Espaco> listarEspacos() {
        return espacoRepository.findAll();
    }

    // Deletar um espaço
    public void deletarEspaco(Long id) {
        espacoRepository.deleteById(id);
    }

    // Consultar espaços com capacidade maior que um valor X
    public List<Espaco> consultarEspacosPorCapacidade(Integer capacidade) {
        return espacoRepository.findByCapacidadeGreaterThan(capacidade);
    }
}
