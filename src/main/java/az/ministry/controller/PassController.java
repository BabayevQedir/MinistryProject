package az.ministry.controller;
import az.ministry.model.Pass;
import az.ministry.model.dto.PassRequest;
import az.ministry.service.PassService;
import lombok.RequiredArgsConstructor;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/passes")
@RequiredArgsConstructor
public class PassController {
    private final PassService passService;
    @GetMapping
    public List<Pass> getAllPasses() {
        return passService.getAllPasses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pass> getPassById(@PathVariable Long id) {
        Pass pass = passService.getPassById(id).orElseThrow(() -> new IllegalArgumentException("Pass not found"));
        return ResponseEntity.ok(pass);
    }

    @PostMapping
    public ResponseEntity<Pass> createPass(@RequestBody PassRequest passRequest) {
        Pass createdPass = passService.createPass(passRequest);
        return ResponseEntity.ok(createdPass);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pass> updatePass(@PathVariable Long id, @RequestBody Pass passDetails) {
        Pass updatedPass = passService.updatePass(id, passDetails);
        return ResponseEntity.ok(updatedPass);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePass(@PathVariable Long id) {
        passService.deletePass(id);
        return ResponseEntity.noContent().build();
    }

}
