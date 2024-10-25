package zucchivan.dev.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProjectDTO(Long id, String name, String location, LocalDate startDate, LocalDate endDate, BigDecimal budget) {}