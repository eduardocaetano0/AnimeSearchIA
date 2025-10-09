CREATE TABLE Anime_catalogo{
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    sinopse VARCHAR(255) NOT NULL,
    ANIME_GENEROS VARCHAR(255) NOT NULL,
    numeroEpisodios INT NOT NULL,
    numeroTemporadas INT NOT NULL,
    classificacaoIndicativa VARCHAR(255) NOT NULL,
    urlImagemCapa VARCHAR(255) NOT NULL,
    dataLancamento DATE NO NULL
    };