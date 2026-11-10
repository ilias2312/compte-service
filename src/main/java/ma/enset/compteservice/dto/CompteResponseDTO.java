package ma.enset.compteservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.compteservice.entities.TypeCompte;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompteResponseDTO {
    private Long id;
    private Double solde;
    private Date dateCreation;
    private TypeCompte type;
}