package az.ministry.service;
import az.ministry.model.Officer;
import az.ministry.model.Pass;
import az.ministry.model.Visitor;
import az.ministry.model.dto.PassRequest;
import az.ministry.repository.OfficerRepository;
import az.ministry.repository.PassRepository;
import az.ministry.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassService {
    private final PassRepository passRepository;
    private final VisitorRepository visitorRepository;
    private final OfficerRepository officerRepository;

    public List<Pass> getAllPasses() {
        return passRepository.findAll();
    }

    public Optional<Pass> getPassById(Long id) {
        return passRepository.findById(id);
    }

    public Pass createPass(PassRequest passRequest) {

        Visitor visitor = visitorRepository.findById(passRequest.getVisitorId())
                .orElseThrow(() -> new IllegalArgumentException("Visitor not found"));
        Officer officer = officerRepository.findById(passRequest.getOfficerId())
                .orElseThrow(() -> new IllegalArgumentException("Officer not found"));

        Pass pass = Pass.builder()
                .accepted(passRequest.getABoolean())
                .id(passRequest.getPassRequestId())
                .visitor(visitor)
                .officer(officer)
                .entryTime(passRequest.getEntryTime())
                .exitTime(passRequest.getExitTime())
                .build();

        return passRepository.save(pass);
    }


    public Pass updatePass(Long id, Pass passDetails) {
        Pass pass = passRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pass not found"));

        pass.setVisitor(passDetails.getVisitor());
        pass.setOfficer(passDetails.getOfficer());
        pass.setEntryTime(passDetails.getEntryTime());
        pass.setExitTime(passDetails.getExitTime());

        return passRepository.save(pass);
    }

    public void deletePass(Long id) {
        Pass pass = passRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pass not found"));
        passRepository.delete(pass);
    }
}
