package az.ministry.service;
import az.ministry.model.Visitor;
import az.ministry.repository.VisitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitorService {
    private final VisitorRepository visitorRepository;

    public List<Visitor> findAllVisitor(){
        return visitorRepository.findAll();
    }

    public Optional<Visitor> findVisitorById(Long id){
        return visitorRepository.findById(id);
    }

    public Visitor saveVisitor(Visitor visitor){
        return visitorRepository.save(visitor);
    }

    public void deleteVisitorById(Long id){
         visitorRepository.deleteById(id);
    }
    public Visitor updateVisitor(Long id, Visitor newVisitor) {
        return visitorRepository.findById(id)
                .map(visitor -> {
                    visitor.setFinCode(newVisitor.getFinCode());
                    visitor.setName(newVisitor.getName());
                    visitor.setSurname(newVisitor.getSurname());
                    visitor.setContactDetails(newVisitor.getContactDetails());
                    return visitorRepository.save(visitor);
                })
                .orElseGet(() -> {
                    newVisitor.setId(id);
                    return visitorRepository.save(newVisitor);
                });
    }


}
