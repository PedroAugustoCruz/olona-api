package olona.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import olona.api.animal.Animal;
import olona.api.animal.AnimalRepository;
import olona.api.animal.DadosCadastroAnimal;
import olona.api.animal.DadosListagemAnimais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    AnimalRepository repository;

    @GetMapping
    public Page<DadosListagemAnimais> listar(@PageableDefault(size = 10, sort = {"id"})Pageable paginacao) {
       return repository.findAll(paginacao).map(DadosListagemAnimais::new);
    }


    @PostMapping
    @Transactional
    public void cadastrarAnimal(@RequestBody @Valid DadosCadastroAnimal dados){
        repository.save(new Animal(dados));
    }
    @PutMapping
    @Transactional
    public void atualizarAnimal(@RequestBody @Valid DadosAtualizarAnimal dados){
        var animal = repository.getReferenceById(dados.id());
        animal.atualizarInformacoes(dados);
    }
}
