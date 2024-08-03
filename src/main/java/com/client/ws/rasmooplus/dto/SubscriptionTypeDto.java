package com.client.ws.rasmooplus.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionTypeDto {
    private Long id;

    @NotBlank(message = "must not be null or empty")
    private String name;

    @Max(value = 12, message = "must not be higher than 12")
    private Long accessMonth;

    @NotNull(message = "must not be null")
    private BigDecimal price;

    @NotBlank(message = "must not be null or empty")
    @Size(min = 5, max = 15, message = "must be between 5 and 15")
    private String productKey;
}
