package zucchivan.dev.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zucchivan.dev.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {}