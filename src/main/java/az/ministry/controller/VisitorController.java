package az.ministry.controller;
import az.ministry.model.Visitor;
import az.ministry.service.VisitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/visitors")
@RequiredArgsConstructor
public class VisitorController {
    private final VisitorService visitorService;

    @GetMapping
    public List<Visitor> getAllVisitors() {
        return visitorService.findAllVisitor();
    }

    @GetMapping("/{id}")
    public Optional<Visitor> getVisitorById(@PathVariable Long id) {
        return visitorService.findVisitorById(id);
    }

    @PostMapping
    public Visitor createVisitor(@RequestBody Visitor visitor) {
        return visitorService.saveVisitor(visitor);
    }

    @PutMapping("/{id}")
    public Visitor updateVisitor(@PathVariable Long id, @RequestBody Visitor visitor) {
        return visitorService.updateVisitor(id, visitor);
    }

    @DeleteMapping("/{id}")
    public void deleteVisitor(@PathVariable Long id) {
        visitorService.deleteVisitorById(id);
    }
}
