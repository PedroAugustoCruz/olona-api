package olona.api.controller;

import jakarta.validation.constraints.NotNull;
import olona.api.animal.Classificacao;

import java.math.BigDecimal;

public record DadosAtualizarAnimal(@NotNull Long id, String nome, BigDecimal preco, Classificacao classificacao) {

}
