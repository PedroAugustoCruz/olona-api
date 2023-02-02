package olona.api.animal;

import java.math.BigDecimal;

public record DadosDetalhamentoAnimal(Long id, String nome, BigDecimal preco, Classificacao classificacao) {
    public DadosDetalhamentoAnimal(Animal animal){
        this(animal.getId(), animal.getNome(), animal.getPreco(),animal.getClassificacao());
    }
}
