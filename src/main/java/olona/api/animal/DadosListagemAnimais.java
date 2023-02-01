package olona.api.animal;

import java.math.BigDecimal;

public record DadosListagemAnimais(Long id, String nome, BigDecimal preco, Classificacao classificacao) {

    public DadosListagemAnimais(Animal animal){
        this(animal.getId(), animal.getNome(),animal.getPreco(), animal.getClassificacao());
    }
}
