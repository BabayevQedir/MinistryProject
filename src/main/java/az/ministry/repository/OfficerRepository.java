package az.ministry.repository;


import az.ministry.model.Officer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficerRepository extends JpaRepository<Officer,Long> {
}
