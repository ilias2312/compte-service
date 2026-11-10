package ma.enset.compteservice.service;

import lombok.AllArgsConstructor;
import ma.enset.compteservice.dto.CompteRequestDTO;
import ma.enset.compteservice.dto.CompteResponseDTO;
import ma.enset.compteservice.entities.Compte;
import ma.enset.compteservice.mappers.CompteMapper;
import ma.enset.compteservice.repositories.CompteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CompteServiceImpl implements CompteService {

    private final CompteRepository compteRepository;
    private final CompteMapper compteMapper;

    @Override
    public CompteResponseDTO addCompte(CompteRequestDTO compteDTO) {
        Compte compte = compteMapper.fromCompteRequestDTO(compteDTO);
        compte.setDateCreation(new Date());
        return compteMapper.fromCompte(compteRepository.save(compte));
    }

    @Override
    public CompteResponseDTO getCompte(Long id) {
        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Compte %s introuvable", id)));
        return compteMapper.fromCompte(compte);
    }

    @Override
    public List<CompteResponseDTO> getAllComptes() {
        return compteRepository.findAll().stream().map(compteMapper::fromCompte).toList();
    }

    @Override
    public CompteResponseDTO updateCompte(Long id, CompteRequestDTO compteDTO) {
        Compte existant = compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Compte %s introuvable", id)));
        if (compteDTO.getSolde() != null) existant.setSolde(compteDTO.getSolde());
        if (compteDTO.getType() != null) existant.setType(compteDTO.getType());
        return compteMapper.fromCompte(compteRepository.save(existant));
    }

    @Override
    public void deleteCompte(Long id) {
        compteRepository.deleteById(id);
    }
}