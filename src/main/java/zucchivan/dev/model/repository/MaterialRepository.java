package zucchivan.dev.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zucchivan.dev.model.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {}