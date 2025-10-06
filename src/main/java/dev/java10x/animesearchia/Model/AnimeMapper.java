package dev.java10x.animesearchia.Model;

import org.springframework.stereotype.Component;

@Component
public class AnimeMapper {

    public AnimeModel map(AnimeDTO animeDTO){
        AnimeModel anime = new AnimeModel();

        anime.setId(anime.getId());
        anime.setTitulo(anime.getTitulo());
        anime.setSinopse(anime.getSinopse());
        anime.setNumeroEpisodios(anime.getNumeroEpisodios());
        anime.setNumeroTemporadas(anime.getNumeroTemporadas());
        anime.setAnimegeneros(anime.getAnimegeneros());
        anime.setClassificacaoIndicativa(anime.getClassificacaoIndicativa());
        anime.setUrlImagemCapa(anime.getUrlImagemCapa());
        anime.setDataLancamento(anime.getDataLancamento());
        return anime;
    }
    public AnimeDTO map(AnimeModel anime){
        AnimeDTO dto = new AnimeDTO();

        dto.setId(dto.getId());
        dto.setTitulo(dto.getTitulo());
        dto.setSinopse(dto.getSinopse());
        dto.setNumeroEpisodios(dto.getNumeroEpisodios());
        dto.setNumeroTemporadas(dto.getNumeroTemporadas());
        dto.setAnimegeneros(dto.getAnimegeneros());
        dto.setClassificacaoIndicativa(dto.getClassificacaoIndicativa());
        dto.setUrlImagemCapa(dto.getUrlImagemCapa());
        dto.setDataLancamento(dto.getDataLancamento());

        return dto;
    }
}
