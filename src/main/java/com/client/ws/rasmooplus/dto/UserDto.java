package com.client.ws.rasmooplus.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;

    @NotBlank(message = "must not bem null or empty")
    @Min(value = 6, message = "must not be lesser than 6")
    private String name;

    @Email(message = "invalid")
    private String email;

    @Size(min = 11, message = "must be equals to 11")
    private String phone;

    @CPF(message = "invalid")
    private String cpf;

    private LocalDate dtSubscription = LocalDate.now();

    private LocalDate dtExpiration = LocalDate.now();

    @NotNull(message = "must not be null")
    private Long userTypeId;

    private Long subscriptionTypeId;
}
