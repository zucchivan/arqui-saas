package zucchivan.dev.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zucchivan.dev.data.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {}