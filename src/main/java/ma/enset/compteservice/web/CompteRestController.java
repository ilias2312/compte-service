package ma.enset.compteservice.web;

import lombok.AllArgsConstructor;
import ma.enset.compteservice.dto.CompteRequestDTO;
import ma.enset.compteservice.dto.CompteResponseDTO;
import ma.enset.compteservice.service.CompteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comptes")
@AllArgsConstructor
public class CompteRestController {

    private final CompteService compteService;

    @GetMapping
    public List<CompteResponseDTO> comptes() {
        return compteService.getAllComptes();
    }

    @GetMapping("/{id}")
    public CompteResponseDTO compte(@PathVariable Long id) {
        return compteService.getCompte(id);
    }

    @PostMapping
    public CompteResponseDTO save(@RequestBody CompteRequestDTO compte) {
        return compteService.addCompte(compte);
    }

    @PutMapping("/{id}")
    public CompteResponseDTO update(@PathVariable Long id, @RequestBody CompteRequestDTO compte) {
        return compteService.updateCompte(id, compte);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        compteService.deleteCompte(id);
    }
}