package zucchivan.dev.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zucchivan.dev.data.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {}