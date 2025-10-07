package dev.java10x.animesearchia.Model;

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
    private Integer numeroEpisodios;
    private Integer numeroTemporadas;
    private LocalDate dataLancamento;
    private String classificacaoIndicativa;
    private String urlImagemCapa;


}
