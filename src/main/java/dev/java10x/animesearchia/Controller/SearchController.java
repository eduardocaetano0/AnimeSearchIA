package dev.java10x.animesearchia.Controller;

import dev.java10x.animesearchia.Model.AnimeDTO;
import dev.java10x.animesearchia.Model.AnimeModel;
import dev.java10x.animesearchia.Service.AnimeService;
import dev.java10x.animesearchia.Service.GeminiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class SearchController {
    private final GeminiService geminiService;
    private AnimeService animeService;

    public SearchController(GeminiService geminiService, AnimeService animeService) {
        this.geminiService = geminiService;
        this.animeService = animeService;
    }

    @GetMapping("/search")
    public Mono<ResponseEntity<String>> searchAnime() {
        List<AnimeDTO> animeDto = animeService.listarAnimes();
            return geminiService.searchAnime(animeDto)
                    .map(search -> ResponseEntity.ok(search))
                    .defaultIfEmpty(ResponseEntity.noContent().build());

        }
}
