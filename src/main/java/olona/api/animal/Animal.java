package olona.api.animal;

import jakarta.persistence.*;
import lombok.*;
import olona.api.controller.DadosAtualizarAnimal;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "Animais")
@Entity(name = "Animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private BigDecimal preco;



    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;

    private boolean ativo = true;

    public Animal(DadosCadastroAnimal dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.preco = dados.preco();
        this.classificacao = dados.classificacao();
    }

    public void atualizarInformacoes(DadosAtualizarAnimal dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.preco() != null){
            this.preco = dados.preco();
        }
        if(dados.classificacao() != null){
            this.classificacao = dados.classificacao();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
