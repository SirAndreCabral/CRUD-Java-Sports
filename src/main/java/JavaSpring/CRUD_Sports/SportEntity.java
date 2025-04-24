package JavaSpring.CRUD_Sports;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "tb_sport")
public class SportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Descrição é obrigatório")
    private String descricao;

    @NotNull(message = "Número de jogadores é obrigatório")
    @Min(value = 1, message = "Número mínimo de jogadores é 1")
    private int numeroJogadores;

    @NotBlank(message = "Tipo é obrigatório")
    private String tipo;

    @NotNull(message = "Campo Olimpico é obrigatório")
    private Boolean olimpico;

    @NotBlank(message = "País de origem é obrigatório")
    private String paisOrigem;

    @NotNull(message = "Ano de criação é obrigatório")
    @Min(value = 1000, message = "Ano de criação é obrigatório")
    private Integer anoCriacao;
}
