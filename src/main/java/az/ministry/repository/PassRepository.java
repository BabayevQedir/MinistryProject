package az.ministry.repository;


import az.ministry.model.Pass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassRepository extends JpaRepository<Pass, Long> {
}
