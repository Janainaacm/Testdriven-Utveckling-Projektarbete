package se.reky.janaina.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import se.reky.janaina.model.Player;


import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    @NonNull
    List<Player> findAll(@NonNull Sort sort);
}
