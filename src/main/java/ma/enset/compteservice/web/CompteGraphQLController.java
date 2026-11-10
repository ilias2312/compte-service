package ma.enset.compteservice.web;

import lombok.AllArgsConstructor;
import ma.enset.compteservice.dto.CompteRequestDTO;
import ma.enset.compteservice.dto.CompteResponseDTO;
import ma.enset.compteservice.service.CompteService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class CompteGraphQLController {

    private final CompteService compteService;

    @QueryMapping
    public List<CompteResponseDTO> allComptes() {
        return compteService.getAllComptes();
    }

    @QueryMapping
    public CompteResponseDTO compteById(@Argument Long id) {
        return compteService.getCompte(id);
    }

    @QueryMapping
    public Map<String, Object> totalSolde() {
        List<CompteResponseDTO> comptes = compteService.getAllComptes();
        double somme = comptes.stream().mapToDouble(CompteResponseDTO::getSolde).sum();
        int n = comptes.size();
        return Map.of("nombreComptes", n, "sommeSoldes", somme, "moyenneSoldes", n == 0 ? 0.0 : somme / n);
    }

    @MutationMapping
    public CompteResponseDTO saveCompte(@Argument CompteRequestDTO compte) {
        return compteService.addCompte(compte);
    }

    @MutationMapping
    public CompteResponseDTO updateCompte(@Argument Long id, @Argument CompteRequestDTO compte) {
        return compteService.updateCompte(id, compte);
    }

    @MutationMapping
    public Boolean deleteCompte(@Argument Long id) {
        compteService.deleteCompte(id);
        return true;
    }
}