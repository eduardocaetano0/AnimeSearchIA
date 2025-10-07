package dev.java10x.animesearchia.Service;

import dev.java10x.animesearchia.Model.AnimeDTO;
import dev.java10x.animesearchia.Model.AnimeMapper;
import dev.java10x.animesearchia.Model.AnimeModel;
import dev.java10x.animesearchia.Repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimeService {
    private final AnimeRepository repository;
    private final AnimeMapper mapper;

    public AnimeService(AnimeRepository repository, AnimeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    //Adiciona Anime ---> POST
    public AnimeDTO adicionaAnime(AnimeDTO animeDTO) {
        AnimeModel anime = new AnimeMapper().map(animeDTO);
        anime = repository.save(anime);
        return mapper.map(anime);
    }

    //Listar os animes ---> GET
    public List<AnimeDTO> listarAnimes() {
        List<AnimeModel> animes = repository.findAll();
        return animes.stream()
                .map(mapper::map)
                .collect(Collectors.toList());

    }

    //Listar por Id
    public AnimeDTO listarPorId(Long id) {
        Optional<AnimeModel> anime = repository.findById(id);
        return anime.map(mapper::map).orElse(null);
    }

    //Alterar anime por id
    public AnimeDTO atualizaAnimePorId(Long id, AnimeDTO animeDTO) {
        Optional<AnimeModel> animeExistente = repository.findById(id);
        if (animeExistente.isPresent()) {
            AnimeModel animeAtualizado = mapper.map(animeDTO);
            animeAtualizado.setId(id);
            animeAtualizado = repository.save(animeAtualizado);
            return mapper.map(animeAtualizado);
        }else {
            return null;
        }
    }
    //delete
    public void removerAnimePorId(Long id) {
        repository.deleteById(id);
    }
}
