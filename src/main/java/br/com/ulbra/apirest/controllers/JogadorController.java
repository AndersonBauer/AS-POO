package br.com.ulbra.apirest.controllers;

import br.com.ulbra.apirest.dto.jogadores.request.JogadorRequest;
import br.com.ulbra.apirest.dto.jogadores.response.JogadorResponseDTO;
import br.com.ulbra.apirest.entities.Jogador;
import br.com.ulbra.apirest.services.JogadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {this.jogadorService = jogadorService;}

    @GetMapping
    public List<JogadorResponseDTO> getAllJogadores() {return this.jogadorService.getAllJogadores();}

    @PostMapping
    public ResponseEntity<Jogador> createJogador(@RequestBody JogadorRequest jogadorRequest){
        Jogador jogador = this.jogadorService.createJogador(jogadorRequest);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(jogador.getId()).toUri();

        return ResponseEntity.created(uri).body(jogador);
    }
}
