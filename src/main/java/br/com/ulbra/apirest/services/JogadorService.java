package br.com.ulbra.apirest.services;

import br.com.ulbra.apirest.dto.jogadores.request.JogadorRequest;
import br.com.ulbra.apirest.dto.jogadores.response.JogadorResponseDTO;
import br.com.ulbra.apirest.dto.jogadores.response.JogadorTreinadorDTO;
import br.com.ulbra.apirest.entities.Jogador;
import br.com.ulbra.apirest.entities.Treinador;
import br.com.ulbra.apirest.repositories.JogadorRepository;
import br.com.ulbra.apirest.repositories.TreinadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {
    private final JogadorRepository jogadorRepository;
    private final TreinadorRepository treinadorRepository;

    public JogadorService(JogadorRepository jogadorRepository,  TreinadorRepository treinadorRepository) {
        this.jogadorRepository = jogadorRepository;
        this.treinadorRepository = treinadorRepository;
    }

    public List<JogadorResponseDTO> getAllJogadores() {
        return this.jogadorRepository.findAll()
                .stream()
                .map(item ->
                        new JogadorResponseDTO(
                                item.getContent(),
                                new JogadorTreinadorDTO(item.getTreinador().getNome())
                        )).toList();
    }

    public Jogador createJogador(JogadorRequest jogadorRequest) {
        Treinador treinador = treinadorRepository.findById(jogadorRequest.getTreinadorId())
                .orElseThrow();

        Jogador jogador = new Jogador();
        jogador.setContent(jogadorRequest.getContent());
        jogador.setTreinador(treinador);

        return jogadorRepository.save(jogador);
    }
}

