package olona.api.animal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosCadastroAnimal(
        @NotBlank
        String nome,
        @NotNull
        BigDecimal preco,

        @NotNull
        Classificacao classificacao
) {
}
