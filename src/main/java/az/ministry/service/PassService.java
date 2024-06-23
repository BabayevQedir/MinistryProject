package az.ministry.service;
import az.ministry.model.Pass;
import az.ministry.repository.PassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassService {
    private final PassRepository passRepository;

    public List<Pass> getAllPasses() {
        return passRepository.findAll();
    }

    public Optional<Pass> getPassById(Long id) {
        return passRepository.findById(id);
    }

    public Pass savePass(Pass pass) {
        return passRepository.save(pass);
    }

    public Pass updatePass(Long id, Pass newPass) {
        return passRepository.findById(id)
                .map(pass -> {
                    pass.setEntryTime(newPass.getEntryTime());
                    pass.setExitTime(newPass.getExitTime());
                    pass.setHost(newPass.getHost());
                    pass.setAccepted(newPass.isAccepted());
                    return passRepository.save(pass);
                })
                .orElseGet(() -> {
                    newPass.setId(id);
                    return passRepository.save(newPass);
                });
    }

    public void deletePass(Long id) {
        passRepository.deleteById(id);
    }
}
