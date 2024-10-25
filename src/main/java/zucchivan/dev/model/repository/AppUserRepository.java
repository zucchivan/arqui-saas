package zucchivan.dev.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zucchivan.dev.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {}