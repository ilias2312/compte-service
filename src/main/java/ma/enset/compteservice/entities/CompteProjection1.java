package ma.enset.compteservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "mobile", types = Compte.class)
public interface CompteProjection1 {
    Long getId();
    Double getSolde();
}