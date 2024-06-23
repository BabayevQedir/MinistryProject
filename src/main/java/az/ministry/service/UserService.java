package az.ministry.service;

import az.ministry.model.Officer;
import az.ministry.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<Officer> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<Officer> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Officer saveUser(Officer officer) {
        return userRepository.save(officer);
    }

    public Officer updateUser(Long id, Officer newOfficer) {
        return userRepository.findById(id)
                .map(officer -> {
                    officer.setName(newOfficer.getName());
                    officer.setSurname(newOfficer.getSurname());
                    return userRepository.save(newOfficer);
                })
                .orElseGet(() -> {
                    newOfficer.setId(id);
                    return userRepository.save(newOfficer);
                });
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }
}
