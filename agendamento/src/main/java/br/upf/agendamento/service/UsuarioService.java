package br.upf.agendamento.service;

import br.upf.agendamento.model.Usuario;
import br.upf.agendamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Criar um novo usuário
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Editar um usuário
    public Usuario editarUsuario(Long id, Usuario usuario) {
        Optional<Usuario> existingUsuario = usuarioRepository.findById(id);
        if (existingUsuario.isPresent()) {
            Usuario updatedUsuario = existingUsuario.get();
            updatedUsuario.setNome(usuario.getNome());
            updatedUsuario.setEmail(usuario.getEmail());
            updatedUsuario.setSenha(usuario.getSenha());
            updatedUsuario.setDataNascimento(usuario.getDataNascimento());
            return usuarioRepository.save(updatedUsuario);
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    // Listar todos os usuários
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Deletar um usuário
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Consultar usuário pelo email
    public Usuario consultarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o email: " + email));
    }
}
