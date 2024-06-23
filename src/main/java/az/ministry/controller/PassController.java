package az.ministry.controller;
import az.ministry.model.Pass;
import az.ministry.service.PassService;
import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/passes")
@RequiredArgsConstructor
public class PassController {
    private final PassService passService;

    @GetMapping
    public List<Pass> getAllPass(){
        return passService.getAllPasses();
    }

    @GetMapping("/{id}")
    public Optional<Pass> getPass(@PathVariable Long id){
        return passService.getPassById(id);
    }
    @DeleteMapping("/{id}")
    public void deletePass(@PathVariable Long id){
        passService.deletePass(id);
    }
    @PostMapping
    public Pass createPass(@RequestBody Pass pass){
        return passService.savePass(pass);
    }
    @PutMapping("/{id}")
    public Pass updatePass(@PathVariable Long id, @RequestBody Pass pass) {
        return passService.updatePass(id, pass);
    }



}
