package zucchivan.dev.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zucchivan.dev.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {}