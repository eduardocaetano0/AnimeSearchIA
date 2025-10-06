package dev.java10x.animesearchia.Repository;

import dev.java10x.animesearchia.Model.AnimeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<AnimeModel, Long> {
}
