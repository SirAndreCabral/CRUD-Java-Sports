package JavaSpring.CRUD_Sports;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SportRepository extends JpaRepository<SportEntity, UUID> {
    Optional<SportEntity> findByNome(String nome);
}
