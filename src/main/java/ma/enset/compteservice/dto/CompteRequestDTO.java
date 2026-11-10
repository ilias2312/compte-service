package ma.enset.compteservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.compteservice.entities.TypeCompte;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompteRequestDTO {
    private Double solde;
    private TypeCompte type;
}