package zucchivan.dev.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zucchivan.dev.data.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {}