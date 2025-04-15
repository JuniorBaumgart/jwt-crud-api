package br.upf.agendamento.repository;

import br.upf.agendamento.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Consulta por email (usando Spring Data JPA automático)
    Optional<Usuario> findByEmail(String email);
    
    Usuario findByNome(String nome);

}
