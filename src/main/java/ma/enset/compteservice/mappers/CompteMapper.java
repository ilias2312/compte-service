package ma.enset.compteservice.mappers;

import ma.enset.compteservice.dto.CompteRequestDTO;
import ma.enset.compteservice.dto.CompteResponseDTO;
import ma.enset.compteservice.entities.Compte;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompteMapper {

    public Compte fromCompteRequestDTO(CompteRequestDTO dto) {
        Compte compte = new Compte();
        BeanUtils.copyProperties(dto, compte);
        return compte;
    }

    public CompteResponseDTO fromCompte(Compte compte) {
        CompteResponseDTO dto = new CompteResponseDTO();
        BeanUtils.copyProperties(compte, dto);
        return dto;
    }
}