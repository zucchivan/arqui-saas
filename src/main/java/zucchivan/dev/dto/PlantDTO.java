package zucchivan.dev.dto;

import java.time.LocalDateTime;

public record PlantDTO(Long id, int version, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {}