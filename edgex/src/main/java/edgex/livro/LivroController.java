package edgex.livro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/livros")

public class LivroController {
	
	@Autowired
    private LivroRepository livroRepo;

    @GetMapping
    public List<Livro> listarLivros() {
        return livroRepo.findAll();
    }

    @GetMapping("/{id}")
    public Livro recuperarById(@PathVariable String id) {
        return livroRepo.findById(id).get();
    }

    @PostMapping
    public String criarLivro(@RequestBody Livro novo) {
        if (livroRepo.findById(novo.getId()).isPresent()) {
            throw new LivroFoiDuplicadoException();
        }
        novo = livroRepo.save(novo);
        return novo.getId();
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable String id) {
        livroRepo.deleteById(id);
    }

    @PutMapping("/{id}")
    public void Atualizar(@PathVariable String id, @RequestBody Livro atualizado) {
        if (!id.equals(atualizado.getId())) {
        	throw new IdLivroDivergenteException();
        }
        if (!livroRepo.findById(atualizado.getId()).isPresent()) {
            throw new LivroNaoEncontradoException();

        }
        livroRepo.save(atualizado);
    }

}
