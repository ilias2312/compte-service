package ma.enset.compteservice.service;

import ma.enset.compteservice.dto.CompteRequestDTO;
import ma.enset.compteservice.dto.CompteResponseDTO;

import java.util.List;

public interface CompteService {
    CompteResponseDTO addCompte(CompteRequestDTO compteDTO);
    CompteResponseDTO getCompte(Long id);
    List<CompteResponseDTO> getAllComptes();
    CompteResponseDTO updateCompte(Long id, CompteRequestDTO compteDTO);
    void deleteCompte(Long id);
}