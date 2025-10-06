package dev.java10x.animesearchia.Model;

import dev.java10x.animesearchia.Model.Enum.Generos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnimeDTO {

    private Long id;
    private String titulo;
    private String sinopse;
    private Generos Animegeneros;
    private Integer numeroEpisodios;
    private Integer numeroTemporadas;
    private LocalDate dataLancamento;
    private String classificacaoIndicativa;
    private String urlImagemCapa;


}
