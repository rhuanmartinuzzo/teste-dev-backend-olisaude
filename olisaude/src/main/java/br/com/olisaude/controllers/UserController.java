package br.com.olisaude.controllers;


import br.com.olisaude.data.vo.v1.UserVO;
import br.com.olisaude.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/olisaude/v1")

public class UserController {


    @Autowired
    private UserServices service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserVO> findAll(){return service.findAll(); };

    @GetMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserVO findById(@PathVariable (value = "id") Long id){ return service.findById(id);};

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserVO create(@RequestBody UserVO user) {
        return service.create(user);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserVO update(@RequestBody UserVO user) {
        return service.update(user);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
