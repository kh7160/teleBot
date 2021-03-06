package com.example.controller;

import java.util.List;

import com.example.entity.User;
import com.example.entity.UserRepository;
//import com.example.exception.UserNotFoundException;
import com.example.exception.UserNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/user")
    List<User> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

//    @PostMapping("/users")
//    User newUser(@RequestBody User newUser) {
//        return repository.save(newUser);
//    }

    // Single item

    @GetMapping("/user/{charId}")
    List<User> userByCharId(@PathVariable String charId) {
//        System.out.println(repository.findById(id));
//        System.out.println(repository.findByCharId(Long.toString(id)));
//        User user = repository.findById(id).get(); # 객체 가져와서 사용
//        System.out.println(user.getChar_id());
        return repository.findByCharId(charId);
    }

//    @PutMapping("/users/{charId}/{account}")
//    User replaceUser(@RequestBody User newUser, @PathVariable String charId, @PathVariable String account) {
//
//        return repository.getByCharIdAndAccount(charId, account)
//                .map(User -> {
//                    User.setName(newUser.getName());
//                    User.setRole(newUser.getRole());
//                    return repository.save(User);
//                })
//                .orElseGet(() -> {
//                    newUser.setId(id);
//                    return repository.save(newUser);
//                });
//    }

//    @DeleteMapping("/users/{id}")
//    void deleteUser(@PathVariable Long id) {
//        repository.deleteById(id);
//    }
}