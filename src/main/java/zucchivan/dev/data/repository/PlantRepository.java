package zucchivan.dev.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zucchivan.dev.data.Plant;

public interface PlantRepository extends JpaRepository<Plant, Long> {}