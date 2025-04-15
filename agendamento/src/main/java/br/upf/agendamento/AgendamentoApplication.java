package br.upf.agendamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "br.upf.agendamento.model")  // Adapte para o pacote onde estão suas entidades
@EnableJpaRepositories(basePackages = "br.upf.agendamento.repository")  // Adapte para o pacote onde estão seus repositórios
public class AgendamentoApplication {
    public static void main(String[] args) {
        SpringApplication.run(AgendamentoApplication.class, args);
    }
}
