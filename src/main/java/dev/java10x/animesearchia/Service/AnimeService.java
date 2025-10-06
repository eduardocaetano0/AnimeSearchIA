package dev.java10x.animesearchia.Service;

import dev.java10x.animesearchia.Model.AnimeDTO;
import dev.java10x.animesearchia.Model.AnimeMapper;
import dev.java10x.animesearchia.Model.AnimeModel;
import dev.java10x.animesearchia.Repository.AnimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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

    //Lista os animes ---> GET
    public List<AnimeDTO> listarAnimes() {
        List<AnimeModel> animes = repository.findAll();
        return animes.stream()
                .map(mapper::map)
                .collect(Collectors.toList());

    }
}
