package olona.api.controller;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import olona.api.animal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    AnimalRepository repository;

    @GetMapping
    public ResponseEntity<Page<DadosListagemAnimais>> listar(@PageableDefault(size = 10, sort = {"id"})Pageable paginacao) {
       var page =  repository.findByAtivoTrue(paginacao).map(DadosListagemAnimais::new);

       return ResponseEntity.ok(page);
    }


    @PostMapping
    @Transactional
    public void cadastrarAnimal(@RequestBody @Valid DadosCadastroAnimal dados){
        repository.save(new Animal(dados));
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizarAnimal(@RequestBody @Valid DadosAtualizarAnimal dados){
        var animal = repository.getReferenceById(dados.id());
        animal.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoAnimal(animal));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarAnimal(@PathVariable Long id ){
        var animal = repository.getReferenceById(id);
        animal.excluir();
        return ResponseEntity.noContent().build();
    }

}
