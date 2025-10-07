package dev.java10x.animesearchia.Model;

import org.springframework.stereotype.Component;

@Component
public class AnimeMapper {

    public AnimeModel map(AnimeDTO animeDTO){
        AnimeModel anime = new AnimeModel();

        anime.setId(animeDTO.getId());
        anime.setTitulo(animeDTO.getTitulo());
        anime.setSinopse(animeDTO.getSinopse());
        anime.setNumeroEpisodios(animeDTO.getNumeroEpisodios());
        anime.setNumeroTemporadas(animeDTO.getNumeroTemporadas());
        anime.setClassificacaoIndicativa(animeDTO.getClassificacaoIndicativa());
        anime.setUrlImagemCapa(animeDTO.getUrlImagemCapa());
        anime.setDataLancamento(animeDTO.getDataLancamento());
        return anime;
    }
    public AnimeDTO map(AnimeModel anime){
        AnimeDTO dto = new AnimeDTO();

        dto.setId(anime.getId());
        dto.setTitulo(anime.getTitulo());
        dto.setSinopse(anime.getSinopse());
        dto.setNumeroEpisodios(anime.getNumeroEpisodios());
        dto.setNumeroTemporadas(anime.getNumeroTemporadas());
        dto.setClassificacaoIndicativa(anime.getClassificacaoIndicativa());
        dto.setUrlImagemCapa(anime.getUrlImagemCapa());
        dto.setDataLancamento(anime.getDataLancamento());

        return dto;
    }
}
