package ma.enset.compteservice;

import ma.enset.compteservice.entities.Compte;
import ma.enset.compteservice.entities.TypeCompte;
import ma.enset.compteservice.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class CompteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository) {
        return args -> {
            compteRepository.save(Compte.builder().solde(9800.0).dateCreation(new Date()).type(TypeCompte.COURANT).build());
            compteRepository.save(Compte.builder().solde(4300.0).dateCreation(new Date()).type(TypeCompte.EPARGNE).build());
            compteRepository.save(Compte.builder().solde(1200.0).dateCreation(new Date()).type(TypeCompte.COURANT).build());
            compteRepository.findAll().forEach(c ->
                    System.out.println(c.getId() + " -> " + c.getSolde() + " (" + c.getType() + ")"));
        };
    }
}