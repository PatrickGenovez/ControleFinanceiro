package br.com.devpatrick.controlefinanceiro;

import br.com.devpatrick.controlefinanceiro.model.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ControleFinanceiroApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControleFinanceiroApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(Menu menu) {
        return args -> {
            menu.iniciar();
        };
    }
}
