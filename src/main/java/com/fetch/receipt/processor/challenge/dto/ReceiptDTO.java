package com.fetch.receipt.processor.challenge.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class ReceiptDTO {
    @NotBlank(message = "Retailer name is required")
    @Pattern(
            regexp = "^[\\w\\s\\-&]+$",
            message = "Retailer name must only contain letters, numbers, spaces, hyphens, and ampersands"
    )
    private String retailer;

    @NotNull(message = "Purchase date on the receipt is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate purchaseDate;

    @NotNull(message = "Purchase time is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime purchaseTime;

    @NotNull(message = "Items cannot be null")
    @NotEmpty(message = "Items cannot be empty")
    private List<ItemDTO> items;

    @NotBlank(message = "Total amount paid is required")
    private String total;

}
