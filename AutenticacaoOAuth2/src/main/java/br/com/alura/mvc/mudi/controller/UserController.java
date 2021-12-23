package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.User;
import br.com.alura.mvc.mudi.model.consts.Const;
import br.com.alura.mvc.mudi.repository.RoleRepository;
import br.com.alura.mvc.mudi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Secured({Const.ROLE_ADMIN})
    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {

        user = this.userRepository.save(user);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @Secured({Const.ROLE_ADMIN})
    @PutMapping
    public ResponseEntity<User> edit(@RequestBody User user) {

        user = this.userRepository.save(user);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @Secured({Const.ROLE_CLIENT, Const.ROLE_ADMIN})
    @GetMapping
    public ResponseEntity<Page<User>> list(@RequestParam("page") int page, @RequestParam("size") int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
        return new ResponseEntity<Page<User>>(userRepository.findAll(pageable), HttpStatus.OK);
    }
}
