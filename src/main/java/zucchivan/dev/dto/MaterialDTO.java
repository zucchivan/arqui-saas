package zucchivan.dev.dto;

import java.math.BigDecimal;

public record MaterialDTO(Long id, String name, String type, BigDecimal costPerUnit, int quantity,
                          BigDecimal amountPaid, String supplier, String metadata, RoomDTO room) {
}