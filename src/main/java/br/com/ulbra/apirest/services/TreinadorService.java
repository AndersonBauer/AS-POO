package br.com.ulbra.apirest.services;

import br.com.ulbra.apirest.dto.treinadores.TreinadorJogadorDTO;
import br.com.ulbra.apirest.dto.treinadores.TreinadorResponseDTO;
import br.com.ulbra.apirest.entities.Treinador;
import br.com.ulbra.apirest.repositories.TreinadorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinadorService {
    private TreinadorRepository treinadorRepository;

    public TreinadorService(TreinadorRepository treinadorRepository) {
        this.treinadorRepository = treinadorRepository;
    }

    public Treinador getTreinador(Long id) {
        return this.treinadorRepository.findById(id).orElseThrow();
    }

    public List<TreinadorResponseDTO> getTreinadores() {
        return this.treinadorRepository.findAll()
                .stream()
                .map(item -> new TreinadorResponseDTO(
                        item.getNome(),
                        item.getTitulos(),
                        item.getPremiosIndividuais(),
                        item.getJogadores()
                                .stream()
                                .map(jogador -> new TreinadorJogadorDTO(
                                        jogador.getId(),
                                        jogador.getContent()
                                ))
                                .toList()
                ))
                .toList();
    }

    public Treinador createTreinador(Treinador treinador) {
        return this.treinadorRepository.save(treinador);
    }

    public void deleteTreinador(Long id) {
        Treinador treinador = this.treinadorRepository.findById(id).orElseThrow();
        this.treinadorRepository.delete(treinador);
    }
}
