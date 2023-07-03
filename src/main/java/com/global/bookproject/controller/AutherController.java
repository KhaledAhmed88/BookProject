package com.global.bookproject.controller;

import com.global.bookproject.entity.Auther;
import com.global.bookproject.exception.AutherNotFoundException;
import com.global.bookproject.service.AutherService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Validated
@RestController
@RequestMapping ("/api/v1/auther")
public class AutherController {
    @Autowired
    private AutherService autherService;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
       return ResponseEntity.ok(autherService.findALl());
    }

    @GetMapping("/{id}")
    public Auther findById(@PathVariable @Min(value = 1) @Max(value = 1000) Long id){
        Auther tempAuther = autherService.findById(id);
        if (tempAuther==null){
            throw new AutherNotFoundException("Couldn't found Auther with this ID " + id);
        }
        return tempAuther;

    }
    @GetMapping("/name/{autherName}")
    public Optional<Auther> getAutherByAutherName (@PathVariable String autherName){
        Optional<Auther> tempAuthern= autherService.findByAutherName(autherName);
        return tempAuthern;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAuther(@Valid @RequestBody Auther auther){
        return ResponseEntity.ok(autherService.createAuther(auther));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAuther (@Valid @RequestBody Auther auther){
        return ResponseEntity.ok(autherService.updateAuther(auther));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAuther (@PathVariable @Min(value = 1) @Max(value = 1000) Long id){
        autherService.deleteAuther(id);
        return ResponseEntity.ok("Auther with this ID " + id + " has been deleted");
    }
}
