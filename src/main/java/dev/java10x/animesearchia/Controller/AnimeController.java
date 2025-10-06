package dev.java10x.animesearchia.Controller;

import dev.java10x.animesearchia.Model.AnimeDTO;
import dev.java10x.animesearchia.Service.AnimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anime")
public class AnimeController {
    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    //post
    @PostMapping("/adiciona")
    public ResponseEntity<AnimeDTO> adicionaAnime(@RequestBody AnimeDTO anime) {
        AnimeDTO novoAnime = animeService.adicionaAnime(anime);
        return ResponseEntity.ok(novoAnime);
    }
    //get
    @GetMapping("/listar")
    public ResponseEntity<List<AnimeDTO>> listarAnimes() {
        List<AnimeDTO> animes = animeService.listarAnimes();
        return ResponseEntity.ok(animes);
    }
    //update
    //delete
}
