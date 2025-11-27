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

    public JogadorResponseDTO getJogadorById(Long id) {
        Jogador jogador = jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));

        return new JogadorResponseDTO(
                jogador.getContent(),
                new JogadorTreinadorDTO(jogador.getTreinador().getNome())
        );
    }

    public Jogador updateJogador(Long id, JogadorRequest jogadorAtualizado) {
        Jogador jogador = jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));

        // Atualiza o conteúdo
        jogador.setContent(jogadorAtualizado.getContent());

        // Atualiza o treinador se for passado
        if (jogadorAtualizado.getTreinadorId() != null) {
            Treinador treinador = treinadorRepository.findById(jogadorAtualizado.getTreinadorId())
                    .orElseThrow(() -> new RuntimeException("Treinador não encontrado"));
            jogador.setTreinador(treinador);
        }

        return jogadorRepository.save(jogador);
    }

    public void deleteJogador(Long id) {
        Jogador jogador = jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
        jogadorRepository.delete(jogador);
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

