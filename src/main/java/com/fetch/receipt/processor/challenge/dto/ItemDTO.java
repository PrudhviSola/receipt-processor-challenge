package com.fetch.receipt.processor.challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    @NotBlank(message = "Short description cannot be blank")
    @Pattern(regexp = "^[\\w\\s\\-]+$", message = "Short description must only contain letters, numbers, spaces, or hyphens")
    private String shortDescription;

    @NotBlank(message = "Price cannot be blank")
    @Pattern(regexp = "^\\d+\\.\\d{2}$", message = "Price must be a valid decimal value with two digits after the decimal point (e.g., 6.49)")
    private String price;
}
