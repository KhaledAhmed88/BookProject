package com.global.bookproject.controller;

import com.global.bookproject.entity.Auther;
import com.global.bookproject.entity.Book;
import com.global.bookproject.service.BookService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    BookService bookService;


    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable @Min(value = 1) @Max(value = 1000)Long id){
        return ResponseEntity.ok(bookService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createBook(@Valid @RequestBody Book book){
        return ResponseEntity.ok(bookService.createBook(book));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBook (@Valid @RequestBody Book book){
        return ResponseEntity.ok(bookService.updateBook(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook (@PathVariable @Min(value = 1) @Max(value = 1000) Long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book with this ID " + id + " has been deleted");
    }
}
