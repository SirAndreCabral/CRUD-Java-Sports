package JavaSpring.CRUD_Sports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class SportService {

    @Autowired
    private SportRepository sportRepository;

    public SportEntity criar(SportEntity sportEntity) {
        int anoAtual = LocalDate.now().getYear();
        if (sportEntity.getAnoCriacao() > anoAtual){
            throw new RuntimeException("O ano de criação precisa ser menor ou igual ao ano atual");
        }
        sportRepository.findByNome(sportEntity.getNome()).ifPresent(sportEntity1 -> {
            throw new RuntimeException("Sport já cadastrado");
        });
        return sportRepository.save(sportEntity);
    }

    public List<SportEntity> listarTodos() {
        return sportRepository.findAll();
    }

    public SportEntity listarUm(UUID id) {
        return sportRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Esporte não encontrado com o id: " + id));
    }

    public SportEntity atualizar(UUID id, SportEntity sportEntity) {
        var sportAtualizado = sportRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Esporte não encontrado com o id: " + id));
        sportAtualizado.setNome(sportEntity.getNome());
        sportAtualizado.setAnoCriacao(sportEntity.getAnoCriacao());
        sportAtualizado.setDescricao(sportEntity.getDescricao());
        sportAtualizado.setNumeroJogadores(sportEntity.getNumeroJogadores());
        sportAtualizado.setOlimpico(sportEntity.getOlimpico());
        sportAtualizado.setPaisOrigem(sportEntity.getPaisOrigem());
        sportAtualizado.setTipo(sportEntity.getTipo());

        return sportRepository.save(sportAtualizado);
    }

    public void deletar(UUID id) {
        sportRepository.deleteById(id);
    }
}
