package JavaSpring.CRUD_Sports;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/sport")
public class SportController {

    @Autowired
    private SportService sportService;

    @PostMapping("/criar-sport")
    public ResponseEntity<SportEntity> criarSport(@Valid @RequestBody SportEntity sportEntity) {
        SportEntity novoSport = sportService.criar(sportEntity);

        return ResponseEntity.ok(novoSport);
    }

    @GetMapping("/listar-sports")
    public List<SportEntity> listarTodosSports() {
        return sportService.listarTodos();
    }

    @GetMapping("/listar-sport/{uuid}")
    public SportEntity listarUmSport(@PathVariable UUID uuid) {
        return sportService.listarUm(uuid);
    }

    @PutMapping("/atualizar-sport/{uuid}")
    public ResponseEntity<SportEntity> atualizarSport(@Valid @PathVariable UUID uuid,
                                                      @RequestBody SportEntity sportEntity) {

        SportEntity sportAtualizado = sportService.atualizar(uuid, sportEntity);

        return ResponseEntity.ok(sportAtualizado);
    }

    @DeleteMapping("/deletar-sport/{uuid}")
    public ResponseEntity<Void> deletarSport(@PathVariable UUID uuid) {
        sportService.deletar(uuid);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
