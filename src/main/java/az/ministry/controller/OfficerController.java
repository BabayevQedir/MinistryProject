package az.ministry.controller;
import az.ministry.model.Officer;
import az.ministry.service.OfficerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class OfficerController {
    private final OfficerService officerService;

    @GetMapping
    public List<Officer> getAllUsers(){
        return officerService.getAllUser();
    }

    @GetMapping("/id")
    public Optional<Officer> getUser(@Param("id")Long id){
        return officerService.getUserById(id);
    }
    @PostMapping()
    public Officer saveUser(@RequestBody Officer officer){
        return officerService.saveUser(officer);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        officerService.deleteUser(id);
    }
    @PutMapping("/{id}")
    public Officer updateUser(@PathVariable Long id, @RequestBody Officer officer){
        return officerService.updateUser(id, officer);
    }
}
