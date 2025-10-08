package dev.java10x.animesearchia.Controller;

import dev.java10x.animesearchia.Model.AnimeDTO;
import dev.java10x.animesearchia.Service.AnimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anime")
@CrossOrigin(origins = "*")
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
    //get listar geral
    @GetMapping("/listar")
    public ResponseEntity<List<AnimeDTO>> listarTodosAnimes() {
        List<AnimeDTO> animes = animeService.listarAnimes();
        return ResponseEntity.ok(animes);
    }

    //Listar por ID
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarAnimeId(@PathVariable Long id) {
        AnimeDTO anime = animeService.listarPorId(id);
        if(anime != null) {
            return ResponseEntity.ok(anime);
        }else  {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Anime não encontrado");
        }
    }

    //update
    @PutMapping("/alterar/{id}")
    public ResponseEntity<?>alterarAnimePorId(@PathVariable Long id, @RequestBody AnimeDTO anime) {
        AnimeDTO alteraAnime = animeService.atualizaAnimePorId(id, anime);
        return ResponseEntity.ok(alteraAnime);
    }

    //delete
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarAnimePorId(@PathVariable Long id) {
        if(animeService.listarPorId(id) != null){
            animeService.removerAnimePorId(id);
            return ResponseEntity.ok("Anime removido com sucesso");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Anime do (ID): "+id+" não encontrado");
        }
    }

}
