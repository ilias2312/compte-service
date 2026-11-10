package ma.enset.compteservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "solde", types = Compte.class)
public interface CompteProjection2 {
    Double getSolde();
}