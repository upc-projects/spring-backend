package io.proyection.projection.controller;

import io.proyection.projection.domain.User;
import io.proyection.projection.exception.ResourceNotFoundException;
import io.proyection.projection.repository.UserRepository;
import io.proyection.projection.service.MapValidationErrorService;
import io.proyection.projection.service.UserService;
import io.proyection.projection.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result) {
        //Validate that passwords match
        userValidator.validate(user, result);

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;

        User newUser = userService.save(user);

        return new ResponseEntity<User>(newUser, HttpStatus.CREATED);
    }
}
