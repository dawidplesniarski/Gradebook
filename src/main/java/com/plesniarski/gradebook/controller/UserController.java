package com.plesniarski.gradebook.controller;

import com.plesniarski.gradebook.authentication.LoginUser;
import com.plesniarski.gradebook.domain.dto.AllUsersDto;
import com.plesniarski.gradebook.domain.dto.UserDto;
import com.plesniarski.gradebook.domain.dto.UserUniversityDto;
import com.plesniarski.gradebook.domain.entity.User;
import com.plesniarski.gradebook.exceptions.UserNotFoundException;
import com.plesniarski.gradebook.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody UserDto user){
        final User u = userService.addUser(user);
        return ResponseEntity.ok(u);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<AllUsersDto>> findAllUsers(){
        final List<AllUsersDto> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserUniversityDto> getUserById(@PathVariable Long id) throws UserNotFoundException {
        final UserUniversityDto user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginUser loginUser){
        Long now = System.currentTimeMillis();
        if(userService.loginValidation(loginUser)){
        return Jwts.builder()
                .setSubject(loginUser.getLogin())
                .claim("roles","user")
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + 20000))
                .signWith(SignatureAlgorithm.HS512, loginUser.getPassword())
                .compact();}
        return "";
    }
}
