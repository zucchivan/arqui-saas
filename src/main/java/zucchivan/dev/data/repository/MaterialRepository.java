package zucchivan.dev.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zucchivan.dev.data.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {}