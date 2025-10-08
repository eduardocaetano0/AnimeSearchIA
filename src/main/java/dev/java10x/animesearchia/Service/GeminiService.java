package dev.java10x.animesearchia.Service;

import dev.java10x.animesearchia.Model.AnimeDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GeminiService {

    private final WebClient webClient;
    private String apiKey = System.getenv("GEMINI_API_KEY");

    public GeminiService(WebClient webClient) {
        this.webClient = webClient;
    }

/*
curl "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent" \
  -H "x-goog-api-key: $GEMINI_API_KEY" \ header
  -H 'Content-Type: application/json' \ header
  -X POST \
  -d '{
    "contents": cada List.of() cria um desse ---> [
      cada Map.of cria um desse --->{
        "parts": [
          {
            "text": "meu prompt"
          }
        ]
      }
    ]
  }'
 */

    public Mono<String> searchAnime(List<AnimeDTO> animeDto) {
        String listaAnimes = animeDto.stream()
                .map(anime -> String.format("%s (Eps: %d, Temporadas: %d)",
                        anime.getTitulo(),
                        anime.getNumeroEpisodios(),
                        anime.getNumeroTemporadas()))
                .collect(Collectors.joining("\n"));
        String prompt = String.format(
                "Você é um especialista em animes. Analise a lista de animes a seguir: [%s]. " +
                        "Sugira 2 novos animes baseados nessa lista. " +
                        "Sua resposta DEVE TER uma lista com o nome do anime com um pequeno resumo da sinopse, seguido pelo número de episódios e temporadas entre parênteses. " +
                        "Separe cada anime com um ponto e vírgula. E de um espaço legal para separar os animes. " +
                        "Por exemplo: Anime A (Eps: 24, Temporadas: 1); Anime B (Eps: 12, Temporadas: 1);",
                listaAnimes
        );

        Map<String, Object> requestBody = Map.of(
                "contents", List.of(
                        Map.of("parts", List.of(
                                Map.of("text", prompt)
                        ))
                )
        );
        return webClient.post()
                .header("x-goog-api-key", apiKey)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .map(response ->{
                    try {
                        // Pega a lista de "candidates" é onde a API do gemini devolve
                        List<Map<String, Object>> candidates = (List<Map<String, Object>>) response.get("candidates");
                        // Pega o primeiro "content" de dentro do primeiro "contents"
                        Map<String, Object> content = (Map<String, Object>) candidates.get(0).get("content");
                        // Pega a lista de "parts" de dentro do "content"
                        List<Map<String, Object>> parts = (List<Map<String, Object>>) content.get("parts");
                        // Pega o "text" de dentro da primeira "part"
                        return parts.get(0).get("text").toString();
                    } catch (Exception e) {
                        return "Erro ao processar a resposta da API.";
                    }
                });
    }
}
