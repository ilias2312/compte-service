package ma.enset.compteservice;

import ma.enset.compteservice.entities.Compte;
import ma.enset.compteservice.entities.TypeCompte;
import ma.enset.compteservice.repositories.CompteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CompteRepositoryTest {

    @Autowired
    private CompteRepository compteRepository;

    @BeforeEach
    void cleanDatabase() {
        compteRepository.deleteAll();
    }

    @Test
    void shouldSaveAndFindCompte() {
        Compte saved = compteRepository.save(
                Compte.builder().solde(5000.0).dateCreation(new Date()).type(TypeCompte.COURANT).build());
        assertNotNull(saved.getId());
        assertEquals(5000.0, compteRepository.findById(saved.getId()).orElseThrow().getSolde());
    }

    @Test
    void shouldFindByType() {
        compteRepository.save(Compte.builder().solde(100.0).dateCreation(new Date()).type(TypeCompte.EPARGNE).build());
        compteRepository.save(Compte.builder().solde(200.0).dateCreation(new Date()).type(TypeCompte.COURANT).build());
        List<Compte> epargnes = compteRepository.findByType(TypeCompte.EPARGNE);
        assertEquals(1, epargnes.size());
        assertEquals(TypeCompte.EPARGNE, epargnes.get(0).getType());
    }

    @Test
    void shouldDeleteCompte() {
        Compte saved = compteRepository.save(
                Compte.builder().solde(1.0).dateCreation(new Date()).type(TypeCompte.COURANT).build());
        compteRepository.deleteById(saved.getId());
        assertTrue(compteRepository.findById(saved.getId()).isEmpty());
    }
}