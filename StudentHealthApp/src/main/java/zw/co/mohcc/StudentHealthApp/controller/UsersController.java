package zw.co.mohcc.StudentHealthApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import zw.co.mohcc.StudentHealthApp.model.Users;
import zw.co.mohcc.StudentHealthApp.service.UsersService;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/register")
    public ResponseEntity<Users> save(@RequestBody Users user) {
        Users newUser = UsersService.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);

    }
    @GetMapping("/Getting")
    public ResponseEntity<List<Users>> findAll() {
        return usersService.getUsers();
    }
    @DeleteMapping("{userId}")
    public void deleteUser(@PathVariable ("userId") Long userId) {
        usersService.deleteUser(userId);
    }
}
