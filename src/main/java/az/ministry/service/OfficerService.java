package az.ministry.service;

import az.ministry.model.Officer;
import az.ministry.repository.OfficerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OfficerService {
    private final OfficerRepository officerRepository;

    public List<Officer> getAllUser() {
        return officerRepository.findAll();
    }

    public Optional<Officer> getUserById(Long id) {
        return officerRepository.findById(id);
    }

    public Officer saveUser(Officer officer) {
        return officerRepository.save(officer);
    }

    public Officer updateUser(Long id, Officer newOfficer) {
        return officerRepository.findById(id)
                .map(officer -> {
                    officer.setName(newOfficer.getName());
                    officer.setSurname(newOfficer.getSurname());
                    return officerRepository.save(newOfficer);
                })
                .orElseGet(() -> {
                    newOfficer.setId(id);
                    return officerRepository.save(newOfficer);
                });
    }

    public void deleteUser(Long id) {
        officerRepository.deleteById(id);

    }
}
