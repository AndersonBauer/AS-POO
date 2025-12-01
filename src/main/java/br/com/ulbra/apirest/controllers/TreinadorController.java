package br.com.ulbra.apirest.controllers;

import br.com.ulbra.apirest.dto.treinadores.TreinadorResponseDTO;
import br.com.ulbra.apirest.entities.Treinador;
import br.com.ulbra.apirest.services.TreinadorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/treinadores")
public class TreinadorController {
    private TreinadorService treinadorService;

    public TreinadorController(TreinadorService treinadorService){this.treinadorService = treinadorService;}

    @GetMapping
    public ResponseEntity<List<TreinadorResponseDTO>> getTreinadores() {
        return ResponseEntity.ok(treinadorService.getTreinadores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Treinador> getTreinador(@PathVariable Long id){
        return ResponseEntity.ok((Treinador) this.treinadorService.getTreinador(id));
    }

    @PostMapping
    public ResponseEntity<Treinador> createTreinador(@RequestBody Treinador treinador){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(treinador.getId()).toUri();
        return ResponseEntity.created(uri).body(this.treinadorService.createTreinador(treinador));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTreinador(@PathVariable Long id){
        this.treinadorService.deleteTreinador(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Treinador> updateTreinador(
            @PathVariable Long id,
            @RequestBody Treinador treinadorAtualizado
    ) {
        Treinador treinador = treinadorService.getTreinador(id);

        treinador.setNome(treinadorAtualizado.getNome());
        treinador.setTitulos(treinadorAtualizado.getTitulos());
        treinador.setPremiosIndividuais(treinadorAtualizado.getPremiosIndividuais());

        Treinador atualizado = treinadorService.createTreinador(treinador); // ou save
        return ResponseEntity.ok(atualizado);
    }
}
