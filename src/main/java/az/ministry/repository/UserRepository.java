package az.ministry.repository;


import az.ministry.model.Officer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Officer,Long> {
}
