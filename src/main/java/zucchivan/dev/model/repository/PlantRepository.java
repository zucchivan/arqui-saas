package zucchivan.dev.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zucchivan.dev.model.Plant;

public interface PlantRepository extends JpaRepository<Plant, Long> {}