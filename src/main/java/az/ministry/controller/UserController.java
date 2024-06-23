package az.ministry.controller;
import az.ministry.model.Officer;
import az.ministry.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<Officer> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/id")
    public Optional<Officer> getUser(@Param("id")Long id){
        return userService.getUserById(id);
    }
    @PostMapping()
    public Officer saveUser(@RequestBody Officer officer){
        return userService.saveUser(officer);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
    @PutMapping("/{id}")
    public Officer updateUser(@PathVariable Long id, @RequestBody Officer officer){
        return userService.updateUser(id, officer);
    }
}
