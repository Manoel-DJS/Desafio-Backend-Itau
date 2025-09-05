package challenge.itau.me.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.time.OffsetDateTime;

public record TransactionRequestDto(

        @NotNull
        @Min(0)
        Double valor,
        @NotNull
        @PastOrPresent
        OffsetDateTime dataHora

) {
}
